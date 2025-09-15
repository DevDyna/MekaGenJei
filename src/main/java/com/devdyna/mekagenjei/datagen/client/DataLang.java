package com.devdyna.mekagenjei.datagen.client;

import static com.devdyna.mekagenjei.Main.*;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class DataLang extends LanguageProvider {

    public DataLang(PackOutput o) {
        super(o, ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(GAS_BURNING_GENERATOR_CATEGORY_ID, "Gas Burning Generator");
        add(BIOFUEL_GENERATOR_CATEGORY_ID, "BioFuel Generator Fuels");
    }

}
