package id.aksesoris;

/*
 * Class Mouse
 *
 * → merupakan class child dari class Aksesoris, properti serta method-method
 *   yang terdapat di class ini memiliki kaitan dengan object mouse
 * */
public class Mouse extends Aksesoris {

    /* --------------------------------------------------------------------------
     * Is Wireless
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data mouse wirless atau tidak
     *
     * @var Boolean
     * */
    private Boolean isWireless;

    /* --------------------------------------------------------------------------
     * Pemakaian Tombol
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data batas maksimal pemaakain tombol pada mouse
     *
     * @var Integer
     * */
    private Integer pemakaianTombol;

    /* Constructor */
    public Mouse(String nama, String merk, Integer harga, Integer stok, String jenis, Integer pemakaianTombol, Boolean isWireless) {
        super(nama, merk, harga, stok, jenis);
        this.pemakaianTombol = pemakaianTombol;
        this.isWireless = isWireless;
    }

    /* Overloading Constructor */
    public Mouse() {
        super();
        this.pemakaianTombol = 0;
        this.isWireless = false;
    }

    /* Encapsulations */
    public Boolean getWireless() { return this.isWireless; }
    public Integer getPemakaianTombol() { return this.pemakaianTombol; }

    public void setIsWireless(Boolean isWireless) { this.isWireless = isWireless; }
    public void setPemakaianTombol(Integer pemakaianTombol) { this.pemakaianTombol = pemakaianTombol; }

    /* Methods */
    public void cetakInfoAksesoris() {
        super.cetakInfoAksesoris();
        System.out.println("     |   | Wireless  : " + getWireless() );
        System.out.println("     |   | Pemakaian Tombol : " + getPemakaianTombol() + " kali" );
    }

}
