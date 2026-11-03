
package com.unpri.charactermanager.model;

public class Character {

    // Atribut private (Encapsulation)
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attack;
    private int defense;
    private int mana;

    // Constructor pertama: constructor sederhana
    public Character(String name, CharacterType type) {
        this(name, type, 1, 100, 10, 5);
    }

    // Constructor kedua: constructor lengkap
    public Character(String name, CharacterType type,
                     int level, int hitPoints,
                     int attack, int defense) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong!");
        }

        if (type == null) {
            throw new IllegalArgumentException("Tipe karakter tidak boleh null!");
        }

        if (level < 1 || hitPoints < 0 || attack < 0 || defense < 0) {
            throw new IllegalArgumentException("Nilai atribut tidak valid!");
        }

        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attack = attack;
        this.defense = defense;
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
            throw new IllegalArgumentException("Nama tidak boleh kosong!");
        }
        this.name = name;
    }

    public void setType(CharacterType type) {
        if (type == null) {
            throw new IllegalArgumentException("Tipe tidak boleh null!");
        }
        this.type = type;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal adalah 1!");
        }

        int difference = level - this.level;

        // Setiap kenaikan level menambah HP dan attack
        this.hitPoints += difference * 10;
        this.attack += difference * 5;

        this.level = level;
    }

    public void setHitPoints(int hitPoints) {
        if (hitPoints < 0) {
            throw new IllegalArgumentException("HP tidak boleh negatif!");
        }
        this.hitPoints = hitPoints;
    }

    public void setAttack(int attack) {
        if (attack < 0) {
            throw new IllegalArgumentException("Attack tidak boleh negatif!");
        }
        this.attack = attack;
    }

    public void setDefense(int defense) {
        if (defense < 0) {
            throw new IllegalArgumentException("Defense tidak boleh negatif!");
        }
        this.defense = defense;
    }

    // Mini-Challenge: Setter mana dengan validasi
    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh bernilai negatif!"
            );
        }
        this.mana = mana;
    }

    // Method level up
    public void levelUp() {
        setLevel(this.level + 1);
    }

    // Mini-Challenge: Memeriksa apakah karakter masih hidup
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Menampilkan informasi karakter
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
