package cc.cassian.creeperconfetti.config;

import folk.sisby.kaleido.api.WrappedConfig;
import folk.sisby.kaleido.lib.quiltconfig.api.annotations.FloatRange;

public class ModConfig extends WrappedConfig {
    @FloatRange(min = 0f, max = 1f)
    public float chance = 1f;
    @FloatRange(min=0f, max = 1f)
    public float damage = 1f;
    @FloatRange(min=0f, max = 1f)
    public float soundChance = .05f;
}
