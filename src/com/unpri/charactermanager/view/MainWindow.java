
package com.unpri.charactermanager.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
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

    // Konstanta batas level tinggi
    private static final int HIGH_LEVEL_LIMIT = 5;

    private JPanel cardsPanel;
    private JLabel totalLabel;
    private JLabel averageLabel;

    public MainWindow(CharacterManager manager) {

        this.manager = manager;

        setTitle("Character Manager - TP10");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));

        getContentPane().setBackground(AppTheme.BACKGROUND);

        createHeader();
        createCharacterPanel();
        createFooter();

        refreshDisplay();

        // Ukuran jendela mengikuti komponen
        pack();
        setMinimumSize(getSize());
        setLocationRelativeTo(null);
    }

    // ================= HEADER =================
    private void createHeader() {

        JLabel title = new JLabel(
                "CHARACTER MANAGER",
                SwingConstants.CENTER
        );

        title.setFont(AppTheme.TITLE_FONT);
        title.setForeground(AppTheme.TEXT_DARK);
        title.setBorder(
                BorderFactory.createEmptyBorder(20, 10, 10, 10)
        );

        add(title, BorderLayout.NORTH);
    }

    // ================= CHARACTER PANEL =================
    private void createCharacterPanel() {

        cardsPanel = new JPanel(new GridLayout(0, 2, 15, 15));
        cardsPanel.setBackground(AppTheme.BACKGROUND);
        cardsPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        );

        JScrollPane scrollPane = new JScrollPane(cardsPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(AppTheme.BACKGROUND);

        add(scrollPane, BorderLayout.CENTER);
    }

    // ================= FOOTER =================
    private void createFooter() {

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 15));
        footer.setBackground(AppTheme.BACKGROUND);

        totalLabel = new JLabel();
        averageLabel = new JLabel();

        totalLabel.setFont(AppTheme.BOLD_FONT);
        averageLabel.setFont(AppTheme.BOLD_FONT);

        totalLabel.setForeground(AppTheme.TEXT_DARK);
        averageLabel.setForeground(AppTheme.TEXT_DARK);

        footer.add(totalLabel);
        footer.add(averageLabel);

        add(footer, BorderLayout.SOUTH);
    }

    // ================= REFRESH DATA =================
    public void refreshDisplay() {

        cardsPanel.removeAll();

        for (Character character : manager.getAllCharacters()) {
            cardsPanel.add(createCharacterCard(character));
        }

        totalLabel.setText(
                "Total Karakter: " + manager.getTotalCharacters()
        );

        averageLabel.setText(
                String.format(
                        "Rata-rata Level: %.2f",
                        manager.getAverageLevel()
                )
        );

        cardsPanel.revalidate();
        cardsPanel.repaint();

        pack();
    }

    // ================= CHARACTER CARD =================
    private JPanel createCharacterCard(Character character) {

        CharacterType role = character.getType();

        JPanel card = new JPanel(new GridLayout(0, 1, 5, 5));

        // Warna kartu dari AppTheme
        card.setBackground(AppTheme.colorFor(role));

        // Wajib agar warna background JPanel terlihat
        card.setOpaque(true);

        // Border dari AppTheme
        card.setBorder(AppTheme.CARD_BORDER);

        JLabel nameLabel = new JLabel(
                "Nama: " + character.getName()
        );

        JLabel roleLabel = new JLabel(
                "Role: " + role
        );

        JLabel levelLabel = new JLabel(
                "Level: " + character.getLevel()
        );

        JLabel hpLabel = new JLabel(
                "HP: " + character.getHitPoints()
        );

        JLabel attackLabel = new JLabel(
                "Attack: " + character.getAttack()
        );

        JLabel defenseLabel = new JLabel(
                "Defense: " + character.getDefense()
        );

        // Font dan warna teks
        nameLabel.setFont(AppTheme.BOLD_FONT);
        roleLabel.setFont(AppTheme.NORMAL_FONT);
        levelLabel.setFont(AppTheme.NORMAL_FONT);
        hpLabel.setFont(AppTheme.NORMAL_FONT);
        attackLabel.setFont(AppTheme.NORMAL_FONT);
        defenseLabel.setFont(AppTheme.NORMAL_FONT);

        nameLabel.setForeground(AppTheme.TEXT_DARK);
        roleLabel.setForeground(AppTheme.TEXT_DARK);
        hpLabel.setForeground(AppTheme.TEXT_DARK);
        attackLabel.setForeground(AppTheme.TEXT_DARK);
        defenseLabel.setForeground(AppTheme.TEXT_DARK);

        // Mini-Challenge: level minimal 5 berwarna emas dan tebal
        if (character.getLevel() >= HIGH_LEVEL_LIMIT) {

            levelLabel.setForeground(AppTheme.GOLD);
            levelLabel.setFont(AppTheme.HIGH_LEVEL_FONT);

            levelLabel.setText(
                    "★ LEVEL TINGGI: " + character.getLevel()
            );
        }

        // Properti tambahan 1:
        // Tooltip menampilkan informasi karakter saat diarahkan mouse
        card.setToolTipText(
                "Detail " + character.getName()
                + " | HP: " + character.getHitPoints()
                + " | Attack: " + character.getAttack()
                + " | Defense: " + character.getDefense()
        );

        // Properti tambahan 2:
        // Karakter level 1 dibuat nonaktif
        if (character.getLevel() == 1) {

            card.setEnabled(false);
            nameLabel.setEnabled(false);
            roleLabel.setEnabled(false);
            levelLabel.setEnabled(false);
            hpLabel.setEnabled(false);
            attackLabel.setEnabled(false);
            defenseLabel.setEnabled(false);
        }

        card.add(nameLabel);
        card.add(roleLabel);
        card.add(levelLabel);
        card.add(hpLabel);
        card.add(attackLabel);
        card.add(defenseLabel);

        return card;
    }
}
