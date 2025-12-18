package me.dinoson850.ancientweapons.item;

import me.dinoson850.ancientweapons.AncientWeapons;
import me.dinoson850.ancientweapons.item.custom.BoneCleaverItem;
import me.dinoson850.ancientweapons.item.custom.BoneClubItem;
import me.dinoson850.ancientweapons.item.custom.BoneFalxItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item ANCIENT_BONE = registerItem("ancient_bone", new Item(new Item.Settings()));
    public static final Item ANCIENT_FANG = registerItem("ancient_fang", new Item(new Item.Settings()));

    public static final Item BONE_CLEAVER = registerItem("bone_cleaver", new BoneCleaverItem(ModToolMaterials.ANCIENT, 7, -3.0F, new Item.Settings().rarity(Rarity.RARE)));
    public static final Item BONE_CLUB = registerItem("bone_club", new BoneClubItem(ModToolMaterials.ANCIENT, 6, -3.0F, new Item.Settings().rarity(Rarity.RARE)));
    public static final Item BONE_FALX = registerItem("bone_falx", new BoneFalxItem(ModToolMaterials.ANCIENT, 2, -2.0F, new Item.Settings().rarity(Rarity.RARE)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(ANCIENT_BONE);
        entries.add(ANCIENT_FANG);
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(BONE_CLEAVER);
        entries.add(BONE_CLUB);
        entries.add(BONE_FALX);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AncientWeapons.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AncientWeapons.LOGGER.info("Registering Mod Items for " + AncientWeapons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
    }
}
