package com.devdyna.mekagenjei.client.jei.categories;

import static com.devdyna.mekagenjei.Main.*;

import javax.annotation.Nullable;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.client.jei.api.FuelCategory;
import com.devdyna.mekagenjei.utils.Numbers;
import com.devdyna.mekagenjei.zStatic.GASBURNING;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.chemical.gas.attribute.GasAttributes.Fuel;
import mekanism.client.jei.ChemicalStackRenderer;
import mekanism.client.jei.MekanismJEI;
import mekanism.generators.common.registries.GeneratorsBlocks;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.level.ItemLike;

public class GasBurningCategory<T> extends FuelCategory<zStatic.GASBURNING> {

        public GasBurningCategory(IGuiHelper guiHelper) {
                super(guiHelper);

        }

        public final static RecipeType<zStatic.GASBURNING> TYPE = RecipeType.create(ID,
                        zStatic.categories.GAS_BURNING_FUELGAS.key(),
                        zStatic.GASBURNING.class);

        @Override
        public void setSlotType(GASBURNING recipe, IRecipeSlotBuilder slot) {
                slot.addIngredient(MekanismJEI.TYPE_GAS,
                                new GasStack(recipe.getGas(), 1000))
                                .setCustomRenderer(MekanismJEI.TYPE_GAS,
                                                new ChemicalStackRenderer<GasStack>(1000, 16, 16));
        }

        public @Nullable Fuel getFuel(GASBURNING recipe) {
                return recipe.getGas().get().get(Fuel.class);
        }

        public boolean isValid(GASBURNING recipe) {
                return getFuel(recipe) != null;
        }

        @Override
        public double duration(GASBURNING recipe) {
                return isValid(recipe) ? getFuel(recipe).getBurnTicks() : 0;
        }

        @Override
        public double rate(GASBURNING recipe) {
                return (isValid(recipe)
                                ? Numbers.jouleToFE(getFuel(recipe).getEnergyPerTick().getValue()) * (double) 256
                                                / getFuel(recipe).getBurnTicks()
                                : 0);
        }

        @Override
        public RecipeType<GASBURNING> getRecipeType() {
                return TYPE;
        }

        @Override
        public String getTitleKey() {
                return zStatic.categories.GAS_BURNING_FUELGAS.key();
        }

        @Override
        public ItemLike getIconItem() {
                return GeneratorsBlocks.GAS_BURNING_GENERATOR.getBlock();
        }

}
