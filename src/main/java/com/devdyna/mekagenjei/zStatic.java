package com.devdyna.mekagenjei;

import static com.devdyna.mekagenjei.Main.ID;

import java.util.List;

import com.devdyna.mekagenjei.client.jei.api.IGasCategory;

import mekanism.api.chemical.Chemical;
import mekanism.common.registration.impl.DeferredChemical;
import mekanism.common.registries.*;
import mekanism.generators.common.registries.GeneratorsChemicals;
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

    public enum TURBINE implements IGasCategory {

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

    public enum WASTE implements IGasCategory {

        NUCLEAR_WASTE(MekanismChemicals.NUCLEAR_WASTE, true),
        SPENT_NUCLEAR_WASTE(MekanismChemicals.SPENT_NUCLEAR_WASTE, true),
        POLONIUM(MekanismChemicals.POLONIUM, false),
        PLUTONIUM(MekanismChemicals.PLUTONIUM, false);

        private DeferredChemical<Chemical> gas;
        private boolean canDecay;

        WASTE(DeferredChemical<Chemical> gas, boolean canDecay) {
            this.gas = gas;
            this.canDecay = canDecay;
        }

        public DeferredChemical<Chemical> getGas() {
            return gas;
        }

        public boolean getCondition() {
            return canDecay;
        }

    }

    public enum PUMP {

        WATER(Fluids.WATER, false),
        HEAVY_WATER(MekanismFluids.HEAVY_WATER.get(), true);

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

        D_T(List.of(GeneratorsChemicals.FUSION_FUEL)),
        UNCRAFTED(List.of(GeneratorsChemicals.DEUTERIUM, GeneratorsChemicals.TRITIUM));

        private List<DeferredChemical<Chemical>> gas;

        FUSION_FUELS(List<DeferredChemical<Chemical>> gas) {
            this.gas = gas;
        }

        public List<DeferredChemical<Chemical>> getGasList() {
            return gas;
        }

    }


    public record RecipeRecord<T>(RecipeType<T> type, T[] values){}

}