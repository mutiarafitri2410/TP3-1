package com.unpri.charactermanager;

import java.util.ArrayList;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        System.out.println("==================================");
        System.out.println("     CHARACTER MANAGER - AP6");
        System.out.println("==================================");

        // Membuat karakter
        Character aragorn = new Character(
                "Aragorn", CharacterType.WARRIOR, 6, 160, 45, 30);

        Character gandalf = new Character(
                "Gandalf", CharacterType.MAGE, 7, 110, 55, 15);

        Character legolas = new Character(
                "Legolas", CharacterType.ARCHER, 4, 120, 35, 20);

        Character merlin = new Character(
                "Merlin", CharacterType.MAGE, 5, 100, 60, 10);

        Character dara = new Character(
                "Dara", CharacterType.HEALER, 3, 130, 20, 25);

        // Menguji addCharacter()
        System.out.println("\n--- MENAMBAHKAN KARAKTER ---");

        manager.addCharacter(aragorn);
        manager.addCharacter(gandalf);
        manager.addCharacter(legolas);
        manager.addCharacter(merlin);
        manager.addCharacter(dara);

        // Menguji penolakan nama duplikat
        Character aragornDuplikat = new Character(
                "Aragorn", CharacterType.MAGE, 2, 100, 20, 10);

        boolean duplicateResult = manager.addCharacter(aragornDuplikat);

        System.out.println("Karakter duplikat berhasil ditambahkan: "
                + duplicateResult);

        // Menampilkan semua karakter
        System.out.println("\n--- DAFTAR KARAKTER ---");

        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        // Menguji findByName()
        System.out.println("\n--- PENCARIAN KARAKTER ---");

        Character found = manager.findByName("Gandalf");

        if (found != null) {
            System.out.println("Karakter ditemukan: " + found);
        } else {
            System.out.println("Karakter tidak ditemukan.");
        }

        // Menguji getTotalCharacters()
        System.out.println("\nTotal karakter: "
                + manager.getTotalCharacters());

        // Menguji getAverageLevel()
        System.out.println("\n--- ANALISIS KARAKTER ---");

        System.out.printf("Rata-rata level: %.2f%n",
                manager.getAverageLevel());

        // Menguji findByType()
        System.out.println("\nKarakter dengan tipe MAGE:");

        ArrayList<Character> mages =
                manager.findByType(CharacterType.MAGE);

        for (Character mage : mages) {
            System.out.println(mage.getName());
        }

        // Menguji metode analisis tambahan
        Character strongest = manager.findStrongest();

        if (strongest != null) {
            System.out.println("\nKarakter dengan attack tertinggi: "
                    + strongest.getName()
                    + " (Attack: " + strongest.getAttack() + ")");
        }

        // Menguji equals()
        System.out.println("\n--- PENGUJIAN EQUALS ---");

        Character characterA = new Character(
                "Aragorn", CharacterType.WARRIOR);

        Character characterB = new Character(
                "Aragorn", CharacterType.MAGE);

        System.out.println("characterA == characterB: "
                + (characterA == characterB));

        System.out.println("characterA.equals(characterB): "
                + characterA.equals(characterB));

        // Menguji defensive copy
        System.out.println("\n--- PENGUJIAN DEFENSIVE COPY ---");

        ArrayList<Character> copiedList = manager.getAllCharacters();

        System.out.println("Jumlah data sebelum list salinan diubah: "
                + manager.getTotalCharacters());

        copiedList.clear();

        System.out.println("Jumlah data setelah list salinan dihapus: "
                + manager.getTotalCharacters());

        // Menguji removeCharacter()
        System.out.println("\n--- MENGHAPUS KARAKTER ---");

        boolean removed = manager.removeCharacter("Dara");

        System.out.println("Dara berhasil dihapus: " + removed);

        System.out.println("Total karakter sekarang: "
                + manager.getTotalCharacters());

        // Menampilkan daftar akhir
        System.out.println("\n--- DAFTAR AKHIR ---");

        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        System.out.println("\n==================================");
        System.out.println("       PROGRAM SELESAI");
        System.out.println("==================================");
    }
}