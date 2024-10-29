import java.io.Serializable;

public class Supplier implements Serializable {
    protected String ma;
    protected String name;
    protected String sdt;
    protected String email;
    protected Address address; 
    private static int supplier=0;
    public Supplier(String name,String sdt, Address address,String email, String ma) {
        this.name=name;
        this.sdt=sdt;
        this.address=address;
        this.email=email;
        this.ma=ma;
        supplier++;
    }
    
    public Supplier(){
        super();
        supplier++;
        ma = "SPR"+supplier;
        name=null;
        sdt=null;
        address=new Address();
        email=null;
        ma=null;
    }

    public static int supplier(){
        return supplier;
    }

    public void setemail(String email){
        this.email=email;
    }
    public String getemail(){
        return email;
    }

    public void setname(String name){
        this.name=name;
    }
    public String getname(){
        return name;
    }

    public void setsdt(String sdt){
        this.sdt=sdt;
    }
    public String getsdt(){
        return sdt;
    }

    public void setaddress(Address address){
        this.address=address;
    }
    public Address getaddress(){
        return address;
    }
    
    public String getMa() {
        return ma;
    }
    public void setMa(String ma) {
        this.ma = ma;
    }

    public void nhapPerson() {
        name=Check.nhapChuoi("Ten: ","Error");
        ma=Check.nhapChuoi("Ma : ","Error");
        sdt=Check.nhapSoDienThoai("So dien thoai: ","Error");
        email=Check.nhapChuoi("Email: ","Error ");
        address=Check.nhapDiaChi("Dia chi: ","Error");  
    }
    
    public void xuatPerson() {
        System.out.printf("%-10s%-20s%-18s%-20s%-25s\n",ma,name,sdt,email,address);
    }

    public String toString() {
        return name+";"+sdt+";"+address+";"+email+";"+ma;
    }

    public static void main(String[] args) {}
}
