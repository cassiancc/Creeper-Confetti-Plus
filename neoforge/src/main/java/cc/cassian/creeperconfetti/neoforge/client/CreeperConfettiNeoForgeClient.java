package cc.cassian.creeperconfetti.neoforge.client;

import cc.cassian.creeperconfetti.ModClient;
import cc.cassian.creeperconfetti.config.neoforge.ModConfigFactory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.registries.DeferredRegister;

import static cc.cassian.creeperconfetti.CreeperConfettiMod.MOD_ID;
import static cc.cassian.creeperconfetti.ModClient.confetti;

public class CreeperConfettiNeoForgeClient {
    public static void init(IEventBus eventBus) {
        registerConfetti(eventBus);
        registerModsPage();
    }

    public static void registerConfetti(IEventBus eventBus) {
        DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(RegistryKeys.SOUND_EVENT, MOD_ID);
        SOUNDS.register(confetti.id().getPath(), () -> confetti);
        SOUNDS.register(eventBus);
    }

    //Integrate Cloth Config screen (if mod present) with NeoForge mod menu.
    public static void registerModsPage() {
        if (ModList.get().isLoaded("cloth_config")) ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, ModConfigFactory::new);
    }
}
