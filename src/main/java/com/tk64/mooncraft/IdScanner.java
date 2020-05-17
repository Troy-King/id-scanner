package com.tk64.mooncraft;

import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.command.Command;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

import com.tk64.mooncraft.commands.CreatePapersCommand;

@Plugin(name = IdScanner.PLUGIN_NAME, version = "1.0.0")
@Author(name = "Tak_atak")
@Command(name = "createpapers")
public class IdScanner extends JavaPlugin {

  public static final String PLUGIN_NAME = "IdScanner";
  private static final Logger LOGGER = Logger.getLogger(IdScanner.class.getName());

  @Override
  public void onEnable() {
    this.getCommand("createpapers").setExecutor(new CreatePapersCommand());
  }

  @Override
  public void onDisable() {

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
