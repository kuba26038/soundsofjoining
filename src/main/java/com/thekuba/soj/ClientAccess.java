package com.thekuba.soj;

import com.thekuba.soj.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


import javax.annotation.Nullable;

public class ClientAccess {
    @Nullable
    private static final Minecraft minecraft = Minecraft.getInstance();
@OnlyIn(Dist.CLIENT)
public static void SoundPlayer(){

        double d4 = minecraft.gameRenderer.getMainCamera().getPosition().x;
        double d5 = minecraft.gameRenderer.getMainCamera().getPosition().y;
        double d6 = minecraft.gameRenderer.getMainCamera().getPosition().z;
    minecraft.level.playLocalSound(d4, d5, d6, ModSounds.THE_SOUND_ITSELF.get(), SoundSource.RECORDS, 1.0F, 1.0F, false);
    }
}

