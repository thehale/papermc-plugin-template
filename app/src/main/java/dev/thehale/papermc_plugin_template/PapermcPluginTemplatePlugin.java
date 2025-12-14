
package dev.thehale.papermc_plugin_template;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import dev.thehale.papermc_plugin_template.bstats.Metrics;
import dev.thehale.papermc_plugin_template.command.ExampleCommand;

public class PapermcPluginTemplatePlugin extends JavaPlugin {

    public static PapermcPluginTemplatePlugin instance;
    public static Logger log;
    public final static String NAME = "PapermcPluginTemplate";
    public final static int BSTATS_PLUGIN_ID = 20765;
    
    private ConfigManager configManager;

    /**
     * Default constructor.
     * 
     * <p>Used solely by MockBukkit during unit tests.
     */
    public PapermcPluginTemplatePlugin() {
        super();
    }

    /**
     * Parameterized constructor.
     * 
     * <p>Used solely by MockBukkit during unit tests.
     */
    protected PapermcPluginTemplatePlugin(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
    }

    @Override
    public void onEnable() {
        instance = this;
        log = getLogger();
        logTemplateAttribution();
        setup();
        log.info("Ready!");
    }

    private void logTemplateAttribution() {
        // Please do *not* remove this attribution. It helps other hopeful plugin developers find this template.
        log.info("[ATTRIBUTION] Powered by the PaperMC Plugin Template created by Joseph Hale (https://jhale.dev)");
        log.info("[ATTRIBUTION] Copyright (c) 2021-2024. All rights reserved.");
        log.info("[ATTRIBUTION] Licensed under the terms of the MPL-2.0 license.");
        log.info("[ATTRIBUTION] Issues with the template can be reported at https://github.com/thehale/papermc-plugin-template/issues");
        log.info("[ATTRIBUTION]");
        log.info("[ATTRIBUTION] CREATE YOUR OWN PLUGIN: https://github.com/thehale/papermc-plugin-template");
    }

    private void setup() {
        configManager = new ConfigManager(this);
        configManager.reloadConfig();
        
        getServer().getPluginManager().registerEvents(new PapermcPluginTemplateListener(), this);
        
        ExampleCommand exampleCommand = new ExampleCommand(this);
        getCommand("example").setExecutor(exampleCommand);
        getCommand("example").setTabCompleter(exampleCommand);
        
        new Metrics(this, BSTATS_PLUGIN_ID);
    }
    
    public ConfigManager getConfigManager() {
        return configManager;
    }

    @Override
    public void onDisable() {
        log.info("Thanks for using " + NAME + "!");
    }
}
