// Copyright (c) 2023 Joseph Hale
// 
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package dev.thehale.papermc_plugin_template;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import dev.thehale.papermc_plugin_template.bstats.Metrics;

public class PapermcPluginTemplatePlugin extends JavaPlugin {

    public static PapermcPluginTemplatePlugin instance;
    public static Logger log;
    public final static String NAME = "PapermcPluginTemplate";
    public final static int BSTATS_PLUGIN_ID = 20765;  // TODO: Replace with your own bStats plugin ID

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
        getServer().getPluginManager().registerEvents(new PapermcPluginTemplateListener(), this);
        new Metrics(this, BSTATS_PLUGIN_ID);  // Enable bStats metrics
    }

    @Override
    public void onDisable() {
        log.info("Thanks for using papermc_plugin_template!");
    }
}