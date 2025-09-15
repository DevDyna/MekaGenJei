package com.devdyna.mekagenjei;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Main.ID)
public class Main {

    public static final String ID = "mekagenjei";

    public static final String GAS_BURNING_GENERATOR_CATEGORY_ID = ID+".jei.gas_burning";
    public static final String BIOFUEL_GENERATOR_CATEGORY_ID = ID+".jei.bio_fuel";

    public Main(IEventBus bus, ModContainer mc) {

    }
}
