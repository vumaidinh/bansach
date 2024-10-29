import java.io.Serializable;

public class Food extends Product {
    public static int food;
    public Food(String loai,String brand,String tensp, String masp,long dongia, int soluong) {
        super(loai,brand, tensp, masp, dongia,soluong);
        food++;
    }
    public Food(){
        super();
        food++;
        masp="FD"+food;
        loai="Food";
    }
    public static int getFood(){
        return food;
    }

    public void nhapProduct(){
        System.out.println("Day la thuc an");
        super.nhapProduct();

    }
    public void xuatProduct(){
        System.out.printf("%-20s%-25s%-15s%-12d%-8s%-8s%-10s%-10d\n",brand,tensp,masp,dongia," "," "," ",soluong);    
    }
    public String toString(){
        return loai+";"+brand+";"+tensp+";"+masp+";"+dongia+";"+soluong;
    }
    public static void main(String[] args){
    }
}