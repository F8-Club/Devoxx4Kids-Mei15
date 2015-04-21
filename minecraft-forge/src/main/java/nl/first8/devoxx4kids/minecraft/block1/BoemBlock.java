package nl.first8.devoxx4kids.minecraft.block1;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BoemBlock extends BlockTNT
{

	private final String name = "boemBlok";

	public BoemBlock() {
		super();
		this.setCreativeTab(CreativeTabs.tabBlock);
		super.setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
	}

	@Override
	public void explode(World worldIn, BlockPos pos, IBlockState state,
			EntityLivingBase igniter) {
		 if (!worldIn.isRemote)
	        {
	            if (((Boolean)state.getValue(EXPLODE)).booleanValue())
	            {
	            	EntityTNTPrimed entitytntprimed = new BoemTNTEntity(worldIn, (double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), igniter);
	                worldIn.spawnEntityInWorld(entitytntprimed);
	                worldIn.playSoundAtEntity(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
	            }
	        }
	}

	public String getName() {
		return name;
	}
	
	
	
}