/*
 * VitalBroadcast is a Spigot Plugin that gives players the ability to send broadcasts.
 * Copyright © 2022 Leopold Meinel & contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see https://github.com/TamrielNetwork/VitalBroadcast/blob/main/LICENSE
 */

package com.tamrielnetwork.vitalwelcome.utils;

import com.tamrielnetwork.vitalwelcome.VitalBroadcast;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Chat {

	private Chat() {
		throw new IllegalStateException("Utility class");
	}

	private static final VitalBroadcast main = JavaPlugin.getPlugin(VitalBroadcast.class);

	public static void sendBroadcast(@NotNull String message) {

		for (Player player : Bukkit.getServer().getOnlinePlayers()) {
			player.sendMessage(replaceColors(message));
		}
	}

	public static void sendMessage(@NotNull CommandSender player, @NotNull String message) {

		player.sendMessage(replaceColors(Objects.requireNonNull(main.getMessages().getMessagesConf().getString(message))));
	}

	public static String replaceColors(@NotNull String string) {

		return ChatColor.translateAlternateColorCodes('&', string);
	}

}