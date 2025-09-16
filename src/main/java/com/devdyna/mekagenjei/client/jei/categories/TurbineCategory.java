package com.devdyna.mekagenjei.client.jei.categories;

import static com.devdyna.mekagenjei.Main.*;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.client.jei.api.MonoGasCategory;
import mekanism.generators.common.registries.GeneratorsItems;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;

public class TurbineCategory<T> extends MonoGasCategory<zStatic.TURBINE> {

    public final static RecipeType<zStatic.TURBINE> TYPE = RecipeType.create(ID,
            zStatic.categories.TURBINE_STEAM.name(),
            zStatic.TURBINE.class);

    public TurbineCategory(IGuiHelper guiHelper) {
        super(TYPE, guiHelper, zStatic.categories.TURBINE_STEAM.name(),
                GeneratorsItems.TURBINE_BLADE.get());
    }

}
