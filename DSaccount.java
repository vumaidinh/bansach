import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DSaccount implements Serializable,Chucnang<Dsnhanvien>{
    public Account[] dsAccounts;
    private int n;
    private FILE fi;
    private List<Account> list;
    public DSaccount(List<Account> list,Account[] dsAccounts,int n){
        this.dsAccounts=dsAccounts;
        this.n=n;
        this.list=list;
    }
    public DSaccount(){
        dsAccounts=null;
        n=0;
        fi=new  FILE();
        list=null;

    }
    
    public void Nhap(Dsnhanvien nv){
        int choice,choice1;
        dsAccounts= new Account[n];
        Account a;
        do{
            do{
                System.out.println("1. Tao tai khoan Admin");
                System.out.println("2. Tao tai khoan nhan vien");
                choice=Check.nhapSoNguyen("Chon: ","Error");
            }while(choice <1 || choice>2);
            switch (choice) {
                case 1: a=new Admin();
                        a.setMatkhau(Inputpassword());
                        dsAccounts=Arrays.copyOf(dsAccounts,dsAccounts.length+1);
                        dsAccounts[n]=a;
                        n++;
                        break;
                case 2: int k;
                        do{
                            k=0;
                            String ma=Check.nhapChuoi("Nhap vao ma nhan vien de tao tai khoan: ","Error");
                            for(int i=0;i<nv.dsnhanvien.length;i++)
                                if(nv.dsnhanvien[i].getMa().equals(ma)){
                                    a=new Accountnhanvien();
                                    a.setMa(nv.dsnhanvien[i].getMa());
                                    a.setMatkhau(Inputpassword());
                                    a.setTendangnhap("nhanvien"+nv.dsnhanvien[i].getMa());
                                    dsAccounts=Arrays.copyOf(dsAccounts,dsAccounts.length+1);
                                    dsAccounts[n]=a;
                                    n++;
                                    k++;
                                }
                            if(k!=1)
                                System.out.println("Ma nhan vien khong ton tai");
                        }while(k!=1);
                        break;
                default:
                    break;
            }
            do{ 
                System.out.println("1. Yes");
                System.out.println("2. No");
                choice1=Check.nhapSoNguyen("Tao tai khoan tiep?:  ","Error");
            }while(choice1 <1 || choice1 > 2);
        }while(choice1!=2);
        list=new ArrayList<Account>(Arrays.asList(dsAccounts));
        fi.GhifileAccounts(list);
    }
    public void Nhap(){}

    public void Xuat(){
        listtoarray();
        System.out.printf("%-5s%-10s%-25s%-20s\n","STT","MA","TAI KHOAN","MAT KHAU");
        for(int i=0;i<dsAccounts.length;i++){
            System.out.printf("%-5d",i+1);
            dsAccounts[i].Xuat();
        }
    }

    public void Delete(){
        listtoarray();
        int k;
        do{
            k=0;
            String ma=Check.nhapChuoi("Nhap vao ma nhan vien muon xoa: ","Error");
            for(int i=0;i<dsAccounts.length;i++)
                if (dsAccounts[i].getMa().equals(ma)) {
                    for(int j=i;j<dsAccounts.length-1;j++)
                        dsAccounts[j]=dsAccounts[j+1];
                    dsAccounts=Arrays.copyOf(dsAccounts,dsAccounts.length-1);
                    n--;
                    k++;
                }
                if(k!=1)
                    System.out.println("Ma nhan vien khong ton tai");
        }while(k!=1);
        list=new ArrayList<Account>(Arrays.asList(dsAccounts));
        fi.GhifileAccounts(list);
    }

    public void Add(Dsnhanvien nv){
        listtoarray();
        int choice,k,v;
        Account a;
        do{
            v=0;
            System.out.println("1. Admin");
            System.out.println("2. Nhan vien");
            choice=Check.nhapSoNguyen("Chon loai tai khoan muon them: ", "Error");
        }while(choice <1 || choice >2);
        switch (choice) {
            case 1: a=new Admin();
                    a.setMatkhau(Inputpassword());
                    dsAccounts=Arrays.copyOf(dsAccounts,dsAccounts.length+1);
                    dsAccounts[n]=a;
                    n++;
                    v++;
                    list=new ArrayList<Account>(Arrays.asList(dsAccounts));
                    fi.GhifileAccounts(dsAccounts[n]);
                    break;
            case 2: do{
                        k=0;
                        String ma=Check.nhapChuoi("Nhap vao ma nhan muon them tai khoan: ","Error");
                        for(int i=0;i<nv.dsnhanvien.length;i++)
                            if(nv.dsnhanvien[i].getMa().equals(ma)){
                                a=new Account();
                                a.setMa(nv.dsnhanvien[i].getMa());
                                a.setMatkhau(Inputpassword());
                                a.setTendangnhap("nhanvien"+nv.dsnhanvien[i].getMa());
                                dsAccounts=Arrays.copyOf(dsAccounts,dsAccounts.length+1);
                                dsAccounts[n]=a;
                                n++;
                                k++;
                                list=new ArrayList<Account>(Arrays.asList(dsAccounts));
                                fi.GhifileAccounts(dsAccounts[n]);
                            }
                        if(k!=1)
                            System.out.println("Ma nhan vien khong ton tai");
                    }while(k!=1);
                    v++;
                    break;
            default:
                break;
        }
        list=new ArrayList<Account>(Arrays.asList(dsAccounts));
        fi.GhifileAccounts(dsAccounts[n-1]);
    }
    public void Add(){}

    public void FindbyID(){}
    public void FindbyName(){}

    public void Edit(){
        listtoarray();
        int choice,k;
        choice=k=0;
        do{
            String ma=Check.nhapChuoi("Nhap ma nhan vien muon chinh sua: ", "Error");
            for(int i=0;i<dsAccounts.length;i++){
                if (dsAccounts[i].getMa().equals(ma)) {
                    while (choice!=3) {
                    System.out.println("1. Thay doi ten dang nhap");
                    System.out.println("2. Thay doi mat khau");
                    System.out.println("3. Thoat");
                    choice=Check.nhapSoNguyen("Chon: ","Error");
                    switch (choice) {
                        case 1:
                            dsAccounts[i].setTendangnhap(Inputnamelogin());
                            break;
                        case 2:
                            dsAccounts[i].setMatkhau(Inputpassword());
                            break;
                        default:
                            break;
                        }
                    }
                    k++;
                }
            }
            if(k==0)
                System.out.println("Tai khoan khong ton tai");
        }while(k==0);
        list=new ArrayList<Account>(Arrays.asList(dsAccounts));
        fi.GhifileAccounts(list);

    }

    public String Inputpassword(){
        return Check.nhapMatKhau("Nhap mat khau (1 chu thuong, 1 chu in, 1 so, 1 ki tu dac biet): ","Error");
    }

    public void Khoitao(){
        list=new ArrayList<>();
        Admin a =new Admin("ADMIN1","adminADMIN1","1@aA");
        Accountnhanvien b=new Accountnhanvien("STAFF1","nhanvienSTAFF1","1@aA");
        list.add(a);
        list.add(b);
        fi.GhifileAccounts(list);
    }

    public Account[] listtoarray(){
        list=fi.DocfileAccounts();
        dsAccounts=new Account[list.size()];
        n=list.size();
        for(int i=0;i<list.size();i++)
            dsAccounts[i]=list.get(i);
        return dsAccounts;
    }

    public String Inputnamelogin(){
        return Check.nhapChuoi("Ten dang nhap: ", "Error");
    }

    
    public static void main(String[] args){
        DSaccount a=new DSaccount();
        a.Khoitao();
        
        
    }
}
