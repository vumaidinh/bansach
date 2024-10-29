import java.io.Serializable;

public class Digital extends Product implements Serializable{
    private int congsuat;
    private static int digital=0;
    public Digital(String loai,String brand, String tensp, String masp, long dongia,int congsuat, int soluong) {
        super(loai,brand, tensp, masp, dongia,soluong); 
        this.congsuat = congsuat;
        digital++;
    }
    public Digital(){
        super();    
        digital++;
        congsuat=0;
        masp="DGT"+digital;
        loai="Digital";
    }
    
    public static int getDigital(){
        return digital;
    }
    
    public int getCongsuat() {
        return congsuat;
    }
    public void setCongsuat(int congsuat) {
        this.congsuat = congsuat;
    }
    
    public void dientu(){
        System.out.println("Day la thiet bi dien tu");
    }
    
    public void nhapProduct(){
        System.out.println("Day la thiet bi dien tu");
        super.nhapProduct();
        congsuat=Check.nhapSoNguyen("Cong suat: ","Error");
        
    }
    
    public void xuatProduct(){
        System.out.printf("%-20s%-25s%-15s%-12d%-8s%-8s%-10d%-10d\n",brand,tensp,masp,dongia," "," ",congsuat,soluong);
    }
    public String toString(){
        return loai+";"+brand+";"+tensp+";"+masp+";"+dongia+";"+congsuat+";"+soluong;
   }
    
    public static void main(String[] args){ }
}
