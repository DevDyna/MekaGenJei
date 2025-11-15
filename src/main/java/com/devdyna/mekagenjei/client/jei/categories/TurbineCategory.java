package com.devdyna.mekagenjei.client.jei.categories;

import static com.devdyna.mekagenjei.Main.*;

import org.jetbrains.annotations.Nullable;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.zStatic.TURBINE;
import com.devdyna.mekagenjei.client.jei.api.MonoGasCategory;
import mekanism.generators.common.registries.GeneratorsItems;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.level.ItemLike;

public class TurbineCategory<T> extends MonoGasCategory<zStatic.TURBINE> {

    public final static RecipeType<zStatic.TURBINE> TYPE = RecipeType.create(ID,
            zStatic.categories.TURBINE_STEAM.key(),
            zStatic.TURBINE.class);

    public TurbineCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public String getTitleKey() {
        return zStatic.categories.TURBINE_STEAM.key();
    }

    @Override
    public ItemLike getIconItem() {
        return GeneratorsItems.TURBINE_BLADE.get();
    }

    @Override
    public RecipeType<TURBINE> getRecipeType() {
        return TYPE;
    }

    @Override
    public @Nullable String setBackGround() {
        return null;
    }

}
