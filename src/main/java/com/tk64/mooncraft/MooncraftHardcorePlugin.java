package com.tk64.mooncraft;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.tk64.mooncraft.model.PlayerData;
import com.tk64.mooncraft.util.ServerFileUtil;

public class MooncraftHardcorePlugin extends JavaPlugin {

  private static final Logger LOGGER = Logger.getLogger(MooncraftHardcorePlugin.class.getName());
  public static final ScoreboardManager SCOREBOARD_MANAGER = Bukkit.getScoreboardManager();

  /**
   * List containing all active players on the Server
   */
  private List<PlayerData> activePlayers;

  @Override
  public void onEnable() {
    populateActivePlayers();
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

  private void populateActivePlayers() {
    List<PlayerData> whitelist = getListData(ServerFileUtil.WHITELIST_JSON);
    List<PlayerData> banlist = getListData(ServerFileUtil.BANNED_PLAYERS_JSON);

    activePlayers = new ArrayList<>(whitelist);
    activePlayers.removeAll(banlist);
  }

  private List<PlayerData> getListData(String pathToList) {
    List<PlayerData> list = new ArrayList<>();
    JSONParser parser = new JSONParser();

    try (Reader reader = new FileReader(pathToList)) {
      JSONArray jsonArray = (JSONArray) parser.parse(reader);
      for (Object o : jsonArray) {
        JSONObject jsonObject = (JSONObject) o;
        PlayerData playerData = new PlayerData();

        playerData.setUuid((String) jsonObject.get("uuid"));
        playerData.setName((String) jsonObject.get("name"));

        list.add(playerData);
      }

    } catch (IOException | ParseException e) {
      LOGGER.log(Level.SEVERE, e.toString());
    }

    return list;
  }

}
