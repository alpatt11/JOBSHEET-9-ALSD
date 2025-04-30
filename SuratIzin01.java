import java.util.Scanner;

public class SuratIzin01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackSurat01 stack = new StackSurat01(10);
        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat Izin");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine(); 
            switch (pilihan) {
                case 1:
                    System.out.print("ID Surat: ");
                    String id = sc.nextLine();
                    System.out.print("Nama Mahasiswa: ");
                    String nama = sc.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = sc.nextLine();
                    System.out.print("Jenis Izin (S/I): ");
                    char jenis = sc.nextLine().toUpperCase().charAt(0);
                    System.out.print("Durasi Izin (hari): ");
                    int durasi = sc.nextInt();
                    sc.nextLine();

                    Surat01 suratBaru = new Surat01(id, nama, kelas, jenis, durasi);
                    stack.push(suratBaru);
                    System.out.println("Surat berhasil ditambahkan.");
                    break;

                case 2:
                    Surat01 diproses = stack.pop();
                    if (diproses != null) {
                        System.out.println("Memproses surat izin:");
                        diproses.tampil();
                    }
                    break;

                case 3:
                    Surat01 terakhir = stack.peek();
                    if (terakhir != null) {
                        System.out.println("Surat terakhir:");
                        terakhir.tampil();
                    }
                    break;

                case 4:
                    System.out.print("Masukkan nama mahasiswa: ");
                    String cariNama = sc.nextLine();
                    boolean ditemukan = stack.cariSurat(cariNama);
                    System.out.println(ditemukan ? "Surat ditemukan." : "Surat tidak ditemukan.");
                    break;

                default:
                    System.out.println("Keluar dari program.");
            }
        } while (pilihan >= 1 && pilihan <= 4);

        sc.close();
    }
}