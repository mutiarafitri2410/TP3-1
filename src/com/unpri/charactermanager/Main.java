
package com.unpri.charactermanager;

import javax.swing.SwingUtilities;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        manager.addCharacter(new Character(
                "Aragorn", CharacterType.WARRIOR, 6, 160, 45, 30
        ));

        manager.addCharacter(new Character(
                "Gandalf", CharacterType.MAGE, 7, 110, 55, 15
        ));

        manager.addCharacter(new Character(
                "Legolas", CharacterType.ARCHER, 4, 120, 35, 20
        ));

        manager.addCharacter(new Character(
                "Merlin", CharacterType.MAGE, 5, 100, 60, 10
        ));

        manager.addCharacter(new Character(
                "Dara", CharacterType.HEALER, 3, 130, 20, 25
        ));

        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}
