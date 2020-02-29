package com.github.soulcrystal.mightandmagic;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.soulcrystal.mightandmagic.init.ModBlocks;
import com.github.soulcrystal.mightandmagic.init.ModItems;

@Mod(MightandMagic.MODID)
public final class MightandMagic {

	public static final String MODID = "mightandmagic";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	
	
	public MightandMagic() 
	{
		final ModLoadingContext modLoadingContext = ModLoadingContext.get();
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		// Register Deferred Registers (Does not need to be before Configs)
		ModBlocks.BLOCKS.register(modEventBus);
		ModItems.ITEMS.register(modEventBus);
		
	}	
	
}