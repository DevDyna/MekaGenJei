package com.devdyna.mekagenjei.client.jei.categories;

import static com.devdyna.mekagenjei.Main.*;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.client.jei.drawable.ItemIcon;
import com.devdyna.mekagenjei.utils.x;

import mekanism.common.registries.MekanismItems;
import mekanism.generators.common.registries.GeneratorsBlocks;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;

@SuppressWarnings({ "null" })
public class BioFuelCategory<T> extends AbstractRecipeCategory<zStatic.BIOFUEL> {

    public final static RecipeType<zStatic.BIOFUEL> TYPE = RecipeType.create(ID,
            zStatic.categories.BIOFUEL_FUELS.key(),
            zStatic.BIOFUEL.class);

    public BioFuelCategory(IGuiHelper guiHelper) {
        super(TYPE, Component.translatable(zStatic.categories.BIOFUEL_FUELS.key()),
                ItemIcon.of(guiHelper, GeneratorsBlocks.BIO_GENERATOR.get().asItem()), 16, 16);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, zStatic.BIOFUEL recipe, IFocusGroup group) {
        builder.addInputSlot(0, 0).addItemStack(new ItemStack(recipe.getItems()));
    }

    @Override
    public void draw(zStatic.BIOFUEL recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX,
            double mouseY) {
        var font = Minecraft.getInstance().font;

        guiGraphics.drawString(font,
                Component.literal("x" + (200 * (x.item(recipe.getItems()).is(MekanismItems.BIO_FUEL) ? 1 : 9)) + "mb"),
                24,
                2,
                0xffffff);
    }

}
