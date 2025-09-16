package com.devdyna.mekagenjei.client.jei.categories;

import static com.devdyna.mekagenjei.Main.*;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.client.jei.drawable.ItemIcon;
import com.devdyna.mekagenjei.zStatic.FUSION_FUELS;

import mekanism.api.chemical.ChemicalStack;
import mekanism.client.recipe_viewer.jei.ChemicalStackRenderer;
import mekanism.client.recipe_viewer.jei.MekanismJEI;
import mekanism.generators.common.registries.GeneratorsItems;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

@SuppressWarnings("null")
public class FusionFuelCategory<T> extends AbstractRecipeCategory<zStatic.FUSION_FUELS> {

        public FusionFuelCategory(IGuiHelper guiHelper) {
                super(TYPE, Component.translatable(zStatic.categories.GAS_BURNING_FUELGAS.key()),
                                ItemIcon.of(guiHelper, GeneratorsItems.HOHLRAUM.get().asItem()), 40, 16);
        }

        public final static RecipeType<zStatic.FUSION_FUELS> TYPE = RecipeType.create(ID,
                        zStatic.categories.FUSION_FUELS.key(),
                        zStatic.FUSION_FUELS.class);

        @Override
        public void setRecipe(IRecipeLayoutBuilder builder, zStatic.FUSION_FUELS recipe, IFocusGroup group) {

                var list = recipe.getGasList();
                var size = list.size();

                list.forEach(g -> {

                        var index = list.indexOf(g);

                        builder.addInputSlot(
                                        (size > 1 ? 0 : 12) + (index > 0 ? 24 : 0),
                                        0)
                                        .addIngredient(MekanismJEI.TYPE_CHEMICAL,
                                                        new ChemicalStack(g, 1000))
                                        .setCustomRenderer(MekanismJEI.TYPE_CHEMICAL,
                                                        new ChemicalStackRenderer(1000, 16, 16));

                });

        }

        @Override
        public void draw(FUSION_FUELS recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX,
                        double mouseY) {
                var font = Minecraft.getInstance().font;

                if (recipe.getGasList().size() > 1)
                        guiGraphics.drawString(font,
                                        Component.literal("+"),
                                        17,
                                        4,
                                        0xffffff);
        }

}
