package com.devdyna.mekagenjei.client.jei.categories;

import static com.devdyna.mekagenjei.Main.*;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.client.jei.drawable.ItemIcon;
import com.devdyna.mekagenjei.utils.x;

import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismItems;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.network.chat.Component;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;

@SuppressWarnings({ "null" })
public class PumpExtractionCategory<T> extends AbstractRecipeCategory<zStatic.PUMP> {

    public final static RecipeType<zStatic.PUMP> TYPE = RecipeType.create(ID,
            zStatic.categories.PUMP_OUTPUT.key(),
            zStatic.PUMP.class);

    public PumpExtractionCategory(IGuiHelper guiHelper) {
        super(TYPE, Component.translatable(zStatic.categories.PUMP_OUTPUT.key()),
                ItemIcon.of(guiHelper, MekanismBlocks.ELECTRIC_PUMP.get().asItem()), 16, 16);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, zStatic.PUMP recipe, IFocusGroup group) {
        builder.addInputSlot(0, 0).addFluidStack(recipe.getFluid());
        if (recipe.getCondition())
            builder.addInputSlot(16, 0).addItemStack(x.item(MekanismItems.FILTER_UPGRADE));
    }

}
