package com.github.soulcrystal.mightandmagic.init;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.github.soulcrystal.mightandmagic.MightandMagic;


public final class ModBlocks {

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MightandMagic.MODID);

	//Resource Blocks
	//ToDoList
	//Wood Pile, Ore Pile, Gold Pile, Gem Pile, Sulfur Pile, Crystal Pile, Mercury Cauldron
	public static final RegistryObject<Block> HOMM_CRYSTAL_ORE_BLOCK = BLOCKS.register("homm_crystal_ore_block", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)));
	public static final RegistryObject<Block> HOMM_CALOMEL_ORE_BLOCK = BLOCKS.register("homm_calomel_ore_block", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)));
	public static final RegistryObject<Block> HOMM_GEM_SAND = BLOCKS.register("homm_gem_sand", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)));
	public static final RegistryObject<Block> HOMM_PYRITE_ORE_BLOCK = BLOCKS.register("homm_pyrite_ore_block", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)));
	public static final RegistryObject<Block> HOMM_ORE_PILE_BLOCK = BLOCKS.register("homm_ore_pile_block", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	//Inferno Blocks
	//ToDoList
	//Crystallized Lava, Igneous cobblestone, Brick slab/stairs/wall, wrought iron, bone block(already exists in MC), ashen bone, shingles, smokestacks	
	public static final RegistryObject<Block> HOMM_IGNEOUS_ROCK_BLOCK = BLOCKS.register("homm_igneous_rock_block", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> HOMM_LOOSE_MAGMA_BLOCK0 = BLOCKS.register("homm_loose_magma_block0", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> HOMM_LOOSE_MAGMA_BLOCK1 = BLOCKS.register("homm_loose_magma_block1", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> HOMM_LOOSE_MAGMA_BLOCK2 = BLOCKS.register("homm_loose_magma_block2", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> HOMM_LOOSE_MAGMA_BLOCK3 = BLOCKS.register("homm_loose_magma_block3", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> HOMM_IGNEOUS_BRICK_BLOCK = BLOCKS.register("homm_igneous_brick_block", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));

}
