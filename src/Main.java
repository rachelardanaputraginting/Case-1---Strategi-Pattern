public class Main {

//    Tanpa Strategi Pattern
//    public static void main(String[] args) {
//        _Pesanan pesanan1 = new _Pesanan("reguler");
//        pesanan1.prosesPengiriman();
//
//        _Pesanan pesanan2 = new _Pesanan("ekspres");
//        pesanan2.prosesPengiriman();
//
//        _Pesanan pesanan3 = new _Pesanan("ambil_sendiri");
//        pesanan3.prosesPengiriman();
//    }

    //Menggunakan Strategi Pattern
public static void main(String[] args) {
        Pesanan pesanan1 = new Pesanan(new PengirimanReguler());
        pesanan1.prosesPengiriman();

        Pesanan pesanan2 = new Pesanan(new PengirimanEkspres());
        pesanan2.prosesPengiriman();

        Pesanan pesanan3 = new Pesanan(new AmbilSendiri());
        pesanan3.prosesPengiriman();
        }
}


