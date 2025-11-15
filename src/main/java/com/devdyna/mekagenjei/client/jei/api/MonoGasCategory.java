package com.devdyna.mekagenjei.client.jei.api;

import com.devdyna.mekagenjei.utils.Size;

import mekanism.api.chemical.ChemicalStack;
import mekanism.client.recipe_viewer.jei.ChemicalStackRenderer;
import mekanism.client.recipe_viewer.jei.MekanismJEI;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;

@SuppressWarnings({ "null" })
public abstract class MonoGasCategory<T> extends BaseRecipeCategory<T> {


    public MonoGasCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public Size setXY() {
        return Size.of(16, 16);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, T recipe, IFocusGroup group) {
        if (recipe instanceof IGasCategory cat)
            builder.addInputSlot(0, 0)
                    .addIngredient(MekanismJEI.TYPE_CHEMICAL,
                            new ChemicalStack(cat.getGas(), 1000))
                    .setCustomRenderer(MekanismJEI.TYPE_CHEMICAL, new ChemicalStackRenderer(1000, 16, 16));
    }

}
