// Copyright (c) 2023 Joseph Hale
// 
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package dev.thehale.papermc_plugin_template;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
    
    private final PapermcPluginTemplatePlugin plugin;
    private FileConfiguration config;
    private File configFile;
    
    public ConfigManager(PapermcPluginTemplatePlugin plugin) {
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), "config.yml");
    }
    
    public void reloadConfig() {
        if (!configFile.exists()) {
            plugin.getDataFolder().mkdirs();
            saveDefaultConfig();
        }
        
        config = YamlConfiguration.loadConfiguration(configFile);
        
        InputStream defaultStream = plugin.getResource("config.yml");
        if (defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            config.setDefaults(defaultConfig);
            config.options().copyDefaults(true);
            saveConfig();
        }
    }
    
    public FileConfiguration getConfig() {
        if (config == null) {
            reloadConfig();
        }
        return config;
    }
    
    public void saveConfig() {
        if (config == null || configFile == null) {
            return;
        }
        
        try {
            getConfig().save(configFile);
        } catch (Exception e) {
            plugin.getLogger().severe("Could not save config to " + configFile + ": " + e.getMessage());
        }
    }
    
    private void saveDefaultConfig() {
        if (configFile == null) {
            configFile = new File(plugin.getDataFolder(), "config.yml");
        }
        
        if (!configFile.exists()) {
            plugin.saveDefaultConfig();
        }
    }
    
    public String getString(String path, String defaultValue) {
        return getConfig().getString(path, defaultValue);
    }
    
    public int getInt(String path, int defaultValue) {
        return getConfig().getInt(path, defaultValue);
    }
    
    public boolean getBoolean(String path, boolean defaultValue) {
        return getConfig().getBoolean(path, defaultValue);
    }
    
    @SuppressWarnings("unchecked")
    public List<String> getStringList(String path) {
        return getConfig().getStringList(path);
    }
}

