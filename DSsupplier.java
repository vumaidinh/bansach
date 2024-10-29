import java.util.Arrays;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class DSsupplier implements Serializable,Chucnang<DSsupplier>{
    public Supplier[] dssupplier;
    private List<Supplier> list;
    private int n;    
    private FILE fi;
    public DSsupplier(Supplier[] dssupplier, int n, List<Supplier> list) {
        this.dssupplier = dssupplier;
        this.n = n;
        this.list=list;

    }
    public DSsupplier(){
        dssupplier=null;
        n=0;
        list=null;
        fi=new FILE();
    }
    
    public void Nhap(){
        n=Check.nhapSoNguyen("Nhap vao so nha cung cap: ","Error");
        dssupplier=new Supplier[n];
        Supplier a;
        for(int i=0;i<dssupplier.length;i++){
            a=new Supplier();
            a.nhapPerson();
            dssupplier[i]=a;
            System.out.println();
        }
        list=new ArrayList<Supplier>(Arrays.asList(dssupplier));
        fi.GhifileSuppliers(list);
    }
    public void Nhap(DSsupplier ncc){}

    public void FindbyName(){
        listtoarray();
        int k=0;
        String ten=Check.nhapChuoi("Nhap vao ten nha cung cap tim kiem: ", "Error");
        for(int i=0;i<dssupplier.length;i++)
            if(dssupplier[i].getname().equalsIgnoreCase(ten)){
                System.out.printf("%-5s%-10s%-20s%-18s%-20s%-25s\n","STT","MA","CONG TY","SO DIEN THOAI","EMAIL","DIA CHI");
                System.out.printf("%-5d",i+1);
                dssupplier[i].xuatPerson();
                k++;
            }
        if(k==0)
            System.out.println("Khong tim  thay");
    }
    public void FindbyID(){
        listtoarray();
        int k=0;
        String ma=Check.nhapChuoi("Nhap vao ma nha cung cap tim kiem: ", "Error");
        for(int i=0;i<dssupplier.length;i++)
            if(dssupplier[i].getMa().equals(ma)){
                System.out.printf("%-10s%-20s%-18s%-20s%-25s\n","MA","CONG TY","SO DIEN THOAI","EMAIL","DIA CHI");
                dssupplier[i].xuatPerson();
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
            String ma=Check.nhapChuoi("Nhap vao ma nha cung cap de xoa: ","Error");
            for(int i=0;i<n;i++)
                if(dssupplier[i].getMa().equals(ma)){
                    for(int j=i;j<n-1;j++)
                        dssupplier[j]=dssupplier[j+1];
                    dssupplier=Arrays.copyOf(dssupplier,dssupplier.length-1 );
                    n--;
                    k++;
                    break;
                }
            if(k!=1)
                System.out.println("Nha cung cap khong ton tai");
        }while(k!=1);
        list =new ArrayList<Supplier>(Arrays.asList(dssupplier));
        fi.GhifileSuppliers(list);
    }
    
    public void Add(){
        listtoarray();
        Supplier supplier=new Supplier();
        System.out.println("Nhap nha cung cap them");
        supplier.nhapPerson();
        dssupplier=Arrays.copyOf(dssupplier,dssupplier.length + 1);
        dssupplier[n]=supplier;
        n++;
        list =new ArrayList<Supplier>(Arrays.asList(dssupplier));
        fi.GhifileSuppliers(dssupplier[n-1]);
    }
    public void Add(DSsupplier ncc){}

    public void Edit(){
        listtoarray();
        int choice,k;
        choice=k=0;
        do{
            String ma=Check.nhapChuoi("Nhap ma nha cung cap muon chinh sua: ","Error");
            for(int i=0;i<dssupplier.length;i++){
                if (dssupplier[i].getMa().equals(ma)) {
                    while (choice!=6) {
                        System.out.println("1. Ho va ten");
                        System.out.println("2. So dien thoai");
                        System.out.println("3. Email");
                        System.out.println("4. Dia chi");
                        System.out.println("5. Ma nha cung cap");
                        System.out.println("6. EXIT!!!");
                        choice=Check.nhapSoNguyen("Chon: ","Error");
                        switch (choice) {
                            case 1:
                                dssupplier[i].setname(inputname());
                                break;
                            case 2:
                                dssupplier[i].setsdt(inputsdt());
                                break;
                            case 3:
                                dssupplier[i].setemail(inputemail());
                                break;
                            case 4:
                                dssupplier[i].setaddress(inputAddress());
                                break;
                            case 5:
                                dssupplier[i].setMa(inputma());
                                break;
                            default:
                                break;
                        }
                    }
                    k++;
                }
            }
            if(k==0)
                System.out.println("Nha cung cap khong ton tai");
        }while(k==1);
        list =new ArrayList<Supplier>(Arrays.asList(dssupplier));
        fi.GhifileSuppliers(list);
    }
    
    public String inputsdt(){
        return Check.nhapChuoi("Nhap vao so dien thoai moi: ","Error");
    }
    
    public String inputname(){
        return Check.nhapChuoi("Nhap ho va ten moi: " ,"Error");
    }
    
    public String inputma(){
        return Check.nhapChuoi("Nhap ma nha cung cap moi: " ,"Error");
    }
    
    public String inputemail(){
        return Check.nhapChuoi("Nhap email moi: " ,"Error");
    }
    
    public Address inputAddress(){
        return Check.nhapDiaChi("Nhap dia chi moi: ","Error");
    }
    
    public void Xuat(){
        listtoarray();
        if (dssupplier==null)
            System.out.println("Danh sach rong");
        else
            System.out.println("                                <---------------DANH SACH CONG TY--------------->");
            System.out.println("                                                     ++++");
            System.out.printf("%-5s%-10s%-20s%-18s%-20s%-25s\n","STT","MA","CONG TY","SO DIEN THOAI","EMAIL","DIA CHI");
            for(int i=0;i<dssupplier.length;i++){
                System.out.printf("%-5d",i+1);
                dssupplier[i].xuatPerson();
            }
    }
    
    public void phieunhap(PhieuNhap pn){
        String mancc;
        int k=0;
        do{
            mancc=Check.nhapChuoi("Nhap vao ma nha cung cap muon chon de nhap hang: ", "Error");
            for(int i=0;i<dssupplier.length;i++)
                if(dssupplier[i].getMa().equals(mancc)){
                    pn.setMaNhaCungCap(dssupplier[i].getMa());
                    k++;
                }
            if(k==0)
                System.out.println("Ma nha cung cap khong ton tai");
        }while(k!=1);
    }
    
    public void Khoitao(){
        list=new ArrayList<>();
        Address Address = new Address("99", "so 1", "quan 1", "Ho Chi Minh");
        Supplier a = new Supplier("LG", "0364523882",  Address, "LG@gmail.com", "SPR1");
        Supplier a1 = new Supplier("ASUS", "0123456789",Address, "asus@gmail.com", "SPR2");
        Supplier a2 = new Supplier("BM","03644746223", Address, "bm@gmail.com", "SPR3");
        Supplier a3 = new Supplier("Hades", "0922364121",Address, "hades@gmail.com", "SPR4");
        Supplier a4 = new Supplier("Samsung","0357362937", Address, "samsung@gmail.com", "SPR5");
        list.add(a);
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        fi.GhifileSuppliers(list);
    }

    public Supplier[] listtoarray(){
        list=fi.DocfileSuppliers();
        dssupplier=new Supplier[list.size()];
        n=list.size();
        for(int i=0;i<list.size();i++)
            dssupplier[i]=list.get(i);
        return dssupplier;
    }

    public static void main(String[] args){
        DSsupplier a=new DSsupplier();
        a.Khoitao();
    }
}
