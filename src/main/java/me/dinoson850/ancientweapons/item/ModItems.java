package me.dinoson850.ancientweapons.item;

import me.dinoson850.ancientweapons.AncientWeapons;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ANCIENT_BONE = registerItem("ancient_bone", new Item(new Item.Settings()));
    public static final Item ANCIENT_FANG = registerItem("ancient_fang", new Item(new Item.Settings()));

    public static final Item BONE_CLEAVER = registerItem("bone_cleaver", new SwordItem(ModToolMaterials.ANCIENT, 7, -3.0F, new Item.Settings()));
    public static final Item BONE_CLUB = registerItem("bone_club", new SwordItem(ModToolMaterials.ANCIENT, 6, -3.0F, new Item.Settings()));
    public static final Item BONE_FALX = registerItem("bone_falx", new SwordItem(ModToolMaterials.ANCIENT, 2, -2.0F, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AncientWeapons.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AncientWeapons.LOGGER.info("Registering Mod Items for " + AncientWeapons.MOD_ID);
    }
}
