# Laporan Posttest 2 - Encapsulation Joki WuWa

**Nama:** Dimas Elang Satria
**NIM:** 2409106027
**Kelas:** PBO A2 2024

---

## Deskripsi Program
Program ini adalah sistem manajemen joki game **Wuthering Waves** berbasis Java yang memungkinkan admin mengelola antrian joki mulai dari pendaftaran akun hingga status penyelesaian.

Pada **Posttest 2** ini, program telah ditingkatkan dengan menerapkan konsep **Encapsulation**. Data diisolasi di dalam class agar tidak dapat diakses langsung dari luar guna menjaga keamanan informasi akun joki dan mencegah perubahan data yang tidak sengaja.

### Fitur CRUD:
* **Create**: Menambahkan pesanan baru (Username, Password, No HP, Tipe Joki, dan Tingkat Kesulitan).
* **Read**: Menampilkan daftar antrian yang masih aktif dan riwayat yang sudah selesai.
* **Update**: Mengubah status pesanan menggunakan method **Setter**.
* **Delete**: Menghapus data pesanan dari sistem.

---

## Penerapan Encapsulation
Sesuai dengan prinsip Encapsulation yang dipelajari, perubahan yang dilakukan pada proyek ini meliputi:
1. **Access Modifier**: Mengubah semua atribut/properti class menjadi `private` agar data tersembunyi sepenuhnya dari dunia luar.
2. **Getter**: Menyediakan method `public get` untuk mengambil nilai dari properti di dalam class.
3. **Setter**: Menyediakan method `public set` untuk mengatur atau mengubah nilai property (seperti status pesanan) dengan kontrol yang lebih baik.

---

## Struktur Class
Program ini menggunakan 4 Class untuk memisahkan logika data secara terorganisir:
1. `Main`: Pusat jalannya program, menu, dan interaksi user melalui getter/setter.
2. `DataJoki`: Menyimpan informasi identitas akun (Username, Password, No HP) secara privat.
3. `Layanan`: Mengelola jenis joki dan detail pesanan.
4. `Harga`: Menentukan nominal harga otomatis berdasarkan tingkat kesulitan.

---

## Dokumentasi Tampilan Program & Kode

### 1. Menu Utama & CRUD
![Menu Utama](assets/menu.png)

### 2. Implementasi Encapsulation (Kode Program)
![Class](assets/datajokiGetterSetter.png)

![Main](assets/mainGetterSetter.png)

### 3. Output Tambah & Daftar Pesanan
![Tambah Data](assets/tambah.png)
![Lihat Data](assets/lihat.png)