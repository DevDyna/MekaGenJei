package com.devdyna.mekagenjei.client.jei.api;

import mekanism.api.chemical.Chemical;
import mekanism.common.registration.impl.DeferredChemical;

public interface IGasCategory {
    abstract DeferredChemical<Chemical> getGas();
}
