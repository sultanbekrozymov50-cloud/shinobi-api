package com.konoha.shinobi_api.pattern;

import com.konoha.shinobi_api.model.*;

public class ShinobiFactory {
    public static Shinobi createShinobi(String type, String name, int chakra) {
        if ("medic".equalsIgnoreCase(type)) {
            return new MedicNinja(0, name, chakra);
        } else if ("warrior".equalsIgnoreCase(type)) {
            return new WarriorNinja(0, name, chakra);
        }
        throw new IllegalArgumentException("Unknown shinobi type: " + type);
    }
}