import java.io.Serializable;

public class Staff extends Supplier implements Serializable{
    private String sex;
    private Date dob;
    private static int Staff=0;;

    public Staff(String name,String sdt, Address address,String email, String ma,Date dob,String sex) {
        super(name,sdt,address,email,ma);
        this.dob = dob;
        this.sex = sex;
        Staff++;
    }

    public Staff() {
        super();
        Staff++;
        dob = new Date();
        ma = "Staff"+Staff;
        sex = null;
    }

    public static int getStaff(){
        return Staff;
    }

    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public void nhapPerson() {
        super.nhapPerson();
        do{
            sex = Check.nhapChuoi("Gioi tinh (Nam/Nu): ","Error");
        }while(!(sex.equalsIgnoreCase("Nam") || sex.equalsIgnoreCase("Nu")));
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
        Staff a=new Staff();
        Staff b=new Staff();
        a.nhapPerson();
        b.nhapPerson();
        a.xuatPerson();
        b.xuatPerson();
    }
}
