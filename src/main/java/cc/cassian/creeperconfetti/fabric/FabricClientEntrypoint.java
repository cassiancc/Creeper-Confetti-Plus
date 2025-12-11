package cc.cassian.creeperconfetti.fabric;

//? fabric || unobf {
import cc.cassian.creeperconfetti.CreeperConfettiMod;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

import static cc.cassian.creeperconfetti.ModClient.confetti;

public class FabricClientEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        CreeperConfettiMod.LOGGER.info("Initializing {} Client", CreeperConfettiMod.MOD_ID);
        Registry.register(BuiltInRegistries.SOUND_EVENT, confetti.location(), confetti);
    }

}
//?}