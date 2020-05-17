package com.tk64.mooncraft;

import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
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
    Player player = event.getPlayer();
    ItemStack idPaper = PlayerId.createPlayerIdPaper(player);

    // try to add Id Papers to player inventory; if not, then drop at feet
    Map<Integer, ItemStack> rejectedItems = player.getInventory().addItem(idPaper);
    if (!rejectedItems.isEmpty()) {
      player.getWorld().dropItem(player.getLocation().add(0, 1, 0), idPaper);
    }
  }

}
