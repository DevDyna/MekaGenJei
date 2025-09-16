package com.devdyna.mekagenjei.client.jei;

import java.util.List;

import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.client.jei.categories.BioFuelCategory;
import com.devdyna.mekagenjei.client.jei.categories.GasBurningCategory;
import com.devdyna.mekagenjei.client.jei.categories.TurbineCategory;
import com.devdyna.mekagenjei.utils.x;

import mekanism.generators.common.registries.GeneratorsBlocks;
import mekanism.generators.common.registries.GeneratorsItems;
import mezz.jei.api.*;
import mezz.jei.api.registration.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("null")
@JeiPlugin
public class MainPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return x.rl("jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration event) {
        event.addRecipeCategories(new BioFuelCategory<>(
                event.getJeiHelpers().getGuiHelper()));

        event.addRecipeCategories(new GasBurningCategory<>(
                event.getJeiHelpers().getGuiHelper()));

        event.addRecipeCategories(new TurbineCategory<>(
                event.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration event) {
        event.addRecipes(BioFuelCategory.TYPE, List.of(zStatic.BIOFUEL.values()));
        event.addRecipes(GasBurningCategory.TYPE, List.of(zStatic.GASBURNING.values()));
        event.addRecipes(TurbineCategory.TYPE, List.of(zStatic.TURBINE.values()));

    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration event) {
        event.addRecipeCatalyst(new ItemStack(GeneratorsBlocks.GAS_BURNING_GENERATOR.get()), GasBurningCategory.TYPE);
        event.addRecipeCatalyst(new ItemStack(GeneratorsBlocks.BIO_GENERATOR.get()), BioFuelCategory.TYPE);
        
        event.addRecipeCatalysts(TurbineCategory.TYPE,
                GeneratorsBlocks.TURBINE_CASING.get().asItem(),
                GeneratorsBlocks.TURBINE_ROTOR.get(), GeneratorsBlocks.TURBINE_VALVE.get(),
                GeneratorsBlocks.TURBINE_VENT.get(), GeneratorsItems.TURBINE_BLADE.get()
        );
    }

}
