
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Nhaphang implements Serializable{
    private PhieuNhap phieunhap;
    private PhieuNhap[] pn;
    private Product[] Products;
    private CTphieunhap[] ctpn;
    private List<PhieuNhap> listpn;
    private List<CTphieunhap> listctpn;
    private List<Product> listProduct;
    private long sum;
    private FILE fi;
    private int k;
    private int j;
    private int n;  

    public Nhaphang(PhieuNhap phieunhap, int j,int k,Product[] Products, int n, PhieuNhap[] pn, CTphieunhap[] ctpn) {
        this.Products = Products;
        this.phieunhap=phieunhap;
        this.n = n;
        this.j=j;
        this.pn = pn;
        this.ctpn = ctpn;
        this.k=k;
    }

    public Nhaphang(){
        sum=0;
        phieunhap=null;
        k=0;
        j=0;
        Products =null;
        n=0;
        pn=null;
        ctpn=null;
        listctpn=null;
        listProduct=null;
        listpn=null;
        fi=new FILE();
    }

    public void nhapphieunhap(DSsupplier dsncc,Taikhoan account,Danhsach ds){
        listtoarrayPhieuNhaps();
        CTphieunhap a;
        int choice;
        ctpn=new CTphieunhap[j];
        pn=new PhieuNhap[k];
        do{
            phieunhap=new PhieuNhap();
            account.phieunhap(phieunhap);
            dsncc.Xuat();
            dsncc.phieunhap(phieunhap);
            phieunhap.setNgaynhap(InputDate());
            int input,v,i,m,count,t;
            pn=Arrays.copyOf(pn,pn.length+1);
            pn[k]=phieunhap;
            k++;
            do{
                do{
                    v=count=0;
                    ds.Xuat();
                    String masp=Check.nhapChuoi("Nhap vao ma san pham muon nhap hang: ","Error");
                    for(i=0;i<ds.danhsach.length;i++){
                        a=new CTphieunhap();
                        if(ds.danhsach[i].getmasp().equals(masp)){
                            if(ctpn.length>0)
                                for(m=0;m<ctpn.length;m++){
                                    if(ctpn[m].getMaSanPham().equals(masp)){
                                        a.setsl(Inputquantity());
                                        ds.danhsach[i].setSoluong(ds.danhsach[i].getSoluong()+a.getsl());
                                        ctpn[m].setsl(ctpn[m].getsl()+a.getsl());
                                        ctpn[m].setTongTien(ds.danhsach[i].getdongia()*ctpn[m].getsl());
                                        count++;
                                        v++;
                                    }
                                }
                            if (count==0) {
                                a.setloai(ds.danhsach[i].getLoai());
                                a.setMapn(phieunhap.getMapn());
                                a.settensp(ds.danhsach[i].gettensp());
                                a.setMaSanPham(ds.danhsach[i].getmasp());
                                a.setDongia(ds.danhsach[i].getdongia());
                                a.setsl(Inputquantity());
                                ds.danhsach[i].setSoluong(ds.danhsach[i].getSoluong()+a.getsl());
                                a.setTongTien(ds.danhsach[i].getdongia()*a.getsl());
                                if(a.getloai().equalsIgnoreCase("Physical")){
                                    Physical physical=(Physical)ds.danhsach[i];
                                    a.setColor(physical.getcolor());
                                    a.setSize(physical.getsize());
                                }
                                if(a.getloai().equalsIgnoreCase("Digital")){
                                    Digital digital=(Digital) ds.danhsach[i];
                                    a.setCongsuat(digital.getCongsuat());
                                }
                                ctpn=Arrays.copyOf(ctpn,ctpn.length +1);
                                ctpn[j]=a;
                                j++;
                                v++; 
                            }
                        }
                    }
                    if (v==0)
                        System.out.println("Ma san pham khon ton tai");
                }while(v!=1);
                do{
                    do{
                        System.out.println("1. Xoa bo san pham trong gio hang");
                        System.out.println("2. Nhap hang tiep");
                        System.out.println("3. Xem gio hang");
                        System.out.println("4. Thanh toan");
                        input=Check.nhapSoNguyen("Chon: ","Error");
                    }while(input<1 || input>4);
                    if(input==1){
                        if(ctpn.length!=0){
                            System.out.printf("%-5s%-10s%-15s%-25s%-15s%-10s%-10s%-15s%-15s\n","STT","MPN","MA SAN PHAM","TEN SAN PHAM","SO LUONG","SIZE","MAU","DON GIA","THANH TIEN");
                            for(i=0;i<ctpn.length;i++){
                                System.out.printf("%-5d",i+1);
                                ctpn[i].xuat();
                            }
                            Delete();
                        }
                        else
                            System.out.println("Gio hang rong");
                    } else if(input==3){
                        Giohang(phieunhap);
                    }
                }while(input==1 || input==3);
            }while(input!=4);
            System.out.println("Tao phieu nhap tiep theo");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice=Check.nhapSoNguyen("Chon: ","Error");
            if(choice==1){
                if(ctpn==null)
                    System.out.println("Khong co hoa don");
                else
                    xuatphieunhap();
            }
        }while(choice!=2);
        xuatphieunhaphoadon(pn[k-1]);
        listpn=new ArrayList<PhieuNhap>(Arrays.asList(pn));
        listctpn=new ArrayList<CTphieunhap>(Arrays.asList(ctpn));
        fi.GhifileCTphieunhaps(listctpn);
        fi.GhifilePhieuNhaps(pn[k-1]);
    }

    public void Delete(){
        int k;
        do{
            k=0;
            String ma=Check.nhapChuoi("Nhap ma san pham muon bo: ","Error");
            for(int i=0;i<ctpn.length;i++)
                if (ctpn[i].getMaSanPham().equals(ma)){
                    for(int j=i;j<ctpn.length-1;j++)
                        ctpn[j]=ctpn[j+1];
                    ctpn=Arrays.copyOf(ctpn,ctpn.length-1);
                    j--;
                    k++;
                    break; 
                }
            if(k!=1)
                System.out.println("Ma san pham khon dung");
        }while(k!=1);
    }
    
    public void xuatphieunhaphoadon(PhieuNhap pn){
        int k;
        k=0;
        sum=0;
        System.out.println("                          -------------PHIEU NHAP-------------");
        System.out.println("                                          ++++");
        pn.xuat();
        System.out.printf("%-5s%-10s%-15s%-25s%-15s%-10s%-10s%-15s%-15s\n","STT","MPN","MA SAN PHAM","TEN SAN PHAM","SO LUONG","SIZE","MAU","DON GIA","THANH TIEN");
        for(int j=0;j<ctpn.length;j++)
            if (ctpn[j].getMapn().equals(pn.getMapn())){
                k++;
                sum+=ctpn[j].getTongTien();
                System.out.printf("%-5d",k);
                ctpn[j].xuat();
            }
        System.out.printf("%-90s TONG HOA DON: %d\n","",sum);   
    }

    public void xuatphieunhap(){
        listtoarrayCTphieunhaps();
        listtoarrayPhieuNhaps();
        int i,k;
        for(i=0;i<pn.length;i++){
            k=0;
            sum=0;
            System.out.println("                          -------------PHIEU NHAP-------------");
            System.out.println("                                          ++++");
            pn[i].xuat();
            System.out.printf("%-5s%-10s%-15s%-25s%-15s%-10s%-10s%-15s%-15s\n","STT","MPN","MA SAN PHAM","TEN SAN PHAM","SO LUONG","SIZE","MAU","DON GIA","THANH TIEN");
            for(int j=0;j<ctpn.length;j++)
                if (ctpn[j].getMapn().equals(pn[i].getMapn())){
                    k++;
                    sum+=ctpn[j].getTongTien();
                    System.out.printf("%-5d",k);
                    ctpn[j].xuat();
                }
            System.out.printf("%-90s TONG HOA DON: %d\n","",sum);
        }
    }

    public Date InputDate(){
        return Check.nhapNgayThang("Ngay nhap phieu: ","Error");
    }

    public int Inputquantity(){
        while (true) {
            try{
                int sl=Check.nhapSoNguyen("Nhap vao so luong  muon nhap hang: ","Error");
                return sl;
            }catch (Exception e){
                System.out.print("KHONG HOP LE!!! Nhap lai so luong");
            }
        }
    }

    public String InputSize(){
        return Check.nhapChuoi("Chon size: ","Error");
    }

    public String InputeColor(){
        return Check.nhapChuoi("Chon mau: ","Error");
    }

    public void Giohang(PhieuNhap pn){
        System.out.println("                     ----------GIO HANG----------");
        System.out.printf("%-5s%-10s%-15s%-25s%-15s%-10s%-10s%-15s%-15s\n","STT","MPN","MA SAN PHAM","TEN SAN PHAM","SO LUONG","SIZE","MAU","DON GIA","THANH TIEN");
        for(int i=0;i<ctpn.length;i++)
            if(ctpn[i].getMapn().equals(pn.getMapn())){
                System.out.printf("%-5d",i+1);
                ctpn[i].xuat();
            }

    }

    public void Khoitao(){
        listProduct=new ArrayList<>();
        listctpn=new ArrayList<>();
        listpn=new ArrayList<>();
        Date day1=new Date(11,2,2022);
        Date day2=new Date(30,8,2022);
        Date day3=new Date(25,6,2023);
        /*Product a = new Digital("Digital","ASUS", "Asus Vivobook 2023", "DGT1", 18000000, 110,200);
        Product a1 = new Digital("Digital","LG", "Tivi LG", "DGT2", 3800000,110,200);
        Product a2 = new Digital("Digital","Samsung", "Samsung A50", "DGT3", 12000000,4000,200);
        Product a3 = new Digital("Digital","ASUS", "Asus Vivobook M1 2020", "DGT4", 18000000, 110,200);
        Product a4 = new Digital("Digital","LG", "Tivi LG M1", "DGT5", 3800000,110,200);
        Product a5 = new Digital("Digital","Samsung", "Samsung AM1", "DGT6", 12000000,4000,200);
        Product b = new Physical("Physical","Hades", "Ao thun", "PSC1", 200000, "M", "Den",200);
        Product b1 = new Physical("Physical","Hades", "Quan Short", "PSC2", 250000,"L", "Xanh",200);
        Product b2 = new Physical("Physical","Hades", "Quan Jean", "PSC3", 320000,"M", "Den",200);
        Product b3 = new Physical("Physical","Hades", "Jacket", "PSC4", 330000, "XL", "Trang",200);
        Product b4 = new Physical("Physical","NOW", "Ao thun needofwisdom", "PSC5", 200000, "M", "Den",200);
        Product b5 = new Physical("Physical","NOW", "Quan Short needofwisdom", "PSC6", 250000,"L", "Xanh",200);
        Product b6 = new Physical("Physical","NOW", "Quan Jean needofwisdom", "PSC7", 320000,"M", "Den",200);
        Product b7 = new Physical("Physical","NOW", "Jacket needofwisdom", "PSC8", 330000, "XL", "Trang",200);
        Product c = new Food("Food","BM", "Banh mi", "FD1", 30000,200);
        Product c1 = new Food("Food","Oshi", "Snack", "FD2", 10000,200);
        Product c2 = new Food("Food","HaoHao", "Mi goi", "FD3", 5000,200);
        Product c3 = new Food("Food","BM", "Sandwich", "FD4", 30000,200);
        Product c4 = new Food("Food","Oshi", "Snack OiOi", "FD5", 10000,200);
        Product c5 = new Food("Food","HaoHao", "Bot", "FD6", 5000,200);*/
        PhieuNhap pn1=new PhieuNhap("STAFF1","SPR1",day1,"PN1");
        PhieuNhap pn2=new PhieuNhap("STAFF2","SPR2",day2,"PN2");
        PhieuNhap pn3=new PhieuNhap("ADMIN1","SPR3",day3,"PN3");
        CTphieunhap ct1=new CTphieunhap("Digital","PN1","DGT1","Asus Vivobook 2023",100,18000000,100*18000000,"","",100);
        CTphieunhap ct2=new CTphieunhap("Digital","PN2","DGT2","Tivi LG",100,3800000,100*3800000,"","",100);
        CTphieunhap ct3=new CTphieunhap("Digital","PN3","DGT3","Samsung A50",100,12000000,100*12000000,"","",100);
        CTphieunhap ct4=new CTphieunhap("Physical","PN1","PSC1","Ao thun",100,200000,100*200000,"M","Den",0);
        CTphieunhap ct5=new CTphieunhap("Physical","PN2","PSC2","Quan Short",100,250000,100*250000,"L","Xanh",0);
        CTphieunhap ct6=new CTphieunhap("Physical","PN3","PSC3","Quan Jean",100,320000,100*320000,"M", "Den",0);
        CTphieunhap ct7=new CTphieunhap("Physical","PN3","PSC4","Jacket",100,330000,100*330000,"XL", "Trang",0);
        CTphieunhap ct8=new CTphieunhap("Food","PN1","FD1","Banh mi",100,30000,100*30000,"","",0);
        CTphieunhap ct9=new CTphieunhap("Physical","PN2","PSC4","Jacket",100,330000,100*330000,"XL", "Trang",0);
        CTphieunhap ct10=new CTphieunhap("Digital","PN2","DGT3","Samsung A50",100,12000000,100*12000000,"","",0);
        /*listProduct.add(a);
        listProduct.add(a1);
        listProduct.add(a2);
        listProduct.add(a3);
        listProduct.add(a4);
        listProduct.add(a5);
        listProduct.add(b);
        listProduct.add(b1);
        listProduct.add(b2);
        listProduct.add(b3);
        listProduct.add(b4);
        listProduct.add(b5);
        listProduct.add(b6);
        listProduct.add(b7);
        listProduct.add(c);
        listProduct.add(c1);
        listProduct.add(c2);
        listProduct.add(c3);
        listProduct.add(c4);
        listProduct.add(c5);*/
        listpn.add(pn1);
        listpn.add(pn2);
        listpn.add(pn3);
        listctpn.add(ct1);
        listctpn.add(ct2);
        listctpn.add(ct3);
        listctpn.add(ct4);
        listctpn.add(ct5);
        listctpn.add(ct6);
        listctpn.add(ct7);
        listctpn.add(ct8);
        listctpn.add(ct9);
        listctpn.add(ct10);
        fi.GhifileCTphieunhaps(listctpn);
        fi.GhifilePhieuNhaps(listpn);
    }
    

    public PhieuNhap[] listtoarrayPhieuNhaps(){
        listpn=fi.DocfilePhieuNhaps();
        pn=new PhieuNhap[listpn.size()];
        k=listpn.size();
        for(int i=0;i<listpn.size();i++)
            pn[i]=listpn.get(i);
        return pn;
    }

    public CTphieunhap[] listtoarrayCTphieunhaps(){
        listctpn=fi.DocfileCTphieunhaps();
        ctpn=new CTphieunhap[listctpn.size()];
        j=listctpn.size();
        for(int i=0;i<listctpn.size();i++)
            ctpn[i]=listctpn.get(i);
        return ctpn;
    }
    
    public static void main(String[] args) {
        Nhaphang a=new Nhaphang();
        DSaccount acounts=new DSaccount();
        DSsupplier ncc=new DSsupplier();
        Danhsach ds=new Danhsach();
        Taikhoan acc=new Taikhoan();
        a.Khoitao();
    }
}
