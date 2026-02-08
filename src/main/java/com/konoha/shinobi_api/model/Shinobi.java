package com.konoha.shinobi_api.model;

public abstract class Shinobi {
    private int id;
    private String name;
    private int chakraLevel;

    public Shinobi(int id, String name, int chakraLevel) {
        this.id = id;
        this.name = name;
        this.chakraLevel = chakraLevel;
    }

    // Геттеры и сеттеры обязательны для JSON!
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public int getChakraLevel() { return chakraLevel; }

    public abstract void performJutsu();
    public abstract String getNinjaWay();
    public abstract String getType();


    // === PATTERN: BUILDER ===
    // Позволяет создавать объекты так: Shinobi.builder().name("Naruto").build();
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private int chakra;
        private String type;

        public Builder name(String name) { this.name = name; return this; }
        public Builder chakra(int chakra) { this.chakra = chakra; return this; }
        public Builder type(String type) { this.type = type; return this; }

        public Shinobi build() {
            if ("medic".equalsIgnoreCase(type)) {
                return new MedicNinja(0, name, chakra);
            }
            return new WarriorNinja(0, name, chakra);
        }
    }
}