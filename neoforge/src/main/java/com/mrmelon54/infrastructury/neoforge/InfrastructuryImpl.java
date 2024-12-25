package com.mrmelon54.infrastructury.neoforge;

import com.mrmelon54.infrastructury.utils.ConfigScreenRegistrar;
import net.neoforged.fml.ModLoadingContext;
#if MC_VER >= MC_1_21_1
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.minecraft.client.Minecraft;
#elif MC_VER >= MC_1_20_6
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
#else
import net.neoforged.neoforge.client.ConfigScreenHandler.ConfigScreenFactory;
#endif

public class InfrastructuryImpl {
    public static void registerConfigScreen(ConfigScreenRegistrar registrar) {
        #if MC_VER >= MC_1_21_1
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> (modContainer, parent) -> registrar.registerConfigScreen(Minecraft.getInstance(), parent));
        #elif MC_VER >= MC_1_20_6
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> registrar::registerConfigScreen);
        #else
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenFactory.class, () -> new ConfigScreenFactory(registrar::registerConfigScreen));
        #endif
    }
}
