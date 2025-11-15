package com.devdyna.mekagenjei.client.jei.categories;

import static com.devdyna.mekagenjei.Main.*;

import org.jetbrains.annotations.Nullable;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.client.jei.api.FuelCategory;
import com.devdyna.mekagenjei.utils.Numbers;
import com.devdyna.mekagenjei.zStatic.GASBURNING;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.datamaps.IMekanismDataMapTypes;
import mekanism.api.datamaps.chemical.attribute.ChemicalFuel;
import mekanism.client.recipe_viewer.jei.ChemicalStackRenderer;
import mekanism.client.recipe_viewer.jei.MekanismJEI;
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
                slot.addIngredient(MekanismJEI.TYPE_CHEMICAL,
                                new ChemicalStack(recipe.getGas(), 1000))
                                .setCustomRenderer(MekanismJEI.TYPE_CHEMICAL,
                                                new ChemicalStackRenderer(1000, 16, 16));
        }

        public @Nullable ChemicalFuel getFuel(GASBURNING recipe) {
                return recipe.getGas().getData(IMekanismDataMapTypes.INSTANCE.chemicalFuel());
        }

        public boolean isValid(GASBURNING recipe) {
                return getFuel(recipe) != null;
        }

        @Override
        public double duration(GASBURNING recipe) {
                return isValid(recipe) ? getFuel(recipe).burnTicks() : 0;
        }

        @Override
        public double rate(GASBURNING recipe) {
                return (isValid(recipe)
                                ? Numbers.jouleToFE(getFuel(recipe).energyDensity()) * (double) 256
                                                / getFuel(recipe).burnTicks()
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
                return GeneratorsBlocks.GAS_BURNING_GENERATOR.get();
        }

}
