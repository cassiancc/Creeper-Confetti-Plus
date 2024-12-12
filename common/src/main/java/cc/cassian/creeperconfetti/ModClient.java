package cc.cassian.creeperconfetti;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModClient {
  public static SoundEvent confetti = SoundEvent.of(Identifier.of("creeperconfetti", "confetti"));
}
