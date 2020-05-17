package com.tk64.mooncraft;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerId {

  private PlayerId() {

  }

  public static ItemStack createPlayerIdPaper(Player player) {
    ItemStack idPaper = new ItemStack(Material.PAPER);
    ItemMeta meta = idPaper.getItemMeta();
    List<String> lore = new ArrayList<>();
    lore.add("Property of: " + player.getDisplayName());

    meta.setDisplayName("Identification");
    meta.setLore(lore);
    meta.addEnchant(Enchantment.DURABILITY, 1, false);
    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

    idPaper.setItemMeta(meta);
    return idPaper;
  }

}
