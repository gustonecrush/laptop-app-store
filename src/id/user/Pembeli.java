package id.user;

import id.aksesoris.Aksesoris;
import id.laptop.Laptop;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Class Pembeli
 *
 * → merupakan class child dari class User yang digunakan untuk membuat objek Pembeli
 *
 * */
public class Pembeli extends User {

    /* PROPERTIES */

    /* --------------------------------------------------------------------------
     * User ID
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data ID User yang dimiliki Pembeli
     *
     * @var Integer
     * */
    private Integer userID;

    /* --------------------------------------------------------------------------
     * Nama
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data nama pembeli
     *
     * @var String
     * */
    private String nama;

    /* --------------------------------------------------------------------------
     * Jenis Kelamin
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data jenis kelamin pembeli
     *
     * @var String
     * */
    private String jenisKelamin;

    /* --------------------------------------------------------------------------
     * Alamat
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data alamat pembeli
     *
     * @var String
     * */
    private String alamat;

    /* --------------------------------------------------------------------------
     * Telepon
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data nomor telepon pembeli
     *
     * @var String
     * */
    private String telp;

    /* --------------------------------------------------------------------------
     * Keranjang Belanja Laptop
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data object-object laptop yang dipilih pembeli untuk
     *   dibeli dan dilakukan proses pembayaran.
     *   Properti ini akan berguna juga ketika ingin menampilkan data pada menu riwayat pembelian
     *
     * @var Map<String, Laptop>
     * */
    private Map<String, Laptop> keranjangBelanjaLaptop = new IdentityHashMap<>();

    /* --------------------------------------------------------------------------
     * Keranjang Belanja Aksesoris
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data object-object aksesoris yang dipilih pembeli untuk
     *   dibeli dan dilakukan proses pembayaran.
     *   Properti ini akan berguna juga ketika ingin menampilkan data pada menu riwayat pembelian
     *
     * @var Map<String, Aksesoris>
     * */
    private Map<String, Aksesoris> keranjangBelanjaAksesoris = new IdentityHashMap<>();

    public static Random rand = new Random();

    /* CONSTRUCTOR */
    public Pembeli(String nama, String jenisKelamin, String alamat, String telp) {
        super("", "password");
        this.userID = rand.nextInt(100);
        this.nama          = nama;
        this.jenisKelamin  = jenisKelamin;
        this.alamat        = alamat;
        this.telp          = telp;
    }

    /* ENCAPSULATIONS */
    public Integer getUserID() { return this.userID; }
    public String getNama() { return this.nama; }
    public String getJenisKelamin() { return this.jenisKelamin; }
    public String getAlamat() { return this.alamat; }
    public String getTelp() { return this.telp; }
    public Map<String, Laptop> getKeranjangBelanjaLaptop() { return this.keranjangBelanjaLaptop; }
    public Map<String, Aksesoris> getKeranjangBelanjaAksesoris() { return this.keranjangBelanjaAksesoris; }

    public void setUserID() { this.userID = rand.nextInt(100); }
    public void setNama(String newNama) { this.nama = newNama; }
    public void setJenisKelamin(String newJenisKelamin) { this.jenisKelamin = newJenisKelamin; }
    public void setAlamat(String newAlamat) { this.alamat = newAlamat; }
    public void setTelp(String newTelp) { this.telp = newTelp; }
    public void setKeranjangBelanjaLaptop(Integer number, Laptop laptopYangDibeli) {
        this.keranjangBelanjaLaptop.put(number.toString(), laptopYangDibeli);
    }
    public void setKeranjangBelanjaAksesoris(Integer number, Aksesoris aksesorisYangDibeli) {
        this.keranjangBelanjaAksesoris.put(number.toString(), aksesorisYangDibeli);
    }

    /* METHODS */

