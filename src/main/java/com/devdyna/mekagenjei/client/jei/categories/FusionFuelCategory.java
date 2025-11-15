package com.devdyna.mekagenjei.client.jei.categories;

import static com.devdyna.mekagenjei.Main.*;

import org.jetbrains.annotations.Nullable;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.client.jei.api.BaseRecipeCategory;
import com.devdyna.mekagenjei.utils.Size;
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
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class FusionFuelCategory<T> extends BaseRecipeCategory<zStatic.FUSION_FUELS> {

        public FusionFuelCategory(IGuiHelper guiHelper) {
                super(guiHelper);
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

                if (recipe.getGasList().size() > 1)
                        guiGraphics.drawString(font,
                                        Component.literal("+"),
                                        17,
                                        4,
                                        0xffffff);
        }

        @Override
        public RecipeType<FUSION_FUELS> getRecipeType() {
                return TYPE;
        }

        @Override
        public String getTitleKey() {
                return zStatic.categories.FUSION_FUELS.key();
        }

        @Override
        public ItemLike getIconItem() {
                return GeneratorsItems.HOHLRAUM.get();
        }

        @Override
        public Size setXY() {
                return Size.of(40, 16);
        }

        @Override
        public @Nullable String setBackGround() {
                return null;
        }

}
