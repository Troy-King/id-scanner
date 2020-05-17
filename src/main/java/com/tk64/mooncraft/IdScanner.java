package com.tk64.mooncraft;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class IdScanner extends JavaPlugin {

  private static final Logger LOGGER = Logger.getLogger(IdScanner.class.getName());

  @Override
  public void onEnable() {

  }

  @Override
  public void onDisable() {

  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    boolean success = false;

    if (sender instanceof Player && !sender.isOp()) {
      sender.sendMessage(ChatColor.ITALIC.toString() + ChatColor.GRAY.toString() + "Permission Denied.");
    }

    switch (label.toLowerCase()) {
      case "createpapers":
        success = CommandParser.createPapers(sender, args);
        break;
    }

    return success;
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();

    // you only get papers once, unless through divine intervention
    if (player.hasPlayedBefore()) {
      return;
    }

    PlayerId.givePapers(player);
  }

}
