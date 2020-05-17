package com.tk64.mooncraft;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class IdScanner extends JavaPlugin {

  private static final Logger LOGGER = Logger.getLogger(IdScanner.class.getName());

  @Override
  public void onEnable() {

  }

  @Override
  public void onDisable() {

  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    return false;
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {

  }

}
