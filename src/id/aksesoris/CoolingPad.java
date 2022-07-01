package id.aksesoris;

/*
 * Class CoolingPad ( Alat Pendingin Laptop )
 *
 * → merupakan class child dari class Aksesoris, properti serta method-method
 *   yang terdapat di class ini memiliki kaitan dengan object cooling pad
 * */
public class CoolingPad extends Aksesoris {

    /* --------------------------------------------------------------------------
     * Speed Fan
     * --------------------------------------------------------------------------
     * → Properti yang menyimpan data kecepatan dari Aksesoris cooling pad
     *
     * @var Integer
     * */
    private Integer speedFan;

    /* Constructor */
    public CoolingPad(String nama, String merk, Integer harga, Integer stok, String jenis, Integer speedFan) {
        super(nama, merk, harga, stok, jenis);
        this.speedFan = speedFan;
    }

    /* Overloading Constructor */
    public CoolingPad() {
        super();
        this.speedFan = 0;
    }

    /* Encapsulations */
    public Integer getSpeedFan() { return this.speedFan; }
    public void setSpeedFan(Integer speedFan) { this.speedFan = speedFan; }

    /* Methods */
    public void cetakInfoAksesoris() {
        super.cetakInfoAksesoris();
        System.out.println("     |   | Speed Fan : " + getSpeedFan() );
    }

}
