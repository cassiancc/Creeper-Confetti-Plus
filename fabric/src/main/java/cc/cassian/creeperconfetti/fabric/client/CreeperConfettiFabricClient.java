package cc.cassian.creeperconfetti.fabric.client;

import cc.cassian.creeperconfetti.ModClient;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

import static cc.cassian.creeperconfetti.ModClient.confetti;

public final class CreeperConfettiFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        registerConfetti();
    }

    public static void registerConfetti() {
        Registry.register(BuiltInRegistries.SOUND_EVENT, confetti.location(), confetti);
    }
}
