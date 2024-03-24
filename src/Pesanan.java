public class Pesanan {
    private MetodePengiriman metodePengiriman;

    public Pesanan(MetodePengiriman metodePengiriman) {
        this.metodePengiriman = metodePengiriman;
    }

    public void aturMetodePengiriman(MetodePengiriman metodePengiriman) {
        this.metodePengiriman = metodePengiriman;
    }

    public void prosesPengiriman() {
        metodePengiriman.kirim();
    }
}