import java.io.Serializable;

public class Address  implements Serializable{
    private String sonha;
    private String street;
    private String district;
    private String city;
    public Address(String sonha,String street,String district,String city){
        this.sonha=sonha;
        this.street=street;
        this.district=district;
        this.city=city;
    }
    
    public Address(){
        sonha=null;
        street=null;
        district=null;
        city=null;
    }
    
    public void setsonha(String sonha){
        this.sonha=sonha;
    }
    public String getsonha(){
        return sonha;
    }
    
    public void setstreet(String street){
        this.street=street;
    }
    public String getstreet(){
        return street;
    }
    
    public void setdistrict(String district){
        this.district=district;
    }
    public String getdistrict(){
        return district;
    }
    
    public void setcity(String city){
        this.city=city;
    }
    public String getcity(){
        return city;
    }
    
    public void nhapAddress(){
        sonha=Check.nhapChuoi("Nhap vao so nha: ","Error");
        street=Check.nhapChuoi("Nhap vao ten duong: ","Error");
        district=Check.nhapChuoi("Nhap vao ten/so quan/huyen:  ","Error");
        city=Check.nhapChuoi("Nhap vao thanh pho/tinh","Error");
    }
    public void xuatAddress(){
        System.out.print(sonha+"-"+street+"-"+district+"-"+city);
    }
    
    public String toString(){
        return sonha+"-"+street+"-"+district+"-"+city;
    }
    public static void main(String[] args){
        Address a=new Address();
        a.nhapAddress();
        a.xuatAddress();
    }

    
}
