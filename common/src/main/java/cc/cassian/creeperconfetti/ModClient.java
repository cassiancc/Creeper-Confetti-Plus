package cc.cassian.creeperconfetti;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class ModClient {
  public static SoundEvent confetti = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("creeperconfetti", "confetti"));
}
