import java.io.Serializable;

public class CTphieunhap implements Serializable{
    private String maSanPham;
    private String tensp;
    private int sl;
    private int congsuat;
    private long tongTien;
    private long dongia;
    private String mapn;
    private String loai;
    private String size;
    private String color;
    
    public CTphieunhap(String loai,String mapn,String maSanPham,String tensp,int sl,long dongia,long tongTien,String size,String color,int congsuat) {
        this.maSanPham = maSanPham;
        this.loai=loai;
        this.tongTien = tongTien;
        this.dongia=dongia;
        this.mapn=mapn;
        this.size=size;
        this.color=color;
        this.tensp = tensp;
        this.sl = sl;
        this.congsuat=congsuat;
    }
    public CTphieunhap() {
        size="";
        color="";
        maSanPham = "";
        tensp = "";
        sl = 0;
        tongTien = sl*dongia;
        dongia=0;
        mapn=null;
        loai=null;
        congsuat=0;
    }
    
    public int getCongsuat() {
        return congsuat;
    }
    public void setCongsuat(int congsuat) {
        this.congsuat = congsuat;
    }

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getloai(){
        return loai;
    }
    public void setloai(String loai){
        this.loai=loai;
    }

    public String getMapn() {
        return mapn;
    }
    public void setMapn(String mapn) {
        this.mapn = mapn;
    }

    public long getDongia() {
        return dongia;
    }
    public void setDongia(long dongia) {
        this.dongia = dongia;
    }

    public String getMaSanPham() {
        return maSanPham;
    }
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String gettensp() {
        return tensp;
    }
    public void settensp(String tensp) {
        this.tensp = tensp;
    }

    public int getsl() {
        return sl;
    }
    public void setsl(int sl) {
        this.sl = sl;
    }

    public long getTongTien() {
        return tongTien;
    }
    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public void xuat() {
        System.out.printf("%-10s%-15s%-25s%-15d%-10s%-10s%-15d%-15d\n",mapn,maSanPham,tensp,sl,size,color,dongia,tongTien);
    }

    public String toString(){
        return loai+";"+mapn+";"+maSanPham+";"+tensp+";"+sl+";"+dongia+";"+tongTien+";"+size+";"+color+";"+congsuat;
    }
    
    public static void main(String[] args) {
        CTphieunhap ctpn = new CTphieunhap();
        
    }
}
