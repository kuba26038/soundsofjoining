package com.thekuba.soj.sound;


import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;


public final class configmaker {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> names;


        static
        {

            BUILDER.push("the array of UUIDs for the Sounds Of Joining mod");


            names = BUILDER
                    .comment("To get your UUID either visit https://mcuuid.net/ or check the server log for it since this mod logs your UUID every time you join.")
                    .defineList("UUID_Array", Arrays.asList("893fe864-7b87-4155-b1de-82a517d0e294", "0ca54301-6170-4c44-b3e0-b8afa6b81ed2", "ccfdbafa-2364-310a-95fd-42a807f353bc", "380df991-f603-344c-a090-369bad2a924a"), entry -> true);

            BUILDER.pop();

            SPEC = BUILDER.build();
        }




}
