import java.util.Scanner;

public class Dangnhap {
    Scanner sc=new   Scanner(System.in);
    public void showMenuAccounts(){
        System.out.println("1. Them tai khoan");
        System.out.println("2. Xoa tai khoan");
        System.out.println("3. Xem danh sach tai khoan");
        System.out.println("4. Thoat");
    }
    
    public void showMenuThongke(){
        System.out.println("1. Thong ke san pham ");
        System.out.println("2. Thong ke san pham theo ngay");
        System.out.println("3. Thong ke tai khoan");
        System.out.println("4. Thong ke phieu");
        System.out.println("5. Thoat");
    }

    public void showMenuManageProducts(){
        System.out.println("1. Them san pham");
        System.out.println("2. Tim kiem bang ten san pham");
        System.out.println("3. Tim kiem bang ma san pham");
        System.out.println("4. Xoa san pham");
        System.out.println("5. Chinh sua thong tin san pham");
        System.out.println("6. Xem danh sach san pham");
        System.out.println("7. Thoat");
    }

    public void showMenuAdmin(){
        System.out.println("1. San pham");
        System.out.println("2. Nhan vien");
        System.out.println("3. Khach hang");
        System.out.println("4. Nha cung cap");
        System.out.println("5. Nhap hang");
        System.out.println("6. Xuat hang");
        System.out.println("7. Thong ke");
        System.out.println("8. Tai khoan");
        System.out.println("9. Thoat");
    }

    public void showMenuStaff(){
        System.out.println("1. Tim kiem bang san pham");
        System.out.println("2. Tim kiem bang ma san pham");
        System.out.println("3. Xem danh sach san pham");
        System.out.println("4. Xuat hang");
        System.out.println("5. Thoat");
    }

    public void showMenuManageCustomer(){
        System.out.println("1. Them khach hang");
        System.out.println("2. Tim kiem bang ten khach hang");
        System.out.println("3. Tim kiem bang ma khach hang");
        System.out.println("4. Xoa khach hang");
        System.out.println("5. Chinh sua thong tin khach hang");
        System.out.println("6. Xem danh sach khach hang");
        System.out.println("7. Thoat");
    }

    public void showMenuManageStaff(){
        System.out.println("1. Them nhan vien");
        System.out.println("2. Tim kiem bang ten nhan vien");
        System.out.println("3. Tim kiem bang ma nhan vien");
        System.out.println("4. Xoa nhan vien");
        System.out.println("5. Chinh sua thong tin nhan vien");
        System.out.println("6. Xem danh sach nhan vien");
        System.out.println("7. Thoat");
    }

    public void showMenuManageSupplier(){
        System.out.println("1. Them nha cung cap");
        System.out.println("2. Tim kiem bang ten nha cung cap");
        System.out.println("3. Tim kiem bang ma nha cung cap");
        System.out.println("4. Xoa nha cung cap");
        System.out.println("5. Chinh sua thong tin nha cung cap");
        System.out.println("6. Xem danh sach nha cung cap");
        System.out.println("7. Thoat");
    }

