package com.mrmelon54.infrastructury.neoforge;

import com.mrmelon54.infrastructury.utils.ConfigScreenRegistrar;
import net.neoforged.fml.ModLoadingContext;
#if MC_VER <= MC_1_20_4
import net.neoforged.neoforge.client.ConfigScreenHandler.ConfigScreenFactory;
#else
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
#endif

public class InfrastructuryImpl {
    public static void registerConfigScreen(ConfigScreenRegistrar registrar) {
        #if MC_VER <= MC_1_20_4
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenFactory.class, () -> new ConfigScreenFactory(registrar::registerConfigScreen));
        #else
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> registrar::registerConfigScreen);
        #endif
    }
}
