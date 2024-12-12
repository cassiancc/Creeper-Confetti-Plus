package cc.cassian.creeperconfetti.neoforge;

import cc.cassian.creeperconfetti.CreeperConfettiMod;
import cc.cassian.creeperconfetti.neoforge.client.CreeperConfettiNeoForgeClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

import static cc.cassian.creeperconfetti.CreeperConfettiMod.MOD_ID;


@Mod(MOD_ID)
public final class CreeperConfettiNeoForge {
    public CreeperConfettiNeoForge(IEventBus eventBus, ModContainer container) {
        // Run our common setup.
        CreeperConfettiMod.init();
        if (FMLEnvironment.dist.equals(Dist.CLIENT)) {
            CreeperConfettiNeoForgeClient.init(eventBus);
        }
    }


}
