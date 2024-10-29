
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Danhsach implements Serializable,Chucnang<Danhsach>{
    public Product[] danhsach;
    private List<Product> list;
    private int n;
    private FILE fi;
    public Danhsach(int n,Product[] danhsach){
        this.n=n;
        this.danhsach=danhsach;
    }
    public Danhsach(){
        danhsach=null;
        n=0;
        list=null;
        fi=new FILE();
    }
    
    public void Nhap(){
        int k,choice;
        danhsach=new Product[n];
        Product a;
        do{
            do{
            System.out.println("1.Physical");
            System.out.println("2.Digital");
            System.out.println("3.Food");
            choice=Check.nhapSoNguyen("Chon san pham muon nhap: ","Error");
            }while(choice<1 || choice>3);
            switch(choice){
                case 1:a=new Physical();
                        a.nhapProduct();
                        danhsach=Arrays.copyOf(danhsach,danhsach.length+1);
                        danhsach[n]=a;
                        n++;
                        break;
                case 2: a=new Digital();
                        a.nhapProduct();
                        danhsach=Arrays.copyOf(danhsach,danhsach.length+1);
                        danhsach[n]=a;
                        n++;
                        break;
                case 3:a=new Food();
                        a.nhapProduct();
                        danhsach=Arrays.copyOf(danhsach,danhsach.length+1);
                        danhsach[n]=a;
                        n++;
                        break;
                default:break;
            }
            do{
                System.out.println("1. Nhap tiep san pham");
                System.out.println("2. Thoat");
                k=Check.nhapSoNguyen("Chon: ", "Error");
            }while(k<1 || k>2);
        }while(k!=2);
        list=new ArrayList<Product>(Arrays.asList(danhsach));
        fi.GhifileProducts(list);
    }
    public void Nhap(Danhsach pr){}

    public void demPR(){
        int countP,countD,countF;
        countD=countP=countF=0;
        for(int i=0;i<danhsach.length;i++){
            if(danhsach[i] instanceof Physical)
               countP++;
            else if(danhsach[i] instanceof Digital)
               countD++;
            else if(danhsach[i] instanceof Food)
               countF++;
        }
        System.out.println("So luong san pham Physical: "+countP);
        System.out.println("So luong san pham Digital: "+countD);
        System.out.println("So luong san pham Food: "+countF);
        System.out.println("Tong so luong san pham: "+(countD+countF+countP));
    }
    
    public void Xuat(){
        listtoarray();
        if (danhsach==null)
            System.out.println("Danh sach rong");
        else
            System.out.println("                                       <--------------DANH SACH SAN PHAM-------------->");
            System.out.println("                                                             +++++");
            System.out.printf("%-5s%-20s%-25s%-15s%-12s%-8s%-8s%-10s%-10s\n","STT","THUONG HIEU","TEN SAN PHAM","MA SAN PHAM","DON GIA","SIZE","COLOR","CONG SUAT","SO LUONG");
            for(int i=0;i<danhsach.length;i++){
                System.out.printf("%-5d",i+1);
                danhsach[i].xuatProduct();
            }
            System.out.println();
            demPR();
    }
    
    public void FindbyName(){
        listtoarray();
        int k=0;
        String ten=Check.nhapChuoi("Nhap vao ten san pham tim kiem: ","Error");
        for(int i=0;i<danhsach.length;i++)
            if(danhsach[i].gettensp().equalsIgnoreCase(ten)){
                System.out.printf("%-20s%-25s%-15s%-12s%-8s%-8s%-10s%-10s\n","THUONG HIEU","TEN SAN PHAM","MA SAN PHAM","DON GIA","SIZE","COLOR","CONG SUAT","SO LUONG");
                danhsach[i].xuatProduct();
                k++;
            }
        if(k==0)
            System.out.println("Khong tim thay");
    }
    public void FindbyID(){
        listtoarray();
        int k=0;
        String ma=Check.nhapChuoi("Nhap vao ma san pham tim kiem: ","Error");
        for(int i=0;i<danhsach.length;i++)
            if(danhsach[i].getmasp().equals(ma)){
                System.out.printf("%-20s%-25s%-15s%-12s%-8s%-8s%-10s%-10s\n","THUONG HIEU","TEN SAN PHAM","MA SAN PHAM","DON GIA","SIZE","COLOR","CONG SUAT","SO LUONG");
               danhsach[i].xuatProduct();
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
            String ma=Check.nhapChuoi("Nhap vao ma san pham de xoa: ","Error");
            for(int i=0;i<n;i++)
                if(danhsach[i].getmasp().equals(ma)){
                    for(int j=i;j<n-1;j++)
                        danhsach[j]=danhsach[j+1];
                    danhsach=Arrays.copyOf(danhsach,danhsach.length-1 );
                    n--;
                    k++;
                    break;
            }
            System.out.println(k);
            if(k!=1)
                System.out.println("San pham khong ton tai");
        }while(k!=1);
        list= new ArrayList<Product>(Arrays.asList(danhsach));
        fi.GhifileProducts(list);
    }
    
    public void add(Product a){
        danhsach=Arrays.copyOf(danhsach,danhsach.length+1);
        danhsach[n]=a;
        n++;
        list =new ArrayList<Product>(Arrays.asList(danhsach));
        fi.GhifileProducts(danhsach[n-1]);
    }
    public void Add(){
        listtoarray();
        int choice;
        Product a;
        System.out.println(" Chon san pham muon them");
        do{
            System.out.println("1.Physical");
            System.out.println("2.Digital");
            System.out.println("3.Food");
            choice=Check.nhapSoNguyen("Chon: ","Error");
        }while(choice<1 || choice>3);
        switch(choice){
            case 1: a=new Physical();
                    a.nhapProduct();
                    add(a);
                    break;
            case 2: a=new Digital();
                    a.nhapProduct();
                    add(a);
                    break;
            case 3: a=new Food();
                    a.nhapProduct();   
                    add(a);
                    break;
            default: break;
        }        
    }
    public void Add(Danhsach pr){}


    public void Edit(){
        listtoarray();
        int k;
        do{
            k=0;
            String ma=Check.nhapChuoi("Nhap vao ma san pham muon chinh sua: ","Error");
            for(int i=0;i<danhsach.length;i++){
                if(danhsach[i].getmasp().equals(ma)){
                    if(danhsach[i] instanceof Physical){
                        Physical a=(Physical)danhsach[i];
                        int choice=0;
                        while (choice !=7) {
                            System.out.println("1. Sua thuong hieu");
                            System.out.println("2. Sua ten san pham");
                            System.out.println("3. Sua ma san pham");
                            System.out.println("4. Sua don gia cua san pham");
                            System.out.println("5. Sua size");
                            System.out.println("6. Sua mau sac");
                            System.out.println("7. Thoat");
                            choice=Check.nhapSoNguyen("Su lua chon: ","Error");
                            switch (choice) {
                                case 1:
                                    a.setbrand(inputBrand());
                                    break;
                                case 2:
                                    a.settensp(inputName());
                                    break;
                                case 3:
                                    a.setmasp(inputId());
                                    break;
                                case 4:
                                    a.setdongia(inputPrice());
                                    break;
                                case 5:
                                    a.setsize(inputSize());
                                    break;
                                case 6:
                                    a.setcolor(inputColor());
                                    break;    
                                default:
                                    break;
                            }
                        }
                        k++;
                    }
                    else if(danhsach[i] instanceof Digital){
                        Digital a=(Digital)danhsach[i];
                        int choice=0;
                        while (choice !=6) {
                            System.out.println("1. Sua thuong hieu");
                            System.out.println("2. Sua ten san pham");
                            System.out.println("3. Sua ma san pham");
                            System.out.println("4. Sua don gia cua san pham");
                            System.out.println("5. Sua cong suat");
                            System.out.println("6. Thoat");
                            choice=Check.nhapSoNguyen("Su lua chon: ","Error");
                            switch (choice) {
                                case 1:
                                    a.setbrand(inputBrand());
                                    break;
                                case 2:
                                    a.settensp(inputName());
                                    break;
                                case 3:
                                    a.setmasp(inputId());
                                    break;
                                case 4:
                                    a.setdongia(inputPrice());
                                    break;
                                case 5:
                                    a.setCongsuat(inputWattage());
                                    break;   
                                default:
                                    break;
                            }
                        }
                        k++;
                    }
                    else if(danhsach[i] instanceof Food){
                        Food a=(Food)danhsach[i];
                        int choice=0;
                        while (choice !=5) {
                            System.out.println("1. Sua thuong hieu");
                            System.out.println("2. Sua ten san pham");
                            System.out.println("3. Sua ma san pham");
                            System.out.println("4. Sua don gia cua san pham");
                            System.out.println("5. Thoat");
                            choice=Check.nhapSoNguyen("Su lua chon: ","Error");
                            switch (choice) {
                                case 1:
                                    a.setbrand(inputBrand());
                                    break;
                                case 2:
                                    a.settensp(inputName());
                                    break;
                                case 3:
                                    a.setmasp(inputId());
                                    break;
                                case 4:
                                    a.setdongia(inputPrice());
                                    break;   
                                default:
                                    break;
                            }
                        }
                        k++;
                    }
                }
            }
            if(k==0)
                System.out.println("San pham khong ton tai");
        }while(k==0);
        list=new ArrayList<Product>(Arrays.asList(danhsach));
        fi.GhifileProducts(list);
    }
    
    public String inputName(){
        return Check.nhapChuoi("Nhap vao ten san pham moi: ", "error");
    }
    
    public String inputBrand(){
        return Check.nhapChuoi("Nhap vao ten thuong hieu moi: ","error");
    }
    
    public String inputId(){
        return Check.nhapChuoi("Nhap vao ma san pham moi: ","error");
    }
    
    public long inputPrice(){
        System.out.print("Nhap vao gia san pham: ");
        while (true) {
            try{
                long id=Check.nhapSoNguyenL("Nhap vao ma san pham: ","error");
                return id;
            }catch (Exception e){
                System.out.print("KHONG HOP LE!!!!! Nhap lai ma san pham: ");
            }
        }
    }
    
    public int inputQuantity(){
        System.out.print("Nhap vao so luong: ");
        while (true) {
            try{
                int quantity=Check.nhapSoNguyen("Nhap vao so luong kho: ","error");
                return quantity;
            }catch (Exception e){
                System.out.print("KHONG HOP LE!!!!! Nhap lai so luong: ");
            }
        }
    }
    
    public Date inputNSX(){
        return Check.nhapNgayThang("Nhap lai ngay san xuat: ","error");
    }
    
    public String inputColor(){
        return Check.nhapChuoi("Nhap vao mau moi: ","error");
    }
    
    public String inputSize(){
        return Check.nhapChuoi("Nhap vao kich thuoc moi: ","error");
    }
    
    public Date inputWarranty(){
        return Check.nhapNgayThang("Nhap lai thoi gian bao hanh: ","error");
    }
    
    public int inputWattage(){
        System.out.print("Nhap vao cong suat: ");
        while (true) {
            try{
                int wattage=Check.nhapSoNguyen("Nhap vao cong suat: ","error");
                return wattage;
            }catch (Exception e){
                System.out.print("KHONG HOP LE!!!!! Nhap lai cong suat: ");
            }
        }
    }
    
    public Date inputHSD(){
        return Check.nhapNgayThang("Nhap lai han su dung: ","error");
    }
    
    public void Khoitao(){
        list=new ArrayList<>();
        Product b = new Physical("Physical","Hades", "Ao thun", "PSC1", 400000, "M", "Den",100);
        Product b1 = new Physical("Physical","Hades", "Quan Short", "PSC2", 300000,"L", "Xanh",100);
        Product b2 = new Physical("Physical","Hades", "Quan Jean", "PSC3", 350000,"M", "Den",100);
        Product a = new Digital("Digital","ASUS", "Asus Vivobook 2023", "DGT1", 20000000, 110,100);
        Product a1 = new Digital("Digital","LG", "Tivi LG", "DGT2", 4000000, 110,100);
        Product a2 = new Digital("Digital","Samsung", "Samsung A50", "DGT3", 15000000, 4000,100);
        Product c = new Food("Food","Chups chups", "Keo deo", "FD1", 50000,100);
        Product c1 = new Food("Food","Vonka", "Chocolate", "FD2", 55000,100);
        Product c2 = new Food("Food","HaoHao", "Mi goi", "FD3", 7000,100);
        list.add(a);
        list.add(a1);
        list.add(a2);
        list.add(b);
        list.add(b1);
        list.add(b2);
        list.add(c);
        list.add(c1);
        list.add(c2);
        fi.GhifileProducts(list);
    }
    
    public Product[] listtoarray(){
        list=fi.DocfileProducts();
        danhsach=new Product[list.size()];
        n=list.size();
        for(int i=0;i<list.size();i++)
            danhsach[i]=list.get(i);
        return danhsach;
    }
    public static void main(String[] args){
        Danhsach a=new Danhsach();
        a.Khoitao();
    }
}
