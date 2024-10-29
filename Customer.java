import java.io.Serializable;

public class Customer extends Supplier implements Serializable{
    private Date dob;
    private String sex;
    private static int customer=0;
    
    public Customer(String name,String sdt, Address address,String email, String ma,Date dob,String sex) {
        super(name,sdt,address,email,ma);
        this.sex = sex;
        this.dob=dob;
        customer++;
    }

    public Customer() {
        super();
        customer++;
        dob = new Date();
        ma = "KH"+customer;
        sex = null;
    }

    public static int getCustomer() {
        return customer;
    }

    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSex() {
        return sex;
    }

    @Override
    public void nhapPerson() {
        super.nhapPerson();
        do{
            sex = Check.nhapChuoi("Gioi tinh (Nam/Nu): ","Error");
        }while(!(sex.equals("Nam") || sex.equals("Nu")));
        dob=Check.nhapNgayThang("Nhap ngay thang nam sinh (dd/mm/yyyy): ","Error");
    }

    @Override
    public void xuatPerson() {
        System.out.printf("%-10s%-25s%-12s%-12s%-15s%-25s%-45s\n",ma,name,sex,dob,sdt,email,address);
    }

    @Override
    public String toString() {
        return name+";"+sdt+";"+address+";"+email+";"+ma+";"+dob+";"+sex;
    }

    public static void main(String[] args) {
    }
}
