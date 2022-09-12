/*
 * File: VitalBroadcastCmd.java
 * Author: Leopold Meinel (leo@meinel.dev)
 * -----
 * Copyright (c) 2022 Leopold Meinel & contributors
 * SPDX ID: GPL-3.0-or-later
 * URL: https://www.gnu.org/licenses/gpl-3.0-standalone.html
 * -----
 */

package dev.meinel.leo.vitalwelcome.commands;

import dev.meinel.leo.vitalwelcome.utils.Chat;
import dev.meinel.leo.vitalwelcome.utils.commands.Cmd;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class VitalBroadcastCmd implements CommandExecutor {

  @Override
  public boolean onCommand(
      @NotNull CommandSender sender,
      @NotNull Command command,
      @NotNull String label,
      @NotNull String[] args) {
    if (Cmd.isArgsLengthLessThan(sender, args, 1)) {
      return false;
    }
    doBroadcast(sender, args);
    return true;
  }

  private void doBroadcast(
      @NotNull CommandSender sender,
      @NotNull String[] args) {
    if (Cmd.isNotPermitted(sender, "vitalbroadcast.broadcast")) {
      return;
    }
    StringBuilder broadcastBuilder = new StringBuilder();
    for (String arg : args) {
      if (arg.equals(args[0])) {
        broadcastBuilder.append(arg);
        continue;
      }
      broadcastBuilder.append(" ").append(arg);
    }
    String broadcast = broadcastBuilder.toString();
    Chat.sendBroadcast(broadcast);
  }
}
