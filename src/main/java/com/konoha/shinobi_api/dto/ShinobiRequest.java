package com.konoha.shinobi_api.dto;

public class ShinobiRequest {
    private String name;
    private int chakra;
    private String type; // "warrior" или "medic"

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getChakra() { return chakra; }
    public void setChakra(int chakra) { this.chakra = chakra; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}