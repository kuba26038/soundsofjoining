package com.thekuba.soj;

import com.thekuba.soj.sound.ModSounds;

import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(soundsofjoining.MOD_ID)
public class soundsofjoining {

public static final String MOD_ID = "soundsofjoining";
	public soundsofjoining() {	
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
    @SubscribeEvent
    public void pickupItem(PlayerLoggedInEvent event) {

    }
} 
