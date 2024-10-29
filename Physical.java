import java.io.Serializable;

public class  Physical extends Product implements Serializable{
    private String size;
    private String color;
    private static int physical=0;
    public Physical(String loai,String brand, String tensp, String masp, long dongia,String size,String color, int soluong) {
        super(loai,brand, tensp, masp, dongia,soluong);
        this.size = size;
        this.color = color;
        physical++;
    }
    public Physical(){
        super();
        physical++;
        masp="PSC"+physical;
        size=null;
        color=null;
        loai="Physical";
    }
    
    public static int getPhysical() {
        return physical;
    }
    public void setsize(String size){
        this.size=size;
    }
    public String getsize(){
        return size;
    }
    public void setcolor(String color){
        this.color=color;
    }
    public String getcolor(){
        return color;
    }
    public void nhapProduct(){
        System.out.println("Day la quan ao");
        super.nhapProduct();
        size=Check.nhapChuoi("Nhap vao kich thuoc: ","error");
        color=Check.nhapChuoi("Nhap vao mau: ","error");
    }
    @Override
    public void xuatProduct(){
        System.out.printf("%-20s%-25s%-15s%-12d%-8s%-8s%-10s%-10d\n",brand,tensp,masp,dongia,size,color," ",soluong);
    }
    public String toString(){
        return loai+";"+brand+";"+tensp+";"+masp+";"+dongia+";"+size+";"+color+";"+soluong;
    }
    public static void main(String[] args){
        Physical a=new Physical();
        a.nhapProduct();
        a.xuatProduct();
    }
}
