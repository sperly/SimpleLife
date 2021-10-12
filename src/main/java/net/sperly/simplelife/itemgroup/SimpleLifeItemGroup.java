
package net.sperly.simplelife.itemgroup;

import net.sperly.simplelife.item.SolarCellItem;
import net.sperly.simplelife.SimplelifeModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@SimplelifeModElements.ModElement.Tag
public class SimpleLifeItemGroup extends SimplelifeModElements.ModElement {
	public SimpleLifeItemGroup(SimplelifeModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsimple_life") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SolarCellItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
