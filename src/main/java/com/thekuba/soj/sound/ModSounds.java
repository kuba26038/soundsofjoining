package com.thekuba.soj.sound;

import com.thekuba.soj.SoundsOfJoining;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
//MinecraftForge.EVENT_BUS.register(new ListenerClass());
public class ModSounds {
public static final DeferredRegister<SoundEvent> SOUND_EVENTS = 
					DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SoundsOfJoining.MOD_ID);

public static RegistryObject<SoundEvent> THE_SOUND_ITSELF = registerSoundEvent("the_sound_itself");

private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
	return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(SoundsOfJoining.MOD_ID, name)));
}

public static void register(IEventBus eventBus) {
	SOUND_EVENTS.register(eventBus);
}
}

