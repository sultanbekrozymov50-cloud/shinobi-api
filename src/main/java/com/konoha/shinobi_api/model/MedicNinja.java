package com.konoha.shinobi_api.model;

public class MedicNinja extends Shinobi {
    public MedicNinja(int id, String name, int chakraLevel) {
        super(id, name, chakraLevel);
    }

    @Override
    public void performJutsu() {
        System.out.println(getName() + " использует Технику Мистической Ладони!");
    }

    @Override
    public String getNinjaWay() {
        return "Жизнь товарища важнее всего.";
    }

    @Override
    public String getType() {
        return "MedicNinja";
    }
}