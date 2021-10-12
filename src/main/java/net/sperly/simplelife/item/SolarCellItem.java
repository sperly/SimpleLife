
package net.sperly.simplelife.item;

import net.sperly.simplelife.itemgroup.SimpleLifeItemGroup;
import net.sperly.simplelife.SimplelifeModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@SimplelifeModElements.ModElement.Tag
public class SolarCellItem extends SimplelifeModElements.ModElement {
	@ObjectHolder("simplelife:solar_cell")
	public static final Item block = null;
	public SolarCellItem(SimplelifeModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SimpleLifeItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("solar_cell");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
