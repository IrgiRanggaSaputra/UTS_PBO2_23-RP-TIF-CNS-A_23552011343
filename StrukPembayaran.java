
package com.mycompany.project_uts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StrukPembayaran {
    public static void cetakStruk(Mahasiswa mhs, int semester, double total, double bayar, double kembalian) {
        System.out.println("\n=========== STRUK PEMBAYARAN ===========");
        System.out.println("Tanggal     : " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println("Nama        : " + mhs.nama);
        System.out.println("NIM         : " + mhs.getNim());
        System.out.println("Semester    : " + semester);
        System.out.println("----------------------------------------");
        System.out.printf("Total Tagihan : Rp%.2f\n", total);
        System.out.printf("Jumlah Bayar  : Rp%.2f\n", bayar);
        System.out.printf("Kembalian     : Rp%.2f\n", kembalian);
        System.out.println("----------------------------------------");
        System.out.println("           Terima Kasih");
        System.out.println("========================================\n");
    }
}

