package com.ghostcrab.thermalcasting.handler;

import com.ghostcrab.thermalcasting.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;

    public static boolean testValue = false;

    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if(configuration == null)
        {
            Configuration configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if(event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        try
        {
            // Load the configuration file
            configuration.load();

            // Read in properties from configuration file
            testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false,
                    "This is an example config value");
        }
        catch(Exception e)
        {
            // Log the exception
        }
        finally
        {
            // Save the configuration file
            if(configuration.hasChanged())
            {
                configuration.save();
            }
        }

        System.out.println(testValue);
    }
}
