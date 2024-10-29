import java.io.Serializable;
public class CTphieuxuat implements Serializable{
    private String maSanPham;
    private String maPhieuXuat;
    private String tenSanPham;
    private int soLuong;
    private long tongTien;
    private long dongia;
    private String loai;
    private Date date;
    private String size;
    private String color;
    private int congsuat;
    
    public CTphieuxuat(String loai,String maPhieuXuat,String maSanPham,String tenSanpham,int soluong,long dongia,long tongTien, Date date,String size,String color,int congsuat){
        this.date=date;
        this.maSanPham=maSanPham;
        this.tenSanPham=tenSanpham;
        this.loai=loai;
        this.maPhieuXuat=maPhieuXuat;
        this.soLuong=soluong;
        this.dongia=dongia;
        this.tongTien=tongTien;
        this.size=size;
        this.color=color;
        this.congsuat=congsuat;
    }
    public CTphieuxuat() {
        size="";
        color="";
        maPhieuXuat="";
        maSanPham ="";
        tenSanPham ="";
        soLuong = 0;
        dongia=0;
        tongTien = soLuong*dongia;
        loai=null;
        congsuat=0;
        date=new Date();
    }
    
    public int getcongsuat(){
        return congsuat;
    }
    public void setcongsuat(int congsuat){
        this.congsuat=congsuat;
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
    
    public Date getdate(){
        return date;
    }
    public void setdate(Date date){
        this.date=date;
    }
    
    public String getLoai() {
        return loai;
    }
    public void setLoai(String loai) {
        this.loai = loai;
    }
    
    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }
    public void setMaPhieuXuat(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
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
    
    public String getTenSanPham() {
        return tenSanPham;
    }
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
    
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public long getTongTien() {
        return tongTien;
    }
    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }
    
    public void xuat() {
        System.out.printf("%-10s%-15s%-25s%-15d%-20s%-10s%-10s%-15d%-15d\n",maPhieuXuat,maSanPham,tenSanPham,soLuong,date,size,color,dongia,tongTien);
    }
    
    
    @Override
    public String toString() {
        return loai+";"+maPhieuXuat+";"+maSanPham+";"+tenSanPham+";"+soLuong+";"+dongia+";"+tongTien+";"+date+";"+size+";"+color+";"+congsuat ;
    }
    public static void main(String[] args) {
        CTphieuxuat ctpx = new CTphieuxuat();
        ctpx.xuat();
    }

}
