import java.io.Serializable;

public class Account implements Serializable{
    protected String tendangnhap;
    protected String matkhau;
    protected String ma;
    public Account(String ma, String tendangnhap, String matkhau) {
        this.ma=ma;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
    }
    
    public Account(){
        tendangnhap=null;
        matkhau=null;
        ma=null;
    }
    
    public void setMa(String ma){
        this.ma=ma;
    }
    public String getMa(){
        return ma;
    }
    
    public String getTendangnhap() {
        return tendangnhap;
    }
    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }
    
    public String getMatkhau() {
        return matkhau;
    }
    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
    
    public void Xuat(){
        System.out.printf("%-10s%-25s%-20s\n",ma,tendangnhap,matkhau);
    }
    
    @Override
    public String toString() {
        return ma+";"+tendangnhap+";"+matkhau;
    }

    public static void main(String[] args){}
}