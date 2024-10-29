import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    private static final String UPPERCASE_REGEX = ".*[A-Z].*";
    private static final String LOWERCASE_REGEX = ".*[a-z].*";
    private static final String DIGIT_REGEX = ".*\\d.*";
    private static final String SPECIAL_CHARACTER_REGEX = ".*[@#$%^&+=].*";
    public static String RegexNgayThang = ""; // Biểu thức chính quy (regex) để kiểm tra định dạng ngày
    public static String REGEX_PHONE="^\\d{10}$"; // Biểu thức chính quy kiểm tra số điện thoại
    public static String REGEX_MAIL="^(.+)@(\\S+) $."; //Biểu thức chính quy kiểm tra email
    public static Scanner sc=new  Scanner(System.in);
    
    public static String nhapChuoi(String thongBao, String thongBaoLoi) {
        String chuoiNhap = "";
        boolean kiemTra = false;
        while (!kiemTra) {
            // khối try-catch để bắt và xử lý ngoại lệ nếu người dùng nhập sai
            try {
                chuoiNhap = Common.nhapChuoi(thongBao); // lấy một ký tự để kiểm tra hợp lệ
                if (chuoiNhap.length() == 0) {
                    System.out.println(thongBaoLoi); // hiển thị thông báo lỗi
                } else {
                    kiemTra = true;
                }
            } catch (Exception e) {
                System.out.println(thongBaoLoi); // hiển thị thông báo lỗi
            }
        }
        return chuoiNhap;
    }
    
    public static int nhapSoNguyen(String thongBao, String thongBaoLoi) {
        int soNguyenNhap = 0;
        boolean kiemTra = false;

        do {
            try {
                soNguyenNhap = Common.nhapSoNguyen(thongBao);
                kiemTra = true;
            } catch (InputMismatchException e) {
                System.out.println(thongBaoLoi);
                Common.scanner.nextLine(); // Đọc và loại bỏ giá trị không hợp lệ từ scanner
            }
        } while (!kiemTra);

        return soNguyenNhap;
    }
    
    public static long nhapSoNguyenL(String thongBao, String thongBaoLoi) {
        long soNguyenNhap = 0;
        boolean kiemTra = false;

        do {
            try {
                soNguyenNhap = Common.nhapSoNguyenL(thongBao);
                kiemTra = true;
            } catch (InputMismatchException e) {
                System.out.println(thongBaoLoi);
                Common.scanner.nextLine(); // Đọc và loại bỏ giá trị không hợp lệ từ scanner
            }
        } while (!kiemTra);

        return soNguyenNhap;
    }
    
    public static float nhapSoThuc(String thongBao, String thongBaoLoi) {
        float NhapSoThuc = 0;
        boolean kiemTra = false;
        while (!kiemTra) {
            try {
                NhapSoThuc = Common.nhapSoThuc(thongBao);
                kiemTra = true;
            } catch (Exception e) {
                System.out.println(thongBaoLoi);
            }
        }
        return NhapSoThuc;
    }
    
    public static double nhapSoThapPhan(String thongBao, String thongBaoLoi) {
        double NhapSoThapPhan = 0;
        boolean kiemTra = false;
        while (!kiemTra) {
            try {
                NhapSoThapPhan = Common.nhapSoThapPhan(thongBao);
                kiemTra = true;
            } catch (Exception e) {
                System.out.println(thongBaoLoi);
            }
        }
        return NhapSoThapPhan;
    }
    
    public static char nhapKyTu(String thongBao, String thongBaoLoi) {
        char NhapKyTu = 0;
        boolean kiemTra = false;
        while (!kiemTra) {
            try {
                NhapKyTu = Common.nhapKyTu(thongBao );
                kiemTra = true;
            } catch (Exception e) {
                System.out.println(thongBaoLoi);
            }
        }
        return NhapKyTu;
    }
    
    public static boolean nhapBoolean(String thongBao, String thongBaoLoi) {
        boolean NhapBoolean = false;
        boolean kiemTra = false;
        while (!kiemTra) {
            try {
                NhapBoolean = Common.nhapBoolean(thongBao);
                kiemTra = true;
            } catch (Exception e) {
                System.out.println(thongBaoLoi);
            }
        }
        return NhapBoolean;
    }
    
    public static Date nhapNgayThang(String thongBao, String thongBaoLoi) {
        Date NhapNgay = null;
        boolean kiemTra = false;
        while (!kiemTra) {
            try {
                NhapNgay = Common.nhapNgayThang(thongBao);
                kiemTra = NhapNgay.checkDate();
            } catch (Exception e) {
                System.out.println(thongBaoLoi);
            }
        }
        return NhapNgay;
    }
    
    public static Address nhapDiaChi(String thongBao, String thongBaoLoi) {
        Address diaChi = Common.nhapDiaChi(thongBao);
        // Kiểm tra dữ liệu địa chỉ sau khi đã nhập
        if (diaChi.getsonha().isEmpty() || diaChi.getstreet().isEmpty() || diaChi.getcity().isEmpty()
                || diaChi.getcity().isEmpty()) {
            System.out.println(thongBaoLoi);
            return nhapDiaChi(thongBao, thongBaoLoi); // Yêu cầu nhập lại nếu dữ liệu không hợp lệ
        } else {
            return diaChi;
        }
    }

    public static String nhapEmail(String thongBao, String thongBaoLoi) {
        String email = "";
        boolean kiemTra = false;

        while (!kiemTra) {
            try {
                email = Common.nhapChuoi(thongBao);
                if (!isValidEmail(email)) {
                    System.out.println(thongBaoLoi);
                } else {
                    kiemTra = true;
                }
            } catch (Exception e) {
                System.out.println(thongBaoLoi);
            }
        }
        return email;
    }

    public static String nhapSoDienThoai(String thongBao, String thongBaoLoi) {
        String soDienThoai = "";
        boolean kiemTra = false;

        while (!kiemTra) {
            try {
                soDienThoai = Common.nhapChuoi(thongBao);
                if (!isValidPhoneNumber(soDienThoai)) {
                    System.out.println(thongBaoLoi);
                } else {
                    kiemTra = true;
                }
            } catch (Exception e) {
                System.out.println(thongBaoLoi);
            }
        }
        return soDienThoai;
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^0\\d{9}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean kiemTraMatKhau(String matKhau) {
        boolean chuaChuHoa = Pattern.matches(UPPERCASE_REGEX, matKhau);
        boolean chuaChuThuong = Pattern.matches(LOWERCASE_REGEX, matKhau);
        boolean chuaSo = Pattern.matches(DIGIT_REGEX, matKhau);
        boolean chuaKiTuDacBiet = Pattern.matches(SPECIAL_CHARACTER_REGEX, matKhau);
    
        return chuaChuHoa && chuaChuThuong && chuaSo && chuaKiTuDacBiet;
    }
    
    public static String nhapMatKhau(String thongBao, String thongBaoLoi) {
        String matKhau = "";
        boolean kiemTra = false;
    
        while (!kiemTra) {
            try {
                matKhau = Common.nhapChuoi(thongBao);
                if (!kiemTraMatKhau(matKhau)) {
                    System.out.println(thongBaoLoi);
                } else {
                    kiemTra = true;
                }
            } catch (Exception e) {
                System.out.println(thongBaoLoi);
            }
        }
        return matKhau;
    }
    

    public static void main(String[] args) {
        String email = Check.nhapEmail("Nhap email: ",
        "Email khong hop le, vui long nhap lai.");
System.out.println(email);
    }
}
