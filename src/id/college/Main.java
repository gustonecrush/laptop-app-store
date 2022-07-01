package id.college;

import id.aksesoris.*;
import id.laptop.*;
import id.menu.*;
import id.user.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        /* Instansiasi object Scanner */
        Scanner inputUser = new Scanner(System.in);

        /* Instansiasi object BufferedReader */
        BufferedReader inputUserString = new BufferedReader(new InputStreamReader(System.in));

        /* Invoke method static Menu : isiDataDiriPembeli() */
        Menu.isiDataDiriPembeli(inputUserString);

        /* Variable untuk menyimpan object Pembeli */
        Pembeli pembeli =  Menu.getDataPembeli();

        /* Invoke method static Menu : menu() */
        Menu.menu(inputUser, pembeli, dataStoreLaptop(), dataStoreAksesoris());

    }

    public static Map<Integer, Laptop> dataStoreLaptop() {
        /*------------------------------------------------------------------------------------------------------------
         * dataStoreLaptop()
         * -----------------------------------------------------------------------------------------------------------
         * I → inputUser, parameter dengan tipe Scanner yang digunakan untuk mengambil input dari pembeli
         * O → Array Associative yang memiliki key bertipe Integer dan value bertipe Laptop
         * Ket → Fungsi ini digunakan untuk menampung data-data dari Object Laptop yang bejibun
         *       disimpan didalam fungsi agar dapat digunakan berulang-ulang nantinya
         * -----------------------------------------------------------------------------------------------------------*/

        /* Siapkan variable laptops dengan tipe Array Associative yang key nya Integer dan valueny Laptop */
        Map<Integer, Laptop> laptops = new HashMap<>();

        /* Masukkan key serta instansiasi object Laptop ke Array Associative satu-per-satu */
        laptops.put(1, new Laptop(
                1,
                "Apple",
                "MacBook Air M1 2020",
                17_000_000,
                10));

        laptops.put(2, new Laptop(
                2,
                "Asus",
                "ASUS ROG STRIX G512LI-I75TB6B",
                18_499_000,
                5));

        laptops.put(3, new Laptop(
                3,
                "HP",
                "HP Pavilion 14-ec0013AU & 14-ec0014AU",
                9_999_000,
                2));

        laptops.put(4, new Laptop(
                4,
                "Acer",
                "ACER NITRO AN515-57",
                16_499_000,
                15));

        laptops.put(5, new Laptop(
                5,
                "Apple",
                "MacBook Pro 14-inch",
                28_469_000,
                10));

        laptops.put(6, new Laptop(
                6,
                "Lenovo",
                "LENOVO IDEAPAD 5-14ITL05-S3ID I7-1165G7",
                15_499_000,
                5));

        laptops.put(7, new Laptop(
                7,
                "Asus",
                "ASUS VIVOBOOK L510MA N4020 4GB 256GB W10 15.6 FULL HD NUMPAD BLIT",
                4_790_000,
                53));

        laptops.put(8, new Laptop(
                8,
                "HP",
                "HP Victus 16 i7-11800H-RTX 3060-16GB-512GB SSD-Win 10 - OHS 2019",
                19_699_000,
                17));

        /* Return nilai laptops yang telah berisi kumpulan object Laptop */
        return laptops;

    }
    
    public static Map<Integer, Aksesoris> dataStoreAksesoris() {
        /*------------------------------------------------------------------------------------------------------------
         * dataStoreAksesoris()
         * -----------------------------------------------------------------------------------------------------------
         * I → inputUser, parameter dengan tipe Scanner yang digunakan untuk mengambil input dari pembeli
         * O → Array Associative yang memiliki key bertipe Integer dan value bertipe Aksesoris
         * Ket → Fungsi ini digunakan untuk menampung data-data dari Object Aksesoris yang bejibun
         *       disimpan didalam fungsi agar dapat digunakan berulang-ulang nantinya
         * -----------------------------------------------------------------------------------------------------------*/

        /* Siapkan variable aksesorises dengan tipe Array Associative yang key nya Integer dan valueny Aksesoris */
        Map<Integer, Aksesoris> aksesorises = new HashMap<>();

        /* Masukkan key serta instansiasi object Aksesoris ke Array Associative satu-per-satu */
        aksesorises.put(1, new Mouse(
                "Logitech G PRO X SUPERLIGHT",
                "Logitech",
                1_979_000,
                120,
                "Mouse",
                5_000_000,
                true));

        aksesorises.put(2, new Mouse(
                "Mouse Wired Gamming Office USB RGB Colorful breathing light",
                "Foomee",
                59_800,
                210,
                "Mouse",
                3_000_000,
                false));

        aksesorises.put(3, new Speaker(
                "MW09 Portable Wireless Bluetooth Speaker Bluetooth 5.0",
                "Basike",
                119_000,
                233,
                "Speaker",
                true,
                "20Hz-20Khz"));

        aksesorises.put(4, new Speaker(
                "Speaker 2.0 Laptop/Komputer V350",
                "Kisonli",
                49_900,
                523,
                "Speaker",
                false,
                "20Hz-20Khz"));

        aksesorises.put(5, new Hardisk(
                "Seagate One Touch HDD",
                "Seagate",
                1_096_000,
                382,
                "Hardisk",
                "2TB",
                "External"));

        aksesorises.put(6, new Hardisk(
                "Seagate BarraCuda Harddisk Internal Laptop 1TB SATA3.0",
                "Seagate",
                715_000,
                120,
                "Hardisk",
                "1TB",
                "Internal"));

        aksesorises.put(7, new CoolingPad(
                "Coretech Twinfan Cooling Pad",
                "Goto",
                109_000,
                511,
                "Cooling Pad",
                1000
                ));

        aksesorises.put(8, new CoolingPad(
                "Coretech Penta-Fan Cooling Pad",
                "Goto",
                198_900,
                30,
                "Cooling Pad",
                2400
                ));

        aksesorises.put(9, new LaptopCase(
                "Laptop Case Joyko LTC-102 14-15 inch",
                "Joyko",
                94000,
                120,
                "Laptop Case",
                false,
                "Gray"));

        aksesorises.put(10, new LaptopCase(
                "Premiere Gen 2 Slingbag 14.2\"",
                "Copper",
                279_900,
                85,
                "Laptop Case",
                true,
                "Black"));

        /* Return nilai laptops yang telah berisi kumpulan object Aksesoris */
        return aksesorises;
    }

}
