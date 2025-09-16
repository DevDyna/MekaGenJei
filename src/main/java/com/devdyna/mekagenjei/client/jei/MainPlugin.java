package com.devdyna.mekagenjei.client.jei;

import java.util.List;
import com.devdyna.mekagenjei.zStatic;
import com.devdyna.mekagenjei.client.jei.categories.*;
import com.devdyna.mekagenjei.utils.x;

import mekanism.common.registries.MekanismBlocks;
import mekanism.generators.common.registries.GeneratorsBlocks;
import mekanism.generators.common.registries.GeneratorsItems;
import mezz.jei.api.*;
import mezz.jei.api.registration.*;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings({ "null" })
@JeiPlugin
public class MainPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return x.rl("jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration event) {

        var guiHelper = event.getJeiHelpers().getGuiHelper();

        event.addRecipeCategories(
                new BioFuelCategory<>(guiHelper),
                new GasBurningCategory<>(guiHelper),
                new TurbineCategory<>(guiHelper),
                new RadioactiveBarrelCategory<>(guiHelper),
                new FusionFuelCategory<>(guiHelper),
                new PumpExtractionCategory<>(guiHelper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration event) {

        event.addRecipes(BioFuelCategory.TYPE, List.of(zStatic.BIOFUEL.values()));
        event.addRecipes(GasBurningCategory.TYPE, List.of(zStatic.GASBURNING.values()));
        event.addRecipes(TurbineCategory.TYPE, List.of(zStatic.TURBINE.values()));
        event.addRecipes(RadioactiveBarrelCategory.TYPE, List.of(zStatic.WASTE.values()));
        event.addRecipes(PumpExtractionCategory.TYPE, List.of(zStatic.PUMP.values()));
        event.addRecipes(FusionFuelCategory.TYPE, List.of(zStatic.FUSION_FUELS.values()));

    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration event) {

        event.addRecipeCatalyst(GeneratorsBlocks.GAS_BURNING_GENERATOR, GasBurningCategory.TYPE);

        event.addRecipeCatalyst(GeneratorsBlocks.BIO_GENERATOR, BioFuelCategory.TYPE);

        event.addRecipeCatalysts(TurbineCategory.TYPE,
                GeneratorsBlocks.TURBINE_CASING,
                GeneratorsBlocks.TURBINE_VALVE,
                GeneratorsBlocks.TURBINE_VENT,
                GeneratorsItems.TURBINE_BLADE,
                GeneratorsBlocks.TURBINE_ROTOR,
                GeneratorsBlocks.ELECTROMAGNETIC_COIL,
                GeneratorsBlocks.ROTATIONAL_COMPLEX,
                GeneratorsBlocks.SATURATING_CONDENSER);

        event.addRecipeCatalyst(MekanismBlocks.RADIOACTIVE_WASTE_BARREL, RadioactiveBarrelCategory.TYPE);

        event.addRecipeCatalyst(MekanismBlocks.ELECTRIC_PUMP, PumpExtractionCategory.TYPE);

        event.addRecipeCatalysts(FusionFuelCategory.TYPE,
                GeneratorsItems.HOHLRAUM,
                GeneratorsBlocks.FUSION_REACTOR_CONTROLLER,
                GeneratorsBlocks.FUSION_REACTOR_FRAME,
                GeneratorsBlocks.FUSION_REACTOR_LOGIC_ADAPTER,
                GeneratorsBlocks.FUSION_REACTOR_PORT,
                GeneratorsBlocks.LASER_FOCUS_MATRIX);

    }

}
