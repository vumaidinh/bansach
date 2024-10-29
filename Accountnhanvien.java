import java.io.Serializable;

public class Accountnhanvien extends Account implements Serializable{
    public Accountnhanvien(String ma,String tendangnhap,String matkhau){
        super(ma,tendangnhap,matkhau);
    }
    
    public Accountnhanvien(){
        super();
    }
    
    public void Xuat(){
        super.Xuat();
    }
    public String toString(){
        return super.toString();
    }
    public static void main(String[] args){}
}
