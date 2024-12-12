package cc.cassian.creeperconfetti.config.neoforge;

import net.neoforged.fml.loading.FMLLoader;

import java.nio.file.Path;

public class ModConfigImpl {
    public static Path configPath() {
        return Path.of(FMLLoader.getGamePath() + "/config").resolve("creeperconfetti.properties");
    }
}
