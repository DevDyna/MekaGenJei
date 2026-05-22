package com.devdyna.mekagenjei.client.jei.api;

import mekanism.api.chemical.gas.Gas;
import mekanism.common.registration.impl.GasRegistryObject;

public interface IGasCategory {
    abstract GasRegistryObject<Gas> getGas();
}
