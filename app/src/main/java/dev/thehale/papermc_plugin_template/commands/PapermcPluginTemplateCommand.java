// Copyright (c) 2023 Joseph Hale
// 
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package dev.thehale.papermc_plugin_template.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * You can add commands to your plugin by creating a class that implements
 * {@link CommandExecutor} and overriding the {@link #onCommand} method.
 * 
 * To handle a command, add logic inside the {@link #onCommand} method. For
 * example, to greet the player who ran the command:
 * 
 * ```
 * public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
 *     if (sender instanceof Player player) {
 *         player.sendMessage("Hello " + player.getName() + "!");
 *     } else {
 *         sender.sendMessage("This command can only be run by a player.");
 *     }
 *     return true;
 * }
 * ```
 * 
 * Each command also needs to be registered in two places:
 * 
 * 1. In {@code plugin.yml}, under the {@code commands:} key. For example:
 *    ```yaml
 *    commands:
 *      hello:
 *        description: Greet the player.
 *        usage: /hello
 *    ```
 * 
 * 2. In the plugin's main class (e.g. {@code PapermcPluginTemplatePlugin}),
 *    by calling {@link org.bukkit.command.PluginCommand#setExecutor} inside the
 *    {@code setup()} method. For example:
 *    ```
 *    getCommand("hello").setExecutor(new PapermcPluginTemplateCommand());
 *    ```
 * 
 * You can also check arguments passed to the command via the {@code args} array.
 * For example, if a player runs {@code /hello world}, then {@code args[0]} will
 * be {@code "world"}.
 * 
 * Learn more about creating commands in the PaperMC documentation:
 * https://docs.papermc.io/paper/dev/commands
 */
public class PapermcPluginTemplateCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player.sendMessage("Hello " + player.getName() + "! (from PapermcPluginTemplate)");
        } else {
            sender.sendMessage("This command can only be run by a player.");
        }
        return true;
    }

}
