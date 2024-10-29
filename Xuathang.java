import java.util.Arrays;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Xuathang implements Serializable{
    private PhieuXuat phieuxuat;
    private CTphieuxuat[] ctpx;
    private PhieuXuat[] px;
    private List<CTphieuxuat> listctpx;
    private List<PhieuXuat> listpx;
    private long sum;
    private FILE fi;
    private int n;
    private int m;
    public Xuathang(PhieuXuat phieuxuat, int n,int m, PhieuXuat[] px, CTphieuxuat[] ctpx,List<CTphieuxuat> listctpx,List<PhieuXuat> listpx) {
        this.m = m;
        this.phieuxuat=phieuxuat;
        this.px = px;
        this.ctpx = ctpx;
        this.n=n;
        this.listctpx=listctpx;
        this.listpx=listpx;
    }
    public Xuathang(){
        sum=0;
        phieuxuat=null;
        n=0;
        m=0;
        px=null;
        ctpx=null;
        listctpx=null;
        listpx=null;
        fi=new FILE();
    }
    
    public void nhapphieuxuat(Danhsach ds,DScustomer dskh, Taikhoan account){
        listtoarrayPhieuXuats();
        px=new PhieuXuat[m];
        ctpx=new CTphieuxuat[n];
        CTphieuxuat a;
        int input,k,count,j,i;
        phieuxuat=new PhieuXuat();
        dskh.Xuat();
        account.phieuxuat(phieuxuat);
        dskh.phieuxuat(phieuxuat);
        phieuxuat.setNgayXuat(InputDate());
        px=Arrays.copyOf(px,px.length+1);
        px[m]=phieuxuat;
        m++;
        do{
            do{
                k=count=0;
                ds.Xuat();
                String masp=Check.nhapChuoi("Nhap vao ma san pham muon mua hang: ","Error");
                for(i=0;i<ds.danhsach.length;i++){
                    a=new CTphieuxuat();
                    if(ds.danhsach[i].getmasp().equalsIgnoreCase(masp)){
                        if(ctpx.length>0)
                            for(j=0;j<ctpx.length;j++)
                            if (ctpx[j].getMaSanPham().equalsIgnoreCase(masp)) {
                                do{
                                    a.setSoLuong(Inputquantity());
                                    if(a.getSoLuong() > ds.danhsach[i].getSoluong())
                                        System.out.println("So luong khong du");
                                }while(a.getSoLuong() > ds.danhsach[i].getSoluong());
                                ds.danhsach[i].setSoluong(ds.danhsach[i].getSoluong()-a.getSoLuong());
                                ctpx[j].setSoLuong(ctpx[j].getSoLuong()+a.getSoLuong());
                                ctpx[j].setTongTien(ds.danhsach[i].getdongia()*ctpx[j].getSoLuong());
                                count++;
                                k++;
                            }
                        if(count==0){
                            a.setMaPhieuXuat(phieuxuat.getMaPhieuXuat());
                            a.setTenSanPham(ds.danhsach[i].gettensp());
                            a.setMaSanPham(ds.danhsach[i].getmasp());
                            a.setLoai(ds.danhsach[i].getLoai());
                            do{
                                a.setSoLuong(Inputquantity());
                                if(a.getSoLuong() > ds.danhsach[i].getSoluong())
                                    System.out.println("So luong khong du");
                            }while(a.getSoLuong() > ds.danhsach[i].getSoluong());
                            ds.danhsach[i].setSoluong(ds.danhsach[i].getSoluong()-a.getSoLuong());
                            a.setDongia(ds.danhsach[i].getdongia());
                            a.setTongTien(ds.danhsach[i].getdongia()*a.getSoLuong());
                            if(ds.danhsach[i].getLoai().equalsIgnoreCase("Digital") || ds.danhsach[i].getLoai().equalsIgnoreCase("Food" ))
                                a.setdate(InputHSD());
                            if(ds.danhsach[i].getLoai().equalsIgnoreCase("Physical")){
                                Physical physical=(Physical)ds.danhsach[i];
                                do{
                                    a.setColor(InputeColor());
                                    if(!a.getColor().equalsIgnoreCase(physical.getcolor()))
                                        System.out.println("Khong co san pham");
                                }while(!a.getColor().equalsIgnoreCase(physical.getcolor()));
                                do{
                                    a.setSize(InputSize());
                                    if(!a.getSize().equalsIgnoreCase(physical.getsize()))
                                        System.out.println("Khong co san pham");
                                }while(!a.getSize().equalsIgnoreCase(physical.getsize()));
                            } else if(ds.danhsach[i].getLoai().equalsIgnoreCase("Digital")){
                                Digital digital=(Digital) ds.danhsach[i];
                                a.setcongsuat(digital.getCongsuat());
                            }
                            ctpx=Arrays.copyOf(ctpx,ctpx.length+1);
                            ctpx[n]=a;
                            n++;
                            k++;
                        }
                    }
                }
                if(k==0)
                    System.out.println("Ma san pham khong ton tai");
            }while(k!=1);
            do{
                do{
                    System.out.println("1. Xoa bo san pham trong gio hang");
                    System.out.println("2. Mua tiep");
                    System.out.println("3. Thanh toan");
                    System.out.println("4. Xem gio hang");
                    input=Check.nhapSoNguyen("Chon: ","Error");
                }while(input<1 || input >5);
                if(input==1){
                    if(ctpx.length!=0){
                        System.out.printf("%-5s%-10s%-15s%-25s%-15s%-20s%-10s%-10s%-15s%-15s\n","STT","MPX","MA SAN PHAM","TEN SAN PHAM","SO LUONG","HSD/BAO HANH","SIZE","MAU","DON GIA","THANH TIEN");
                        for(i=0;i<ctpx.length;i++){
                            System.out.printf("%-5d",i+1);
                            ctpx[i].xuat();
                        }
                        Delete(ds);
                    }
                    else
                        System.out.println("Gio hang rong");
                } else if(input==4){
                    Giohang(phieuxuat);
                }
            }while(input==1 || input==4);
        }while(input!=3);
        xuatphiexuathoadon(px[m-1]);
        listctpx=new ArrayList<CTphieuxuat>(Arrays.asList(ctpx));
        listpx=new ArrayList<PhieuXuat>(Arrays.asList(px));
        fi.GhifileCTphieuxuats(listctpx);
        fi.GhifilePhieuXuats(px[m-1]);
    }    

    public void Delete(Danhsach ds){
        int k;
        do{
            k=0;
            String ma=Check.nhapChuoi("Nhap ma san pham muon bo: ","Error");
            for(int i=0;i<ctpx.length;i++)
                if (ctpx[i].getMaSanPham().equalsIgnoreCase(ma)){
                    for(int t=0;t<ds.danhsach.length;t++)
                        if(ds.danhsach[t].getmasp().equalsIgnoreCase(ctpx[i].getMaSanPham()))
                            ds.danhsach[t].setSoluong(ds.danhsach[t].getSoluong()+ctpx[i].getSoLuong());
                    for(int j=i;j<ctpx.length-1;j++)
                        ctpx[j]=ctpx[j+1];
                    ctpx=Arrays.copyOf(ctpx,ctpx.length-1);
                    n--;
                    k++;
                    break;
                }
            if(k!=1)
                System.out.println("Ma san pham khong dung");
        }while(k!=1);
    }
   
    public Date InputDate(){
        return Check.nhapNgayThang("Ngay xuat phieu: ","Error");
    }
    
    public Date InputHSD(){
        return Check.nhapNgayThang("HSD/Bao hanh: ","Error");
    }
    
    public int Inputquantity(){
        while (true) {
            try{
                int sl=Check.nhapSoNguyen("Nhap vao so luong muon mua hang: ","Error");
                return sl;
            }catch (Exception e){
                System.out.print("KHONG HOP LE!!! Nhap lai so luong: ");
            }
        }
    }
    
    public String InputSize(){
        return Check.nhapChuoi("Chon size: ","Error");
    }
    
    public String InputeColor(){
        return Check.nhapChuoi("Chon mau: ","Error");
    }
    
    public int InputCongsuat(){
        return Check.nhapSoNguyen("Chon cong suat: ","Error");
    }

    public void xuatphiexuathoadon(PhieuXuat px){
        int k=0;
        System.out.println("                          -------------PHIEU XUAT-------------");
        System.out.println("                                          ++++");
        px.xuat();
        System.out.printf("%-5s%-10s%-15s%-25s%-15s%-20s%-10s%-10s%-15s%-15s\n","STT","MPX","MA SAN PHAM","TEN SAN PHAM","SO LUONG","HSD/BAO HANH","SIZE","MAU","DON GIA","THANH TIEN");
        for(int i=0;i<ctpx.length;i++)
            if(ctpx[i].getMaPhieuXuat().equalsIgnoreCase(px.getMaPhieuXuat())){
                k++;
                sum+=ctpx[i].getTongTien();
                System.out.printf("%-5d",k);
                ctpx[i].xuat();
            }
            System.out.printf("%-90s TONG HOA DON: %d\n","",sum);
    }

    public void xuatphiexuat(){
        listtoarrayPhieuXuats();
        listtoarrayCTphieuxuats();
        int k;
        for(int j=0;j<m;j++){
            k=0;
            sum=0;
            System.out.println("                          -------------PHIEU XUAT-------------");
            System.out.println("                                          ++++");
            px[j].xuat();
            System.out.printf("%-5s%-10s%-15s%-25s%-15s%-20s%-10s%-10s%-15s%-15s\n","STT","MPX","MA SAN PHAM","TEN SAN PHAM","SO LUONG","HSD/BAO HANH","SIZE","MAU","DON GIA","THANH TIEN");
            for(int i=0;i<n;i++)
                if(ctpx[i].getMaPhieuXuat().equalsIgnoreCase(px[j].getMaPhieuXuat())){
                    k++;
                    sum+=ctpx[i].getTongTien();
                    System.out.printf("%-5d",k);
                    ctpx[i].xuat();
                }
            System.out.printf("%-90s TONG HOA DON: %d\n","",sum);
        }
        System.out.println();
    }
    
    public void Giohang(PhieuXuat px){
        System.out.println("                     ----------GIO HANG----------");
        System.out.printf("%-5s%-10s%-15s%-25s%-15s%-20s%-10s%-10s%-15s%-15s\n","STT","MPX","MA SAN PHAM","TEN SAN PHAM","SO LUONG","HSD/BAO HANH","SIZE","MAU","DON GIA","THANH TIEN");
        for(int i=0;i<ctpx.length;i++)
            if(ctpx[i].getMaPhieuXuat().equalsIgnoreCase(px.getMaPhieuXuat())){
                System.out.printf("%-5d",i+1);
                ctpx[i].xuat();
            }
    }

    public PhieuXuat[] listtoarrayPhieuXuats(){
        this.listpx=fi.DocfilePhieuXuats();
        px=new PhieuXuat[listpx.size()];
        m=listpx.size();
        for(int i=0;i<listpx.size();i++)
            px[i]=listpx.get(i);
        return px;
    }

    public CTphieuxuat[] listtoarrayCTphieuxuats(){
        listctpx=fi.DocfileCTphieuxuats();
        ctpx=new CTphieuxuat[listctpx.size()];
        n=listctpx.size();
        for(int i=0;i<listctpx.size();i++)
            ctpx[i]=listctpx.get(i);
        return ctpx;
    }
    
    public void Khoitao(){
        listctpx=new ArrayList<>();
        listpx=new ArrayList<>();
        Date date=new Date();
        Date hsd1=new Date(11,11,2023);
        Date hsd2=new Date(16,12,2023);
        Date hsd3=new Date(15,11,2023);
        Date d1=new Date(11,11,2022);
        Date d2=new Date(16,6,2023);
        Date d3=new Date(15,5,2023);
        CTphieuxuat a=new CTphieuxuat("Physical","PX1","PSC1","Ao thun",50,400000,50*400000,date,"M","Den",0);
        CTphieuxuat a1=new CTphieuxuat("Physical","PX1","PSC2","Quan Short",50,300000,50*300000,date,"L","Xanh",0);
        CTphieuxuat a2=new CTphieuxuat("Physical","PX2","PSC1","Ao thun",50,400000,50*400000,date,"M","Den",0);
        CTphieuxuat a3=new CTphieuxuat("Physical","PX3","PSC2","Quan Short",50,300000,50*300000,date,"L","Xanh",0);
        CTphieuxuat a4=new CTphieuxuat("Food","PX1","FD1","Keo deo",50,50000,50*50000,hsd1,"","",0);
        CTphieuxuat a5=new CTphieuxuat("Food","PX2","FD1","Keo deo",50,50000,50*50000,hsd2,"","",0);
        CTphieuxuat a6=new CTphieuxuat("Food","PX3","FD2","Chocolate",50,55000,50*55000,hsd3,"","",0);
        CTphieuxuat a7=new CTphieuxuat("Digital","PX1","DGT1","Asus Vivobook 2023",50,20000000,50*20000000,hsd1,"","",100);
        CTphieuxuat a8=new CTphieuxuat("Digital","PX2","DGT2","Tivi LG",50,4000000,50*4000000,hsd2,"","",100);
        CTphieuxuat a9=new CTphieuxuat("Digital","PX3","DGT1","Asus Vivobook 2023",50,20000000,50*20000000,hsd3,"","",100);
        PhieuXuat b=new PhieuXuat("STAFF2","KH1",d1,"PX1");
        PhieuXuat b1=new PhieuXuat("STAFF3","KH2",d2,"PX2");
        PhieuXuat b2=new PhieuXuat("ADMIN1","KH3",d3,"PX3");
        listctpx.add(a);
        listctpx.add(a1);
        listctpx.add(a2);
        listctpx.add(a3);
        listctpx.add(a4);
        listctpx.add(a5);
        listctpx.add(a6);
        listctpx.add(a7);
        listctpx.add(a8);
        listctpx.add(a9);
        listpx.add(b);
        listpx.add(b1);
        listpx.add(b2);
        fi.GhifileCTphieuxuats(listctpx);
        fi.GhifilePhieuXuats(listpx);
    }
    public static void main(String[] args){
        Xuathang a=new Xuathang();
        Dsnhanvien nv=new Dsnhanvien();
        DSaccount account=new DSaccount();
        Danhsach ds=new Danhsach();
        DScustomer kh=new DScustomer();
        Taikhoan tk=new Taikhoan();
        a.Khoitao();
        
               
    }
}
