package me.dinoson850.ancientweapons.effect;

import me.dinoson850.ancientweapons.AncientWeapons;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect PHYTOTOXIN_EFFECT = new PhytotoxinEffect();
    public static final StatusEffect ARMOR_BREAK_EFFECT = new ArmorBreakEffect();

    public static void registerEffects() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(AncientWeapons.MOD_ID, "phytotoxin"), PHYTOTOXIN_EFFECT);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(AncientWeapons.MOD_ID, "armor_break"), ARMOR_BREAK_EFFECT)
                .addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "1cde13b0-1be1-48f5-8963-782d1df74d78", -2, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "1cde13b0-1be1-48f5-8963-782d1df74d78", -1, EntityAttributeModifier.Operation.ADDITION);

        AncientWeapons.LOGGER.info("Registering Mod Effects for " + AncientWeapons.MOD_ID);
    }
}
