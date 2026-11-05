
package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import com.unpri.charactermanager.model.CharacterType;

public final class AppTheme {

    // ================= WARNA =================
    public static final Color BACKGROUND = new Color(245, 247, 252);
    public static final Color TEXT_DARK = new Color(35, 45, 65);
    public static final Color GOLD = new Color(212, 160, 30);

    // Warna kartu berdasarkan role
    public static final Color WARRIOR_COLOR = new Color(255, 225, 225);
    public static final Color MAGE_COLOR = new Color(225, 235, 255);
    public static final Color ARCHER_COLOR = new Color(225, 245, 225);
    public static final Color HEALER_COLOR = new Color(245, 230, 255);

    // ================= FONT =================
    public static final Font TITLE_FONT =
            new Font("SansSerif", Font.BOLD, 24);

    public static final Font NORMAL_FONT =
            new Font("SansSerif", Font.PLAIN, 14);

    public static final Font BOLD_FONT =
            new Font("SansSerif", Font.BOLD, 14);

    // Font untuk karakter level tinggi
    public static final Font HIGH_LEVEL_FONT =
            new Font("SansSerif", Font.BOLD, 16);

    // ================= BORDER =================
    public static final Border CARD_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                            new Color(210, 215, 225), 1),
                    BorderFactory.createEmptyBorder(12, 12, 12, 12)
            );

    private AppTheme() {
        // Mencegah objek AppTheme dibuat
    }

    // Memilih warna berdasarkan role karakter
    public static Color colorFor(CharacterType type) {

        if (type == null) {
            return BACKGROUND;
        }

        switch (type) {
            case WARRIOR:
                return WARRIOR_COLOR;

            case MAGE:
                return MAGE_COLOR;

            case ARCHER:
                return ARCHER_COLOR;

            case HEALER:
                return HEALER_COLOR;

            default:
                return BACKGROUND;
        }
    }
}
