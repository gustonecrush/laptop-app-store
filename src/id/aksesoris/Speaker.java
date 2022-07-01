package id.aksesoris;

/*
 * Class Speaker
 *
 * → merupakan class child dari class Aksesoris, properti serta method-method
 *   yang terdapat di class ini memiliki kaitan dengan object speaker
 * */
public class Speaker extends Aksesoris {

    /* --------------------------------------------------------------------------
     * Is Wireless
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data speaker wirless atau tidak
     *
     * @var Boolean
     * */
    private Boolean isWireless;

    /* --------------------------------------------------------------------------
     * Frequency Response
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data frequency yang dimiliki speaker
     *
     * @var String
     * */
    private String frequencyResponse;

    /* Constructor */
    public Speaker(String nama, String merk, Integer harga, Integer stok, String jenis, Boolean isWireless, String frequencyResponse) {
        super(nama, merk, harga, stok, jenis);
        this.isWireless = isWireless;
        this.frequencyResponse = frequencyResponse;
    }

    /* Overloading Constructor */
    public Speaker() {
        super();
        this.isWireless = false;
        this.frequencyResponse = "0Hz";
    }

    /* Encapsulations */
    public Boolean getWireless() { return this.isWireless; }
    public String getFrequencyResponse() { return this.frequencyResponse; }

    public void setIsWireless(Boolean isWireless) { this.isWireless = isWireless; }
    public void setFrequencyResponse(String frequencyResponse) { this.frequencyResponse = frequencyResponse; }

    /* Methods */
    public void cetakInfoAksesoris() {
        super.cetakInfoAksesoris();
        System.out.println("     |   | Wireless  : " + getWireless() );
        System.out.println("     |   | Frequency : " + getFrequencyResponse() );
    }

}
