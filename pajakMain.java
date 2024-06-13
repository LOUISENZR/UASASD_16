import java.util.Scanner;

public class pajakMain {
    public static void main(String[] args) {
        SLLPajak lois = new SLLPajak();
        Scanner sc16 = new Scanner(System.in);
        int menu;

        kendaraan16 kendaraan1 = new kendaraan16(1234, "Toyota Avanza", 2, 1300, 2020, 4, 6);
        kendaraan16 kendaraan2 = new kendaraan16(5678, "Honda Civic", 4, 2000, 2018, 3, 5);
        kendaraan16 kendaraan3 = new kendaraan16(9101, "Suzuki Ertiga", 2, 1200, 2019, 5, 7);
        kendaraan16 kendaraan4 = new kendaraan16(2345, "Mitsubishi Pajero", 4, 2500, 2015, 2, 4);

        lois.addFirst(kendaraan1);
        lois.addLast(kendaraan2);
        lois.addLast(kendaraan3);
        lois.addLast(kendaraan4);

        do {
            System.out.println("==================*******================");
            System.out.println("         PAJAK DAERAH ANTARTIKA          ");
            System.out.println("==================*******================");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Bayar Pajak");
            System.out.println("3. Tampilkan Seluruh Transaksi");
            System.out.println("4. Urutkan Transaksi Berdasarkan Nama Pemilik");
            System.out.println("5. Keluar");
            System.out.print("Input Nomor\t\t: ");
            menu = sc16.nextInt();
            sc16.nextLine(); 

            switch (menu) {
                case 1:
                    System.out.println("=====================================");
                    System.out.println("\t\tDAFTAR KENDARAAN");
                    System.out.println("=====================================");
                    lois.print();
                    break;
                case 2:
                    System.out.println("=====================================");
                    System.out.println("\t\tBAYAR PAJAK");
                    System.out.println("=====================================");
                    System.out.print("Masukkan TNKB\t\t: ");
                    int tnkb = sc16.nextInt();
                    // sc.next(); 
                    // sc.nextLine();
                    boolean success = lois.denda(tnkb);
                    if (success) {
                        System.out.println("Pembayaran pajak berhasil!");
                    } else {
                        System.out.println("TNKB tidak ditemukan, silakan coba lagi.");
                    }
                    break;
                case 3:
                    System.out.println("=====================================");
                    System.out.println("\t\tSELURUH TRANSAKSI");
                    System.out.println("=====================================");
                    lois.printPajak();
                    System.out.println("Total Pendapatan " + lois.totalAkhir);
                    break;
                case 4:
                    System.out.println("=====================================");
                    System.out.println("\tURUTKAN TRANSAKSI BERDASARKAN NAMA PEMILIK");
                    System.out.println("=====================================");
                    lois.sortByName();
                    lois.print();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (menu > 0 && menu < 5);
    }
}