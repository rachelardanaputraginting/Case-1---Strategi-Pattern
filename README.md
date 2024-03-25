NIM		: 2022573010111	
Nama		: Rachel Ardana Putra Ginting	
Kelas		: TI-2C
Mata Kuliah	: Design Pattern

Kasus: Pengiriman Pesanan

Deskripsi
Bayangkan Anda memiliki sebuah aplikasi e-commerce sederhana yang memungkinkan pengguna untuk memesan barang secara online. Setiap kali pengguna menyelesaikan pembelian, Anda perlu mengatur pengiriman barang sesuai dengan pilihan yang mereka buat, misalnya pengiriman reguler, ekspres, atau pengambilan langsung di toko (pick-up).

Tanpa Strategy Pattern:
Tanpa Strategi Pattern, sistem akan menjadi kaku dan sulit diubah, Setiap kali ingin menambahkan algoritma baru, programmer harus mengubah kode sumber secara langsung. Hal ini dapat menyebabkan bug dan masalah kompabilitas.

Contoh Kode
public class Pesanan {  
    private String metodePengiriman;  
  
    public Pesanan(String metodePengiriman) {  
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

public static void main(String[] args) {  
    Pesanan pesanan1 = new Pesanan("reguler");  
    pesanan1.prosesPengiriman();  
  
    Pesanan pesanan2 = new Pesanan("ekspres");  
    pesanan2.prosesPengiriman();  
  
    Pesanan pesanan3 = new Pesanan("ambil_sendiri");  
    pesanan3.prosesPengiriman();  
} 

Masalah:
Kode menjadi kaku dan sulit diubah
Sulit untuk menambahkan algoritma baru
Berpotensi menimbulkan bug dan masalah kompabilitas

Solusi
Dengan menggunakan Strategy Pattern, Anda dapat dengan mudah menambahkan atau mengubah metode-metode pengiriman tanpa harus mengubah kelas-kelas yang sudah ada atau mengganggu logika bisnis utama Anda. Ini membuat kode lebih terstruktur, mudah dimengerti, dan mudah dipelihara.

Contoh Kode
public interface MetodePengiriman {  
    void kirim();  
}  

public class PengirimanReguler implements MetodePengiriman {  
    @Override  
    public void kirim() {  
        System.out.println("Barang dikirim dengan pengiriman reguler.");  
    }  
}  
  
public class PengirimanEkspres implements MetodePengiriman {  
    @Override  
    public void kirim() {  
        System.out.println("Barang dikirim dengan pengiriman ekspres.");  
    }  
}  
  
public class AmbilSendiri implements MetodePengiriman {  
    @Override  
    public void kirim() {  
        System.out.println("Barang akan diambil langsung di toko.");  
    }  
} 

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

public static void main(String[] args) {  
    Pesanan pesanan1 = new Pesanan(new PengirimanReguler());  
    pesanan1.prosesPengiriman();  
  
    Pesanan pesanan2 = new Pesanan(new PengirimanEkspres());  
    pesanan2.prosesPengiriman();  
  
    Pesanan pesanan3 = new Pesanan(new AmbilSendiri());  
    pesanan3.prosesPengiriman();  
}


Analisa
Interface MetodePengiriman:
Interface ini bertanggung jawab untuk mendefinisikan kontrak untuk semua strategi pengiriman.
Ini memungkinkan berbagai metode pengiriman untuk diimplementasikan secara terpisah dan dipilih secara dinamis.
Kelas-kelas Konkrit untuk Setiap Metode Pengiriman:
Setiap kelas yang mengimplementasikan MetodePengiriman mewakili sebuah strategi pengiriman spesifik.
Setiap kelas ini memiliki satu metode kirim() yang menggambarkan tindakan pengiriman yang dilakukan sesuai strateginya.
Kelas Pesanan:
Kelas Pesanan bertanggung jawab untuk mengelola proses pengiriman, namun tidak terikat dengan detail implementasi dari masing-masing strategi pengiriman.
Konstruktor Pesanan menerima objek dari interface MetodePengiriman, sehingga bisa menggunakan berbagai strategi pengiriman tanpa mengkhawatirkan detail implementasinya.
Metode aturMetodePengiriman() memungkinkan pengguna untuk mengubah strategi pengiriman yang digunakan setelah pembuatan objek Pesanan.
Metode prosesPengiriman() mengarahkan pemanggilan ke metode kirim() dari objek MetodePengiriman yang terkait, tanpa harus tahu detail dari setiap strategi pengiriman.
