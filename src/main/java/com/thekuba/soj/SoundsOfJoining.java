package com.thekuba.soj;

import com.thekuba.soj.sound.ModSounds;
import com.thekuba.soj.sound.configmaker;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerPlayerConnection;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
@Mod(SoundsOfJoining.MOD_ID)
public class SoundsOfJoining {
    public static final String MOD_ID = "soundsofjoining";
    public SoundsOfJoining() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModSounds.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, configmaker.SPEC, "soundsofjoining-common.toml");//this one
    }

        public void uuidArray(FMLClientSetupEvent event) {

        }



    @SubscribeEvent
    public void pickupItem(PlayerLoggedInEvent event) {

        String UUID = configmaker.exampleStringListConfigEntry.get().toString().replace("[", "").replace("]", "").replace(" ", "");
        String[] toStringArray = UUID.split(",");//get the list and split it into different uuids

        System.out.println("Player's UUID: " + event.getEntity().getStringUUID().toString());//logs the player's uuid
        //System.out.println(toStringArray[1]);
        for (int i = 0; i < toStringArray.length; i++) {
            if (event.getEntity().getStringUUID().equals(toStringArray[i])) {//"893fe864-7b87-4155-b1de-82a517d0e294" is kuba26038

                UUID = configmaker.exampleStringListConfigEntry.get().toString().replace("[", "").replace("]", "").replace(" ", "");
                toStringArray = UUID.split(",");////get the list and split it into different uuids, again for safety

                event.getEntity().playSound(ModSounds.THE_SOUND_ITSELF.get(), 1, 1);
                //System.out.println("all of the player's uuids: " + toStringArray[i]);
            }
        }

    }


}