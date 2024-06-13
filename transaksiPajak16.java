public class transaksiPajak16 {
    int kode, bulanBayar;
    long nominalBayar, denda;
    kendaraan16 data; 
    transaksiPajak16 next;

    transaksiPajak16(int kode, long nominalBayar, long denda, int bulanBayar, kendaraan16 data, transaksiPajak16 next){
        this.kode = kode;
        this.nominalBayar = nominalBayar;
        this.denda = denda;
        this.bulanBayar = bulanBayar;
        this.data = data;
        this.next = next;
    }
}
