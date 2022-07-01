package id.aksesoris;

/*
 * Class Aksesoris
 *
 * → merupakan class yang digunakan untuk membuat objek Aksesoris. Class Aksesoris ini merupakan parent class,
 *   terdapat beberapa child class yang meng-inherit class ini, antara lain :
 *   1. Mouse
 *   2. Charger
 *   3. Keyboard
 *   4. Monitor
 *   5. USB_FlashDrive
 *   6. Hardisk
 * */
public class Aksesoris {

    /* PROPERTIES */

    /* --------------------------------------------------------------------------
     * Nama
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data nama aksesoris yang dijual
     *
     * @var String
     * */
    protected String nama;

    /* --------------------------------------------------------------------------
     * Merk
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data merk aksesoris yang dijual
     *
     * @var String
     * */
    protected String merk;

    /* --------------------------------------------------------------------------
     * Harga
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data harga aksesoris yang dijual
     *
     * @var Integer
     * */
    protected Integer harga;

    /* --------------------------------------------------------------------------
     * Stok
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data stok dari aksesoris yang dijual, data stok bersifat real-time, dimana
     *   datanya dapat berkurang dengan jumlah aksesoris yang dibeli apabila user membeli aksesoris tersebut
     *
     * @var Integer
     * */
    protected Integer stok;

    /* --------------------------------------------------------------------------
     * Jenis
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data jenis aksesoris yang dijual, apakah itu Mouse, Speaker, dll
     *
     * @var String
     * */
    protected String jenis;

    /* --------------------------------------------------------------------------
     * Jumlah Yang Dibeli Pembeli
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data jumlah item per aksesoris yang akan dibeli
     *   Ex. Pemebli ingin membeli Mouse Logitech sebanyak 5 buah
     *
     * @var Boolean
     * */
    protected Integer jumlahYangDibeliPembeli;

    /* --------------------------------------------------------------------------
     * Paid
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data apakah pembeli telah membayar aksesoris yang akan dibeli atau belum
     *
     * @var Boolean
     * */
    protected Boolean paid;

    /* CONSTRUCTOR */
    public Aksesoris(String nama, String merk, Integer harga, Integer stok, String jenis) {
        /*
         * Aksesoris()
         * I : nama, data berupa nama aksesoris yang dijual
         *     merk, data berupa merk aksesoris yang dijual
         *     harga, data berapa harga aksesoris yang dijual
         *     stok, data berupa stok aksesoris yang tersedia
         * O : -
         * Ket : Constructor ini tidak mengembalikan nilai apapun, digunakan untuk membuat instansiasi/object baru dari kelas Aksesoris
         *       apabila user mengisikan paramater pada saat instansiasi objek
         * */
        this.nama  = nama;
        this.merk  = merk;
        this.harga = harga;
        this.stok  = stok;
        this.jenis = jenis;
    }

    public Aksesoris() {
        /*
         * Aksesoris()
         * I : -
         * O : -
         * Ket : Constructor ini tidak mengembalikan nilai apapun, digunakan untuk membuat instansiasi/object baru dari kelas Aksesoris,
         *       apabila user tidak memasukkan data / parameter ke fungsi ini
         * */
        this.nama  = "";
        this.merk  = "";
        this.harga = 0;
        this.stok  = 0;
    }

    /* ENCAPSULATIONS */
    public String getNama() { return this.nama; }
    public String getMerk() { return this.merk; }
    public Integer getHarga() { return this.harga; }
    public Integer getStok()  { return this.stok; }
    public String getJenis()  { return this.jenis; }
    public Integer getJumlahYangDibeliPembeli() { return this.jumlahYangDibeliPembeli; }
    public Boolean getPaid()  { return this.paid; }

    public void setNama(String nama) { this.nama = nama; }
    public void setMerk(String merk) { this.merk = merk; }
    public void setHarga(Integer harga) { this.harga = harga; }
    public void setStok(Integer stok)   { this.stok = stok; }
    public void setJenis(String jenis)  { this.jenis = jenis; }
    public void setJumlahYangDibeliPembeli(Integer jumlahYangDibeliPembeli) { this.jumlahYangDibeliPembeli = jumlahYangDibeliPembeli; }
    public void setPaid(Boolean paid)  { this.paid = paid;; }

    /* METHODS */

    /* --------------------------------------------------------------------------
     * Cetak Infor Aksesoris
     * --------------------------------------------------------------------------
     * I → -
     * O → -
     * Ket → method ini berfungsi untuk mencetak data aksesoris, tidak mengembalikan
     *       nilai apapun
     * */
    public void cetakInfoAksesoris() {
        System.out.println("     |   | Jenis : " + getJenis() );
        System.out.println("     |   | Merk  : " + getMerk() );
        System.out.println("     |   | Harga : Rp. " + getHarga() );
        System.out.println("     |   | Stok  : " + getStok() );
    }

}
