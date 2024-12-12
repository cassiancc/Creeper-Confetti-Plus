package cc.cassian.creeperconfetti.config;

import cc.cassian.creeperconfetti.CreeperConfettiMod;
import dev.architectury.injectables.annotations.ExpectPlatform;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ModConfig {
  public static float chance = 1f;
  public static float damage = 1f;
  public static float soundChance = .05f;

  @ExpectPlatform
  public static Path configPath() {
    throw new AssertionError();
  }

  static final Path configPath = configPath();

  static float parseRangedFloat(String s, float min, float max, float def) {
    if (s == null) {
      return def;
    }
    try {
      return Math.min(Math.max(Float.parseFloat(s), min), max);
    } catch (NumberFormatException e) {
      return def;
    }
  }

  static void serialize() {
    Properties prop = new Properties();
    prop.setProperty("chance", Float.toString(chance));
    prop.setProperty("damage", Float.toString(damage));
    prop.setProperty("soundChance", Float.toString(soundChance));
    try {
      OutputStream s = Files.newOutputStream(configPath);
      prop.store(s, "Creeper Confetti Config");
      s.close();
    } catch (IOException e) {
      CreeperConfettiMod.LOGGER.warn("Failed to write config!");
    }
  }

  public static void deserialize() {
    Properties prop = new Properties();
    try {
      InputStream s = Files.newInputStream(configPath);
      prop.load(s);
      chance = parseRangedFloat(prop.getProperty("chance"), 0f, 1f, 1f);
      damage = parseRangedFloat(prop.getProperty("damage"), 0f, 1f, 1f);
      soundChance = parseRangedFloat(prop.getProperty("soundChance"), 0f, 1f, .05f);
    } catch (IOException e) {
      CreeperConfettiMod.LOGGER.warn("Failed to read config!");
    }
    ModConfig.serialize();
  }
}