    public static void main(String[] args){
        int choice,choice1,choice2;
        String ask;
        DSaccount admin=new DSaccount();
        Danhsach ds=new Danhsach();
        Dsnhanvien dsnv=new Dsnhanvien();
        DScustomer dskh=new DScustomer();
        DSsupplier dsncc=new DSsupplier();
        Dangnhap dangnhap=new Dangnhap();
        Nhaphang nhaphang=new Nhaphang();
        Xuathang xuathang=new Xuathang();
        Taikhoan account=new Taikhoan();
        Thongke thongke=new Thongke();
        admin.listtoarray();
        ds.listtoarray();
        dskh.listtoarray();
        dsnv.listtoarray();
        dsncc.listtoarray();
        nhaphang.listtoarrayPhieuNhaps();
        xuathang.listtoarrayPhieuXuats();
        do{
            Account acc=account.dangnhap(admin);
            if (acc instanceof Admin) {
                System.out.println("Day la Admin");
                do{
                    do{
                        dangnhap.showMenuAdmin();
                        choice=Check.nhapSoNguyen("Chon: ","Error");
                        System.out.println();
                    }while(choice <1 || choice >9);
                    switch (choice) {
                        case 1:
                            ds.Xuat();
                            do{
                                do{
                                    dangnhap.showMenuManageProducts();
                                    choice1=Check.nhapSoNguyen("Chon: ","Error");
                                    System.out.println();
                                }while(choice1<1 || choice1 >7);
                                switch (choice1) {
                                    case 1: ds.Add();
                                            break;
                                    case 2: ds.FindbyName();
                                            break;
                                    case 3: ds.FindbyID();
                                            break;
                                    case 4: ds.Delete();
                                            break;
                                    case 5: ds.Edit();
                                            break;
                                    case 6: ds.Xuat();;
                                            break;
                                    default:break;
                                }
                                System.out.println();
                            }while(choice1 !=7);
                            break;
                        case 2:
                            dsnv.Xuat();
                            do{
                                do{
                                    dangnhap.showMenuManageStaff();
                                    choice1=Check.nhapSoNguyen("Chon: ", "Error");
                                    System.out.println();
                                }while(choice1<1 || choice1>7);
                                switch (choice1) {
                                    case 1: dsnv.Add();
                                            break;
                                    case 2: dsnv.FindbyName();
                                            break;
                                    case 3: dsnv.FindbyID();
                                            break;
                                    case 4: dsnv.Delete();
                                            break;
                                    case 5: dsnv.Edit();
                                            break;
                                    case 6: dsnv.Xuat();
                                            break;
                                    default:break;
                                }
                                System.out.println();
                            }while(choice1 !=7);
                            break;
                        case 3:
                            dskh.Xuat();;
                            do{
                                do{
                                    dangnhap.showMenuManageCustomer();
                                    choice1=Check.nhapSoNguyen("Chon: ", "Error");
                                    System.out.println();
                                }while(choice1<1 || choice1>7);
                                switch (choice1) {
                                    case 1: dskh.Add();
                                            break;
                                    case 2: dskh.FindbyName();
                                            break;
                                    case 3: dskh.FindbyID();
                                            break;
                                    case 4: dskh.Delete();
                                            break;
                                    case 5: dskh.Edit();
                                            break;
                                    case 6: dskh.Xuat();;
                                            break;
                                    default:break;
                                }
                                System.out.println();
                            }while(choice1 !=7);
                            break;
                        case 4:
                            dsncc.Xuat();
                            do{
                                do{
                                    dangnhap.showMenuManageSupplier();
                                    choice1=Check.nhapSoNguyen("Chon: ", "Error");
                                    System.out.println();
                                }while(choice1<1 || choice>7);
                                switch (choice1) {
                                    case 1: dsncc.Add();
                                            break;
                                    case 2: dsncc.FindbyName();
                                            break;
                                    case 3: dsncc.FindbyID();
                                            break;
                                    case 4: dsncc.Delete();
                                            break;
                                    case 5: dsncc.Edit();
                                            break;
                                    case 6: dsncc.Xuat();
                                            break;
                                    default:break;
                                }
                                System.out.println();
                            }while(choice1 !=7);
                            break;
                        case 5:
                                nhaphang.nhapphieunhap(dsncc,account,ds);
                                ask=Check.nhapChuoi("Xem danh sach phieu nhap (Y/N): ","Error");
                                if(ask.equalsIgnoreCase("Y"))
                                        nhaphang.xuatphieunhap();
                                System.out.println();
                                break;
                        case 6: 
                                xuathang.nhapphieuxuat(ds, dskh, account);
                                ask=Check.nhapChuoi("Xem danh sach phieu nhap (Y/N): ","Error");
                                if(ask.equalsIgnoreCase("Y"))
                                        xuathang.xuatphiexuat();
                                System.out.println();
                                break;
                        case 7: 
                                do{
                                    do{
                                        dangnhap.showMenuThongke();
                                        choice1=Check.nhapSoNguyen("Chon: ","Error");
                                        System.out.println();
                                    }while(choice1<1 || choice1 >5);
                                    switch (choice1) {
                                        case 1: thongke.thongkechinh();
                                                System.out.println();
                                                break;
                                        case 2: thongke.thongketheongay();
                                                System.out.println();
                                                break;
                                        case 3: thongke.thongketaikhoan();
                                                System.out.println();
                                                break;
                                        case 4: thongke.thongkephieu();
                                                System.out.println();
                                                break;
                                        default:
                                                break;
                                    }     
                                    System.out.println();                               
                                }while(choice1!=5);
                                break;
                        case 8: do{
                                        do{
                                                dangnhap.showMenuAccounts();
                                                choice1=Check.nhapSoNguyen("Chon: ","Error");
                                                System.out.println();
                                        }while(choice1 <1 || choice1 >4);
                                        switch (choice1) {
                                                case 1: admin.Add(dsnv);
                                                        break;
                                                case 2: admin.Delete();
                                                        break;
                                                case 3: admin.Xuat();
                                                        break;
                                                default:break;
                                        }
                                        System.out.println();
                                }while(choice1!=4);
                        default:break;
                    }
                    System.out.println();
                }while(choice!=9);
            }
            else if(acc instanceof Accountnhanvien){
                System.out.println("Day la nhan vien");
                ds.Xuat();
                    do{
                        do{
                            dangnhap.showMenuStaff();
                            choice=Check.nhapSoNguyen("Chon: ","Error");
                            System.out.println();
                        }while(choice<1 || choice>5);
                        switch (choice) {
                            case 1: ds.FindbyName();
                                    break;
                            case 2: ds.FindbyID();
                                    break;
                            case 3: ds.Xuat();
                                    break;
                            case 4: ds.Xuat();
                                    dskh.Xuat();
                                    xuathang.nhapphieuxuat(ds, dskh, account);
                                    xuathang.xuatphiexuat();
                                    break;
                            default:break;
                        }
                        System.out.println();
                    }while(choice !=5);
            }
            System.out.println("Dang nhap tiep tuc?");
            System.out.println("1.Yes");
            System.out.println("2.No");
            choice2=Check.nhapSoNguyen("","Error");
            System.out.println();
        }while(choice2!=2);
    }
}