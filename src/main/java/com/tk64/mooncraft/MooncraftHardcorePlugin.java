package com.tk64.mooncraft;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class MooncraftHardcorePlugin extends JavaPlugin {

  public static final ScoreboardManager SCOREBOARD_MANAGER = Bukkit.getScoreboardManager();

  /**
   * Map containing all Players on the Server, sorted by Team name ("Caste") first
   * and then again by Player name
   */
  private Map<String, Set<String>> castMap;

  @Override
  public void onEnable() {
    generateCastMap();
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

  private void generateCastMap() {
    Set<Team> teams = SCOREBOARD_MANAGER.getMainScoreboard().getTeams();
    castMap = new HashMap<>();

    for (Team team : teams) {
      String teamName = team.getDisplayName();
      Set<String> teamMembers = new TreeSet<>((o1, o2) -> o1.compareTo(o2));

      teamMembers.addAll(team.getEntries());
      castMap.put(teamName, teamMembers);
    }
  }

}
