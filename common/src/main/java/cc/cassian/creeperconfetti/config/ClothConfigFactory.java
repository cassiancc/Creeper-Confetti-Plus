package cc.cassian.creeperconfetti.config;

import net.minecraft.client.gui.screen.Screen;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.Text;

public class ClothConfigFactory {

    public static Screen create(Screen parent) {
      ConfigBuilder builder = ConfigBuilder.create()
        .setParentScreen(parent)
        .setTitle(Text.translatable("title.creeperconfetti.config"));
      builder.setSavingRunnable(ModConfig::serialize);
      ConfigCategory general = builder.getOrCreateCategory(Text.translatable("category.creeperconfetti.general"));
      ConfigEntryBuilder entryBuilder = builder.entryBuilder();
      general.addEntry(entryBuilder.startFloatField(Text.translatable("option.creeperconfetti.chance"), ModConfig.chance)
        .setMin(0)
        .setMax(1)
        .setDefaultValue(1f)
        .setTooltip(Text.translatable("option.creeperconfetti.chance.description"))
        .setSaveConsumer(value -> ModConfig.chance = value)
        .build());
      general.addEntry(entryBuilder.startFloatField(Text.translatable("option.creeperconfetti.damage"), ModConfig.damage)
        .setMin(0)
        .setMax(1)
        .setDefaultValue(1f)
        .setTooltip(Text.translatable("option.creeperconfetti.damage.description"))
        .setSaveConsumer(value -> ModConfig.damage = value)
        .build());
      general.addEntry(entryBuilder.startFloatField(Text.translatable("option.creeperconfetti.soundChance"), ModConfig.soundChance)
        .setMin(0)
        .setMax(1)
        .setDefaultValue(.05f)
        .setTooltip(Text.translatable("option.creeperconfetti.soundChance.description"))
        .setSaveConsumer(value -> ModConfig.soundChance = value)
        .build());
      return builder.build();
    }
}
