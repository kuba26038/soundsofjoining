package com.thekuba.soj;

import com.thekuba.soj.sides.ClientSendSound;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
public final class packetHandler {
private packetHandler(){

}


    private static final String ProtocolVersion = "1";

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(SoundsOfJoining.MOD_ID, "main"),
            () -> ProtocolVersion,
            ProtocolVersion::equals,
            ProtocolVersion::equals);
    public static void init() {
//https://www.youtube.com/watch?v=DRdJB3vPFaM
        //https://docs.minecraftforge.net/en/latest/networking/simpleimpl/

        int index = 0;
        INSTANCE.messageBuilder(ClientSendSound.class, index++, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(ClientSendSound::encode).decoder(ClientSendSound::new)
                .consumerNetworkThread(ClientSendSound::handle)
                .add();
    }

}
