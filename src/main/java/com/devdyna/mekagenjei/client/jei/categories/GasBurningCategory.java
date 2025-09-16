package com.devdyna.mekagenjei.client.jei.categories;

import static com.devdyna.mekagenjei.Main.*;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.client.jei.api.MonoGasCategory;
import mekanism.generators.common.registries.GeneratorsBlocks;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;

public class GasBurningCategory<T> extends MonoGasCategory<zStatic.GASBURNING> {

    public GasBurningCategory( IGuiHelper guiHelper) {
        super(TYPE, guiHelper, zStatic.categories.GAS_BURNING_FUELGAS.key(),
                GeneratorsBlocks.GAS_BURNING_GENERATOR.get().asItem());
    }

    public final static RecipeType<zStatic.GASBURNING> TYPE = RecipeType.create(ID,
            zStatic.categories.GAS_BURNING_FUELGAS.key(),
            zStatic.GASBURNING.class);

}
