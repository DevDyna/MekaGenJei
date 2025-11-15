package com.devdyna.mekagenjei.client.jei.categories;

import static com.devdyna.mekagenjei.Main.*;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.client.jei.api.IGasCategory;
import com.devdyna.mekagenjei.client.jei.drawable.ItemIcon;
import com.devdyna.mekagenjei.utils.Numbers;
import com.devdyna.mekagenjei.utils.Pos;
import com.devdyna.mekagenjei.utils.x;
import com.mojang.blaze3d.vertex.PoseStack;

import mekanism.api.chemical.ChemicalStack;
import mekanism.api.datamaps.IMekanismDataMapTypes;
import mekanism.client.recipe_viewer.jei.ChemicalStackRenderer;
import mekanism.client.recipe_viewer.jei.MekanismJEI;
import mekanism.generators.common.registries.GeneratorsBlocks;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

@SuppressWarnings("null")
public class GasBurningCategory<T> extends AbstractRecipeCategory<zStatic.GASBURNING> {

    protected IGuiHelper guiHelper;

    public GasBurningCategory(IGuiHelper guiHelper) {
        super(TYPE, Component.translatable(zStatic.categories.GAS_BURNING_FUELGAS.key()),
                ItemIcon.of(guiHelper, GeneratorsBlocks.GAS_BURNING_GENERATOR.get().asItem()), 96, 32);
        this.guiHelper = guiHelper;
    }

    public final static RecipeType<zStatic.GASBURNING> TYPE = RecipeType.create(ID,
            zStatic.categories.GAS_BURNING_FUELGAS.key(),
            zStatic.GASBURNING.class);

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, zStatic.GASBURNING recipe, IFocusGroup group) {
        if (recipe instanceof IGasCategory cat)
            builder.addInputSlot(1, 8)
                    .addIngredient(MekanismJEI.TYPE_CHEMICAL,
                            new ChemicalStack(cat.getGas(), 1000))
                    .setCustomRenderer(MekanismJEI.TYPE_CHEMICAL, new ChemicalStackRenderer(1000, 16, 16));
    }

    @Override
    public void draw(zStatic.GASBURNING recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
            double mouseX,
            double mouseY) {
        var font = Minecraft.getInstance().font;

        guiHelper.drawableBuilder(x.rl("textures/gui/fuel_icons.png"), 0, 0, 96, 32).setTextureSize(96, 32).build()
                .draw(guiGraphics, 0, 0);

        var data = recipe.getGas().getData(IMekanismDataMapTypes.INSTANCE.chemicalFuel());
        var check = data == null;
        var time = check ? 0 : data.burnTicks();
        var rate = check ? 0 : data.energyPerTick();
        var total = time * rate;

        PoseStack stack = guiGraphics.pose();
        stack.pushPose();
        stack.scale(0.75F, 0.75F, 8000F);
        guiGraphics.drawString(font,
                (Screen.hasShiftDown()
                        ? time / 20 + " sec"
                        : time + " ticks"),
                46, 4,
                0xFFFFFF);
        guiGraphics.drawString(font, (Screen.hasShiftDown() ? Numbers.toCompact(rate) : rate) + " FE/tick", 46, 18,
                0xFFFFFF);
        guiGraphics.drawString(font, (Screen.hasShiftDown() ? Numbers.toCompact(total) : total) + " FE", 46, 32,
                0xFFFFFF);
        stack.popPose();

    }

    @Override
    public void getTooltip(ITooltipBuilder tooltip, zStatic.GASBURNING recipe, IRecipeSlotsView recipeSlotsView,
            double mouseX, double mouseY) {

        if (Pos.of(21, 0).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(ID + ".jei.time"));

        if (Pos.of(21, 11).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(ID + ".jei.rate"));

        if (Pos.of(21, 22).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(ID + ".jei.total"));

    }

}
