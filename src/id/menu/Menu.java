package id.menu;

import id.aksesoris.Aksesoris;
import id.laptop.Laptop;
import id.user.Pembeli;

import java.io.BufferedReader;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    /* PROPERTIES */

    /* ---------------------------------------------------------------------------------------------------------------------------
     * Data Pembeli
     * ---------------------------------------------------------------------------------------------------------------------------
     * → Variable static yang digunakan untuk menyimpan object Pembeli yang diinstansiasi pada
     *   proses pengisian data diri pembeli
     *
     * @var Pembeli
     * */
    private static Pembeli dataPembeli;

    /* METHODS */

    /* ---------------------------------------------------------------------------------------------------------------------------
     * Isi Data Diri Pembeli
     * ---------------------------------------------------------------------------------------------------------------------------
     * I → inputUser, parameter dengan tipe BufferedReader yang digunakan untuk mengambil input
     *     dari user yang bertipe string lebih dari satu kata
     * O → -
     * Ket → method ini tidak mengembalikan nilai apapun, digunakan hanya untuk menampilkan form pengisian
     *       data diri pembeli sebelum menggunakan menu pada aplikasi ini, lalu menginstansiasi
     *       data yang diisikan ke dalam object Pembeli yang disimpan kedalam variable static dataPembeli
     * */
    public static void isiDataDiriPembeli(BufferedReader inputUserString) throws Exception {

        /* Siapkan variable untuk menampung nilai-nilai input dari calon pembeli */
        String inputNama, inputAlamat, inputNoTelp, inputJenisKelamin;

        System.out.println("    ==================================== ");
        System.out.println("   /               WELCOME               \\");
        System.out.println("   ======================================= ");
        System.out.println("  | + |         ISI DATA DIRI         | + |");
        System.out.println("   ======================================= ");

        /* Calon pembeli memasukkan data nama */
        System.out.print  ("  | + | Nama           → ");
        inputNama = inputUserString.readLine();

        /* Calon pembeli memasukkan data alamat */
        System.out.print  ("  | + | Alamat         → ");
        inputAlamat = inputUserString.readLine();

        /* Calon pembeli memasukkan data jenis kelamin */
        System.out.print  ("  | + | Jenis Kelamin  → ");
        inputJenisKelamin = inputUserString.readLine();

        /* Calon pembeli memasukkan data no telpon */
        System.out.print  ("  | + | No Telepon     → ");
        inputNoTelp = inputUserString.readLine();

        dataPembeli = new Pembeli(inputNama, inputJenisKelamin, inputAlamat, inputNoTelp);
    }

    /* ---------------------------------------------------------------------------------------------------------------------------
     * Menu
     * ---------------------------------------------------------------------------------------------------------------------------
     * I → inputUser, parameter dengan tipe Scanner yang digunakan untuk mengambil input dari pembeli
     * O → -
     * Ket → method ini tidak mengembalikan nilai apapun, digunakan hanya untuk menampilkan menu utama
     *       pada aplikasi Laptop Store
     * */
    public static void menu(Scanner inputUser, Pembeli object, Map<Integer, Laptop> dataStoreLaptop, Map<Integer, Aksesoris> dataStoreAksesoris) throws Exception {
        /* pilihMenu → Variable tipe integer untuk menampung no menu yang dipilih oleh Pembeli */
        Integer pilihMenu;

        /* keluar → Variable tipe boolean yang digunakan untuk melakukan pengkondisian apakah Pembeli ingin keluar dari aplikasi */
        Boolean keluar = false;

        /* Selama Pembeli tidak memilih menu dengan no 6 maka variable keluar tidak akan diset true yang
         * yang akan membuat Pembeli terhenti dari perulangan dan keluar dari aplikasi
         *  */
        while(!keluar) {

            System.out.println("  ========================================= ");
            System.out.println(" /              LAPTOP STORE               \\");
            System.out.println(" =========================================== ");
            System.out.println("| + |                MENU               | + |");
            System.out.println(" =========================================== ");
            System.out.println("| 1 | Katalog Laptop & Aksesoris        |   |");
            System.out.println("| 2 | Beli Laptop                       |   |");
            System.out.println("| 3 | Beli Aksesoris Laptop             |   |");
            System.out.println("| 4 | Riwayat Pembelian                 |   |");
            System.out.println("| 5 | Keluar                            |   |");
            System.out.println(" =========================================== ");

            /* Pembeli memasukkan no menu yang ingin diakses */
            System.out.print  ("| + | Pilih Menu (1-6) → ");
            pilihMenu = inputUser.nextInt();
            System.out.println(" ===========================================\n");

            /* Nilai variable pilihMenu akan masuk ke dalam pengkondisian switch case */
            switch (pilihMenu) {

                /* 1 → Pembeli akan diarahkan ke menu katalog yang berisi kumpulan data dari object Laptop dan Aksesoris */
                case 1:
                    menuKatalog(inputUser, object, dataStoreLaptop, dataStoreAksesoris);
                    break;

                /* 2 → Pembeli akan diarahkan ke menu pembelian Laptop */
                case 2:
                    menuBeliLaptop(inputUser, object, dataStoreLaptop, dataStoreAksesoris);
                    break;

                /* 3 → Pembeli akan diarahkan ke menu pembelian Aksesoris */
                case 3:
                    menuBeliAksesoris(inputUser, object, dataStoreLaptop, dataStoreAksesoris);
                    break;

                /* 4 → Pembeli akan diarahkan ke menu dimana dapat melihat riwayat / history pembelian yang telah dilakukan */
                case 4:
                    //menuRiwayatPembelian(InputUser, object, dataStoreLaptop, dataStoreAksesoris);
                    menuRiwayatPembelian(inputUser, object, dataStoreLaptop, dataStoreAksesoris);
                    break;

                /* 5 → Pembeli akan keluar dari aplikasi */
                case 5:
                    keluar = true;
                    System.exit(0);
                    break;

                /* Default → Akan dieksekusi apabila user asal-asalan memasukkan no menu */
                default:
                    System.out.println(" =========================================== ");
                    System.out.println("| ! |        MENU IS NOT AVAILABLE      | ! |");
                    System.out.println(" ===========================================\n ");
                    break;

            } /* endSwitch */

        } /* endWhile */

    }

    /* ---------------------------------------------------------------------------------------------------------------------------
     * Menu Katalog
     * ---------------------------------------------------------------------------------------------------------------------------
     * I → inputUser, parameter dengan tipe Scanner yang digunakan untuk mengambil input dari pembeli
     *     pembeli, parameter dengan tipe class Pembeli yang digunakan untuk instansiasi object Pembeli yang akan
     *              melakukan transaksi
     *     dataStoreLaptop, parameter dengan tipe Map<Integer, Laptop> yang digunakan untuk mengambil data-data laptop
     *     dataStoreAksesoris, parameter dengan tipe Map<Integer, Aksesoris> yang digunakan untuk mengambil data-data aksesoris
     * O → -
     * Ket → method ini tidak mengembalikan nilai apapun, digunakan hanya untuk menampilkan katalog-katalog item
     *       yang dijual di Laptop Store ( Laptop & Aksesorisnya )
     * */
    public static void menuKatalog(Scanner inputUser, Pembeli pembeli, Map<Integer, Laptop> dataStoreLaptop, Map<Integer, Aksesoris> dataStoreAksesoris) throws Exception {
        /*
         * Map<Integer, Aksesoris> laptops
         * → Array associative <key, value> yang digunakan untuk menyimpan data-data object Laptop
         *   yang sebelumnya telah di instansiasi di fungsi dataStoreLaptop yang mengembalikan
         *   data-data dari object Laptop
         * */
        Map<Integer, Laptop> laptops = dataStoreLaptop;

        /*
         * Map<Integer, Aksesoris> aksesorises
         * → Array associative <key, value> yang digunakan untuk menyimpan data-data object Aksesoris
         *   yang sebelumnya telah di instansiasi di fungsi dataStoreAksesoris yang mengembalikan
         *   data-data dari object Aksesoris beserta turunannya
         * */
        Map<Integer, Aksesoris> aksesories = dataStoreAksesoris;

        /* pilihMenu
         *  → Variable dengan tipe integer untuk menampung nilai nomor pilihan menu yang dimasukkan oleh Pembeli
         *    yang digunakan untuk mengeksekusi menu yang akan dijalankan
         */
        Integer pilihMenu;

        /* kembaliKeMenuUtama
         *  → Variable dengan tipe boolean untuk menampung nilai yang akan digunakan pada pengkondisian
         *    apakah Pembeli ingin kembali ke Menu Utama atau masih ingin melihat katalog yang lain
         */
        Boolean kembaliKeMenuUtama = false;

        System.out.println(" =========================================== ");
        System.out.println("| 1 | KATALOG                               | ");
        System.out.println(" =========================================== ");
        System.out.println("| + |          PILIHAN KATALOG          | + |");
        System.out.println("     ======================================= ");
        System.out.println("    | 1 | Laptop                        |   |");
        System.out.println("    | 2 | Aksesoris Laptop              |   |");
        System.out.println("    | 3 | Kembali Ke Menu Utama         |   |");
        System.out.println("     ======================================= ");

        /* Pembeli memasukkan no menu yang dipilih (1-2) untuk melihat katalog (3) untuk kembali ke menu utama */
        System.out.print  ("| + | Pilih Katalog (1-2) → ");
        pilihMenu = inputUser.nextInt();

        /* Selama Pembeli tidak memilih menu dengan no 3 maka variable kembaliKeMenuUtama tidak akan diset menjadi true yang membuat
         *  perulangan agar masih berada di menu katalog tidak terhenti
         *  */
        while(!kembaliKeMenuUtama) {

            /* Nilai variable pilihMenu akan masuk ke dalam pengkondisian switch case */
            switch (pilihMenu) {

                /* 1 → Maka pembeli akan mendapatkan katalog laptop-laptop yang dijual */
                case 1:
                    /* numberForLaptop
                     *  → Variable dengan tipe integer untuk menampung nilai yang hanya digunakan untuk penomoran
                     *    pada saat data-data laptop ditampilkan
                     * */
                    Integer numberForLaptop = 1;

                    System.out.println("     ======================================= ");
                    System.out.println("     | * | Laptop                       |   |");
                    System.out.println("     ======================================= ");

                    /*
                     * Lakukan perulangan untuk data-data object Laptop yang disimpan di dalam Array Associative
                     * 1. Map.Entry<Integer, Laptop> set
                     * 2. laptops.entrySet()
                     * → Ambil seluruh data dari laptops yang bertipe Array associative dengan <key, value> : <Integer, Laptop> (2)
                     *   lalu masukkan setiap perulangannya ke dalam (1) variable Array associative dengan nama set
                     * */
                    for(Map.Entry<Integer, Laptop> set : laptops.entrySet()) {
                        /*
                         * laptop
                         * → Variable dengan tipe Laptop untuk menampung nilai object yang didapat tiap perulangannya pada variable set
                         *  */
                        Laptop laptop = set.getValue();

                        /* Cetak numberForLaptop & properti jenis dari object laptop */
                        System.out.println("     | " + numberForLaptop + " | " + laptop.getJenis());

                        /* Panggil method dari laptop yaitu cetakInfoLaptop yang akan mencetak informasi detail dari object laptop tsb */
                        laptop.cetakInfoLaptop();
                        System.out.println("      ------------------------------------------------------");

                        /* Increment pada variable numberForLaptop */
                        numberForLaptop++;
                    } /* endFor */

                    break;

                /* 2 → Maka pembeli akan mendapatkan katalog aksesoris yang dijual */
                case 2:
                    /* numberForAksesoris
                     *  → Variable dengan tipe integer untuk menampung nilai yang hanya digunakan untuk penomoran
                     *    pada saat data-data aksesoris ditampilkan
                     * */
                    Integer numberForAksesoris = 1;

                    System.out.println("     ======================================= ");
                    System.out.println("     | * | Aksesoris                    |   |");
                    System.out.println("     ======================================= ");

                    /*
                     * Lakukan perulangan untuk data-data object Aksesoris yang disimpan di dalam Array Associative
                     * 1. Map.Entry<Integer, Aksesoris> set
                     * 2. aksesorises.entrySet()
                     * → Ambil seluruh data dari aksesorises yang bertipe Array associative dengan <key, value> : <Integer, Aksesoris> (2)
                     *   lalu masukkan setiap perulangannya ke dalam (1) variable Array associative dengan nama set
                     * */
                    for(Map.Entry<Integer, Aksesoris> set : aksesories.entrySet()) {
                        /*
                         * aksesoris
                         * → Variable dengan tipe Aksesoris untuk menampung nilai object yang didapat tiap perulangannya pada variable set
                         *  */
                        Aksesoris aksesoris = set.getValue();

                        /* Cetak numberForAksesoris & properti nama dari object aksesoris */
                        System.out.println("     | " + numberForAksesoris + " | " + aksesoris.getNama());
                        System.out.println("      ------------------------------------------------------");

                        /* Panggil method dari aksesoris yaitu cetakInfoAksesoris yang akan mencetak informasi detail dari object aksesoris tsb */
                        aksesoris.cetakInfoAksesoris();
                        System.out.println("      ------------------------------------------------------");

                        /* Increment pada variable numberForAksesoris */
                        numberForAksesoris++;
                    } /* endFor */

                    break;

                /* 3 → Maka pembeli akan dikembalikan ke menu utama */
                case 3:
                    /* Nilai kembaliKeMenuUtama diset menjadi true agar perulangan terhenti */
                    kembaliKeMenuUtama = true;
                    System.out.println("\n");

                    /* Lalu pembeli diarahkan kembali ke fungsi menu yang menampilkan menu utama */
                    menu(inputUser, pembeli, dataStoreLaptop, dataStoreAksesoris);
                    System.exit(0);

                    break;

                /* Default → Akan dieksekusi apabila pembeli memasukkan no menu asal-asalan */
                default:

                    System.out.println(" =========================================== ");
                    System.out.println("| ! | Katalog Tidak Tersedia            | ! |");
                    System.out.println(" =========================================== ");

                    break;
            } /* endSwitch */

            /* Pembeli memasukkan no menu lagi, (1-2) untuk lanjut melihat katalog yang lain (3) untuk kembali ke menu utama */
            System.out.print  ("| + | Pilih Katalog (1-2)(3: Kembali ke Menu Utama) → ");
            pilihMenu = inputUser.nextInt();

        } /* endWhile */

    }

    /* ---------------------------------------------------------------------------------------------------------------------------
     * Menu Beli Laptop
     * ---------------------------------------------------------------------------------------------------------------------------
     * I → inputUser, parameter dengan tipe Scanner yang digunakan untuk mengambil input dari pembeli
     *     object, parameter dengan tipe class Pembeli yang digunakan untuk instansiasi object Pembeli yang akan
     *             melakukan transaksi
     *     dataStoreLaptop, parameter dengan tipe Map<Integer, Laptop> yang digunakan untuk mengambil data-data laptop
     *     dataStoreAksesoris, parameter dengan tipe Map<Integer, Aksesoris> yang digunakan untuk mengambil data-data aksesoris
     * O → -
     * Ket → method ini tidak mengembalikan nilai apapun, digunakan hanya untuk menjalankan proses pembelian
     *       laptop yang dilakukan oleh pembeli
     * */
    public static void menuBeliLaptop(Scanner inputUser, Pembeli object, Map<Integer, Laptop> dataStoreLaptop, Map<Integer, Aksesoris> dataStoreAksesoris) throws Exception {
        /* -----------------------------------------------------------------------------------------------------------
         * Pembeli
         * -----------------------------------------------------------------------------------------------------------
         * → Variable dengan tipe Pembeli yang menampung nilai object yang telah diinstansiasi sebelumnya
         * → Variable ini akan digunakan untuk mereference salah satu method yang dimili yaitu setKeranjangLaptop
         *   untuk menampung object-object Laptop beserta turunannya yang dibeli oleh pembeli
         *
         * @var Pembeli
         * */
        Pembeli pembeli = object;

        /* -----------------------------------------------------------------------------------------------------------
         * Laptops
         * -----------------------------------------------------------------------------------------------------------
         * → Array associative <key, value> yang digunakan untuk menyimpan data-data object Laptop
         *   yang sebelumnya telah di instansiasi di fungsi dataStoreLaptop yang mengembalikan
         *   data-data dari object Laptop beserta turunannya
         *
         * @var Map<Integer, Laptop>
         * */
        Map<Integer, Laptop> laptops = dataStoreLaptop;

        /* -----------------------------------------------------------------------------------------------------------
         * Number of Laptop
         * -----------------------------------------------------------------------------------------------------------
         *  → Variable dengan tipe integer untuk menampung nilai yang hanya digunakan untuk penomoran
         *    pada saat data-data laptop ditampilkan
         *
         * @var Integer
         * */
        Integer numberOfLaptop = 1;

        /* -----------------------------------------------------------------------------------------------------------
         * Number of Laptop Yang Dibeli
         * -----------------------------------------------------------------------------------------------------------
         *  → Variable dengan tipe integer untuk menampung nilai yang akan digunakan sebagai key pada anggota Array
         *    Associative salah satu properti object Pembeli yaitu Map<String, Laptop> keranjangBelanjaLaptop
         *
         * @var Integer
         * */
        Integer numberOfLaptopYangDibeli = 1;

        /* -----------------------------------------------------------------------------------------------------------
         * Pilih Laptop Yang Dibeli
         * -----------------------------------------------------------------------------------------------------------
         *  → Variable dengan tipe integer untuk menampung nilai nomor pilihan yang dimasukkan oleh pembeli
         *    dari input user, nilai variable ini bakal dipakai untuk mengakses object dari
         *    Map<Integer, Laptop> laptops melalui key-nya, karena keynya berupa angka integer
         *
         * @var Integer
         * */
        Integer pilihLaptopYangDibeli;

        /* -----------------------------------------------------------------------------------------------------------
         * Jumlah
         * -----------------------------------------------------------------------------------------------------------
         * → Variable untuk menampung nilai jumlah item yang dibeli per Laptop
         *
         * @var Integer
         * */
        Integer jumlah;

        /* -----------------------------------------------------------------------------------------------------------
         * Pilih Lagi
         * -----------------------------------------------------------------------------------------------------------
         * → Variable dengan tipe string untuk menampung nilai Y/T untuk pengkondisian pembeli ingin menambah Laptop
         *   lain yang ingin dibeli atau tidak
         *
         * @var String
         */
        String pilihLagi = "Y";

        System.out.println(" =========================================== ");
        System.out.println("| 2 | BELI LAPTOP                           | ");
        System.out.println(" =========================================== ");
        System.out.println("| + |           LIST LAPTOP             | + |");
        System.out.println("     ======================================= ");

        /*
         * Lakukan perulangan untuk data-data object Laptop yang disimpan di dalam Array Associative
         * 1. Map.Entry<Integer, Laptop> set
         * 2. laptops.entrySet()
         * → Ambil seluruh data dari laptops yang bertipe Array associative dengan <key, value> : <Integer, Laptop> (2)
         *   lalu masukkan setiap perulangannya ke dalam (1) variable Array associative dengan nama set
         * */
        for(Map.Entry<Integer, Laptop> set : laptops.entrySet()) {
            /*
             * laptops
             * → Variable dengan tipe Laptop untuk menampung nilai object yang didapat tiap perulangannya pada variable set
             *  */
            Laptop laptop = set.getValue();

            /* Cetak numberForLaptop & properti-properti dari object laptop */
            System.out.println("     | " + numberOfLaptop + " | " + laptop.getJenis());
            System.out.println("     | + | Merk          : " + laptop.getMerk());
            System.out.println("     | + | Harga         : Rp. " + laptop.getHarga());
            System.out.println("     | + | Stok          : " + laptop.getStok());
            /* Kondisi ini hanya untuk ngakalin cetak garis (----) biar tampilannya rapih */
            if(numberOfLaptop < 10) System.out.println("      --------------------------------------");

            /* Increment pada variable numberForLaptop */
            numberOfLaptop++;
        }

        /* Selama Pembeli memasukkan konfirmasi Y untuk menambah aksesoris lain yang ingin dibeli, maka perulangan tidak akan terhenti */
        while(pilihLagi.equals("Y")) {

            System.out.println("      =======================================");

            /* Pembeli memasukkan no Laptop yang mereference ke key yang menampung nilai object Laptop */
            System.out.print  ("     | + | Pilih Laptop (1-10) → ");
            pilihLaptopYangDibeli = inputUser.nextInt();

            /* Pembeli memasukkan jumlah item per Laptop yang akan dibeli */
            System.out.print  ("     | + | Masukkan Jumlah        → ");
            jumlah = inputUser.nextInt();
            laptops.get(pilihLaptopYangDibeli).setJumlahYangDibeliPembeli(jumlah);

            /*
             * Menambahkan
             *
             *  1. numberOfLaptopYangDibeli → nilai yang digunakan untuk membuat key baru pada Array Associative laptopYangDibeli
             *  2. laptops.get(pilihLaptopYangDibeli) → mengambil object dari laptops dengan key pilihLaptopYangDibeli
             *
             *  Ke dalam fungsi put() pada Array Associative laptopYangDibeli
             *  */
            pembeli.setKeranjangBelanjaLaptop(numberOfLaptopYangDibeli, laptops.get(pilihLaptopYangDibeli));

            /*
             * Melakukan method setStok pada object Laptop yang dipilih oleh Pembeli
             * agar data yang dimiliki bersifat real
             * 1. laptops.get(pilihLaptopYangDibeli) → Kita ambil object dari Array Associative laptops dengan key pilihLaptopYangDibeli
             *                                                yang telah diinput user sebelumnya
             * 2. setStok(laptops.get(pilihLaptopYangDibeli).getStok() - jumlah)
             *    → Kita set nilai stok objectnya dengan cara
             *      1. laptops.get(pilihLaptopYangDibeli) → Kembali ke poin-jumlah
             *      2. .getStok()-jumlah → Lalu kita ambil nilai stoknya dan kita kurangkan dengan nilai jumlah yang diinput user sebelumnya
             * */
            laptops.get(pilihLaptopYangDibeli).setStok(laptops.get(pilihLaptopYangDibeli).getStok() - jumlah);
            laptops.get(pilihLaptopYangDibeli).setPaid(false);

            System.out.println("      =======================================");

            /* Pembeli melakukan konfirmasi dengan memasukkan data String Y/T, apakah mereka ingin menambah laptop yang dibeli atau tidak */
            System.out.print  ("     | + | Pilih Lagi (Y/T) → ");
            pilihLagi = inputUser.next();

        } /* endWhile */

        /*
         * Setelah selesai,
         * nilai pada Array Associative Map<Integer, Laptops> laptopYangDibeli kita set ke properti object Pembeli
         * dengan cara kita set nilai properti keranjangBelanjaLaptop pada object Pembeli dengan method setKeranjangBelanjaLaptop
         *  */
//        pembeli.setKeranjangBelanjaLaptop(laptopYangDibeli);
        System.out.println("      =======================================");

        /*
         * Melakukan Pembayaran laptop yang dibeli
         * */

        /*
         * Cetak Struk Pembelian Laptop
         * */
        System.out.println(" | + |          STRUK PEMBELIAN          | + |");
        System.out.println("  =========================================== ");
        pembeli.cetakStrukPembelianLaptop();
        System.out.println("  =========================================== ");

        /*
         * Pembayaran
         * */
        Integer nominalPembayaran;
        System.out.println(" | + |             PEMBAYARAN            | + |");
        System.out.println("  =========================================== ");
        System.out.println(" | Tagihan   → Rp. " + pembeli.totalBelanjaLaptop());
        System.out.print  (" | Bayar     → Rp. ");
        nominalPembayaran = inputUser.nextInt();
        if(nominalPembayaran > pembeli.totalBelanjaLaptop()) {
            System.out.println("  -------------------------------------------");
            System.out.println(" | Cashback  → Rp. " + (nominalPembayaran - pembeli.totalBelanjaLaptop()));
        }  else if(nominalPembayaran < pembeli.totalBelanjaLaptop()) {
            do {
                System.out.println("  -------------------------------------------");
                System.out.println(" | ! | Uang yang anda bayarkan kurang!");
                System.out.println("  -------------------------------------------");
                System.out.print  (" | Bayar     → Rp. ");
                nominalPembayaran = inputUser.nextInt();
                if(nominalPembayaran > pembeli.totalBelanjaLaptop()) {
                    System.out.println("  -------------------------------------------");
                    System.out.println(" | Cashback  → Rp. " + (nominalPembayaran - pembeli.totalBelanjaLaptop()));
                }
            } while(nominalPembayaran < pembeli.totalBelanjaLaptop());
        }
        pembeli.setAllPaidLaptop();
        System.out.println("  =========================================== ");
        System.out.println(" | + |           TERIMA KASIH            | + |");
        System.out.println("  =========================================== ");

        /*
         * Kembali Ke Menu Utama
         * */
        menu(inputUser, object, dataStoreLaptop, dataStoreAksesoris);
        System.exit(0);

    }

    /* ---------------------------------------------------------------------------------------------------------------------------
     * Menu Beli Aksesoris
     * ---------------------------------------------------------------------------------------------------------------------------
     * I → inputUser, parameter dengan tipe Scanner yang digunakan untuk mengambil input dari pembeli
     *     object, parameter dengan tipe class Pembeli yang digunakan untuk instansiasi object Pembeli yang akan
     *             melakukan transaksi
     *     dataStoreLaptop, parameter dengan tipe Map<Integer, Laptop> yang digunakan untuk mengambil data-data laptop
     *     dataStoreAksesoris, parameter dengan tipe Map<Integer, Aksesoris> yang digunakan untuk mengambil data-data aksesoris
     * O → -
     * Ket → method ini tidak mengembalikan nilai apapun, digunakan hanya untuk menjalankan proses pembelian
     *       aksesoris yang dilakukan oleh pembeli
     * */
    public static void menuBeliAksesoris(Scanner inputUser, Pembeli object, Map<Integer, Laptop> dataStoreLaptop, Map<Integer, Aksesoris> dataStoreAksesoris) throws Exception {
        /* -----------------------------------------------------------------------------------------------------------
         * Pembeli
         * -----------------------------------------------------------------------------------------------------------
         * → Variable dengan tipe Pembeli yang menampung nilai object yang telah diinstansiasi sebelumnya
         * → Variable ini akan digunakan untuk mereference salah satu method yang dimili yaitu setKeranjangAksesoris
         *   untuk menampung object-object Aksesoris beserta turunannya yang dibeli oleh pembeli
         *
         * @var Pembeli
         * */
        Pembeli pembeli = object;

        /* -----------------------------------------------------------------------------------------------------------
         * Aksesorises
         * -----------------------------------------------------------------------------------------------------------
         * → Array associative <key, value> yang digunakan untuk menyimpan data-data object Aksesoris
         *   yang sebelumnya telah di instansiasi di fungsi dataStoreAksesoris yang mengembalikan
         *   data-data dari object Aksesoris beserta turunannya
         *
         * @var Map<Integer, Aksesoris>
         * */
        Map<Integer, Aksesoris> aksesorises = dataStoreAksesoris;

        /* -----------------------------------------------------------------------------------------------------------
         * Number of Aksesoris
         * -----------------------------------------------------------------------------------------------------------
         *  → Variable dengan tipe integer untuk menampung nilai yang hanya digunakan untuk penomoran
         *    pada saat data-data aksesoris ditampilkan
         *
         * @var Integer
         * */
        Integer numberOfAksesoris = 1;

        /* -----------------------------------------------------------------------------------------------------------
         * Number of Aksesoris Yang Dibeli
         * -----------------------------------------------------------------------------------------------------------
         *  → Variable dengan tipe integer untuk menampung nilai yang akan digunakan sebagai key pada anggota Array
         *    Associative salah satu properti object Pembeli yaitu Map<String, Aksesoris> keranjangBelanjaAksesoris
         *
         * @var Integer
         * */
        Integer numberOfAksesorisYangDibeli = 1;

        /* -----------------------------------------------------------------------------------------------------------
         * Pilih Aksesoris Yang Dibeli
         * -----------------------------------------------------------------------------------------------------------
         *  → Variable dengan tipe integer untuk menampung nilai nomor pilihan yang dimasukkan oleh pembeli
         *    dari input user, nilai variable ini bakal dipakai untuk mengakses object dari
         *    Map<Integer, Aksesoris> aksesorises melalui key-nya, karena keynya berupa angka integer
         *
         * @var Integer
         * */
        Integer pilihAksesorisYangDibeli;

        /* -----------------------------------------------------------------------------------------------------------
         * Jumlah
         * -----------------------------------------------------------------------------------------------------------
         * → Variable untuk menampung nilai jumlah item yang dibeli per aksesorisnya
         *
         * @var Integer
         * */
        Integer jumlah;

        /* -----------------------------------------------------------------------------------------------------------
         * Pilih Lagi
         * -----------------------------------------------------------------------------------------------------------
         * → Variable dengan tipe string untuk menampung nilai Y/T untuk pengkondisian pembeli ingin menambah aksesoris
         *   lain yang ingin dibeli atau tidak
         *
         * @var String
         */
        String pilihLagi = "Y";

        System.out.println(" =========================================== ");
        System.out.println("| 3 | BELI AKSESORIS                        | ");
        System.out.println(" =========================================== ");
        System.out.println("| + |           LIST AKSESORIS          | + |");
        System.out.println("     ======================================= ");

        /*
         * Lakukan perulangan untuk data-data object Aksesoris yang disimpan di dalam Array Associative
         * 1. Map.Entry<Integer, Aksesoris> set
         * 2. aksesorises.entrySet()
         * → Ambil seluruh data dari aksesorises yang bertipe Array associative dengan <key, value> : <Integer, Aksesoris> (2)
         *   lalu masukkan setiap perulangannya ke dalam (1) variable Array associative dengan nama set
         * */
        for(Map.Entry<Integer, Aksesoris> set : aksesorises.entrySet()) {
            /*
             * aksesoris
             * → Variable dengan tipe Aksesoris untuk menampung nilai object yang didapat tiap perulangannya pada variable set
             *  */
            Aksesoris aksesoris = set.getValue();

            /* Cetak numberForAksesoris & properti-properti dari object aksesoris */
            System.out.println("     | " + numberOfAksesoris + " | " + aksesoris.getNama());
            System.out.println("     | + | Harga : Rp. " + aksesoris.getHarga());
            System.out.println("     | + | Stok  : " + aksesoris.getStok());
            /* Kondisi ini hanya untuk ngakalin cetak garis (----) biar tampilannya rapih */
            if(numberOfAksesoris < 10) System.out.println("      --------------------------------------");

            /* Increment pada variable numberForAksesoris */
            numberOfAksesoris++;
        }

        /* Selama Pembeli memasukkan konfirmasi Y untuk menambah aksesoris lain yang ingin dibeli, maka perulangan tidak akan terhenti */
        while(pilihLagi.equals("Y")) {

            System.out.println("      =======================================");

            /* Pembeli memasukkan no Aksesoris yang mereference ke key yang menampung nilai object Aksesoris */
            System.out.print  ("     | + | Pilih Aksesoris (1-10) → ");
            pilihAksesorisYangDibeli = inputUser.nextInt();

            /* Pembeli memasukkan jumlah item per aksesoris yang akan dibeli */
            System.out.print  ("     | + | Masukkan Jumlah        → ");
            jumlah = inputUser.nextInt();
            aksesorises.get(pilihAksesorisYangDibeli).setJumlahYangDibeliPembeli(jumlah);

            /*
             * Menambahkan
             *
             *  1. numberOfAksesorisYangDibeli → nilai yang digunakan untuk membuat key baru pada Array Associative aksesorisYangDibeli
             *  2. aksesorises.get(pilihAksesorisYangDibeli) → mengambil object dari aksesorises dengan key pilihAksesorisYangDibeli
             *
             *  Ke dalam fungsi put() pada Array Associative aksesorisYangDibeli
             *  */
            pembeli.setKeranjangBelanjaAksesoris(numberOfAksesorisYangDibeli, aksesorises.get(pilihAksesorisYangDibeli));

            /*
             * Melakukan method setStok pada object Aksesoris yang dipilih oleh Pembeli
             * agar data yang dimiliki bersifat real
             * 1. aksesorises.get(pilihAksesorisYangDibeli) → Kita ambil object dari Array Associative aksesorises dengan key pilihAksesorisYangDibeli
             *                                                yang telah diinput user sebelumnya
             * 2. setStok(aksesorises.get(pilihAksesorisYangDibeli).getStok() - jumlah)
             *    → Kita set nilai stok objectnya dengan cara
             *      1. aksesorises.get(pilihAksesorisYangDibeli) → Kembali ke poin-jumlah
             *      2. .getStok()-jumlah → Lalu kita ambil nilai stoknya dan kita kurangkan dengan nilai jumlah yang diinput user sebelumnya
             * */
            aksesorises.get(pilihAksesorisYangDibeli).setStok(aksesorises.get(pilihAksesorisYangDibeli).getStok() - jumlah);
            aksesorises.get(pilihAksesorisYangDibeli).setPaid(false);

            System.out.println("      =======================================");

            /* Pembeli melakukan konfirmasi dengan memasukkan data String Y/T, apakah mereka ingin menambah aksesoris yang dibeli atau tidak */
            System.out.print  ("     | + | Pilih Lagi (Y/T) → ");
            pilihLagi = inputUser.next();

        } /* endWhile */

        /*
         * Setelah selesai,
         * nilai pada Array Associative Map<Integer, Aksesoris> aksesorisYangDibeli kita set ke properti object Pembeli
         * dengan cara kita set nilai properti keranjangBelanjaAksesoris pada object Pembeli dengan method setKeranjangBelanjaAksesoris
         *  */
//        pembeli.setKeranjangBelanjaAksesoris(aksesorisYangDibeli);
        System.out.println("      =======================================");

        /*
         * Melakukan Pembayaran aksesoris yang dibeli
         * */

        /*
         * Cetak Struk Pembelian Aksesoris
         * */
        System.out.println();
        System.out.println(" | + |          STRUK PEMBELIAN          | + |");
        System.out.println("  =========================================== ");
        pembeli.cetakStrukPembelianAksesoris();
        System.out.println("  =========================================== ");

        /*
         * Pembayaran
         * */
        Integer nominalPembayaran;
        System.out.println(" | + |             PEMBAYARAN            | + |");
        System.out.println("  =========================================== ");
        System.out.println(" | Tagihan   → Rp. " + pembeli.totalBelanjaAksesoris());
        System.out.print  (" | Bayar     → Rp. ");
        nominalPembayaran = inputUser.nextInt();
        if(nominalPembayaran > pembeli.totalBelanjaAksesoris()) {
            System.out.println("  -------------------------------------------");
            System.out.println(" | Cashback  → Rp. " + (nominalPembayaran - pembeli.totalBelanjaAksesoris()));
        }  else if(nominalPembayaran < pembeli.totalBelanjaAksesoris()) {
            do {
                System.out.println("  -------------------------------------------");
                System.out.println(" | ! | Uang yang anda bayarkan kurang!");
                System.out.println("  -------------------------------------------");
                System.out.print  (" | Bayar     → Rp. ");
                nominalPembayaran = inputUser.nextInt();
                if(nominalPembayaran > pembeli.totalBelanjaAksesoris()) {
                    System.out.println("  -------------------------------------------");
                    System.out.println(" | Cashback  → Rp. " + (nominalPembayaran - pembeli.totalBelanjaAksesoris()));
                }
            } while(nominalPembayaran < pembeli.totalBelanjaAksesoris());
        }
        pembeli.setAllPaidAksesoris();
        System.out.println("  =========================================== ");
        System.out.println(" | + |           TERIMA KASIH            | + |");
        System.out.println("  =========================================== ");

        /*
         * Kembali Ke Menu Utama
         * */
        menu(inputUser, object, dataStoreLaptop, dataStoreAksesoris);
        System.exit(0);

    }

    /* ---------------------------------------------------------------------------------------------------------------------------
     * Menu Riwayat Pembelian
     * ---------------------------------------------------------------------------------------------------------------------------
     * I → inputUser, parameter dengan tipe Scanner yang digunakan untuk mengambil input dari pembeli
     *     object, parameter dengan tipe class Pembeli yang digunakan untuk instansiasi object Pembeli yang akan
     *             melakukan transaksi
     *     dataStoreLaptop, parameter dengan tipe Map<Integer, Laptop> yang digunakan untuk mengambil data-data laptop
     *     dataStoreAksesoris, parameter dengan tipe Map<Integer, Aksesoris> yang digunakan untuk mengambil data-data aksesoris
     * O → -
     * Ket → Fungsi ini tidak mengembalikan nilai apapun, digunakan hanya untuk menjalankan proses pembelian
     * O → -
     * Ket → method ini tidak mengembalikan nilai apapun, digunakan hanya untuk menjalankan proses pembelian
     *       aksesoris yang dilakukan oleh pembeli
     * */
    public static void menuRiwayatPembelian(Scanner inputUser, Pembeli object, Map<Integer, Laptop> dataStoreLaptop, Map<Integer, Aksesoris> dataStoreAksesoris) throws Exception {
        /* -----------------------------------------------------------------------------------------------------------
         * Pembeli
         * -----------------------------------------------------------------------------------------------------------
         * → Variable dengan tipe Pembeli yang menampung nilai object yang telah diinstansiasi sebelumnya
         * → Variable ini akan digunakan untuk mereference salah satu method yang dimili yaitu setKeranjangAksesoris
         *   untuk menampung object-object Aksesoris beserta turunannya yang dibeli oleh pembeli
         *
         * @var Pembeli
         * */
        Pembeli pembeli = object;

        /* -----------------------------------------------------------------------------------------------------------
         * Aksesorises
         * -----------------------------------------------------------------------------------------------------------
         * → Array associative <key, value> yang digunakan untuk menyimpan data-data object Aksesoris
         *   yang sebelumnya telah di instansiasi di fungsi dataStoreAksesoris yang mengembalikan
         *   data-data dari object Aksesoris beserta turunannya
         *
         * @var Map<Integer, Aksesoris>
         * */
        Map<Integer, Aksesoris> aksesorises = dataStoreAksesoris;       
        
        /* -----------------------------------------------------------------------------------------------------------
         * Aksesorises
         * -----------------------------------------------------------------------------------------------------------
         * → Array associative <key, value> yang digunakan untuk menyimpan data-data object Laptop
         *   yang sebelumnya telah di instansiasi di fungsi dataStoreLaptop yang mengembalikan
         *   data-data dari object Laptop beserta turunannya
         *
         * @var Map<Integer, Laptop>
         * */
        Map<Integer, Laptop> laptops = dataStoreLaptop;
 
        /* pilihMenu
         *  → Variable dengan tipe integer untuk menampung nilai nomor pilihan menu yang dimasukkan oleh Pembeli
         *    yang digunakan untuk mengeksekusi menu yang akan dijalankan
         */
        Integer pilihMenu;

        /* kembaliKeMenuUtama
         *  → Variable dengan tipe boolean untuk menampung nilai yang akan digunakan pada pengkondisian
         *    apakah Pembeli ingin kembali ke Menu Utama atau masih ingin melihat katalog yang lain
         */
        Boolean kembaliKeMenuUtama = false;
      
        System.out.println(" =========================================== ");
        System.out.println("| 5 | RIWAYAT PEMBELIAN                     | ");
        System.out.println(" =========================================== ");
        System.out.println("| + |          PILIHAN RIWAYAT          | + |");
        System.out.println("     ======================================= ");
        System.out.println("    | 1 | Laptop                        |   |");
        System.out.println("    | 2 | Aksesoris Laptop              |   |");
        System.out.println("    | 3 | Kembali Ke Menu Utama         |   |");
        System.out.println("     ======================================= ");

        /* Pembeli memasukkan no menu yang dipilih (1-2) untuk melihat riwayat pembelian (3) untuk kembali ke menu utama */
        System.out.print  ("| + | Pilih Riwayat Pembelian (1-2) → ");
        pilihMenu = inputUser.nextInt();

        /* Selama Pembeli tidak memilih menu dengan no 3 maka variable kembaliKeMenuUtama tidak akan diset menjadi true yang membuat
         *  perulangan agar masih berada di menu katalog tidak terhenti
         *  */
        while(!kembaliKeMenuUtama) {

            /* Nilai variable pilihMenu akan masuk ke dalam pengkondisian switch case */
            switch (pilihMenu) {

                /* 1 → Maka pembeli akan mendapatkan riwayat pembelian Laptop */
                case 1:
                    System.out.println("     ======================================= ");
                    System.out.println("     | * | Laptop                       |   |");
                    System.out.println("     ======================================= ");
                    pembeli.riwayatPembelianLaptop();
                    break;

                /* 2 → Maka pembeli akan mendapatkan riwayat pembelian Aksesoris Laptop  */
                case 2:
                    System.out.println("     ======================================= ");
                    System.out.println("     | * | Aksesoris                    |   |");
                    System.out.println("     ======================================= ");
                    pembeli.riwayatPembelianAksesoris();
                    break;

                /* 3 → Maka pembeli akan dikembalikan ke menu utama */
                case 3:
                    /* Nilai kembaliKeMenuUtama diset menjadi true agar perulangan terhenti */
                    kembaliKeMenuUtama = true;
                    System.out.println("\n");

                    /* Lalu pembeli diarahkan kembali ke fungsi menu yang menampilkan menu utama */
                    menu(inputUser, pembeli, dataStoreLaptop, dataStoreAksesoris);
                    System.exit(0);
                    break;

                /* Default → Akan dieksekusi apabila pembeli memasukkan no menu asal-asalan */
                default:

                    System.out.println(" =========================================== ");
                    System.out.println("| ! | Riwayat Pembelian Tidak Tersedia   | ! |");
                    System.out.println(" =========================================== ");
                    break;
            } /* endSwitch */

            /* Pembeli memasukkan no menu lagi, (1-2) untuk lanjut melihat katalog yang lain (3) untuk kembali ke menu utama */
            System.out.print  ("| + | Pilih Menu (1-2)(3: Kembali ke Menu Utama) → ");
            pilihMenu = inputUser.nextInt();

        } /* endWhile */    
    }

    /* ---------------------------------------------------------------------------------------------------------------------------
     * Get Data Pembeli
     * ---------------------------------------------------------------------------------------------------------------------------
     * I → -
     * O → -
     * Ket → method ini digunakan sebagai encapsulation data pembeli yang sedang mengakses menu
     * */
    public static Pembeli getDataPembeli() { return dataPembeli; }

}
