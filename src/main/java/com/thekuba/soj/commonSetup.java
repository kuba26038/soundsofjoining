package com.thekuba.soj;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = SoundsOfJoining.MOD_ID, bus = Bus.MOD)
public class commonSetup{

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {

        event.enqueueWork(packetHandler::init);
    }

}