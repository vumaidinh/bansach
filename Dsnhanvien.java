import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dsnhanvien implements Serializable,Chucnang<Dsnhanvien>{
    public Staff[] dsnhanvien;
    private List<Staff> list;
    private FILE fi;
    private int n;
    public Dsnhanvien(Staff[] dsnhanvien, int n) {
        this.dsnhanvien = dsnhanvien;
        this.n = n;
    }
    public Dsnhanvien(){
        dsnhanvien=null;
        n=0;
        list=null;
        fi=new FILE();
    }
    
    public void Nhap(){
        n=Check.nhapSoNguyen("Nhap so luong nhan vien: ","Error");
        dsnhanvien=new Staff[n];
        Staff a;
        for(int i=0;i<dsnhanvien.length;i++){
            a=new Staff();
            a.nhapPerson();
            dsnhanvien[i]=a;
            System.out.println();
        }
        list =new ArrayList<Staff>(Arrays.asList(dsnhanvien));
        fi.GhifileStaffs(list);
    }
    public void Nhap(Dsnhanvien nv){}

    public void FindbyName(){
        listtoarray();
        int k=0;
        String ten=Check.nhapChuoi("Nhap vao ten nhan vien tim kiem: ", "Error");
        for(int i=0;i<dsnhanvien.length;i++)
            if(dsnhanvien[i].getname().equalsIgnoreCase(ten)){
                System.out.printf("%-5s%-10s%-25s%-12s%-12s%-15s%-25s%-45s\n","STT","MA","HO TEN","GIOI TINH","NGAY SINH","SO DIEN THOAI","EMAIL","DIA CHI");
                dsnhanvien[i].xuatPerson();
                k++;
            }
        if(k==0)
            System.out.println("Khong tim  thay");
    }
    public void FindbyID(){
        listtoarray();
        int k=0;
        String ma=Check.nhapChuoi("Nhap vao ma nhan vien tim kiem: ", "Error");
        for(int i=0;i<dsnhanvien.length;i++)
            if(dsnhanvien[i].getMa().equals(ma)){
                System.out.printf("%-10s%-25s%-12s%-12s%-15s%-25s%-45s\n","MA","HO TEN","GIOI TINH","NGAY SINH","SO DIEN THOAI","EMAIL","DIA CHI");
                dsnhanvien[i].xuatPerson();
                k++;
            }
        if(k==0)
            System.out.println("Khong tim thay");
    }
    
    public void Delete(){
        listtoarray();
        int k;
        do{
            k=0;
            String ma=Check.nhapChuoi("Nhap vao ma nhan vien de xoa: ","Error");
            for(int i=0;i<n;i++)
                if(dsnhanvien[i].getMa().equals(ma)){
                    for(int j=i;j<n-1;j++)
                        dsnhanvien[j]=dsnhanvien[j+1];
                    dsnhanvien=Arrays.copyOf(dsnhanvien,dsnhanvien.length-1 );
                    n--;
                    k++;
                    break;
            }
            if(k!=1)
                System.out.println("Nhan vien khong ton tai");
        }while(k!=1);
        list=new ArrayList<Staff>(Arrays.asList(dsnhanvien));
        fi.GhifileStaffs(list);
    }
    
    public void Add(){
        listtoarray();
        Staff staff=new Staff();
        System.out.println("Nhap nhan vien them");
        staff.nhapPerson();
        dsnhanvien=Arrays.copyOf(dsnhanvien,dsnhanvien.length + 1);
        dsnhanvien[n]=staff;
        n++;
        list=new ArrayList<Staff>(Arrays.asList(dsnhanvien));
        fi.GhifileStaffs(dsnhanvien[n-1]);
    }
    public void Add(Dsnhanvien nv){}

    public void Edit(){
        listtoarray();
        int choice,k;
        do{
            String ma=Check.nhapChuoi("Nhap ma nhan vien muon chinh sua:", "Error");
            choice=k=0;
            for(int i=0;i<dsnhanvien.length;i++){
                if (dsnhanvien[i].getMa().equals(ma)) {
                    while (choice!=8) {
                    System.out.println("1. Ho va ten");
                    System.out.println("2. Gioi tinh");
                    System.out.println("3. Ngay thang nam sinh");
                    System.out.println("4. So dien thoai");
                    System.out.println("5. Email");
                    System.out.println("6. Dia chi");
                    System.out.println("7. Ma nhan vien");
                    System.out.println("8. EXIT!!!");
                    choice=Check.nhapSoNguyen("Chon: ","Error");
                    switch (choice) {
                        case 1:
                            dsnhanvien[i].setname(inputname());
                            break;
                        case 2:
                            dsnhanvien[i].setSex(inputsex());
                            break;
                        case 3:
                            dsnhanvien[i].setDob(inputdob());
                            break;
                        case 4:
                            dsnhanvien[i].setsdt(inputsdt());
                            break;
                        case 5:
                            dsnhanvien[i].setemail(inputemail());
                            break;
                        case 6:
                            dsnhanvien[i].setaddress(inputAddress());
                            break;
                        case 7:
                            dsnhanvien[i].setMa(inputma());
                            break;
                        default:
                            break;
                        }
                    } 
                    k++;
                }
            }
            if(k==0)
                System.out.println("Nhan vien khong ton tai");
        }while(k==0);
        list=new ArrayList<Staff>(Arrays.asList(dsnhanvien));
        fi.GhifileStaffs(list);
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
        return Check.nhapChuoi("Nhap ma nhan vien moi: " ,"Error");
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
        if (dsnhanvien==null)
            System.out.println("Danh sach rong");
        else
            System.out.println("                                         <---------------DANH SACH NHAN VIEN--------------->");
            System.out.println("                                                              ++++");
            System.out.printf("%-5s%-10s%-25s%-12s%-12s%-15s%-25s%-45s\n","STT","MA","HO TEN","GIOI TINH","NGAY SINH","SO DIEN THOAI","EMAIL","DIA CHI");
            for(int i=0;i<dsnhanvien.length;i++){
                System.out.printf("%-5d",i+1);
                dsnhanvien[i].xuatPerson();
            }
    }
    
    public void Khoitao(){
        list=new ArrayList<>();
        Address ada=new Address("12/284/23","Nguyen Trai","quan 5","Ho Chi Minh");
        Date ad=new Date(2,2,1999);
        Staff a=new Staff("Nguyen Le Nguyen Khang","019287852",ada,"nguyenkhang@gmail.com","Staff1",ad,"Nam");
        Address ada1=new Address("98","Tan My","quan 7","Ho Chi Minh");
        Date ad1=new Date(29,10,2000);
        Staff a1=new Staff("Nguyen Thi My Tuyet","0758365739",ada1,"mytuyet@gmail.com","Staff2",ad1,"Nu");
        Address ada2=new Address("209/209/128C","Ben Van Don","quan 4","Ho Chi Minh");
        Date ad2=new Date(31,12,2002);
        Staff a2=new Staff("Le Ngoc Tu Han","0592856389",ada2,"tuhan@gmail.com","Staff3",ad2,"Nu");
        Address ada3=new Address("123","Duong Ba Trac","quan 8","Ho Chi Minh");
        Date ad3=new Date(19,4,2001);
        Staff a3=new Staff("Nguyen Ngo Thao Tram","0727877865",ada3,"thaotram@gmail.com","Staff4",ad3,"Nu");
        Address ada4=new Address("so 10","Nguyen Van Cu","quan 5","Ho Chi Minh");
        Date ad4=new Date(24,6,2001);
        Staff a4=new Staff("Duong Quang Loc","0765789652",ada4,"quangloc@gmail.com","Staff5",ad4,"Nam");
        list.add(a);
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        fi.GhifileStaffs(list);
    }

    public Staff[] listtoarray(){
        list=fi.DocfileStaffs();
        dsnhanvien=new Staff[list.size()];
        n=list.size();
        for(int i=0;i<list.size();i++)
            dsnhanvien[i]=list.get(i);
        return dsnhanvien;
    }

    public static void main(String[] args){
        Dsnhanvien a=new Dsnhanvien();
        a.Khoitao();
        
    }
}
