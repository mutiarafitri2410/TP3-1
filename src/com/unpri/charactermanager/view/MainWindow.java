
package com.unpri.charactermanager.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.unpri.charactermanager.CharacterManager;
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class MainWindow extends JFrame {

    private final CharacterManager manager;
    private JPanel characterPanel;
    private JLabel averageLevelLabel;
    private JLabel totalCharacterLabel;
    private JButton addButton;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager - TP8");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        JLabel titleLabel = new JLabel(
                "CHARACTER MANAGER",
                SwingConstants.CENTER
        );
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
        titleLabel.setBorder(
                BorderFactory.createEmptyBorder(20, 10, 10, 10)
        );
        add(titleLabel, BorderLayout.NORTH);

        characterPanel = new JPanel(new GridLayout(0, 2, 12, 12));
        characterPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        );

        JScrollPane scrollPane = new JScrollPane(characterPanel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 20, 20, 20)
        );

        JPanel statisticsPanel = new JPanel(new GridLayout(2, 1, 5, 5));

        averageLevelLabel = new JLabel();
        averageLevelLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

        totalCharacterLabel = new JLabel();
        totalCharacterLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        statisticsPanel.add(averageLevelLabel);
        statisticsPanel.add(totalCharacterLabel);

        bottomPanel.add(statisticsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        addButton = new JButton("Tambah Karakter");
        addButton.addActionListener(e -> addNewCharacter());

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshDisplay());

        buttonPanel.add(refreshButton);
        buttonPanel.add(addButton);

        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);

        refreshDisplay();
    }

    private void refreshDisplay() {
        characterPanel.removeAll();

        ArrayList<Character> characters = manager.getAllCharacters();

        for (Character character : characters) {
            JPanel card = new JPanel(new GridLayout(0, 1, 5, 5));

            card.setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(
                                    java.awt.Color.GRAY
                            ),
                            BorderFactory.createEmptyBorder(10, 12, 10, 12)
                    )
            );

            JLabel nameLabel = new JLabel(character.getName());
            nameLabel.setFont(new Font("SansSerif", Font.BOLD, 17));

            card.add(nameLabel);
            card.add(new JLabel("Role: " + character.getType()));
            card.add(new JLabel("Level: " + character.getLevel()));
            card.add(new JLabel("HP: " + character.getHitPoints()));
            card.add(new JLabel("Attack: " + character.getAttack()));
            card.add(new JLabel("Defense: " + character.getDefense()));

            characterPanel.add(card);
        }

        averageLevelLabel.setText(
                String.format(
                        "Rata-rata Level: %.2f",
                        manager.getAverageLevel()
                )
        );

        totalCharacterLabel.setText(
                "Total Karakter: " + manager.getTotalCharacters()
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }

    private void addNewCharacter() {
        Character newCharacter = new Character(
                "Thorin",
                CharacterType.WARRIOR,
                8, 180, 65, 35
        );

        boolean added = manager.addCharacter(newCharacter);

        if (added) {
            addButton.setEnabled(false);
            refreshDisplay();
        }
    }
}
