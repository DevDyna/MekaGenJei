package com.devdyna.mekagenjei.client.jei.categories;

import static com.devdyna.mekagenjei.Main.*;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.client.jei.api.BaseRecipeCategory;
import com.devdyna.mekagenjei.utils.Image;
import com.devdyna.mekagenjei.utils.Size;
import com.devdyna.mekagenjei.utils.x;
import com.devdyna.mekagenjei.zStatic.PUMP;

import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismItems;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluids;

@SuppressWarnings({ "null" })
public class PumpExtractionCategory<T> extends BaseRecipeCategory<zStatic.PUMP> {

    public PumpExtractionCategory(IGuiHelper h) {
        super(h);
    }

    public final static RecipeType<zStatic.PUMP> TYPE = RecipeType.create(ID,
            zStatic.categories.PUMP_OUTPUT.key(),
            zStatic.PUMP.class);

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, zStatic.PUMP recipe, IFocusGroup group) {
        builder.addOutputSlot(13, 3).addFluidStack(recipe.getFluid()).setOutputSlotBackground();
        if (recipe.getCondition())
            builder.addInputSlot(13, 35)
                    .addItemStack(x.item(MekanismItems.FILTER_UPGRADE));
        builder.addInputSlot(14, 60).addFluidStack(Fluids.WATER);

    }

    @Override
    public RecipeType<PUMP> getRecipeType() {
        return TYPE;
    }

    @Override
    public String getTitleKey() {
        return zStatic.categories.PUMP_OUTPUT.key();
    }

    @Override
    public ItemLike getIconItem() {
        return MekanismBlocks.ELECTRIC_PUMP.get().asItem();
    }

    @Override
    public Size setXY() {
        return Size.of(46, 80);
    }

    @Override
    public String setBackGround() {
        return "textures/gui/pump.png";
    }

    @Override
    public void background(GuiGraphics graphics) {
        if (this.setBackGround() != null)
            Image.of()
                    .rl(this.setBackGround())
                    .size(22, 54)
                    .offset(11, 25)
                    .render(helper, graphics);
    }

}
