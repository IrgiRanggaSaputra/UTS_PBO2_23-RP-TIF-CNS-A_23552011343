# UTS Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: Irgi Rangga Saputra</li>
  <li>NIM: 23552011343</li>
  <li>Studi Kasus: Kasir untuk pengelolaan pembayaran administrasi kuliah</li>
</ul>

## Judul Studi Kasus
<p>"Penerapan Konsep OOP dalam Sistem Kasir Pembayaran Administrasi Kuliah Berbasis Java dan MySQL"</p>

## Penjelasan Studi Kasus
<p>Studi kasus ini membahas perancangan dan implementasi sistem kasir pembayaran administrasi kuliah dengan menggunakan konsep Object-Oriented Programming (OOP) dalam bahasa pemrograman Java, 
  serta integrasi dengan database MySQL.</p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>Konsep: Subclass mewarisi atribut dan method dari superclass untuk menghindari duplikasi kode.</p>
<p>Implementasi</p>

```java
java public abstract class Civitas {
    protected int id;
    protected String nama;

    public Civitas(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public abstract void Info();
}



  public class Mahasiswa extends Civitas {
    private String nim;

    public Mahasiswa(int id, String nama, String nim) {
        super(id, nama); // mewarisi dari Civitas
        this.nim = nim;
    }

    @Override
    public void Info() {
        System.out.println("Mahasiswa: " + nama + " - NIM: " + nim);
    }

    public String getNim() {
        return nim;
    }
}
```

- `Mahasiswa` **mewarisi** (`extends`) dari `Civitas`
- Menggunakan `super()` untuk memanggil konstruktor parent-nya



### 2. Encapsulation
Konsep: Menyembunyikan data dengan modifie(`private`) dan menyediakan akses melalui `getter`/`setter`
Implementasi
```java
public class Nilai {
    private String mataKuliah;
    private double skor;

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public double getSkor() {
        return skor;
    }

    public void setSkor(double skor) {
        this.skor = skor;
    }
}
```
- Data seperti `nilai` dan `matakuliah` disembunyikan (`private`) dan hanya bisa di akses melalui method (`getter`/`setter`)
- Hal tersebut untuk melindungi akses langsung dari luar kelas

### 3. Polymorphism
<p>Konsep: Satu method yang bisa berperilaku berbeda di class turunan</p>
Implementasi:

```java
public class Pembayaran {
    public double hitungTagihan(double total) {
        return total;
    }
}

public class PembayaranDiskon extends Pembayaran {
    @Override
    public double hitungTagihan(double total) {
        return total * 0.95; // Diskon 5%
    }
}
```
- Method `hitungTagihan()` digunakan di dua kelas, tapi perilaku berbeda

### 4. Abstract
<p>Konsep: kelas Abstract tidak bisasdi instansiasi dan digunakan sebagai dasar untuk turunan</p>
Implementasi

```java
public abstract class Civitas {
    protected int id;
    protected String nama;

    public Civitas(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public abstract void Info();
}
```
- `Civitas` adalah __kelas abstrak__
- tidak bisa dibuat objeknya langsung
- subclass `Mahasiswa` __wajib__ mengimplementasi method `Info()`

### Contoh Output Running
<pre>
=== SISTEM KASIR ADMINISTRASI KULIAH ===
Masukkan ID Mahasiswa: 100
Mahasiswa: Budi Santoso - NIM 23552011100

>> Tagihan Semester 4
Total Tagihan: Rp500000.0
Masukkan jumlah pembayaran: 520000
Pembayaran berhasil. 
Kembalian: Rp20000.0

=========== STRUK PEMBAYARAN ===========
Tanggal     : 12-05-2025
Nama        : Budi Santoso
NIM         : 23552011100
Semester    : 4
----------------------------------------
Total Tagihan : Rp500000.00
Jumlah Bayar  : Rp520000.00
Kembalian     : Rp20000.00
----------------------------------------
           Terima Kasih
========================================
</pre>


## Demo Proyek
<ul>
  <li>Github: <a href="https://github.com/IrgiRanggaSaputra/UTS_PBO2_23-RP-TIF-CNS-A_23552011343">Github</a></li>
  <li>Youtube: <a href="https://youtu.be/NBNj186Trf8">Youtube</a></li>
</ul>
