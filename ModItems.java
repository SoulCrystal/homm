package com.github.soulcrystal.mightandmagic.init;

import com.github.soulcrystal.mightandmagic.MightandMagic;
import com.github.soulcrystal.mightandmagic.init.ModItemGroups;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public final class ModItems 
{
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MightandMagic.MODID);
	
	//Inferno Mob Drops
	public static final RegistryObject<Item> HOMM_IMP_WING = ITEMS.register("homm_imp_wing", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> HOMM_MANA_CRYSTAL = ITEMS.register("homm_mana_crystal", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> HOMM_EMBER = ITEMS.register("homm_ember", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> HOMM_FIRE = ITEMS.register("homm_fire", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	//Resources
	public static final RegistryObject<Item> HOMM_CRYSTAL = ITEMS.register("homm_crystal", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> HOMM_GEMS = ITEMS.register("homm_gems", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> HOMM_MERCURY = ITEMS.register("homm_mercury", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> HOMM_SULFUR = ITEMS.register("homm_sulfur", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> HOMM_CALOMEL_ORE = ITEMS.register("homm_calomel_ore", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> HOMM_PYRITE_ORE = ITEMS.register("homm_pyrite_ore", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	//Tools and Weapons
	public static final RegistryObject<Item> HOMM_STAF = ITEMS.register("homm_staff", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));

	
	//ToDoList
	//Inferno: Familiar Horn, Fire, Collar, Three Headed Skull, Demon Horn, Golden Chestplate, Whip, Tooth Necklace, Fire Essence, Efreet Lamp, Evil Icon, Devil Horn
	//Fortress: 

	
	//resources
	//ToDoList
	//Pile of Gold, Pile of Wood, Pile of Ore (Ore when smelted gives iron nuggets).

	
	//tools
	//ToDoList
	//All Staff variants, artefact weapons, unique tools(tbd)

}
