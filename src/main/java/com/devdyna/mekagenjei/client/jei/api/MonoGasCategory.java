package com.devdyna.mekagenjei.client.jei.api;

import com.devdyna.mekagenjei.client.jei.drawable.ItemIcon;

import mekanism.api.chemical.ChemicalStack;
import mekanism.client.recipe_viewer.jei.ChemicalStackRenderer;
import mekanism.client.recipe_viewer.jei.MekanismJEI;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;

@SuppressWarnings({ "null" })
public abstract class MonoGasCategory<T> extends AbstractRecipeCategory<T> {

    protected IGuiHelper guiHelper;

    public MonoGasCategory(RecipeType<T> recipeType, IGuiHelper guiHelper, String traslationkey, Item icon) {
        super(recipeType, Component.translatable(traslationkey), ItemIcon.of(guiHelper, icon), 16, 16);
        this.guiHelper = guiHelper;
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
