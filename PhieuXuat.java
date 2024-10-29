import java.io.Serializable;

public class PhieuXuat implements Serializable{
    private String maPhieuXuat;
    private String maNhanVien;
    private String maKhachHang;
    private Date ngayXuat;
    private static int count=0;
    
    public PhieuXuat(String maNhanVien, String maKhachHang, Date ngayXuat,String maPhieuXuat) {
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.ngayXuat = ngayXuat;
        this.maPhieuXuat=maPhieuXuat;
        count++;
    }
    public PhieuXuat(){
        count++;
        maPhieuXuat="PX"+count;
        maNhanVien = null;
        maKhachHang = null;
        ngayXuat = null;
    }
    
    public static int getCount() {
        return count;
    }
    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }
    public void setMaPhieuXuat(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }
    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    public String getMaKhachHang() {
        return maKhachHang;
    }
    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    public Date getNgayXuat() {
        return ngayXuat;
    }
    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }
    
    public void xuat() {
        System.out.printf("KHACH HANG: %-20sNHAN VIEN: %-20sMPX: %-10sNGAY XUAT: %-18s\n",maKhachHang,maNhanVien,maPhieuXuat,ngayXuat);
    }
    @Override
    public String toString() {
        return maNhanVien+";"+maKhachHang+";"+ngayXuat+";"+maPhieuXuat;
    }
    public static void main(String[] args) {
        PhieuXuat px = new PhieuXuat();

        px.xuat();
    }
}
