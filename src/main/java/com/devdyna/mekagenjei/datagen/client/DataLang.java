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

        add(zStatic.categories.BIOFUEL_FUELS.name(), "BioFuel Generator Fuels");
        add(zStatic.categories.GAS_BURNING_FUELGAS.name(), "Gas Burning Fuels");
        add(zStatic.categories.TURBINE_STEAM.name(), "Multiblock Turbine Fuels");
    }

}
