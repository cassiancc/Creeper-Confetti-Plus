package cc.cassian.creeperconfetti.mixin;

import cc.cassian.creeperconfetti.CreeperConfettiMod;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import cc.cassian.creeperconfetti.config.ModConfig;
import cc.cassian.creeperconfetti.ModClient;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin {
    @Shadow
    private int currentFuseTime;
    @Shadow
    private int fuseTime;
    @Shadow
    private int explosionRadius;

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/CreeperEntity;isAlive()Z"))
    void tick(CallbackInfo info) {
        CreeperEntity that = (CreeperEntity)(Object)this;
        World world = that.getWorld();
        int fuseTime = this.fuseTime - (world.isClient ? 2 : 1);
        if (!that.isAlive() || this.currentFuseTime < fuseTime) {
            return;
        }
        Random rand = new Random(that.getUuid().getMostSignificantBits());
        boolean shouldConfetti = false;
        if (ModConfig.chance == 1) {
            shouldConfetti = true;
        }
        else if (ModConfig.chance > 0) {
            if (rand.nextDouble() < ModConfig.chance) {
                shouldConfetti = true;
            }
        }
        if (shouldConfetti) {
            Vec3d pos = that.getPos();
            boolean charged = that.shouldRenderOverlay();
            if (world.isClient) {
                if (rand.nextDouble() < ModConfig.soundChance) {
                    world.playSound(pos.x, pos.y, pos.z, ModClient.confetti, SoundCategory.HOSTILE, 2F, 1F, false);
                }
                world.playSound(pos.x, pos.y, pos.z, SoundEvents.ENTITY_FIREWORK_ROCKET_TWINKLE, SoundCategory.HOSTILE, 1F, 1F, false);
                world.addFireworkParticle(pos.x, pos.y + 0.5F, pos.z, 0, 0, 0, CreeperConfettiMod.generateComponent((byte)4));
                if (charged) {
                    world.addFireworkParticle(pos.x, pos.y + 2.5F, pos.z, 0, 0, 0, CreeperConfettiMod.generateComponent((byte)3));
                }
            } else {
                if (ModConfig.damage != 0) {
                    world.createExplosion(that, pos.x, pos.y, pos.z, ModConfig.damage * (charged ? 2f : 1f) * this.explosionRadius, World.ExplosionSourceType.NONE);
                }
                that.discard();
            }
        }
    }
}
