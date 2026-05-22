package com.devdyna.mekagenjei.client.jei.api;

import com.devdyna.mekagenjei.utils.Size;

import mekanism.api.chemical.gas.GasStack;
import mekanism.client.jei.ChemicalStackRenderer;
import mekanism.client.jei.MekanismJEI;
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
                    .addIngredient(MekanismJEI.TYPE_GAS,
                            new GasStack(cat.getGas(), 1000))
                    .setCustomRenderer(MekanismJEI.TYPE_GAS, new ChemicalStackRenderer<GasStack>(1000, 16, 16));
    }

}
