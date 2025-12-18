package me.dinoson850.ancientweapons.effect;

import me.dinoson850.ancientweapons.AncientWeapons;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect PHYTOTOXIN_EFFECT = new PhytotoxinEffect();
    public static final StatusEffect ARMOR_BREAK_EFFECT = new ArmorBreakEffect();

    public static void registerEffects() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(AncientWeapons.MOD_ID, "phytotoxin"), PHYTOTOXIN_EFFECT);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(AncientWeapons.MOD_ID, "armor_break"), ARMOR_BREAK_EFFECT);

        AncientWeapons.LOGGER.info("Registering Mod Effects for " + AncientWeapons.MOD_ID);
    }
}
