package cc.cassian.creeperconfetti.neoforge;

//? neoforge {
/*import cc.cassian.creeperconfetti.CreeperConfettiMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

import static cc.cassian.creeperconfetti.CreeperConfettiMod.MOD_ID;
import static cc.cassian.creeperconfetti.ModClient.confetti;

@Mod(value = MOD_ID, dist = Dist.CLIENT)
public class NeoforgeClientEntrypoint {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, MOD_ID);

    public NeoforgeClientEntrypoint(IEventBus eventBus) {
        SOUNDS.register(confetti.location().getPath(), () -> confetti);
        SOUNDS.register(eventBus);
    }

}
*///?}