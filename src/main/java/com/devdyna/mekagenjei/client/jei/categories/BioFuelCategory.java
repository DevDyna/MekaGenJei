package com.devdyna.mekagenjei.client.jei.categories;

import static com.devdyna.mekagenjei.Main.*;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.client.jei.drawable.ItemIcon;
import com.devdyna.mekagenjei.utils.Numbers;
import com.devdyna.mekagenjei.utils.Pos;
import com.devdyna.mekagenjei.utils.x;
import com.mojang.blaze3d.vertex.PoseStack;

import mekanism.common.registries.MekanismItems;
import mekanism.generators.common.config.MekanismGeneratorsConfig;
import mekanism.generators.common.registries.GeneratorsBlocks;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;

@SuppressWarnings({ "null" })
public class BioFuelCategory<T> extends AbstractRecipeCategory<zStatic.BIOFUEL> {

        private IGuiHelper guiHelper;

        public final static RecipeType<zStatic.BIOFUEL> TYPE = RecipeType.create(ID,
                        zStatic.categories.BIOFUEL_FUELS.key(),
                        zStatic.BIOFUEL.class);

        public BioFuelCategory(IGuiHelper guiHelper) {
                super(TYPE, Component.translatable(zStatic.categories.BIOFUEL_FUELS.key()),
                                ItemIcon.of(guiHelper, GeneratorsBlocks.BIO_GENERATOR.get().asItem()), 96, 32);
                this.guiHelper = guiHelper;
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder builder, zStatic.BIOFUEL recipe, IFocusGroup group) {
                builder.addInputSlot(1, 8).addItemStack(new ItemStack(recipe.getItems()));
        }

        @Override
        public void draw(zStatic.BIOFUEL recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
                        double mouseX,
                        double mouseY) {
                var font = Minecraft.getInstance().font;

                guiHelper.drawableBuilder(x.rl("textures/gui/fuel_icons.png"), 0, 0, 96, 32).setTextureSize(96, 32)
                                .build()
                                .draw(guiGraphics, 0, 0);

                var time = 200 * (x.item(recipe.getItems()).is(MekanismItems.BIO_FUEL) ? 1 : 9);
                var rate = Numbers.jouleToFE(MekanismGeneratorsConfig.generators.bioGeneration.get());
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
        public void getTooltip(ITooltipBuilder tooltip, zStatic.BIOFUEL recipe, IRecipeSlotsView recipeSlotsView,
                        double mouseX, double mouseY) {

                if (Pos.of(21, 0).setSize(10, 10).test(mouseX, mouseY))
                        tooltip.add(Component.translatable(ID + ".jei.time"));

                if (Pos.of(21, 11).setSize(10, 10).test(mouseX, mouseY))
                        tooltip.add(Component.translatable(ID + ".jei.rate"));

                if (Pos.of(21, 22).setSize(10, 10).test(mouseX, mouseY))
                        tooltip.add(Component.translatable(ID + ".jei.total"));

        }

}
