/*
 * File: Chat.java
 * Author: Leopold Meinel (leo@meinel.dev)
 * -----
 * Copyright (c) 2023 Leopold Meinel & contributors
 * SPDX ID: GPL-3.0-or-later
 * URL: https://www.gnu.org/licenses/gpl-3.0-standalone.html
 * -----
 */

package dev.meinel.leo.vitalwelcome.utils;

import dev.meinel.leo.vitalwelcome.VitalBroadcast;
import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Chat {

    private static final VitalBroadcast main = JavaPlugin.getPlugin(VitalBroadcast.class);

    private Chat() {
        throw new IllegalStateException("Utility class");
    }

    public static void sendBroadcast(@NotNull String message) {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.sendMessage(replaceColors(message));
        }
    }

    public static void sendMessage(@NotNull CommandSender player, @NotNull String message) {
        player.sendMessage(replaceColors(
                Objects.requireNonNull(main.getMessages().getMessagesConf().getString(message))));
    }

    public static String replaceColors(@NotNull String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
