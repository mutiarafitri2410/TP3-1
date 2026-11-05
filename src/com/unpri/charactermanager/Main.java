
package com.unpri.charactermanager;

import javax.swing.SwingUtilities;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        // Karakter 1
        manager.addCharacter(
                new Character("Aragorn", CharacterType.WARRIOR, 6, 160, 45, 30)
        );

        // Karakter 2
        manager.addCharacter(
                new Character("Gandalf", CharacterType.MAGE, 7, 110, 65, 20)
        );

        // Karakter 3
        manager.addCharacter(
                new Character("Legolas", CharacterType.ARCHER, 4, 130, 55, 25)
        );

        // Karakter 4
        manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 5, 120, 70, 15)
        );

        // Karakter 5
        manager.addCharacter(
                new Character("Dara", CharacterType.HEALER, 3, 150, 25, 35)
        );

        // Karakter 6
        manager.addCharacter(
                new Character("Thorin", CharacterType.WARRIOR, 1, 180, 50, 40)
        );

        // Menjalankan GUI melalui Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}
