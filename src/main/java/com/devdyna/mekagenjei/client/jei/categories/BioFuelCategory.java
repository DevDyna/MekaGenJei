package com.devdyna.mekagenjei.client.jei.categories;

import static com.devdyna.mekagenjei.Main.*;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.client.jei.api.FuelCategory;
import com.devdyna.mekagenjei.utils.Numbers;
import com.devdyna.mekagenjei.utils.x;
import com.devdyna.mekagenjei.zStatic.BIOFUEL;
import mekanism.common.registries.MekanismItems;
import mekanism.generators.common.config.MekanismGeneratorsConfig;
import mekanism.generators.common.registries.GeneratorsBlocks;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class BioFuelCategory<T> extends FuelCategory<zStatic.BIOFUEL> {

        public final static RecipeType<zStatic.BIOFUEL> TYPE = RecipeType.create(ID,
                        zStatic.categories.BIOFUEL_FUELS.key(),
                        zStatic.BIOFUEL.class);

        public BioFuelCategory(IGuiHelper guiHelper) {
                super(guiHelper);
        }

        @Override
        public void setSlotType(BIOFUEL recipe, IRecipeSlotBuilder slot) {
                slot.addItemStack(new ItemStack(recipe.getItems()));
        }

        @Override
        public double rate(BIOFUEL recipe) {
                return Numbers.jouleToFE(MekanismGeneratorsConfig.generators.bioGeneration.get());
        }

        @Override
        public double duration(BIOFUEL recipe) {
                return 200 * (x.item(recipe.getItems()).is(MekanismItems.BIO_FUEL) ? 1 : 9);
        }

        @Override
        public RecipeType<BIOFUEL> getRecipeType() {
                return TYPE;
        }

        @Override
        public String getTitleKey() {
                return zStatic.categories.BIOFUEL_FUELS.key();
        }

        @Override
        public ItemLike getIconItem() {
                return GeneratorsBlocks.BIO_GENERATOR.get();
        }

}
