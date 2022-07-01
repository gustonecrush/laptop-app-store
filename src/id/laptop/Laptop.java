package id.laptop;

import id.aksesoris.Aksesoris;

/*
 * Class Laptop
 *
 * → merupakan class yang digunakan untuk membuat objek Laptop
 * */
public class Laptop {

    /* PROPERTIES */

    /* -----------------------------------------------------------------------------------------------------------
     * Merk
     * -----------------------------------------------------------------------------------------------------------
     * → Properti yang menyimpan data merk dari laptop yang dijual
     *
     * @var String
     * */
    private String merk;

    /* -----------------------------------------------------------------------------------------------------------
     * Jenis
     * -----------------------------------------------------------------------------------------------------------
     * → Properti yang menyimpan data jenis dari laptop yang dijual
     *
     * @var String
     * */
    private String jenis;

    /* -----------------------------------------------------------------------------------------------------------
     * Kode Laptop
     * -----------------------------------------------------------------------------------------------------------
     * → Properti yang menyimpan data merk dari laptop yang dijual
     *
     * @var Integer
     * */
    private Integer kodeLaptop;

    /* -----------------------------------------------------------------------------------------------------------
     * Harga
     * -----------------------------------------------------------------------------------------------------------
     * → Properti yang menyimpan data harga dari laptop yang dijual
     *
     * @var Integer
     * */
    private Integer harga;

    /* -----------------------------------------------------------------------------------------------------------
     * Stok
     * -----------------------------------------------------------------------------------------------------------
     * → Properti yang menyimpan data stok dari laptop yang dijual, data stok bersifat real-time, dimana
     *   datanya dapat berkurang dengan jumlah laptop yang dibeli apabila user membeli laptop tersebut
     *
     * @var Integer
     * */
    private Integer stok;

    /* -----------------------------------------------------------------------------------------------------------
     * Jumlah Yang Dibeli Pembeli
     * -----------------------------------------------------------------------------------------------------------
     * → Properti yang menyimpan data jumlah item per laptop yang akan dibeli
     *   Ex. Pemebli ingin membeli Macbook Air 2020 sebanyak 5 buah
     *
     * @var Integer
     * */
    protected Integer jumlahYangDibeliPembeli;

    /* -----------------------------------------------------------------------------------------------------------
     * Paid
     * -----------------------------------------------------------------------------------------------------------
     * → Properti yang menyimpan data apakah pembeli telah membayar laptop yang akan dibeli atau belum
     *
     * @var Boolean
     * */
    protected Boolean paid;

    /* Constructor */
    public Laptop(int kodeLaptop, String merk, String jenis, int harga, int stok){
        /*
         * Laptop()
         * I : kodeLaptop, data berupa kode laptop sebagai identifier laptop yang dijual
         *     jenis, data berupa jenis laptop yang dijual
         *     merk, data berupa merk laptop yang dijual
         *     harga, data berapa harga laptop yang dijual
         *     stok, data berupa stok aksesoris yang tersedia
         * O : -
         * Ket : Constructor ini tidak mengembalikan nilai apapun,
         *       digunakan untuk membuat instansiasi/object baru dari kelas Laptop
         * */
        this.kodeLaptop = kodeLaptop;
        this.merk       = merk;
        this.jenis      = jenis;
        this.harga      = harga;
        this.stok       = stok;
    }

    /* ENCAPSULATIONS */
    public String getMerk()  { return this.merk; }
    public String getJenis() { return this.jenis; }
    public Integer getKodeLaptop() { return this.kodeLaptop; }
    public Integer getHarga() { return this.harga; }
    public Integer getStok()  { return this.stok; }
    public Integer getJumlahYangDibeliPembeli() { return this.jumlahYangDibeliPembeli; }
    public Boolean getPaid()  { return this.paid; }

    public void setMerk(String newMerk)   { this.merk = newMerk; }
    public void setJenis(String newJenis) { this.jenis = newJenis; }
    public void setKodeLaptop(Integer newKodeLaptop) { this.kodeLaptop = newKodeLaptop; }
    public void setHarga(Integer newHarga) { this.harga = newHarga; }
    public void setStok(Integer newStok)   { this.stok = newStok; }
    public void setJumlahYangDibeliPembeli(Integer jumlahYangDibeliPembeli) { this.jumlahYangDibeliPembeli = jumlahYangDibeliPembeli; }
    public void setPaid(Boolean paid)   { this.paid = paid; }

    /* METHODS */
    public void cetakInfoLaptop(){
        System.out.println("     |   | Merk  : " + getMerk() );
        System.out.println("     |   | Harga : Rp. " + getHarga() );
        System.out.println("     |   | Stok  : " + getStok() );
    }

}
