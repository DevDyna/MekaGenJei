package com.devdyna.mekagenjei.client.jei;

import static com.devdyna.mekagenjei.Main.*;

import java.util.List;

import mekanism.generators.common.registries.GeneratorsBlocks;
import mezz.jei.api.*;
import mezz.jei.api.registration.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("null")
@JeiPlugin
public class MainPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return rl("jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration event) {
        event.addRecipeCategories(new GasBurningCategory<>(
                event.getJeiHelpers().getGuiHelper()));

        event.addRecipeCategories(new BioFuelCategory<>(
                event.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration event) {
        event.addRecipes(BioFuelCategory.TYPE, List.of(BioFuelCategory.FUEL.values()));
        event.addRecipes(GasBurningCategory.TYPE, List.of(GasBurningCategory.GASSES.values()));
        

    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration event) {
        event.addRecipeCatalyst(new ItemStack(GeneratorsBlocks.GAS_BURNING_GENERATOR.get()), GasBurningCategory.TYPE);
        event.addRecipeCatalyst(new ItemStack(GeneratorsBlocks.BIO_GENERATOR.get()), BioFuelCategory.TYPE);
    }

}
