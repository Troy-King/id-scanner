package com.tk64.mooncraft;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CommandParser {

  private CommandParser() {

  }

  public static boolean createPapers(CommandSender sender, String[] args) {
    if (args.length == 0) {
      return false;
    }

    Player player = Bukkit.getPlayerExact(args[0]);
    if(player == null) {
      sender.sendMessage(ChatColor.ITALIC.toString() + ChatColor.GRAY.toString() + "This player does not exist -> " + args[0]);
      return false;
    }

    PlayerId.givePapers(player);
    return true;
  }

}
