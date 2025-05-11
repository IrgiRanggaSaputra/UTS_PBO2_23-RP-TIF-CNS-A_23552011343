package com.mycompany.project_uts;


import java.sql.*;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("=== SISTEM KASIR ADMINISTRASI KULIAH ===");

            System.out.print("Masukkan ID Mahasiswa: ");
            int idMahasiswa = scanner.nextInt();

            // Ambil data mahasiswa
            String sqlMahasiswa = "SELECT * FROM mahasiswa WHERE id = ?";
            PreparedStatement psMhs = conn.prepareStatement(sqlMahasiswa);
            psMhs.setInt(1, idMahasiswa);
            ResultSet rsMhs = psMhs.executeQuery();

            if (rsMhs.next()) {
                Mahasiswa mhs = new Mahasiswa(
                    rsMhs.getInt("id"),
                    rsMhs.getString("nama"),
                    rsMhs.getString("nim")
                );
                mhs.Info();

                // Ambil tagihan mahasiswa
                String sqlTagihan = "SELECT * FROM tagihan WHERE mahasiswa_id = ?";
                PreparedStatement psTagihan = conn.prepareStatement(sqlTagihan);
                psTagihan.setInt(1, idMahasiswa);
                ResultSet rsTagihan = psTagihan.executeQuery();

                while (rsTagihan.next()) {
                    int tagihanId = rsTagihan.getInt("id");
                    int semester = rsTagihan.getInt("semester");
                    double total = rsTagihan.getDouble("total");

                    System.out.println("\n>> Tagihan Semester " + semester);
                    System.out.println("Total Tagihan: Rp" + total);

                    System.out.print("Masukkan jumlah pembayaran: ");
                    double bayar = scanner.nextDouble();

                    if (bayar >= total) {
                        // Simpan transaksi
                        String sqlInsert = "INSERT INTO transaksi (tagihan_id, jumlah_bayar, tanggal) VALUES (?, ?, NOW())";
                        PreparedStatement psTransaksi = conn.prepareStatement(sqlInsert);
                        psTransaksi.setInt(1, tagihanId);
                        psTransaksi.setDouble(2, bayar);
                        psTransaksi.executeUpdate();

                        double kembalian = bayar - total;
                        System.out.println("Pembayaran berhasil. \nKembalian: Rp" + kembalian);
                        StrukPembayaran.cetakStruk(mhs, semester, total, bayar, kembalian);

                    } else {
                        double kurang = total - bayar;
                        System.out.println("Pembayaran GAGAL. Uang kurang Rp" + kurang);
                        System.out.println("Silakan bayar sesuai total tagihan.");
                    }
                }

            } else {
                System.out.println("Mahasiswa tidak ditemukan.");
            }

        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan koneksi: " + e.getMessage());
        }

        scanner.close();
    }
}
