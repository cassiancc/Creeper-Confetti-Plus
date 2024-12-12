package cc.cassian.creeperconfetti;

import cc.cassian.creeperconfetti.config.ModConfig;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.component.type.FireworkExplosionComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CreeperConfettiMod {
  public static final String MOD_ID = "creeperconfetti";
  public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

  public static void init() {
    ModConfig.deserialize();
  }

  public static List<FireworkExplosionComponent> generateComponent(byte type) {
    Random rand = new Random();
    int[] list = new int[rand.nextInt(3) + 6];
    list[0] = 0xE67E22;
    list[1] = 0x00E0FF;
    list[2] = 0x0FFF00;
    for (int i = 3; i < list.length; i++) {
      list[i] = rand.nextInt(0x1000000);
    }
    IntList colors = IntList.of(list);
    return Collections.singletonList(new FireworkExplosionComponent(FireworkExplosionComponent.Type.BURST, colors, colors, false, true));
  }
}
