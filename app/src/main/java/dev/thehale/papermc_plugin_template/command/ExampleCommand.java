// Copyright (c) 2023 Joseph Hale
// 
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package dev.thehale.papermc_plugin_template.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import dev.thehale.papermc_plugin_template.PapermcPluginTemplatePlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleCommand implements CommandExecutor, TabCompleter {
    
    private final PapermcPluginTemplatePlugin plugin;
    
    public ExampleCommand(PapermcPluginTemplatePlugin plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("papermcplugintemplate.example")) {
            sender.sendMessage("§cYou don't have permission to use this command!");
            return true;
        }
        
        if (args.length == 0) {
            sender.sendMessage("§6=== PapermcPluginTemplate ===");
            sender.sendMessage("§e/example reload §7- Reload the plugin configuration");
            sender.sendMessage("§e/example info §7- Show plugin information");
            sender.sendMessage("§e/example version §7- Show plugin version");
            return true;
        }
        
        switch (args[0].toLowerCase()) {
            case "reload":
                handleReload(sender);
                break;
                
            case "info":
                handleInfo(sender);
                break;
                
            case "version":
                handleVersion(sender);
                break;
                
            default:
                sender.sendMessage("§cUnknown subcommand: " + args[0]);
                sender.sendMessage("§7Use /example for help");
                break;
        }
        
        return true;
    }
    
    private void handleReload(CommandSender sender) {
        try {
            plugin.getConfigManager().reloadConfig();
            sender.sendMessage("§aConfiguration reloaded successfully!");
        } catch (Exception e) {
            sender.sendMessage("§cError reloading configuration: " + e.getMessage());
            plugin.getLogger().severe("Error reloading config: " + e.getMessage());
        }
    }
    
    private void handleInfo(CommandSender sender) {
        sender.sendMessage("§6=== Plugin Information ===");
        sender.sendMessage("§eName: §f" + plugin.getDescription().getName());
        sender.sendMessage("§eVersion: §f" + plugin.getDescription().getVersion());
        sender.sendMessage("§eAuthor: §f" + plugin.getDescription().getAuthors());
        
        if (sender instanceof Player) {
            Player player = (Player) sender;
            sender.sendMessage("§eYour Location: §f" + 
                player.getLocation().getBlockX() + ", " +
                player.getLocation().getBlockY() + ", " +
                player.getLocation().getBlockZ());
        }
    }
    
    private void handleVersion(CommandSender sender) {
        sender.sendMessage("§ePapermcPluginTemplate version §f" + plugin.getDescription().getVersion());
    }
    
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (!sender.hasPermission("papermcplugintemplate.example")) {
            return new ArrayList<>();
        }
        
        if (args.length == 1) {
            List<String> completions = Arrays.asList("reload", "info", "version");
            String input = args[0].toLowerCase();
            
            List<String> result = new ArrayList<>();
            for (String completion : completions) {
                if (completion.startsWith(input)) {
                    result.add(completion);
                }
            }
            return result;
        }
        
        return new ArrayList<>();
    }
}

