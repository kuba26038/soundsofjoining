package com.thekuba.soj;

import com.thekuba.soj.sides.ClientSendSound;
import com.thekuba.soj.sound.ModSounds;
import com.thekuba.soj.sound.configmaker;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.PacketDistributor;

import javax.annotation.Nullable;


@Mod(SoundsOfJoining.MOD_ID)
public class SoundsOfJoining {
    public static final String MOD_ID = "soundsofjoining";
    public SoundsOfJoining() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModSounds.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, configmaker.SPEC, "soundsofjoining-common.toml");//this one


    }

    @SubscribeEvent
    public void playerJoinedServer( PlayerLoggedInEvent event ) {


        System.out.println("Player's UUID: " + event.getEntity().getStringUUID().toString());//logs the player's uuid

        var UUID  = configmaker.names;
        System.out.println(UUID.get());


            if (UUID.get().contains(event.getEntity().getStringUUID()) ) {//"893fe864-7b87-4155-b1de-82a517d0e294" is kuba26038
                //todo send a packet to the server with a playlocalsound function

                packetHandler.INSTANCE.send(PacketDistributor.ALL.noArg(), new ClientSendSound());
                //somehow make the playerJoinedClient.java execute itself
                System.out.println("it should really work");
            }

    }


    @SubscribeEvent
    public void pickupItemClient( PlayerLoggedInEvent event ) {


    }

    @Nullable
    private ClientLevel level;




}