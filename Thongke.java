import java.util.List;
import java.util.ArrayList;
public class Thongke {
    private List<Product> listproducts;
    private List<CTphieunhap> listctpns;
    private List<CTphieuxuat> listctpxs;
    private List<PhieuNhap> listpns;
    private List<PhieuXuat> listpxs;
    private List<Account> listaccounts;
    private FILE fi;
    public Thongke(){
        fi=new FILE();
    }

    public void thongkesanpham(List<CTphieunhap> ctpn,List<CTphieuxuat> ctpx,List<Product> product){
        int physical,digital,food;
        long sumphysical,sumdigital,sumfood,sumphysical1,sumdigital1,sumfood1;
        physical=digital=food=0;
        sumdigital=sumfood=sumphysical=sumfood1=sumphysical1=sumdigital1=0;
        for(Product a:product){
            if (a.getLoai().equals("Digital")){
                digital++;
            } 
            if(a.getLoai().equals("Physical")){
                physical++;
            } 
            if(a.getLoai().equals("Food")){
                food++;
            }
        }
        for(CTphieunhap a:ctpn){
            if (a.getloai().equals("Digital")){
                sumdigital+=a.getTongTien();
            } 
            if(a.getloai().equals("Physical")){
                sumphysical+=a.getTongTien();
            } 
            if(a.getloai().equals("Food")){
                sumfood+=a.getTongTien();
            }
        }
        for(CTphieuxuat a:ctpx){
            if (a.getLoai().equals("Digital")){
                sumdigital1+=a.getTongTien();
            } 
            if(a.getLoai().equals("Physical")){
                sumphysical1+=a.getTongTien();
            } 
            if(a.getLoai().equals("Food")){
                sumfood1+=a.getTongTien();
            }
        }
        System.out.printf("DIGITAL: %-25d  TIEN XUAT: %-25d TIEN NHAP: %-25d\n",digital,sumdigital1,sumdigital);
        System.out.printf("PHYSICAL: %-25d TIEN XUAT: %-25d TIEN NHAP: %-25d\n",physical,sumphysical1,sumphysical);
        System.out.printf("FOOD: %-25d     TIEN XUAT: %-25d TIEN NHAP: %-25d\n",food,sumfood1,sumfood);
        System.out.printf("%-90s TONG TIEN XUAT: %d\n","",(sumdigital1+sumfood1+sumphysical1));
        System.out.printf("%-90s TONG TIEN NHAP: %d\n","",(sumdigital1+sumfood1+sumphysical1));
    }

