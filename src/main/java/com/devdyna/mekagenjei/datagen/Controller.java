package com.devdyna.mekagenjei.datagen;

import com.devdyna.mekagenjei.Main;
import com.devdyna.mekagenjei.datagen.client.DataLang;

import net.minecraft.data.PackOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@SuppressWarnings({ "removal", "deprecation" })
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = Main.ID)
public class Controller {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator g = e.getGenerator();
        PackOutput po = g.getPackOutput();

        // client
        providerGen(e, g, new DataLang(po));

    }

    private static <T extends DataProvider> void providerGen(GatherDataEvent e, DataGenerator g, T f) {
        g.addProvider(e.includeClient(), f);
    }

}
