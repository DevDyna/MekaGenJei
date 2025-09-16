package com.devdyna.mekagenjei;

import static com.devdyna.mekagenjei.Main.ID;

import com.devdyna.mekagenjei.client.jei.api.IGasCategory;

import mekanism.api.chemical.Chemical;
import mekanism.common.registration.impl.DeferredChemical;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismChemicals;
import mekanism.common.registries.MekanismItems;
import net.minecraft.world.item.Item;

public class zStatic {

    public enum categories {
        GAS_BURNING_FUELGAS(ID + ".jei.gas_burning"),
        BIOFUEL_FUELS(ID + ".jei.bio_fuel"),
        TURBINE_STEAM(ID + ".jei.turbine_steam");

        private String name;

        categories(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    public enum GASBURNING implements IGasCategory{

        HYDROGEN(MekanismChemicals.HYDROGEN),
        ETHENE(MekanismChemicals.ETHENE);

        private DeferredChemical<Chemical> gas;

        GASBURNING(DeferredChemical<Chemical> gas) {
            this.gas = gas;
        }

        public DeferredChemical<Chemical> getGas() {
            return gas;
        }

    }

    public enum TURBINE implements IGasCategory{

        STEAM(MekanismChemicals.STEAM);

        private DeferredChemical<Chemical> gas;

        TURBINE(DeferredChemical<Chemical> gas) {
            this.gas = gas;
        }

        public DeferredChemical<Chemical> getGas() {
            return gas;
        }

    }

    public enum BIOFUEL {

        ITEM(MekanismItems.BIO_FUEL.get()),
        BLOCK(MekanismBlocks.BIO_FUEL_BLOCK.get().asItem());

        private Item items;

        BIOFUEL(Item items) {
            this.items = items;
        }

        public Item getItems() {
            return items;
        }

    }

}