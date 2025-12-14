// Copyright (c) 2023 Joseph Hale
// 
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package dev.thehale.papermc_plugin_template;

import static org.junit.Assert.*;

import org.bukkit.plugin.PluginDescriptionFile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;

public class PapermcPluginTemplatePluginTest {
    
    private ServerMock server;
    private PapermcPluginTemplatePlugin plugin;
    
    @Before
    public void setUp() {
        server = MockBukkit.mock();
        plugin = MockBukkit.load(PapermcPluginTemplatePlugin.class);
    }
    
    @After
    public void tearDown() {
        MockBukkit.unmock();
    }
    
    @Test
    public void testPluginLoads() {
        assertNotNull("Plugin should not be null", plugin);
        assertTrue("Plugin should be enabled", plugin.isEnabled());
    }
    
    @Test
    public void testPluginName() {
        assertEquals("PapermcPluginTemplate", PapermcPluginTemplatePlugin.NAME);
        assertEquals("PapermcPluginTemplate", plugin.getDescription().getName());
    }
    
    @Test
    public void testPluginVersion() {
        assertEquals("0.1.0", plugin.getDescription().getVersion());
    }
    
    @Test
    public void testConfigManager() {
        ConfigManager configManager = plugin.getConfigManager();
        assertNotNull("ConfigManager should not be null", configManager);
        
        String message = configManager.getString("example.message", "default");
        assertNotNull("Config message should not be null", message);
    }
    
    @Test
    public void testPluginInstance() {
        assertEquals("Static instance should match", plugin, PapermcPluginTemplatePlugin.instance);
    }
}

