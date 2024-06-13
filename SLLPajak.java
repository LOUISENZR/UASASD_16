import java.util.Scanner;

public class SLLPajak {
    Scanner sc16 = new Scanner(System.in);
    nodePajak head;
    nodePajak tail;
    transaksiPajak16 kepala;
    transaksiPajak16 ekor;
    int tarif, total, denda, totalAkhir;
    int kode = 0;

    boolean isEmpty() {
        return head == null;
    }

    boolean pajakIsEmpty() {
        return kepala == null;
    }

    void addFirst(kendaraan16 input) {
        nodePajak nodeIN = new nodePajak(input, null);
        if (isEmpty()) {
            head = nodeIN;
            tail = nodeIN;
        } else {
            nodeIN.next = head;
            head = nodeIN;
        }
    }

    void addLast(kendaraan16 input) {
        nodePajak nodeIN = new nodePajak(input, null);
        if (isEmpty()) {
            head = nodeIN;
            tail = nodeIN;
        } else {
            tail.next = nodeIN;
            tail = nodeIN;
        }
    }

    void addLastPajak(kendaraan16 input, int kode, int nominal, int denda, int bulanBayar) {
        transaksiPajak16 pajak = new transaksiPajak16(kode, nominal, denda, bulanBayar, input, null);
        if (pajakIsEmpty()) {
            kepala = pajak;
            ekor = pajak;
        } else {
            ekor.next = pajak;
            ekor = pajak;
        }
    }

    void print() {
        if (!isEmpty()) {
            nodePajak tmp = head;
            System.out.println("|NOMOR TNKB\t|NAMA PEMILIK\t|JENIS\t|CC KENDARAAN\t|TAHUN\t|BULAN HARUS BAYAR\t");
            while (tmp != null) {
                System.out.print(tmp.data.noTNKB + "\t");
                System.out.print(tmp.data.nama + "\t");
                System.out.print(tmp.data.jenis + "\t");
                System.out.print(tmp.data.cc + "\t");
                System.out.print(tmp.data.tahun + "\t");
                System.out.print(tmp.data.bulanHarusBayar + "\t");
                System.out.println("");
                tmp = tmp.next;
            }
            System.out.println("     ");
        } else {
            System.out.println("Linked List Kosong");
        }
    }

    void printPajak() {
        if (!pajakIsEmpty()) {
            transaksiPajak16 tmp = kepala;
            System.out.println("Daftar Transaksi Pembayaran Pajak");
            System.out.print("TNKB\tKODE\tNOMINAL\tDENDA\tBULAN BAYAR\t");
            while (tmp != null) {
                System.out.println("");
                System.out.print(tmp.data.noTNKB + "\t");
                System.out.print(tmp.kode + "\t");
                System.out.print(tmp.nominalBayar + "\t");
                System.out.print(tmp.denda + "\t");
                System.out.print(tmp.bulanBayar + "\t");
                tmp = tmp.next;
            }
            System.out.println("    ");
        } else {
            System.out.println("Linked List Kosong");
        }
    }

    boolean denda(int tnkb) {
        nodePajak tmp = head;
        while (tmp != null) {
            if (tmp.data.noTNKB == tnkb) {
                kode++;
                System.out.println("Data Ada ");
                System.out.print("Jenis Kendaraan :");
                System.out.println("Roda " + tmp.data.jenis);
                System.out.print("CC Kendaraan :");
                System.out.println(tmp.data.cc + "CC");

                if (tmp.data.jenis == 2) {
                    if (tmp.data.cc < 100) {
                        System.out.println("Tarif pajak adalah = 100000");
                        tarif = 100000;
                    } else if (tmp.data.cc >= 100 && tmp.data.cc <= 250) {
                        System.out.println("Tarif pajak adalah = 250000");
                        tarif = 250000;
                    } else if (tmp.data.cc > 250) {
                        System.out.println("Tarif pajak adalah = 500000");
                        tarif = 500000;
                    }
                } else if (tmp.data.jenis == 4) {
                    if (tmp.data.cc < 1000) {
                        System.out.println("Tarif pajak adalah = 750000");
                        tarif = 750000;
                    } else if (tmp.data.cc >= 1000 && tmp.data.cc <= 2500) {
                        System.out.println("Tarif pajak adalah = 1000000");
                        tarif = 1000000;
                    } else if (tmp.data.cc > 2500) {
                        System.out.println("Tarif pajak adalah = 1500000");
                        tarif = 1500000;
                    }
                }

                System.out.print("Bulan Harus Bayar\t ");
                System.out.println("");
                System.out.println("Bulan :" + tmp.data.bulanHarusBayar);
                System.out.println("Bulan Bayar ");
                int bayar = sc16.nextInt();
                int b = bayar - tmp.data.bulanHarusBayar;
                System.out.println("Telat bayar " + b + " Bulan");

                if (b <= 3) {
                    System.out.println("Denda Bayar 50000");
                    denda = 50000;
                    total = tarif + 50000;
                } else {
                    denda = tarif * 50000;
                    total = tarif + denda;
                }

                addLastPajak(tmp.data, kode, tarif, denda, bayar);
                totalAkhir += total;
                return true;
            }
            tmp = tmp.next;
        }
        System.out.println("Data Tidak Ada");
        return false;
    }
    public void sortByName() {
        if (pajakIsEmpty() || kepala == ekor) {
            return; 
        }

        boolean swapped;
        transaksiPajak16 current;
        transaksiPajak16 prev = null;

        do {
            swapped = false;
            current = ekor;

            while (current.next != prev) {
                if (current.data.nama.compareTo(current.next.data.nama) > 0) {
                    // Tukar node
                    transaksiPajak16 temp = current;
                    current = current.next;
                    current.next = temp;
                    swapped = true;
                }
                current = current.next;
            }
            prev = current;
        } while (swapped);
    }


}
