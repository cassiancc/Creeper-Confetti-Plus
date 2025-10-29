package cc.cassian.creeperconfetti.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ClothConfigFactory {

    public static Screen create(Screen parent) {
      ConfigBuilder builder = ConfigBuilder.create()
        .setParentScreen(parent)
        .setTitle(Component.translatable("title.creeperconfetti.config"));
      builder.setSavingRunnable(ModConfig::serialize);
      ConfigCategory general = builder.getOrCreateCategory(Component.translatable("category.creeperconfetti.general"));
      ConfigEntryBuilder entryBuilder = builder.entryBuilder();
      general.addEntry(entryBuilder.startFloatField(Component.translatable("option.creeperconfetti.chance"), ModConfig.chance)
        .setMin(0)
        .setMax(1)
        .setDefaultValue(1f)
        .setTooltip(Component.translatable("option.creeperconfetti.chance.description"))
        .setSaveConsumer(value -> ModConfig.chance = value)
        .build());
      general.addEntry(entryBuilder.startFloatField(Component.translatable("option.creeperconfetti.damage"), ModConfig.damage)
        .setMin(0)
        .setMax(1)
        .setDefaultValue(1f)
        .setTooltip(Component.translatable("option.creeperconfetti.damage.description"))
        .setSaveConsumer(value -> ModConfig.damage = value)
        .build());
      general.addEntry(entryBuilder.startFloatField(Component.translatable("option.creeperconfetti.soundChance"), ModConfig.soundChance)
        .setMin(0)
        .setMax(1)
        .setDefaultValue(.05f)
        .setTooltip(Component.translatable("option.creeperconfetti.soundChance.description"))
        .setSaveConsumer(value -> ModConfig.soundChance = value)
        .build());
      return builder.build();
    }
}
