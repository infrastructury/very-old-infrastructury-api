package com.mrmelon54.infrastructury;

import com.mrmelon54.infrastructury.utils.ConfigScreenRegistrar;
import dev.architectury.injectables.annotations.ExpectPlatform;

public class Infrastructury {
    public static final String MOD_ID = "infrastructury";

    public static void init() {
    }

    @ExpectPlatform
    public static void registerConfigScreen(ConfigScreenRegistrar registrar) {
        // Implemented by each platform
    }
}
