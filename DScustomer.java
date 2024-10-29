import java.util.Arrays;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class DScustomer implements Serializable,Chucnang<DScustomer>{
    public Customer[] dscustomer;
    private List<Customer> list;
    private FILE fi;
    private int n;

    public DScustomer(Customer[] dscustomer, int n) {
        this.dscustomer = dscustomer;
        this.n = n;
    }
    public DScustomer(){
        dscustomer=null;
        n=0;
        list=null;
        fi=new FILE();
    }
    
    public void Nhap(){
        n=Check.nhapSoNguyen("Nhap vao so luong khach hang: ","Error");
        dscustomer=new Customer[n];
        Customer a;
        for(int i=0;i<dscustomer.length;i++){
            a=new Customer();
            a.nhapPerson();
            dscustomer[i]=a;
            System.out.println();
        }
        list =new ArrayList<Customer>(Arrays.asList(dscustomer));
        fi.GhifileCustomers(list);
    }
    public void Nhap(DScustomer kh){}
    
    public void FindbyName(){
        listtoarray();
        int k=0;
        String ten=Check.nhapChuoi("Nhap vao ten khach hang tim kiem: ", "Error");
        for(int i=0;i<dscustomer.length;i++)
            if(dscustomer[i].getname().equalsIgnoreCase(ten)){
                System.out.printf("%-5s%-10s%-25s%-12s%-12s%-15s%-25s%-45s\n","STT","MA","HO TEN","GIOI TINH","NGAY SINH","SO DIEN THOAI","EMAIL","DIA CHI");
                System.out.printf("%-5d",i+1);
                dscustomer[i].xuatPerson();
                k++;
            }
        if(k==0)
            System.out.println("Khong tim thay");
    }
    public void FindbyID(){
        listtoarray();
        int k=0;
        System.out.print("Nhap vao ma khach hang tim kiem: ");
        String ma=Check.nhapChuoi("Nhap vao ma khach hang tim kiem: ", "Error");
        for(int i=0;i<dscustomer.length;i++)
            if(dscustomer[i].getMa().equals(ma)){
                System.out.printf("%-10s%-25s%-12s%-12s%-15s%-25s%-45s\n","MA","HO TEN","GIOI TINH","NGAY SINH","SO DIEN THOAI","EMAIL","DIA CHI");
               dscustomer[i].xuatPerson();
               k++;
            }
        if(k==0)
            System.out.println("Khong tim  thay");
    }
    
    public void Delete(){
        listtoarray();
        int k;
        do{
            k=0;
            String ma=Check.nhapChuoi("Nhap vao ma nhan vien de xoa: ","Error");
            for(int i=0;i<n;i++)
                if(dscustomer[i].getMa().equals(ma)){
                    for(int j=i;j<n-1;j++)
                        dscustomer[j]=dscustomer[j+1];
                    dscustomer=Arrays.copyOf(dscustomer,dscustomer .length-1 );
                    n--;
                    k++;
                    break;
            }
            if(k!=1)
                System.out.println("Khach hang khong ton tai");
        }while(k!=1);
        list=new ArrayList<Customer>(Arrays.asList(dscustomer));
        fi.GhifileCustomers(list);
    }
    
    public void Add(){
        listtoarray();
        Customer customer=new Customer();
        System.out.println("Nhap khach hang them");
        customer.nhapPerson();
        dscustomer=Arrays.copyOf(dscustomer,dscustomer.length+1);
        dscustomer[n]=customer;
        n++;
        list=new ArrayList<Customer>(Arrays.asList(dscustomer));
        fi.GhifileCustomers(dscustomer[n-1]);
    }
    public void Add(DScustomer kh){}

    public void Edit(){
        listtoarray();
        int choice,k;
        choice=k=0;
        do{
            String ma=Check.nhapChuoi("Nhap ma khach hang muon chinh sua: ", "Error");
            for(int i=0;i<dscustomer.length;i++){
                if (dscustomer[i].getMa().equals(ma)) {
                    while (choice!=8) {
                    System.out.println("1. Ho va ten");
                    System.out.println("2. Gioi tinh");
                    System.out.println("3. Ngay thang nam sinh");
                    System.out.println("4. So dien thoai");
                    System.out.println("5. Email");
                    System.out.println("6. Dia chi");
                    System.out.println("7. Ma khach hang");
                    System.out.println("8. EXIT!!!");
                    choice=Check.nhapSoNguyen("Chon: ","Error");
                    switch (choice) {
                        case 1:
                            dscustomer[i].setname(inputname());
                            break;
                        case 2:
                            dscustomer[i].setSex(inputsex());
                            break;
                        case 3:
                            dscustomer[i].setDob(inputdob());
                            break;
                        case 4:
                            dscustomer[i].setsdt(inputsdt());
                            break;
                        case 5:
                            dscustomer[i].setemail(inputemail());
                            break;
                        case 6:
                            dscustomer[i].setaddress(inputAddress());
                            break;
                        case 7:
                            dscustomer[i].setMa(inputma());
                            break;
                        default:
                            break;
                        }
                    }
                    k++;
                }
            }
            if(k==0)
                System.out.println("Khach hang khong ton tai");
        }while(k==0);
        list=new ArrayList<Customer>(Arrays.asList(dscustomer));
        fi.GhifileCustomers(list);
    }
    
    public String inputsdt(){
        return Check.nhapChuoi("Nhap vao so dien thoai moi: ","Error");
    }
    public String inputname(){
        return Check.nhapChuoi("Nhap ho va ten moi: " ,"Error");
    }
    public String inputsex(){
        return Check.nhapChuoi("Nhap gioi tinh moi: " ,"Error");
    }
    public String inputma(){
        return Check.nhapChuoi("Nhap ma khach hang moi: " ,"Error");
    }
    public String inputemail(){
        return Check.nhapChuoi("Nhap email moi: " ,"Error");
    }
    public Address inputAddress(){
        return Check.nhapDiaChi("Nhap dia chi moi: ","Error");
    }
    public Date inputdob(){
        return Check.nhapNgayThang("Nhap ngay thang nam sinh moi: ","Error");
    }
    
    public void Xuat(){
        listtoarray();
        if (dscustomer==null)
            System.out.println("Danh sach rong");
        else
            System.out.println("                                         <---------------DANH SACH KHACH HANG--------------->");
            System.out.println("                                                              ++++");
            System.out.printf("%-5s%-10s%-25s%-12s%-12s%-15s%-25s%-45s\n","STT","MA","HO TEN","GIOI TINH","NGAY SINH","SO DIEN THOAI","EMAIL","DIA CHI");
            for(int i=0;i<dscustomer.length;i++){
                System.out.printf("%-5d",i+1);
                dscustomer[i].xuatPerson();
            }
    }
    
    public void phieuxuat(PhieuXuat px){
        int k=0;
        do{
            String makh=Check.nhapChuoi("Nhap ma khach hang: ","Error");
            for(int i=0;i<dscustomer.length;i++)
                if(dscustomer[i].getMa().equals(makh)){
                    px.setMaKhachHang(dscustomer[i].getMa());
                    k++;
                }
        }while(k!=1);

    }
    
    public void Khoitao(){
        list=new ArrayList<>();
        Date ad=new Date(19,8,2004);
        Address ada=new Address("2086","Huynh Tan Phat","Nha Be","Ho Chi Minh");
        Customer a=new Customer("Nguyen Hoang Tuan Kiet","0798980217",ada,"ngkietbaby19@gmail.com","KH1",ad,"Nam");
        Date ad1=new Date(10,11,2004);
        Address ada1=new Address("44C/67","Bui Van Ba","quan 7","Ho Chi Minh");
        Customer a1=new Customer("Pham Ngoc Cat Nghi","02948572629",ada1,"catnghi@gmail.com","KH2",ad1,"Nu");
        Date ad2=new Date(19,4,2004);
        Address ada2=new Address("So 3","Nguyen Binh Khiem","quan 1","Ho Chi Minh");
        Customer a2=new Customer("Nguyen Hoang Tuan Kiet","0987654321",ada2,"tuankiet@gamil.com","KH3",ad2,"Nam");
        Date ad3=new Date(1,1,2000);
        Address ada3=new Address("123","An Duong Vuong","quan 5","Ho Chi Minh");
        Customer a3=new Customer("Nguyen Ngoc Nhung","0902720212",ada3,"ngocnhung@gmail.com","KH4",ad3,"Nu");
        Date ad4=new Date(31,12,2001);
        Address ada4=new Address("384","Ly Thai To","quan 10","Ho Chi Minh");
        Customer a4=new Customer("Ha Tran Duy Phat","0799664334",ada4,"haphat@gmail.com","KH5",ad4,"Nam");
        list.add(a);
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        fi.GhifileCustomers(list);
    }

    public Customer[] listtoarray(){
        list=fi.DocfileCustomers();
        dscustomer=new Customer[list.size()];
        n=list.size();
        for(int i=0;i<list.size();i++)
            dscustomer[i]=list.get(i);
        return dscustomer;
    }

    public static void main(String[] args){
        DScustomer a=new DScustomer();
        a.Xuat();
    }
    
}
