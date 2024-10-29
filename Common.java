import java.text.DecimalFormat;
import java.util.Scanner;
public class Common {
    public static Scanner scanner = new Scanner(System.in);
    public static long nhapSoNguyenL(String thongBao) {
        System.out.print(thongBao);
        return Long.parseLong(scanner.nextLine());
    }
    // Phương thức để nhập số nguyên từ bàn phím và hiển thị thông báo
    public static int nhapSoNguyen(String thongBao) {
        System.out.print(thongBao);
        return Integer.parseInt(scanner.nextLine());
    }
    // Phương thức để nhập chuỗi từ bàn phím và hiển thị thông báo
    public static String nhapChuoi(String thongBao) {
        System.out.print(thongBao);
        return scanner.nextLine();
    }
    // Phương thức để nhập số thực từ bàn phím và hiển thị thông báo
    public static float nhapSoThuc(String thongBao) {
        System.out.print(thongBao);
        return scanner.nextFloat();
    }
    // Phương thức để nhập số thập phân từ bàn phím và hiển thị thông báo
    public static double nhapSoThapPhan(String thongBao) {
        System.out.print(thongBao);
        return scanner.nextDouble();
    }
    // Phương thức để nhập ký tự từ bàn phím và hiển thị thông báo
    public static char nhapKyTu(String thongBao) {
        System.out.print(thongBao);
        return scanner.next().charAt(0);
    }
    // Phương thức để nhập giá trị boolean từ bàn phím và hiển thị thông báo
    public static boolean nhapBoolean(String thongBao) {
        System.out.print(thongBao);
        return scanner.nextBoolean();
    }
    // Phương thức để định dạng số tiền thành chuỗi VND
    public static String dinhDangTienTe(Object soTien) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(soTien);
    }
    // Phương thức để xóa màn hình
    public static void xoaManHinh() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        /*
         * "\033[H": Đây là escape sequence để đặt con trỏ văn bản về vị trí cụ thể, và
         * ở đây, nó đặt con trỏ về góc trên bên trái của màn hình.
         * "\033[2J": Đây là escape sequence để xóa màn hình. Nó xóa nội dung trên màn
         * hình hiện tại.
         */
    }
    // Phương thức để đợi người dùng nhấn bất kỳ phím nào để tiếp tục
    public static void nhanBatKyPhim() {
        System.out.print("Nhan phim bat ki de tiep tuc...");
        scanner.nextLine();
        scanner.nextLine();
    }
    // Phương thức để nhập thông tin ngày tháng năm
    public static Date nhapNgayThang(String thongBao) {
        System.out.println("Vui long nhap theo dinh dang dd/mm/yyyy");
        String ngayThang = Common.nhapChuoi(thongBao).trim(); // phương thức trim() dùng để xóa khoảng trắng dư thừa
        String[] ngayThangNam = ngayThang.split("/"); // phương thức split() dùng để tách chuỗi bằng dấu "/"
        return new Date(Integer.parseInt(ngayThangNam[0]),Integer.parseInt(ngayThangNam[1]),Integer.parseInt(ngayThangNam[2]));
    }
    public static Date nhapNgayThangs(String thongBao) {
        System.out.println("Vui long nhap theo dinh dang dd/mm/yyyy");
        String ngayThang = Common.nhapChuoi(thongBao).trim(); // phương thức trim() dùng để xóa khoảng trắng dư thừa
        String[] ngayThangNam = ngayThang.split("/"); // phương thức split() dùng để tách chuỗi bằng dấu "/"
        return new Date(Integer.parseInt(ngayThangNam[0]),Integer.parseInt(ngayThangNam[1]),Integer.parseInt(ngayThangNam[2]));
    }
    public static Address nhapDiaChi(String thongBao) { 
        System.out.println(thongBao);
        Address diaChi = new Address();
        diaChi.setsonha(nhapChuoi("So nha: "));
        diaChi.setstreet(nhapChuoi("Ten duong: "));
        diaChi.setdistrict(nhapChuoi("Ten quan: "));
        diaChi.setcity(nhapChuoi("Thanh pho: "));
        return diaChi;
    }
}
/*
 * Integer.parseInt(ngayThangNam[0]): Đoạn mã này chuyển đổi phần tử đầu tiên
 * của mảng 'ngayThangNam'(tức là ngày) từ chuỗi thành số nguyên.
 * Integer.parseInt(ngayThangNam[1]): _______________________________thứ
 * hai_________________________(tức là tháng)____________.
 * Integer.parseInt(ngayThangNam[2]): _______________________________thứ
 * ba__________________________(tức là năm)____________.
 */