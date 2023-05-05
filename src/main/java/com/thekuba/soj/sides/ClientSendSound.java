package com.thekuba.soj.sides;

import com.thekuba.soj.ClientAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

public class ClientSendSound {
    public ClientSendSound(){

    }

    public void encode(FriendlyByteBuf buf){

    }
    public ClientSendSound(FriendlyByteBuf buf){
    }


//i think it should execute the code that's put in here, so that's what i'm going to do

    //somehow get told by playerJoinedServer that you should execute your code
    public boolean handle(@NotNull Supplier<NetworkEvent.Context> ctx) {
        final var success = new AtomicBoolean(false);
        ctx.get().enqueueWork(() -> {//
            ClientAccess.SoundPlayer();
            // DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> success.set(ClientAccess.returningVariable));
        //.level.playLocalSound(d4, d5, d6, SoundEvents.WITHER_SPAWN, SoundSource.HOSTILE, 1.0F, 1.0F, false)
        });
        ctx.get().setPacketHandled(true);
        return success.get();

    }
}
