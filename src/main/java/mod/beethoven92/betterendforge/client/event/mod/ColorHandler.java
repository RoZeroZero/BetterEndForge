package mod.beethoven92.betterendforge.client.event.mod;

import java.util.ArrayList;
import java.util.List;

import mod.beethoven92.betterendforge.BetterEnd;
import mod.beethoven92.betterendforge.common.block.AuroraCrystalBlock;
import mod.beethoven92.betterendforge.common.block.HelixTreeLeavesBlock;
import mod.beethoven92.betterendforge.common.block.JellyshroomCapBlock;
import mod.beethoven92.betterendforge.common.block.ModLanternBlock;
import mod.beethoven92.betterendforge.common.block.RespawnObeliskBlock;
import mod.beethoven92.betterendforge.common.block.TenaneaFlowersBlock;
import mod.beethoven92.betterendforge.common.block.material.StoneMaterial;
import mod.beethoven92.betterendforge.common.init.ModBlocks;
import mod.beethoven92.betterendforge.common.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = BetterEnd.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColorHandler 
{
	@SubscribeEvent
	public static void BlockColorHandler(ColorHandlerEvent.Block event)
	{
		event.getBlockColors().register((state, reader, pos, color) -> 
		                 {return AuroraCrystalBlock.getBlockColor(pos);}, ModBlocks.AURORA_CRYSTAL.get());
		
		event.getBlockColors().register((state, reader, pos, color) -> 
		                 {return TenaneaFlowersBlock.getBlockColor(pos);}, ModBlocks.TENANEA_FLOWERS.get());
		
		event.getBlockColors().register((state, reader, pos, color) -> 
        				 {return RespawnObeliskBlock.getBlockColor(pos);}, ModBlocks.RESPAWN_OBELISK.get());
		
		event.getBlockColors().register((state, reader, pos, color) -> 
		                 {return state.getBlock().getMaterialColor().colorValue;}, 
		                 ModBlocks.HYDRALUX_PETAL_BLOCK_COLORED.getBlocks());
		
		event.getBlockColors().register((state, reader, pos, color) -> 
				        {return state.getBlock().getMaterialColor().colorValue;}, 
				        ModBlocks.BULB_LANTERN_COLORED.getBlocks());

		event.getBlockColors().register((state, reader, pos, color) ->
		 				 {return HelixTreeLeavesBlock.getBlockColor(state);}, 
		 				 ModBlocks.HELIX_TREE_LEAVES.get());
		
		event.getBlockColors().register((state, reader, pos, color) ->
                         {return ((JellyshroomCapBlock)(state.getBlock())).getBlockColor(state);}, 
                         ModBlocks.JELLYSHROOM_CAP_PURPLE.get());
		
		event.getBlockColors().register((state, reader, pos, color) ->
						 {return ModLanternBlock.getBlockColor(state, reader, pos, color);}, 
						 getLanterns());
	}
	
	@SubscribeEvent
	public static void ItemColorHandler(ColorHandlerEvent.Item event)
	{
		event.getItemColors().register((stack, tintIndex) -> 
		                 {return AuroraCrystalBlock.getItemColor();}, ModBlocks.AURORA_CRYSTAL.get());
		
		event.getItemColors().register((stack, tintIndex) -> 
                         {return TenaneaFlowersBlock.getItemColor();}, ModBlocks.TENANEA_FLOWERS.get());
		
		event.getItemColors().register((stack, tintIndex) -> 
                         {return HelixTreeLeavesBlock.getItemColor();}, ModBlocks.HELIX_TREE_LEAVES.get());
		
		event.getItemColors().register((stack, color) -> {
			return ((SpawnEggItem) stack.getItem()).getColor(color);
		}, ModItems.DRAGONFLY_SPAWN_EGG.get(), ModItems.END_FISH_SPAWN_EGG.get(),
				ModItems.SHADOW_WALKER_SPAWN_EGG.get(), ModItems.END_SLIME_SPAWN_EGG.get(),
				ModItems.CUBOZOA_SPAWN_EGG.get(), ModItems.SILK_MOTH_SPAWN_EGG.get());
		
		event.getItemColors().register((stack, tintIndex) -> 
                         {return ((BlockItem)stack.getItem()).getBlock().getMaterialColor().colorValue;}, 
                         ModBlocks.HYDRALUX_PETAL_BLOCK_COLORED.getBlocks());
		
		event.getItemColors().register((stack, tintIndex) -> 
				        {return ((BlockItem)stack.getItem()).getBlock().getMaterialColor().colorValue;}, 
				        ModBlocks.BULB_LANTERN_COLORED.getBlocks());
		
		event.getItemColors().register((stack, tintIndex) -> 
                         {return JellyshroomCapBlock.getItemColor(stack);}, ModBlocks.JELLYSHROOM_CAP_PURPLE.get());
		
		event.getItemColors().register((stack, tintIndex) ->
						 {return ModLanternBlock.getItemColor(stack, tintIndex);}, 
						 getLanterns());

	}
	
	private static Block[] getLanterns() {
		List<Block> result = new ArrayList<>();
		for (StoneMaterial m : StoneMaterial.getMaterials())
			result.add(m.lantern.get());
		result.add(ModBlocks.ANDESITE_LANTERN.get());
		result.add(ModBlocks.BLACKSTONE_LANTERN.get());
		result.add(ModBlocks.DIORITE_LANTERN.get());
		result.add(ModBlocks.END_STONE_LANTERN.get());
		result.add(ModBlocks.GRANITE_LANTERN.get());
		result.add(ModBlocks.PURPUR_LANTERN.get());
		result.add(ModBlocks.QUARTZ_LANTERN.get());
		return result.toArray(new Block[] {});
	}
}
