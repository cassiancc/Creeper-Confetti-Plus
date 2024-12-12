package cc.cassian.creeperconfetti.fabric.client;

import cc.cassian.creeperconfetti.ModClient;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static cc.cassian.creeperconfetti.ModClient.confetti;

public final class CreeperConfettiFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        registerConfetti();
    }

    public static void registerConfetti() {
        Registry.register(Registries.SOUND_EVENT, confetti.id(), confetti);
    }
}
