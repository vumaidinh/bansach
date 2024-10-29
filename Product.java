import java.io.Serializable;

public abstract class Product implements Serializable{
    protected String brand;
    protected String tensp;
    protected String masp;
    protected long dongia;
    protected int soluong;
    protected String loai;

    public Product(String loai,String brand, String tensp, String masp, long dongia, int soluong) {
        this.loai=loai;
        this.soluong=soluong;
        this.brand = brand;
        this.tensp = tensp;
        this.masp = masp;
        this.dongia = dongia;
    }

    public Product() {
        loai=null;
        soluong=0;
        brand = null;
        tensp = null;
        masp = null;
        dongia = 0;
    }

    public String getLoai(){
        return loai;
    }
    public int getSoluong(){
        return soluong;
    }

    public String getbrand() {
        return brand;
    }

    public String gettensp() {
        return tensp;
    }

    public String getmasp() {
        return masp;
    }

    public long getdongia() {
        return dongia;
    }


    public void setSoluong(int soluong){
        this.soluong=soluong;
    }

    public void setbrand(String brand) {
        this.brand = brand;
    }

    public void settensp(String tensp) {
        this.tensp = tensp;
    }

    public void setmasp(String masp) {
        this.masp = masp;
    }

    public void setdongia(long dongia) {
        this.dongia = dongia;
    }

    public void setLoai(String loai){
        this.loai=loai;
    }

    public  void nhapProduct(){
        brand=Check.nhapChuoi("Thuong hieu: ","Error");
        tensp=Check.nhapChuoi("Ten san pham: ","Error");
        dongia=Check.nhapSoNguyenL("Don gia: ","Error");
    }

    public abstract String toString();

    public abstract void xuatProduct();

    public static void main(String[] args) {
    }
}
