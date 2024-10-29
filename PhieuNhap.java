import java.io.Serializable;

public class PhieuNhap implements Serializable{
    private String mapn;
    private String maNhanVien;
    private String maNhaCungCap;
    private Date ngaynhap;
    private static int count=0;

    public PhieuNhap(String maNhanVien, String maNhaCungCap, Date ngaynhap,String mapn) {
        this.maNhanVien = maNhanVien;
        this.maNhaCungCap = maNhaCungCap;
        this.ngaynhap = ngaynhap;
        this.mapn=mapn;
        count++;
    }
    
    public PhieuNhap() {
        count++;
        maNhanVien = null;
        maNhaCungCap = null;
        ngaynhap = null;
        mapn="PN"+count;
    }

    public static int getCount(){
        return count;
    }
    public String getMapn() {
        return mapn;
    }
    public void setMapn(String mapn){
        this.mapn=mapn;
    }
    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }
    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }
    public Date getNgaynhap() {
        return ngaynhap;
    }
    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public void xuat() {
        System.out.printf("CONG TY: %-20sNHANVIEN: %-20sMPN: %-10sNGAY NHAP: %-18s\n",maNhaCungCap,maNhanVien,mapn,ngaynhap);
    }
    public void xuatpxtk(){
        System.out.println();
    }
    @Override
    public String toString() {
        return maNhanVien+";"+maNhaCungCap+";"+ngaynhap+";"+mapn;
    }
    public static void main(String[] args) {
        PhieuNhap a=new PhieuNhap();
        a.setMapn("PXx1111");
        System.out.println(a.getMapn());
    }
}
