package com.devdyna.mekagenjei.client.jei;

import static com.devdyna.mekagenjei.Main.*;

import mekanism.common.registries.MekanismBlocks;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;

@SuppressWarnings({ "null" })
public class BioFuelCategory<T> extends AbstractRecipeCategory<BioFuelCategory.FUEL> {

    public final static RecipeType<FUEL> TYPE = RecipeType.create(ID, BIOFUEL_GENERATOR_CATEGORY_ID,
            BioFuelCategory.FUEL.class);

    public BioFuelCategory(IGuiHelper guiHelper) {
        super(TYPE, Component.translatable(BIOFUEL_GENERATOR_CATEGORY_ID),
                ItemIcon.of(guiHelper, GeneratorsBlocks.BIO_GENERATOR.get().asItem()), 16, 16);
    }

    public enum FUEL {

        ITEM(MekanismItems.BIO_FUEL.get()),
        BLOCK(MekanismBlocks.BIO_FUEL_BLOCK.get().asItem());

        private Item data;

        FUEL(Item data) {
            this.data = data;
        }

    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FUEL recipe, IFocusGroup group) {
        builder.addInputSlot(0, 0).addItemStack(new ItemStack(recipe.data));
    }

    @Override
    public void draw(FUEL recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX,
            double mouseY) {
        var font = Minecraft.getInstance().font;

        guiGraphics.drawString(font,
                Component.literal("x" + (200 * (recipe.data == MekanismItems.BIO_FUEL.get() ? 1 : 9)) + "mb"), 24, 2,
                0xffffff);
    }

}
