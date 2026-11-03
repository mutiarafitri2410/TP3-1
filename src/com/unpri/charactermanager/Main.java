
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("       CHARACTER MANAGER");
        System.out.println("==================================");

        // Membuat tiga karakter
        Character character1 = new Character(
            "Aragorn", CharacterType.WARRIOR,
            5, 150, 40, 30
        );

        Character character2 = new Character(
            "Gandalf", CharacterType.MAGE,
            7, 110, 55, 15
        );

        Character character3 = new Character(
            "Legolas", CharacterType.ARCHER,
            4, 120, 35, 20
        );

        // Menampilkan tiga karakter
        System.out.println("\n=== DAFTAR KARAKTER ===");
        System.out.println(character1);
        System.out.println(character2);
        System.out.println(character3);

        // Demo level up
        System.out.println("\n=== DEMO LEVEL UP ===");

        System.out.println("Sebelum level up:");
        System.out.println(character1);

        character1.levelUp();

        System.out.println("\nSetelah level up:");
        System.out.println(character1);

        // Mini-Challenge: karakter tambahan
        System.out.println("\n=== MINI CHALLENGE ===");

        Character character4 = new Character(
            "Merlin", CharacterType.MAGE
        );

        character4.setMana(150);

        System.out.println(character4);
        System.out.println(
            "Apakah Merlin masih hidup? " + character4.isAlive()
        );

        // Menguji validasi mana
        System.out.println("\n=== TEST VALIDASI MANA ===");

        try {
            character4.setMana(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Validasi berhasil: " + e.getMessage());
        }

        System.out.println("\nProgram selesai.");
    }
}
