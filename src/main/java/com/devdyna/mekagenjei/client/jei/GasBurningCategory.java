package com.devdyna.mekagenjei.client.jei;

import static com.devdyna.mekagenjei.Main.*;

import mekanism.api.chemical.Chemical;
import mekanism.api.chemical.ChemicalStack;
import mekanism.client.recipe_viewer.jei.ChemicalStackRenderer;
import mekanism.client.recipe_viewer.jei.MekanismJEI;
import mekanism.common.registration.impl.DeferredChemical;
import mekanism.common.registries.MekanismChemicals;
import mekanism.generators.common.registries.GeneratorsBlocks;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.network.chat.Component;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;

@SuppressWarnings({ "null" })
public class GasBurningCategory<T> extends AbstractRecipeCategory<GasBurningCategory.GASSES> {

    public final static RecipeType<GASSES> TYPE = RecipeType.create(ID, GAS_BURNING_GENERATOR_CATEGORY_ID,
            GasBurningCategory.GASSES.class);

    public GasBurningCategory(IGuiHelper guiHelper) {
        super(TYPE, Component.translatable(GAS_BURNING_GENERATOR_CATEGORY_ID),
                ItemIcon.of(guiHelper, GeneratorsBlocks.GAS_BURNING_GENERATOR.get().asItem()), 16, 16);
    }

    public enum GASSES {

        HYDROGEN(MekanismChemicals.HYDROGEN),
        ETHENE(MekanismChemicals.ETHENE);

        private DeferredChemical<Chemical> data;

        GASSES(DeferredChemical<Chemical> ethene2) {
            this.data = ethene2;
        }

    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, GASSES recipe, IFocusGroup group) {
        builder.addInputSlot(0, 0).addIngredient(MekanismJEI.TYPE_CHEMICAL, new ChemicalStack(recipe.data, 1000))
                .setCustomRenderer(MekanismJEI.TYPE_CHEMICAL, new ChemicalStackRenderer(1000, 16, 16));
    }

}
