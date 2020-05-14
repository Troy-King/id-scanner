package com.tk64.mooncraft.model;

public class PlayerData {

  private String uuid;
  private String name;

  public PlayerData() {
    
  }

  public PlayerData(String uuid, String name) {
    super();
    this.uuid = uuid;
    this.name = name;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "PlayerData [uuid=" + uuid + ", name=" + name + "]";
  }

}
