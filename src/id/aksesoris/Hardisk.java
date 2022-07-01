package id.aksesoris;

/*
 * Class Hardisk
 *
 * → merupakan class child dari class Aksesoris, properti serta method-method
 *   yang terdapat di class ini memiliki kaitan dengan object hardisk
 * */
public class Hardisk extends Aksesoris {

    /* --------------------------------------------------------------------------
     * Kapasitas
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data kapasitas penyimpanan aksesoris Hardisk
     *
     * @var String
     * */
    private String kapasitas;

    /* --------------------------------------------------------------------------
     * Type
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data tipe hardisk yang dijual
     *
     * @var String
     * */
    private String type;

    /* Constructor */
    public Hardisk(String nama, String merk, Integer harga, Integer stok, String jenis, String kapasitas, String type) {
        super(nama, merk, harga, stok, jenis);
        this.kapasitas = kapasitas;
        this.type = type;
    }

    /* Overloading Constructor */
    public Hardisk() {
        super();
        this.kapasitas = "500GB";
        this.type = "Internal";
    }

    /* Encapsulations */
    public String getKapasitas() { return this.kapasitas; }
    public String getType() { return this.type; }

    public void setKapasitas(String kapasitas) { this.kapasitas = kapasitas; }
    public void setType(String type) { this.type = type; }

    /* Methods */
    public void cetakInfoAksesoris() {
        super.cetakInfoAksesoris();
        System.out.println("     |   | Type : " + getType() );
        System.out.println("     |   | Kapasistas : " + getKapasitas() );
    }

}
