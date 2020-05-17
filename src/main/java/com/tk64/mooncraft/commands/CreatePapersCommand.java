package com.tk64.mooncraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tk64.mooncraft.PlayerId;

public class CreatePapersCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (args.length == 0) {
      return false;
    }

    Player player = Bukkit.getPlayerExact(args[0]);
    if (player == null) {
      sender.sendMessage(
          ChatColor.ITALIC.toString() + ChatColor.GRAY.toString() + "This player does not exist -> " + args[0]
      );
      return false;
    }

    PlayerId.givePapers(player);
    return true;
  }

}
