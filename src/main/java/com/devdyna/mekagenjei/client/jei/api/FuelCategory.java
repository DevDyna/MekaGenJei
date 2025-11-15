package com.devdyna.mekagenjei.client.jei.api;

import static com.devdyna.mekagenjei.Main.ID;

import org.jetbrains.annotations.Nullable;

import com.devdyna.mekagenjei.utils.Numbers;
import com.devdyna.mekagenjei.utils.Pos;
import com.devdyna.mekagenjei.utils.Size;
import com.mojang.blaze3d.vertex.PoseStack;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

@SuppressWarnings("null")
public abstract class FuelCategory<T> extends BaseRecipeCategory<T> {

    public FuelCategory(IGuiHelper h) {
        super(h);
    }

    public abstract void setSlotType(T recipe, IRecipeSlotBuilder slot);

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, T recipe, IFocusGroup group) {
        setSlotType(recipe, builder.addInputSlot(1, 8));
    }

   public abstract double rate(T recipe);

   public abstract double duration(T recipe);

    @Override
    public void draw(T recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
            double mouseX,
            double mouseY) {
        super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);

        var time = duration(recipe);
        var rate = rate(recipe);
        var total = time * rate;

        PoseStack stack = guiGraphics.pose();
        stack.pushPose();
        stack.scale(0.75F, 0.75F, 8000F);
        guiGraphics.drawString(font,
                (Screen.hasShiftDown()
                        ? ((double) time / 20 + "").replaceAll("\\.0$", "") + " sec"
                        : time + " ticks"),
                46, 4,
                0xFFFFFF);
        guiGraphics.drawString(font, (Screen.hasShiftDown() ? Numbers.toCompact(rate) : rate) + " FE/tick", 46,
                18,
                0xFFFFFF);
        guiGraphics.drawString(font, (Screen.hasShiftDown() ? Numbers.toCompact(total) : total) + " FE", 46, 32,
                0xFFFFFF);
        stack.popPose();

    }

    @Override
    public void getTooltip(ITooltipBuilder tooltip, T recipe, IRecipeSlotsView recipeSlotsView,
            double mouseX, double mouseY) {

        if (Pos.of(21, 0).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(ID + ".jei.time"));

        if (Pos.of(21, 11).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(ID + ".jei.rate"));

        if (Pos.of(21, 22).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(ID + ".jei.total"));

    }

    @Override
    public Size setXY() {
        return Size.of(96, 32);
    }

    @Override
    public @Nullable String setBackGround() {
        return "textures/gui/fuel_icons.png";
    }

}
