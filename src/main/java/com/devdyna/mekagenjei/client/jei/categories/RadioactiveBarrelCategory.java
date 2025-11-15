package com.devdyna.mekagenjei.client.jei.categories;

import static com.devdyna.mekagenjei.Main.*;

import org.jetbrains.annotations.Nullable;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.zStatic.WASTE;
import com.devdyna.mekagenjei.client.jei.api.MonoGasCategory;
import mekanism.common.registries.MekanismBlocks;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.ItemLike;

public class RadioactiveBarrelCategory<T> extends MonoGasCategory<zStatic.WASTE> {

    public final static RecipeType<zStatic.WASTE> TYPE = RecipeType.create(ID,
            zStatic.categories.RADIACTIVE_GAS.key(),
            zStatic.WASTE.class);

    public RadioactiveBarrelCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public ItemLike getIconItem() {
        return MekanismBlocks.RADIOACTIVE_WASTE_BARREL.get();
    }

    @Override
    public RecipeType<WASTE> getRecipeType() {
        return TYPE;
    }

    @Override
    public String getTitleKey() {
        return zStatic.categories.RADIACTIVE_GAS.key();
    }

    @Override
    public @Nullable String setBackGround() {
        return null;
    }

    @Override
    public void draw(zStatic.WASTE recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX,
            double mouseY) {
        var font = Minecraft.getInstance().font;

        if (recipe.getCondition())
            guiGraphics.drawString(font,
                    Component.translatable(ID + ".waste.decay"),
                    24,
                    2,
                    0xffffff);
    }

}
