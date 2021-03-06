package nl.first8.devoxx4kids.minecraft.blok8;

import net.minecraft.block.properties.IProperty;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.first8.devoxx4kids.minecraft.other.NamedModel;

public class CreepyEiVoorwerp extends Item implements NamedModel {
	private final String name = "creepyEi";

	public CreepyEiVoorwerp() {
		setCreativeTab(CreativeTabs.tabMisc);
		// activeer(); // Zet deze aan om het creepy ei te activeren
	}

	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn,
			EntityPlayer playerIn) {

		worldIn.spawnEntityInWorld(new VliegendCreepyEi(worldIn, playerIn));
		return itemStackIn;
	}

	private void activeer() {
		setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public IProperty getProperty() {
		return null;
	}
}