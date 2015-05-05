package com.ghostcrab.thermalcasting;

import com.ghostcrab.thermalcasting.handler.ConfigurationHandler;
import com.ghostcrab.thermalcasting.proxy.IProxy;
import com.ghostcrab.thermalcasting.reference.Reference;
import com.ghostcrab.thermalcasting.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version=Reference.VERSION, guiFactory=Reference.GUI_FACTORY_CLASS)
public class ThermalCasting
{
    @Mod.Instance(Reference.MOD_ID)
    public static ThermalCasting instance;

    @SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS,
                serverSide=Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // load network handling, mod config, items and blocks
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        LogHelper.info("Pre Initialization Complete");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        // register guis, tile entities
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // cleanup, other mod integration
    }
}
