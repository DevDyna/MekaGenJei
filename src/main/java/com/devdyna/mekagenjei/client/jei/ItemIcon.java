package com.devdyna.mekagenjei.client.jei;

import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("null")
public class ItemIcon implements IDrawable {
    private final IDrawable items;

    public ItemIcon(IDrawable items) {
        this.items = items;
    }

    public static ItemIcon of(IGuiHelper guiHelper, Item item) {
        return new ItemIcon(guiHelper.createDrawableItemStack(new ItemStack(item)));
    }

    @Override
    public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
        items.draw(guiGraphics, xOffset, yOffset);
    }

    @Override
    public int getWidth() {
        return 16;
    }

    @Override
    public int getHeight() {
        return 16;
    }

}