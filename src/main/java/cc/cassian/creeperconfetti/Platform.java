package cc.cassian.creeperconfetti;

//? fabric  {
import cc.cassian.creeperconfetti.fabric.FabricPlatformImpl;
//?}
//? neoforge {
/*import cc.cassian.creeperconfetti.neoforge.NeoForgePlatformImpl;
*///?}
import java.nio.file.Path;

public interface Platform {

    //? fabric  {
    Platform INSTANCE = new FabricPlatformImpl();
    //?}
    //? neoforge {
    /*Platform INSTANCE = new NeoForgePlatformImpl();
    *///?}


    boolean isModLoaded(String modid);
    String loader();
    Path getConfigDir();
    boolean isDevelopment();

}
