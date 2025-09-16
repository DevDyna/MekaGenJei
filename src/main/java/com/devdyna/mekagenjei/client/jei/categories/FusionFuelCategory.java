package com.devdyna.mekagenjei.client.jei.categories;

import static com.devdyna.mekagenjei.Main.*;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.client.jei.drawable.ItemIcon;
import mekanism.api.chemical.ChemicalStack;
import mekanism.client.recipe_viewer.jei.ChemicalStackRenderer;
import mekanism.client.recipe_viewer.jei.MekanismJEI;
import mekanism.generators.common.registries.GeneratorsItems;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.network.chat.Component;

@SuppressWarnings("null")
public class FusionFuelCategory<T> extends AbstractRecipeCategory<zStatic.FUSION_FUELS> {

    public FusionFuelCategory(IGuiHelper guiHelper) {
        super(TYPE, Component.translatable(zStatic.categories.GAS_BURNING_FUELGAS.key()),
                ItemIcon.of(guiHelper, GeneratorsItems.HOHLRAUM.get().asItem()), 16, 16);
    }

    public final static RecipeType<zStatic.FUSION_FUELS> TYPE = RecipeType.create(ID,
            zStatic.categories.FUSION_FUELS.key(),
            zStatic.FUSION_FUELS.class);

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, zStatic.FUSION_FUELS recipe, IFocusGroup group) {

        recipe.getGasList().forEach(g -> {

            builder.addInputSlot(
                    0 + (recipe.getGasList().size() > 1 ? -8 : 0) +
                            (recipe.getGasList().indexOf(g) * 16),
                    0)
                    .addIngredient(MekanismJEI.TYPE_CHEMICAL,
                            new ChemicalStack(g, 1000))
                    .setCustomRenderer(MekanismJEI.TYPE_CHEMICAL, new ChemicalStackRenderer(1000, 16, 16));

        });

    }

}
