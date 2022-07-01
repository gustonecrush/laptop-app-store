package id.aksesoris;

/*
 * Class LaptopCase ( Tas Laptop )
 *
 * → merupakan class child dari class Aksesoris, properti serta method-method
 *   yang terdapat di class ini memiliki kaitan dengan object laptop case
 * */
public class LaptopCase extends Aksesoris {

    /* --------------------------------------------------------------------------
     * Has Sling
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data apakah object memiliki Sling Bag atau tidak
     *
     * @var Boolean
     * */
    private Boolean hasSling;

    /* --------------------------------------------------------------------------
     * Warna
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data warna dari object Laptop Case
     *
     * @var String
     * */
    private String warna;

    /* Constructor */
    public LaptopCase(String nama, String merk, Integer harga, Integer stok, String jenis, Boolean hasSling, String warna) {
        super(nama, merk, harga, stok, jenis);
        this.hasSling = hasSling;
        this.warna = warna;
    }

    /* Overloading Constructor */
    public LaptopCase() {
        super();
        this.hasSling = false;
        this.warna = "Black";
    }

    /* Encapsulations */
    public Boolean getHasSling() { return this.hasSling; }
    public String getWarna() { return this.warna; }

    public void setHasSling(Boolean hasSling) { this.hasSling = hasSling; }
    public void setWarna(String warna) { this.warna = warna; }

    /* Methods */
    public void cetakInfoAksesoris() {
        super.cetakInfoAksesoris();
        System.out.println("     |   | Warna : " + getWarna() );
        System.out.println("     |   | Has Sling : " + getHasSling() );
    }


}
