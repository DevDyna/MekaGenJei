package com.devdyna.mekagenjei;

import static com.devdyna.mekagenjei.Main.ID;

import java.util.List;

import com.devdyna.mekagenjei.client.jei.api.IGasCategory;

import mekanism.api.chemical.gas.Gas;
import mekanism.common.registration.impl.GasRegistryObject;
import mekanism.common.registries.*;
import mekanism.generators.common.registries.GeneratorsGases;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluids;

public class zStatic {

    public enum categories {
        GAS_BURNING_FUELGAS(ID + ".jei.gas_burning"),
        BIOFUEL_FUELS(ID + ".jei.bio_fuel"),
        TURBINE_STEAM(ID + ".jei.turbine_steam"),
        FUSION_FUELS(ID + ".jei.fusion_fuels"),
        RADIACTIVE_GAS(ID + ".jei.radioactive_gas"),
        PUMP_OUTPUT(ID + ".jei.pump_output")

        ;

        private String name;

        categories(String name) {
            this.name = name;
        }

        public String key() {
            return name;
        }

    }

    public enum GASBURNING implements IGasCategory {

        HYDROGEN(MekanismGases.HYDROGEN),
        ETHENE(MekanismGases.ETHENE);

        private GasRegistryObject<Gas> gas;

        GASBURNING(GasRegistryObject<Gas> gas) {
            this.gas = gas;
        }

        public GasRegistryObject<Gas> getGas() {
            return gas;
        }

    }

    public enum TURBINE implements IGasCategory {

        STEAM(MekanismGases.STEAM);

        private GasRegistryObject<Gas> gas;

        TURBINE(GasRegistryObject<Gas> gas) {
            this.gas = gas;
        }

        public GasRegistryObject<Gas> getGas() {
            return gas;
        }

    }

    public enum BIOFUEL {

        ITEM(MekanismItems.BIO_FUEL.get())
        // ,
        // BLOCK(MekanismBlocks.BIO.get().asItem())
        ;

        private Item items;

        BIOFUEL(Item items) {
            this.items = items;
        }

        public Item getItems() {
            return items;
        }

    }

    public enum WASTE implements IGasCategory {

        NUCLEAR_WASTE(MekanismGases.NUCLEAR_WASTE, true),
        SPENT_NUCLEAR_WASTE(MekanismGases.SPENT_NUCLEAR_WASTE, true),
        POLONIUM(MekanismGases.POLONIUM, false),
        PLUTONIUM(MekanismGases.PLUTONIUM, false);

        private GasRegistryObject<Gas> gas;
        private boolean canDecay;

        WASTE(GasRegistryObject<Gas> gas, boolean canDecay) {
            this.gas = gas;
            this.canDecay = canDecay;
        }

        public GasRegistryObject<Gas> getGas() {
            return gas;
        }

        public boolean getCondition() {
            return canDecay;
        }

    }

    public enum PUMP {

        WATER(Fluids.WATER, false),
        HEAVY_WATER(MekanismFluids.HEAVY_WATER.getFluid(), true);

        private FlowingFluid fluid;
        private boolean requireFilter;

        PUMP(FlowingFluid fluid, boolean requireFilter) {
            this.fluid = fluid;
            this.requireFilter = requireFilter;
        }

        public FlowingFluid getFluid() {
            return fluid;
        }

        public boolean getCondition() {
            return requireFilter;
        }

    }

    public enum FUSION_FUELS {

        D_T(List.of(GeneratorsGases.FUSION_FUEL)),
        UNCRAFTED(List.of(GeneratorsGases.DEUTERIUM, GeneratorsGases.TRITIUM));

        private List<GasRegistryObject<Gas>> gas;

        FUSION_FUELS(List<GasRegistryObject<Gas>> gas) {
            this.gas = gas;
        }

        public List<GasRegistryObject<Gas>> getGasList() {
            return gas;
        }

    }


    public record RecipeRecord<T>(RecipeType<T> type, T[] values){}

}