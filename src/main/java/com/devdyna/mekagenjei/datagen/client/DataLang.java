package com.devdyna.mekagenjei.datagen.client;

import static com.devdyna.mekagenjei.Main.*;

import com.devdyna.mekagenjei.zStatic;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class DataLang extends LanguageProvider {

    public DataLang(PackOutput o) {
        super(o, ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        add(zStatic.categories.BIOFUEL_FUELS.key(), "BioFuel Generator Fuels");
        add(zStatic.categories.GAS_BURNING_FUELGAS.key(), "Gas Burning Fuels");
        add(zStatic.categories.TURBINE_STEAM.key(), "Multiblock Turbine Fuels");
        add(zStatic.categories.RADIACTIVE_GAS.key(), "Radioactive Gasses");
        add(zStatic.categories.PUMP_OUTPUT.key(), "Pump Production");
        add(zStatic.categories.FUSION_FUELS.key(), "Fusion Reactor Fuels");
        add(ID+".waste.decay", "Will not decay");
    }

}