    /* --------------------------------------------------------------------------
     * Cetak Data Pembeli
     * --------------------------------------------------------------------------
     * I → file, parameter dengan tipe FileWriter yang digunakan untuk
     *     menuliskan data pembeli pada sebuah file (txt)
     * O → -
     * Ket → method ini berfungsi untuk menset nilai paid pada tiap-tiap laptop
     *       yang dibeli
     * */
    public void cetakDataPembeli(FileWriter file) throws IOException {
        file.write(" | Nama       : " + this.nama + "\n");
        file.write(" | Gender     : " + this.jenisKelamin + "\n");
        file.write(" | Alamat     : " + this.alamat + "\n");
        file.write(" | No Telepon : " + this.telp + "\n");
    }

    /* --------------------------------------------------------------------------
     * Cetak Struk Pembelian Laptop
     * --------------------------------------------------------------------------
     * I → -
     * O → -
     * Ket → method ini berfungsi untuk mencetak pada console serta membuat file
     *       struk pembelian laptop
     * */
    public void cetakStrukPembelianLaptop() throws IOException {
        Integer numberOfLaptop = 1;

        FileWriter strukPembelian = new FileWriter( "Struk_Pembelian_Laptop_" + this.nama + rand.nextInt(100) + ".txt");

        strukPembelian.write("  =========================================================================================\n");
        strukPembelian.write(" | \t\t\t     \uD83D\uDCBB STRUK PEMBAYARAN LAPTOP LAPTOP STORE \uD83D\uDCBB                   |\n");
        strukPembelian.write("  =========================================================================================\n");
        strukPembelian.write(" | + | Data Pembeli →\n");
        strukPembelian.write("  -----------------------------------------------------------------------------------------\n");
        cetakDataPembeli(strukPembelian);
        strukPembelian.write(" | Tanggal Pembelian  : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "\n");
        strukPembelian.write(" | Tanggal Pembayaran : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))  + "\n");
        strukPembelian.write("  =========================================================================================\n");
        strukPembelian.write(" | + | Laptop Yang Dibeli →\n");
        strukPembelian.write("  -----------------------------------------------------------------------------------------\n");

        for(Map.Entry<String, Laptop> set : this.keranjangBelanjaLaptop.entrySet()) {
            /*
             * aksesoris
             * → Variable dengan tipe Aksesoris untuk menampung nilai object yang didapat tiap perulangannya pada variable set
             *  */
            Laptop laptop = set.getValue();

            /* Cetak numberForAksesoris & properti-properti dari object aksesoris yang dibeli namun belum dibayar */
            if(!laptop.getPaid()) {
                System.out.println(" | " + numberOfLaptop + " | " + laptop.getJenis() + " | Rp. " + laptop.getHarga() + " * " + laptop.getJumlahYangDibeliPembeli() );

                strukPembelian.write(" | " + numberOfLaptop + " | " + laptop.getJenis() + " | Rp. " + laptop.getHarga() + " * " + laptop.getJumlahYangDibeliPembeli()  + "\n" );
            }

            /* Kondisi ini hanya untuk ngakalin cetak garis (----) biar tampilannya rapih */
            if(numberOfLaptop < 10) System.out.println("      ---------------------------------------");

            /* Increment pada variable numberForAksesoris */
            numberOfLaptop++;
        }
        strukPembelian.write("  =========================================================================================\n");
        strukPembelian.write(" | # | Total Bayar → Rp. " + totalBelanjaLaptop() + "\n" );
        strukPembelian.write("  =========================================================================================\n");
        strukPembelian.write(" | # | Status\t → LUNAS\n" );
        strukPembelian.write("\n\n Laptop Store \uD83D\uDC97");
        strukPembelian.write("\n Terima Kasih Telah Berbelanja");
        strukPembelian.close();
        System.out.println(" |   | Total Bayar → Rp. " + totalBelanjaLaptop());
    }

    /* --------------------------------------------------------------------------
     * Cetak Struk Pembelian Aksesoris
     * --------------------------------------------------------------------------
     * I → -
     * O → -
     * Ket → method ini berfungsi untuk mencetak pada console serta membuat file
     *       struk pembelian aksesoris
     * */
    public void cetakStrukPembelianAksesoris() throws IOException {
        Integer numberOfAksesoris = 1;

        FileWriter strukPembelian = new FileWriter( "Struk_Pembelian_Aksesoris_" + this.nama + rand.nextInt(100)  + ".txt");

        strukPembelian.write("  =========================================================================================\n");
        strukPembelian.write(" | \t\t\t   \uD83D\uDCBB STRUK PEMBAYARAN AKSESORIS lAPTOP STORE \uD83D\uDCBB                 |\n");
        strukPembelian.write("  =========================================================================================\n");
        strukPembelian.write(" | + | Data Pembeli →\n");
        strukPembelian.write("  -----------------------------------------------------------------------------------------\n");
        cetakDataPembeli(strukPembelian);
        strukPembelian.write(" | Tanggal Pembelian  : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "\n");
        strukPembelian.write(" | Tanggal Pembayaran : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))  + "\n");
        strukPembelian.write("  =========================================================================================\n");
        strukPembelian.write(" | + | Aksesoris Yang Dibeli →\n");
        strukPembelian.write("  -----------------------------------------------------------------------------------------\n");

        for(Map.Entry<String, Aksesoris> set : this.getKeranjangBelanjaAksesoris().entrySet()) {
            /*
             * aksesoris
             * → Variable dengan tipe Aksesoris untuk menampung nilai object yang didapat tiap perulangannya pada variable set
             *  */
            Aksesoris aksesoris = set.getValue();

            /* Cetak numberForAksesoris & properti-properti dari object aksesoris yang dibeli namun belum dibayar */
            if(!aksesoris.getPaid()) {
                System.out.println(" | " + numberOfAksesoris + " | " + aksesoris.getNama() + " | Rp. " + aksesoris.getHarga() + " * " + aksesoris.getJumlahYangDibeliPembeli() );

                strukPembelian.write(" | " + numberOfAksesoris + " | " + aksesoris.getNama() + " | Rp. " + aksesoris.getHarga() + " * " + aksesoris.getJumlahYangDibeliPembeli()  + "\n" );
            }

            /* Kondisi ini hanya untuk ngakalin cetak garis (----) biar tampilannya rapih */
            if(numberOfAksesoris < 10) System.out.println("      ---------------------------------------");

            /* Increment pada variable numberForAksesoris */
            numberOfAksesoris++;
        }
        
        strukPembelian.write("  =========================================================================================\n");
        strukPembelian.write(" | # | Total Bayar → Rp. " + totalBelanjaAksesoris() + "\n" );
        strukPembelian.write("  =========================================================================================\n");
        strukPembelian.write(" | # | Status\t   → LUNAS\n" );
        strukPembelian.write("\n\n Laptop Store \uD83D\uDC97");
        strukPembelian.write("\n Terima Kasih Telah Berbelanja");
        strukPembelian.close();
        System.out.println(" |   | Total Bayar → Rp. " + totalBelanjaAksesoris());
    }

    /* --------------------------------------------------------------------------
     * Total Belanja Aksesoris
     * --------------------------------------------------------------------------
     * I → -
     * O → -
     * Ket → method ini berfungsi untuk mengembalikan total harga belanja aksesoris
     *       yang dilakukan pembeli
     * */
    public Integer totalBelanjaAksesoris() {
        Integer totalBelanja = 0;
        for(Map.Entry<String, Aksesoris> set : this.keranjangBelanjaAksesoris.entrySet()) {
            Aksesoris aksesoris = set.getValue();
            if(!aksesoris.getPaid()) totalBelanja += aksesoris.getHarga() * aksesoris.getJumlahYangDibeliPembeli();
        }
        return totalBelanja;
    }

    /* --------------------------------------------------------------------------
     * Total Belanja Laptop
     * --------------------------------------------------------------------------
     * I → -
     * O → -
     * Ket → method ini berfungsi untuk mengembalikan total harga belanja laptop
     *       yang dilakukan pembeli
     * */
    public Integer totalBelanjaLaptop() {
        Integer totalBelanja = 0;
        for(Map.Entry<String, Laptop> set : this.keranjangBelanjaLaptop.entrySet()) {
            Laptop laptop = set.getValue();
            if(!laptop.getPaid()) totalBelanja += laptop.getHarga() * laptop.getJumlahYangDibeliPembeli();
        }
        return totalBelanja;
    }

    /* --------------------------------------------------------------------------
     * Set All Paid AKsesoris
     * --------------------------------------------------------------------------
     * I → -
     * O → -
     * Ket → method ini berfungsi untuk menset nilai paid pada tiap-tiap aksesoris
     *       yang dibeli
     * */
    public void setAllPaidAksesoris() {
        for(Map.Entry<String, Aksesoris> set : this.keranjangBelanjaAksesoris.entrySet()) {
            Aksesoris aksesoris = set.getValue();
            if (!aksesoris.getPaid()) aksesoris.setPaid(true);
        }
    }

    /* --------------------------------------------------------------------------
     * Set All Paid Laptop
     * --------------------------------------------------------------------------
     * I → -
     * O → -
     * Ket → method ini berfungsi untuk menset nilai paid pada tiap-tiap laptop
     *       yang dibeli
     * */
    public void setAllPaidLaptop() {
        for(Map.Entry<String, Laptop> set : this.keranjangBelanjaLaptop.entrySet()) {
            Laptop laptop = set.getValue();
            if (!laptop.getPaid()) laptop.setPaid(true);
        }
    }

    /* --------------------------------------------------------------------------
     * Riwayat Pembelian Aksesoris
     * --------------------------------------------------------------------------
     * I → -
     * O → -
     * Ket → method ini berfungsi untuk mencetak data riwayat pembelian aksesoris
     *       yang telah dibeli (lunas)
     * */
    public void riwayatPembelianAksesoris(){
        Integer numberOfAksesoris = 1;
        
        for(Map.Entry<String, Aksesoris> set : this.getKeranjangBelanjaAksesoris().entrySet()) {
            /*
             * aksesoris
             * → Variable dengan tipe Aksesoris untuk menampung nilai object yang didapat tiap perulangannya pada variable set
             *  */
            Aksesoris aksesoris = set.getValue();
            System.out.println(" | " + numberOfAksesoris + " | " + aksesoris.getNama() + " | " );
            System.out.println(" |   | Harga  : Rp. " + aksesoris.getHarga());
            System.out.println(" |   | Jumlah : " + aksesoris.getJumlahYangDibeliPembeli());
            System.out.println(" |   | Total  : Rp. " + (aksesoris.getHarga() * aksesoris.getJumlahYangDibeliPembeli()));

            /* Kondisi ini hanya untuk ngakalin cetak garis (----) biar tampilannya rapih */
            if(numberOfAksesoris < 10) System.out.println("      ---------------------------------------");

            /* Increment pada variable numberForAksesoris */
            numberOfAksesoris++;
        }     
    }

    /* --------------------------------------------------------------------------
     * Riwayat Pembelian Laptop
     * --------------------------------------------------------------------------
     * I → -
     * O → -
     * Ket → method ini berfungsi untuk mencetak data riwayat pembelian laptop
     *       yang telah dibeli (lunas)
     * */
    public void riwayatPembelianLaptop(){
        Integer numberOfLaptop = 1;
        
         for(Map.Entry<String, Laptop> set : this.keranjangBelanjaLaptop.entrySet()) {
            /*
             * aksesoris
             * → Variable dengan tipe Aksesoris untuk menampung nilai object yang didapat tiap perulangannya pada variable set
             *  */
            Laptop laptop = set.getValue();

            /* Cetak numberForAksesoris & properti-properti dari object aksesoris yang dibeli namun belum dibayar */
            System.out.println(" | " + numberOfLaptop + " | " + laptop.getJenis());
            System.out.println(" |   | Harga   : Rp. " + laptop.getHarga());
            System.out.println(" |   | Jumlah  : " + laptop.getJumlahYangDibeliPembeli());
            System.out.println(" |   | Total   : Rp. " + (laptop.getHarga() * laptop.getJumlahYangDibeliPembeli()));

            /* Kondisi ini hanya untuk ngakalin cetak garis (----) biar tampilannya rapih */
            if(numberOfLaptop < 10) System.out.println("      ---------------------------------------");

            /* Increment pada variable numberForAksesoris */
            numberOfLaptop++;
        }  
    }

}
