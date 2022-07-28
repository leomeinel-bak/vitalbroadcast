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
 * along with this program. If not, see https://github.com/LeoMeinel/VitalBroadcast/blob/main/LICENSE
 */

package com.tamrielnetwork.vitalwelcome.commands;

import com.tamrielnetwork.vitalwelcome.utils.Chat;
import com.tamrielnetwork.vitalwelcome.utils.commands.Cmd;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class VitalBroadcastCmd
		implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
	                         @NotNull String[] args) {
		if (Cmd.isArgsLengthLessThan(sender, args, 1)) {
			return false;
		}
		doBroadcast(sender, args);
		return true;
	}

	private void doBroadcast(@NotNull CommandSender sender, @NotNull String[] args) {
		if (Cmd.isNotPermitted(sender, "vitalbroadcast.broadcast")) {
			return;
		}
		StringBuilder broadcastBuilder = new StringBuilder();
		for (String arg : args) {
			if (arg.equals(args[0])) {
				broadcastBuilder.append(arg);
				continue;
			}
			broadcastBuilder.append(" ")
			                .append(arg);
		}
		String broadcast = broadcastBuilder.toString();
		Chat.sendBroadcast(broadcast);
	}
}
