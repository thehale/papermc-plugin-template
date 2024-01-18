// Copyright (c) 2023 Joseph Hale
// 
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package dev.thehale.papermc_plugin_template;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * You can add methods to this class to react to different events in the
 * Minecraft world.
 * 
 * To react to an event, add a method with the @EventHandler annotation, then
 * add a parameter to the method with the type of event you want to react to.
 * 
 * For example, if you want to react to a player joining the server, add a
 * method like this:
 * 
 * ```
 * @EventHandler
 * public void onPlayerJoin(PlayerJoinEvent event) {
 *    // Your code here
 * }
 * ```
 * 
 * Or if you want to react to a player breaking a block, add a method like this:
 * ```
 * @EventHandler
 * public void onBlockBreak(BlockBreakEvent event) {
 *   // Your code here
 * }
 * ```
 * 
 * For each type of event, you'll also have to add an `import` statement at the
 * top of this file (e.g. `import org.bukkit.event.player.PlayerJoinEvent;` or
 * `import org.bukkit.event.block.BlockBreakEvent`).
 * 
 * Check out the list of available events in the Spigot API documentation:
 * https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/event/package-summary.html
 * 
 * Learn more about event handling in the PaperMC documentation:
 * https://docs.papermc.io/paper/dev/event-listeners
 */
public class PapermcPluginTemplateListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("Hello " + player.getName() + "! (from PapermcPluginTemplate)");
    }

}