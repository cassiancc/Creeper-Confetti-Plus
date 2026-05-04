package cc.cassian.creeperconfetti.fabric;

//? fabric  {
import cc.cassian.creeperconfetti.CreeperConfettiMod;
import net.fabricmc.api.ModInitializer;

public class FabricEntrypoint implements ModInitializer {

    @Override
    public void onInitialize() {
        CreeperConfettiMod.init();
    }

}
//?}