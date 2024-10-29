import java.io.Serializable;

public class Admin extends Account implements Serializable{
    private static int count=0;
    
    public Admin(String ma,String tendangnhap, String matkhau){
        super(ma,tendangnhap,matkhau);
        count++;
    }
    
    public Admin(){
        super();
        count++;
        ma="ADMIN"+count;
        tendangnhap="admin"+ma;
    }
    
    public void Xuat(){
        super.Xuat();
    }
    public String toString(){
        return super.toString();
    }
    public static void main(String[] args){}

}
