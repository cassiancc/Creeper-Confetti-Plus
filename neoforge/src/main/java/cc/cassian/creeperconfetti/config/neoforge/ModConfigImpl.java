package cc.cassian.creeperconfetti.config.neoforge;

import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;

public class ModConfigImpl {
    public static Path configPath() {
        return FMLPaths.CONFIGDIR.get().resolve("creeperconfetti.properties");
    }
}
