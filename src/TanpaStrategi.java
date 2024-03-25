public class TanpaStrategi {
    private String metodePengiriman;

    public TanpaStrategi(String metodePengiriman) {
        this.metodePengiriman = metodePengiriman;
    }

    public void prosesPengiriman() {
        if (metodePengiriman.equals("reguler")) {
            kirimDenganPengirimanReguler();
        } else if (metodePengiriman.equals("ekspres")) {
            kirimDenganPengirimanEkspres();
        } else if (metodePengiriman.equals("ambil_sendiri")) {
            ambilSendiri();
        } else {
            System.out.println("Metode pengiriman tidak valid.");
        }
    }

    private void kirimDenganPengirimanReguler() {
        System.out.println("Barang dikirim dengan pengiriman reguler.");
    }

    private void kirimDenganPengirimanEkspres() {
        System.out.println("Barang dikirim dengan pengiriman ekspres.");
    }

    private void ambilSendiri() {
        System.out.println("Barang akan diambil langsung di toko.");
    }
}
