package cc.cassian.creeperconfetti.mixin;

import cc.cassian.creeperconfetti.CreeperConfettiMod;
import cc.cassian.creeperconfetti.config.ModConfig;
import cc.cassian.creeperconfetti.ModClient;

import java.util.Random;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Creeper.class)
public abstract class CreeperEntityMixin {
    @Shadow
    private int swell;
    @Shadow
    private int maxSwell;
    @Shadow
    private int explosionRadius;

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/Creeper;isAlive()Z"))
    void tick(CallbackInfo info) {
        Creeper that = (Creeper)(Object)this;
        Level world = that.level();
        int fuseTime = this.maxSwell - (world.isClientSide() ? 2 : 1);
        if (!that.isAlive() || this.swell < fuseTime) {
            return;
        }
        Random rand = new Random(that.getUUID().getMostSignificantBits());
        boolean shouldConfetti = false;
        if (CreeperConfettiMod.CONFIG.chance == 1) {
            shouldConfetti = true;
        }
        else if (CreeperConfettiMod.CONFIG.chance > 0) {
            if (rand.nextDouble() < CreeperConfettiMod.CONFIG.chance) {
                shouldConfetti = true;
            }
        }
        if (shouldConfetti) {
            Vec3 pos = that.position();
            boolean charged = that.isPowered();
            if (world.isClientSide()) {
                if (rand.nextDouble() < CreeperConfettiMod.CONFIG.soundChance) {
                    world.playLocalSound(pos.x, pos.y, pos.z, ModClient.confetti, SoundSource.HOSTILE, 2F, 1F, false);
                }
                world.playLocalSound(pos.x, pos.y, pos.z, SoundEvents.FIREWORK_ROCKET_TWINKLE, SoundSource.HOSTILE, 1F, 1F, false);
                world.createFireworks(pos.x, pos.y + 0.5F, pos.z, 0, 0, 0, CreeperConfettiMod.generateComponent((byte)4), true);
                if (charged) {
                    world.createFireworks(pos.x, pos.y + 2.5F, pos.z, 0, 0, 0, CreeperConfettiMod.generateComponent((byte)3), true);
                }
            } else {
                if (CreeperConfettiMod.CONFIG.damage != 0) {
                    world.explode(that, pos.x, pos.y, pos.z, CreeperConfettiMod.CONFIG.damage * (charged ? 2f : 1f) * this.explosionRadius, Level.ExplosionInteraction.NONE);
                }
                that.discard();
            }
        }
    }
}
