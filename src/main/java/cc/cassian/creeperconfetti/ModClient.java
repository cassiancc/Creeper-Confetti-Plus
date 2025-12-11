package cc.cassian.creeperconfetti;

import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class ModClient {
  public static SoundEvent confetti = SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("creeperconfetti", "confetti"));
}
