
# Character Manager — TP3 (Java Visual SIH-6406)

## Deskripsi
Project ini merupakan implementasi dasar Character Manager menggunakan bahasa pemrograman Java. Program menerapkan konsep Object-Oriented Programming (OOP), termasuk encapsulation, constructor, enum, getter, setter, dan method. Program juga dikembangkan dengan fitur mana dan pengecekan status kehidupan karakter.

## Fitur
- Character menggunakan private attributes.
- CharacterType menggunakan enum.
- Dua constructor.
- Getter dan setter lengkap.
- Level up dengan peningkatan HP dan attack.
- Validasi mana agar tidak bernilai negatif.
- Method isAlive().
- toString() untuk menampilkan informasi karakter.

## Struktur Folder

```text
CharacterManager/
├── src/
│   └── com/unpri/charactermanager/
│       ├── model/
│       │   ├── Character.java
│       │   └── CharacterType.java
│       └── Main.java
└── README.md
```

## Teknologi
- Java Development Kit (JDK) 17
- Visual Studio Code

## Screenshot Output
Screenshot hasil program akan ditambahkan setelah pengujian.

## Identitas
- Nama: Mutiara Fitri Salbilla Harahap
- NIM: 253303621258
- Mata Kuliah: Java Visual (SIH-6406)
- Universitas: Universitas Prima Indonesia

## Google Docs
Link dokumentasi analisis TP3: 
# Character Manager — TP3 (Java Visual SIH-6406)

## Deskripsi
Project ini merupakan implementasi dasar Character Manager menggunakan bahasa pemrograman Java. Program menerapkan konsep Object-Oriented Programming (OOP), termasuk encapsulation, constructor, enum, getter, setter, dan method. Program juga dikembangkan dengan fitur mana dan pengecekan status kehidupan karakter.

## Fitur
- Character menggunakan private attributes.
- CharacterType menggunakan enum.
- Dua constructor.
- Getter dan setter lengkap.
- Level up dengan peningkatan HP dan attack.
- Validasi mana agar tidak bernilai negatif.
- Method isAlive().
- toString() untuk menampilkan informasi karakter.

## Struktur Folder

```text
CharacterManager/
├── src/
│   └── com/unpri/charactermanager/
│       ├── model/
│       │   ├── Character.java
│       │   └── CharacterType.java
│       └── Main.java
└── README.md
```

## Teknologi
- Java Development Kit (JDK) 17
- Visual Studio Code

## Screenshot Output
Screenshot hasil program akan ditambahkan setelah pengujian.

## Identitas
- Nama: Mutiara Fitri Salbilla Harahap
- NIM: 253303621258
- Mata Kuliah: Java Visual (SIH-6406)
- Universitas: Universitas Prima Indonesia

## Google Docs
Link dokumentasi analisis TP3: https://docs.google.com/document/d/1nqM4U0Bh2YkM-P9eNSOOGG8PisObq0zCnH0nSqej6Fg/edit?usp=sharing


## TP10 - Sprint #4: Theming & Visual MVC Analysis

### Screenshot Perubahan Tampilan
| Sebelum (v0.3) | Sesudah (v0.4) |
|---|---|
| ![v0.3](screenshots/tp3.png) | ![v0.4](screenshots/outputtp8.png) |

### Alasan Warna Disimpan di AppTheme (bukan di Model Character)
Warna merupakan atribut visual murni yang termasuk dalam tanggung jawab layer View. Model (`Character`) bertugas menyimpan data domain murni (seperti nama, tipe, dan level) tanpa tergantung pada pustaka GUI (`java.awt.Color`). Jika warna disimpan di `Character`, data model menjadi terikat (*tightly coupled*) pada komponen Swing, sehingga sulit digunakan kembali pada antarmuka lain (seperti CLI, Web API, atau Android).

### Dua Properti Tambahan yang Dipilih
1. **Highlight Border khusus Karakter Level Tinggi (`HIGHLIGHT_BORDER`)**: 
   - *Alasan*: Memberikan umpan balik visual (*visual hierarchy*) seketika agar pemain/pengguna dapat membedakan karakter berlevel tinggi ($\ge 5$) secara cepat tanpa membaca teks angka satu per satu.
2. **Tooltip Komponen Kartu (`setToolTipText`)**:
   - *Alasan*: Meningkatkan *User Experience* (UX) dengan menyediakan rincian data karakter secara melayang (*hover action*) tanpa mengotori tata letak teks utama pada kartu.

---
https://docs.google.com/document/d/1lpaXtkJ0zbwD_E9gjEwG83wY2RyfXsQCuyWTb3S-xKY/edit?usp=sharing [Link Google Docs Anda]