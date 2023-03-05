package com.fiipractic.week1.models;

public class Pokemon {

    private Integer ID;
    private String name;
    private String type;
    private String trainer;
    private Integer level;

    public Pokemon(Integer ID, String name, String type, String trainer, Integer level) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.trainer = trainer;
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", trainer='" + trainer + '\'' +
                ", level=" + level +
                '}';
    }

}
