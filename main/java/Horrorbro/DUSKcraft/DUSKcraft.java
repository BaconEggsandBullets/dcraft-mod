package Horrorbro.DUSKcraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "Dcraft", name = "DUSKcraft", version = "0.5.0")
public class DUSKcraft {

	public static Item itemSickles;
	public static Item itemFlesh;
	public static Block blockFlesh;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Item and Block initialization and registering
		//Config handling 
		//Hello Robert.
		itemSickles = new ItemSickles().setUnlocalizedName("ItemSickles").setTextureName("Dcraft:itemsickles").setCreativeTab(tabDUSKcraft);
		itemFlesh = new ItemFlesh().setUnlocalizedName("ItemFlesh").setTextureName("Dcraft:itemflesh").setCreativeTab(tabDUSKcraft);
		blockFlesh = new BlockFlesh(Material.cloth).setBlockName("BlockFlesh").setBlockTextureName("dcraft:blockflesh");
		
		
		GameRegistry.registerItem(itemSickles, itemSickles.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemFlesh, itemFlesh.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockFlesh, blockFlesh.getUnlocalizedName().substring(5));
		System.out.println(blockFlesh.getUnlocalizedName().substring(5));
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		//I hope this registers Entities and GUIs
		GameRegistry.addRecipe(new ItemStack(blockFlesh), new Object[]{"FFF",
																	   "FFF",
																	   "FFF", 'F', itemFlesh});
		GameRegistry.addRecipe(new ItemStack(itemSickles), new Object[]{"  I"," II","S  ", 'S', Items.stick, 'I', Items.iron_ingot});
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	public static CreativeTabs tabDUSKcraft = new CreativeTabs("tabDUSKcraft"){
		@Override
		public Item getTabIconItem(){
			return new ItemStack(itemSickles).getItem();
		}
	};
}