    public void thongkephieu(){
        listpns=fi.DocfilePhieuNhaps();
        listpxs=fi.DocfilePhieuXuats();
        listctpns=fi.DocfileCTphieunhaps();
        listctpxs=fi.DocfileCTphieuxuats();
        String ma,ma1;
        long sum;
        int i,j,nhap,xuat,choice,count,k,digital,physical,food;
        i=j=nhap=xuat=0;
        System.out.println("             --------PHIEU--------");
        System.out.printf("%-5s%-15s%-20s%-25s%-15s\n","STT","PHIEU","NHAN VIEN","CONG TY/KHACH HANG","NGAY");
        for(PhieuNhap pn:listpns){
            nhap++;
            System.out.printf("%-5d",i+1);
            System.out.printf("%-15s",pn.getMapn());
            System.out.printf("%-20s",pn.getMaNhanVien());
            System.out.printf("%-25s",pn.getMaNhaCungCap());
            System.out.printf("%-15s\n",pn.getNgaynhap());
            i++;
        }
        for(PhieuXuat px:listpxs){
            xuat++;
            System.out.printf("%-5d",i+j+1);
            System.out.printf("%-15s",px.getMaPhieuXuat());
            System.out.printf("%-20s",px.getMaNhanVien());
            System.out.printf("%-25s",px.getMaKhachHang());
            System.out.printf("%-15s\n",px.getNgayXuat());
            j++;
        }
        System.out.println("PHIEU NHAP: "+nhap);
        System.out.println("PHIEU XUAT: "+xuat);
        do{
            System.out.println("Xem chi tiet phieu?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice=Check.nhapSoNguyen("Chon: ", "Error");
            if(choice==1){
                do{
                    k=count=digital=physical=food=0;
                    sum=0;
                    ma=Check.nhapChuoi("Nhap ma phieu de xem chi tiet phieu: ", "Error");
                    for(PhieuNhap pn: listpns)
                        if(pn.getMapn().equals(ma)){
                            System.out.println("                    ---------------CHI TIET PHIEU NHAP---------------");
                            System.out.println("                                        +++++++");
                            System.out.printf("%-5s%-10s%-15s%-25s%-15s%-10s%-10s%-15s%-15s\n","STT","MPN","MA SAN PHAM","TEN SAN PHAM","SO LUONG","SIZE","MAU","DON GIA","THANH TIEN");
                            count++;
                            for(CTphieunhap ctpn:listctpns)
                                if(ctpn.getMapn().equals(pn.getMapn())){
                                    System.out.printf("%-5d",k+1);
                                    ctpn.xuat();
                                    if(ctpn.getloai().equalsIgnoreCase("Physical")){
                                        physical++;
                                    } else if(ctpn.getloai().equalsIgnoreCase("Digital")){
                                        digital++;
                                    } else {
                                        food++;
                                    }
                                    sum+=ctpn.getTongTien();
                                    k++;
                                }
                            System.out.printf("DIGITAL: %-15d PHYSICAL: %-15d FOOD: %-15d\n",digital,physical,food);
                            System.out.printf("%-90s TONG HOA DON: %d\n","",sum);
                        }
                    for(PhieuXuat px: listpxs)
                        if(px.getMaPhieuXuat().equals(ma)){
                            System.out.println("                    ---------------CHI TIET PHIEU XUAT---------------");
                            System.out.println("                                        +++++++");
                            System.out.printf("%-5s%-10s%-15s%-25s%-15s%-20s%-10s%-10s%-15s%-15s\n","STT","MPX","MA SAN PHAM","TEN SAN PHAM","SO LUONG","HSD/BAO HANH","SIZE","MAU","DON GIA","THANH TIEN");
                            count++;
                            for(CTphieuxuat ctpx:listctpxs)
                                if(ctpx.getMaPhieuXuat().equals(px.getMaPhieuXuat())){
                                    System.out.printf("%-5d",k+1);
                                    ctpx.xuat();
                                    if(ctpx.getLoai().equalsIgnoreCase("Physical")){
                                        physical++;
                                    } else if(ctpx.getLoai().equalsIgnoreCase("Digital")){
                                        digital++;
                                    } else {
                                        food++;
                                    }
                                    sum+=ctpx.getTongTien();
                                    k++;
                                }
                            System.out.printf("DIGITAL: %-15d PHYSICAL: %-15d FOOD: %-15d\n",digital,physical,food);
                            System.out.printf("%-90s TONG HOA DON: %d\n","",sum);
                        }
                    if(count==0){
                        System.out.println("Ma phieu khong ton tai");
                        do{
                            ma1=Check.nhapChuoi("Tiep tuc nhap lai (Y/N): ", "Error");
                        }while(!ma1.equalsIgnoreCase("Y") || !ma1.equalsIgnoreCase("N"));
                    } else {
                        do{
                            ma1=Check.nhapChuoi("Tiep tuc xem chi tiet phieu (Y/N): ","Error");
                        }while(!ma1.equalsIgnoreCase("Y") && !ma1.equalsIgnoreCase("N"));
                    }
                }while(ma1.equalsIgnoreCase("Y"));
            }
        }while(choice<1 || choice>2);
    }

    public void thongkechinh(){
        int i=0;
        int nhap,xuat,choice;
        listctpns=fi.DocfileCTphieunhaps();
        listctpxs=fi.DocfileCTphieuxuats();
        listproducts=fi.DocfileProducts();
        System.out.println("                       ----------SAN PHAM----------");
        System.out.printf("%-5s%-20s%-15s%-25s%-15s%-15s%-15s%-15s\n","STT","THUONG HIEU","MASP","SAN PHAM","SO LUONG","NHAP","XUAT","TON KHO");
        for(Product a:listproducts){
            nhap=xuat=0;
            System.out.printf("%-5d",i+1);
            System.out.printf("%-20s",a.getbrand());
            System.out.printf("%-15s",a.getmasp());
            System.out.printf("%-25s",a.gettensp());
            System.out.printf("%-15d",a.getSoluong());
            for(CTphieunhap b:listctpns)
                if(b.getMaSanPham().equalsIgnoreCase(a.getmasp()))
                    nhap+=b.getsl();
            System.out.printf("%-15s",nhap);
            for(CTphieuxuat c:listctpxs)
                if(c.getMaSanPham().equalsIgnoreCase(a.getmasp()))
                    xuat+=c.getSoLuong();
            System.out.printf("%-15s",xuat);
            a.setSoluong(nhap+a.getSoluong()-xuat);
            System.out.printf("%-15s\n",a.getSoluong());
            i++;
        }
        thongkesanpham(listctpns, listctpxs, listproducts);
        do{
            System.out.println("Loc theo loai san pham");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice=Check.nhapSoNguyen("Chon: ","Error");
            if(choice==1)
                thongketheonhom(listctpns, listctpxs, listproducts);
        }while(choice==1);
    }
    
    public void thongketheonhom(List<CTphieunhap> ctpn,List<CTphieuxuat> ctpx,List<Product> product){
        String loai=null;
        int choice,i,nhap,xuat,count;
        long sumnhap,sumxuat;
        sumnhap=sumxuat=0;
        i=count=0;
        do{
        System.out.println("1. Digital");
        System.out.println("2. Physical");
        System.out.println("3. Food");
        choice=Check.nhapSoNguyen("Chon loai san pham: ", "Error");
        }while(choice<1 || choice>3);
        System.out.println("                          ----------SAN PHAM----------");
        System.out.printf("%-5s%-20s%-15s%-25s%-15s%-15s%-15s%-15s\n","STT","THUONG HIEU","MASP","SAN PHAM","SO LUONG","NHAP","XUAT","TON KHO");
        switch (choice) {
            case 1: 
                    for(Product a:listproducts){
                        if(a.getLoai().equalsIgnoreCase("Digital")){
                            loai="DIGITAL";
                            count++;
                            nhap=xuat=0;
                            System.out.printf("%-5d",i+1);
                            System.out.printf("%-20s",a.getbrand());
                            System.out.printf("%-15s",a.getmasp());
                            System.out.printf("%-25s",a.gettensp());
                            for(CTphieunhap b:ctpn)
                                if(b.getMaSanPham().equalsIgnoreCase(a.getmasp())){
                                    nhap+=b.getsl();
                                    sumnhap+=b.getTongTien();
                                }
                            for(CTphieuxuat c:ctpx)
                                if(c.getMaSanPham().equalsIgnoreCase(a.getmasp())){
                                    xuat+=c.getSoLuong();
                                    sumxuat+=c.getTongTien();
                                }
                            a.setSoluong(a.getSoluong()-nhap+xuat);
                            System.out.printf("%-15d",a.getSoluong());
                            System.out.printf("%-15s",nhap);    
                            System.out.printf("%-15s",xuat);
                            a.setSoluong(a.getSoluong()+nhap-xuat);
                            System.out.printf("%-15s\n",a.getSoluong());
                            i++;
                        }
                    } 
                    break;
            case 2: 
                    for(Product a:listproducts){
                        if(a.getLoai().equalsIgnoreCase("Physical")){
                            loai="PHYSICAL";
                            count++;
                            nhap=xuat=0;
                            System.out.printf("%-5d",i+1);
                            System.out.printf("%-20s",a.getbrand());
                            System.out.printf("%-15s",a.getmasp());
                            System.out.printf("%-25s",a.gettensp());
                            for(CTphieunhap b:ctpn)
                                if(b.getMaSanPham().equalsIgnoreCase(a.getmasp())){
                                    nhap+=b.getsl();
                                    sumnhap+=b.getTongTien();
                                }
                            for(CTphieuxuat c:ctpx)
                                if(c.getMaSanPham().equalsIgnoreCase(a.getmasp())){
                                    xuat+=c.getSoLuong();
                                    sumxuat+=c.getTongTien();
                                }
                            a.setSoluong(a.getSoluong()-nhap+xuat);
                            System.out.printf("%-15d",a.getSoluong());
                            System.out.printf("%-15s",nhap);    
                            System.out.printf("%-15s",xuat);
                            a.setSoluong(a.getSoluong()+nhap-xuat);
                            System.out.printf("%-15s\n",a.getSoluong());
                            i++;
                        }
                    } 
                    break;
            case 3: 
                    for(Product a:listproducts){
                        if(a.getLoai().equalsIgnoreCase("Food")){
                            loai="FOOD";
                            count++;
                            nhap=xuat=0;
                            System.out.printf("%-5d",i+1);
                            System.out.printf("%-20s",a.getbrand());
                            System.out.printf("%-15s",a.getmasp());
                            System.out.printf("%-25s",a.gettensp());
                            for(CTphieunhap b:ctpn)
                                if(b.getMaSanPham().equalsIgnoreCase(a.getmasp())){
                                    nhap+=b.getsl();
                                    sumnhap+=b.getTongTien();
                                }
                            for(CTphieuxuat c:ctpx)
                                if(c.getMaSanPham().equalsIgnoreCase(a.getmasp())){
                                    xuat+=c.getSoLuong();
                                    sumxuat+=c.getTongTien();
                                }
                            a.setSoluong(a.getSoluong()-nhap+xuat);
                            System.out.printf("%-15d",a.getSoluong());
                            System.out.printf("%-15s",nhap);    
                            System.out.printf("%-15s",xuat);
                            a.setSoluong(a.getSoluong()+nhap-xuat);
                            System.out.printf("%-15s\n",a.getSoluong());
                            i++;
                        }
                    }   
            default:
                break;
        }
        System.out.printf("%-90s SO LUONG SAN PHAM %s: %-15d\n","",loai,count);
        System.out.printf("%-90s TONG TIEN NHAP: %-15d\n","",sumnhap);
        System.out.printf("%-90s TONG TIEN XUAT: %-15d\n","",sumxuat);
    }

    public void thongketheongay(){
        hienthongkesanphamchongay();
        int i=0;
        int nhap,xuat,choice;
        List<PhieuNhap> pn=new ArrayList<>();
        List<CTphieunhap> ctpn=new ArrayList<>();
        List<CTphieuxuat> ctpx=new ArrayList<>();
        List<PhieuXuat> px=new ArrayList<>();
        List<Product> product=new ArrayList<>();
        listctpns=fi.DocfileCTphieunhaps();
        listpns=fi.DocfilePhieuNhaps();
        listproducts=fi.DocfileProducts();
        listctpxs=fi.DocfileCTphieuxuats();
        listpxs=fi.DocfilePhieuXuats();
        Date start,end;
        start= Check.nhapNgayThang("Tu ngay: ","Error");
        end=Check.nhapNgayThang("Den ngay: ", "Error");
        for(PhieuNhap a:listpns){
            if (a.getNgaynhap().getTime() >= start.getTime() && a.getNgaynhap().getTime() <= end.getTime()){
                    pn.add(a);
            for(CTphieunhap b:listctpns){
                if(b.getMapn().equalsIgnoreCase(a.getMapn()))
                    ctpn.add(b);
                }
            }
        }
        for(PhieuXuat a:listpxs){
            if (a.getNgayXuat().getTime() >= start.getTime() && a.getNgayXuat().getTime() <= end.getTime()){
                    px.add(a);
            for(CTphieuxuat b:listctpxs){
                if(b.getMaPhieuXuat().equalsIgnoreCase(a.getMaPhieuXuat()))
                    ctpx.add(b);
                }
            }
        }
        
        System.out.println("                           ----------SAN PHAM----------");
        System.out.printf("%-5s%-20s%-15s%-25s%-15s%-15s%-15s%-15s\n","STT","THUONG HIEU","MASP","SAN PHAM","SO LUONG","NHAP","XUAT","TON KHO");
        for(Product a:listproducts){
            nhap=xuat=0;
            System.out.printf("%-5d",i+1);
            System.out.printf("%-20s",a.getbrand());
            System.out.printf("%-15s",a.getmasp());
            System.out.printf("%-25s",a.gettensp());
            System.out.printf("%-15d",a.getSoluong());
            for(CTphieunhap b:ctpn)
                if(b.getMaSanPham().equalsIgnoreCase(a.getmasp()))
                    nhap+=b.getsl();
            System.out.printf("%-15s",nhap);
            for(CTphieuxuat c:ctpx)
                if(c.getMaSanPham().equalsIgnoreCase(a.getmasp()))
                    xuat+=c.getSoLuong();
            System.out.printf("%-15s",xuat);
            a.setSoluong(nhap+a.getSoluong()-xuat);
            System.out.printf("%-15s\n",a.getSoluong());
            i++;
        }
        thongkesanpham(ctpn, ctpx, product);
        do{
            System.out.println("Loc theo loai san pham");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice=Check.nhapSoNguyen("Chon: ","Error");
            if(choice==1)
                thongketheonhom(ctpn, ctpx, product);
        }while(choice==1);
    }

    public void hienthongkesanphamchongay(){
        int i=0;
        int nhap,xuat;
        listctpns=fi.DocfileCTphieunhaps();
        listctpxs=fi.DocfileCTphieuxuats();
        listproducts=fi.DocfileProducts();
        System.out.println("                       ----------SAN PHAM----------");
        System.out.printf("%-5s%-20s%-15s%-25s%-15s%-15s%-15s%-15s\n","STT","THUONG HIEU","MASP","SAN PHAM","SO LUONG","NHAP","XUAT","TON KHO");
        for(Product a:listproducts){
            nhap=xuat=0;
            System.out.printf("%-5d",i+1);
            System.out.printf("%-20s",a.getbrand());
            System.out.printf("%-15s",a.getmasp());
            System.out.printf("%-25s",a.gettensp());
            System.out.printf("%-15d",a.getSoluong());
            for(CTphieunhap b:listctpns)
                if(b.getMaSanPham().equalsIgnoreCase(a.getmasp()))
                    nhap+=b.getsl();
            System.out.printf("%-15s",nhap);
            for(CTphieuxuat c:listctpxs)
                if(c.getMaSanPham().equalsIgnoreCase(a.getmasp()))
                    xuat+=c.getSoLuong();
            System.out.printf("%-15s",xuat);
            a.setSoluong(nhap+a.getSoluong()-xuat);
            System.out.printf("%-15s\n",a.getSoluong());
            i++;
        }
    }

    public void thongketaikhoan(){
        int i,sum;
        i=sum=0;
        listaccounts=fi.DocfileAccounts();
        System.out.println("                     ----------TAI KHOAN----------");
        System.out.printf("%-5s%-10s%-25s%-20s\n","STT","MA","TAI KHOAn","MAT KHAU");
        for(Account a:listaccounts){
            sum++;
            System.out.printf("%-5d",i+1);
            a.Xuat();
            i++;
        }
        System.out.println("TAI KHOAN: "+sum);

    }
    public static void main(String[] args){
        Thongke a=new Thongke();
        a.thongkechinh();
    }    
}
