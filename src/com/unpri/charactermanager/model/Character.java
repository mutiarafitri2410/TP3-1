package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {

    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attack;
    private int defense;
    private int mana;

    // Constructor sederhana
    public Character(String name, CharacterType type) {
        this(name, type, 1, 100, 10, 5);
    }

    // Constructor lengkap
    public Character(String name, CharacterType type,
                     int level, int hitPoints, int attack, int defense) {

        setName(name);
        setType(type);
        setLevel(level);
        setHitPoints(hitPoints);
        setAttack(attack);
        setDefense(defense);
        this.mana = 0;
    }

    // Getter
    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getMana() {
        return mana;
    }

    // Setter
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong.");
        }
        this.name = name.trim();
    }

    public void setType(CharacterType type) {
        if (type == null) {
            throw new IllegalArgumentException("Tipe karakter tidak boleh null.");
        }
        this.type = type;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal adalah 1.");
        }

        if (this.level > 0 && level > this.level) {
            int kenaikan = level - this.level;
            this.hitPoints += kenaikan * 10;
            this.attack += kenaikan * 5;
        }

        this.level = level;
    }

    public void setHitPoints(int hitPoints) {
        if (hitPoints < 0) {
            throw new IllegalArgumentException("Hit Points tidak boleh negatif.");
        }
        this.hitPoints = hitPoints;
    }

    public void setAttack(int attack) {
        if (attack < 0) {
            throw new IllegalArgumentException("Attack tidak boleh negatif.");
        }
        this.attack = attack;
    }

    public void setDefense(int defense) {
        if (defense < 0) {
            throw new IllegalArgumentException("Defense tidak boleh negatif.");
        }
        this.defense = defense;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh negatif.");
        }
        this.mana = mana;
    }

    // Level up
    public void levelUp() {
        setLevel(this.level + 1);
    }

    // Memeriksa apakah karakter masih hidup
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // AP6: Membandingkan karakter berdasarkan nama
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;
        return Objects.equals(this.name, other.name);
    }

    // hashCode harus konsisten dengan equals
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attack=" + attack +
                ", defense=" + defense +
                ", mana=" + mana +
                ", alive=" + isAlive() +
                '}';
    }
}