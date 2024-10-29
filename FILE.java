import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FILE implements Serializable{

    public Product chuyenthanhsanpham(String product){
        String[] data= product.split(";");
        if(data[0].contains("Digital")){
            Digital digital=new Digital();
            digital.setbrand(data[1]);
            digital.settensp(data[2]);
            digital.setmasp(data[3]);
            digital.setdongia(Long.parseLong(data[4]));
            digital.setSoluong(Integer.parseInt(data[6]));
            digital.setLoai(data[0]);
            System.out.println(data[5]);
            digital.setCongsuat(Integer.parseInt(data[5]));
            return digital;
        } else if (data[0].contains("Physical")){
            Physical physical=new Physical();
            physical.setbrand(data[1]);
            physical.settensp(data[2]);
            physical.setmasp(data[3]);
            physical.setdongia(Long.parseLong(data[4]));
            physical.setSoluong(Integer.parseInt(data[7]));
            physical.setLoai(data[0]);
            physical.setsize(data[5]);
            physical.setcolor(data[6]);
            return physical;
        } else {
            Food food=new Food();
            food.setbrand(data[1]);
            food.settensp(data[2]);
            food.setmasp(data[3]);
            food.setdongia(Long.parseLong(data[4]));
            food.setSoluong(Integer.parseInt(data[5]));
            food.setLoai(data[0]);
            return food;
        }
    }
    public Staff chuyenthanhNhanvien(String s){
        String[] data=s.split(";");
        String[] diachi=data[2].split("-");
        String[] ngaysinh=data[5].split("/");
        Address address=new Address(diachi[0],diachi[1],diachi[2],diachi[3]);
        Date date=new Date(Integer.parseInt(ngaysinh[0]),Integer.parseInt(ngaysinh[1]),Integer.parseInt(ngaysinh[2]));
        //Staff staff=new Staff(data[0],data[1],address,data[3],data[4],date,data[6]);
        return new Staff(data[0],data[1],address,data[3],data[4],date,data[6]);
    }
    public Customer chuyenthanhKhachhang(String s){
        String[] data=s.split(";");
        String[] diachi=data[2].split("-");
        String[] ngaysinh=data[5].split("/");
        Address address=new Address(diachi[0],diachi[1],diachi[2],diachi[3]);
        Date date=new Date(Integer.parseInt(ngaysinh[0]),Integer.parseInt(ngaysinh[1]),Integer.parseInt(ngaysinh[2]));
        //Customer customer=new Customer(data[0],data[1],address,data[3],data[4],date,data[6]);
        return new Customer(data[0],data[1],address,data[3],data[4],date,data[6]);
    }
    public Supplier chuyenthanhNhacungcap(String s){
        String[] data=s.split(";");
        String[] diachi=data[2].split("-");
        Address address=new Address(diachi[0],diachi[1],diachi[2],diachi[3]);
        //Supplier supplier=new Supplier(data[0],data[1],address,data[3],data[4]);
        return new Supplier(data[0],data[1],address,data[3],data[4]);
    }
    public PhieuNhap chuyenthanhPhieuNhap(String s){
        String[] data=s.split(";");
        String[] ngay=data[2].split("/");
        Date date=new Date(Integer.parseInt(ngay[0]),Integer.parseInt(ngay[1]),Integer.parseInt(ngay[2]));
        //PhieuNhap phieuNhap= new PhieuNhap(data[0],data[1],date,data[3]);
        return new PhieuNhap(data[0],data[1],date,data[3]);
    }
    public PhieuXuat chuyenthanhPhieuXuat(String s){
        String[] data=s.split(";");
        String[] ngay=data[2].split("/");
        Date date=new Date(Integer.parseInt(ngay[0]),Integer.parseInt(ngay[1]),Integer.parseInt(ngay[2]));
        //PhieuXuat phieuxuat= new PhieuXuat(data[0],data[1],date,data[3]);
        return new PhieuXuat(data[0],data[1],date,data[3]);
    }
    public CTphieunhap chuyenthanhctpn(String s){
        String[] data=s.split(";");
        //CTphieunhap ctpn=new CTphieunhap(data[0],data[1],data[2],data[3],Integer.parseInt(data[4]),Long.parseLong(data[5]),Long.parseLong(data[6]),data[7],data[8],Integer.parseInt(data[9]));
        return new CTphieunhap(data[0],data[1],data[2],data[3],Integer.parseInt(data[4]),Long.parseLong(data[5]),Long.parseLong(data[6]),data[7],data[8],Integer.parseInt(data[9]));
    }
    public CTphieuxuat chuyenthanhctpx(String s){
        String[] data=s.split(";");
        String[] ngay=data[7].split("/");
        Date date =new Date(Integer.parseInt(ngay[0]),Integer.parseInt(ngay[1]),Integer.parseInt(ngay[2]));
        //CTphieuxuat ctpx=new CTphieuxuat(data[0],data[1],data[2],data[3],Integer.parseInt(data[4]),Long.parseLong(data[5]),Long.parseLong(data[6]),data[7],data[8],Integer.parseInt(data[9]));
        return new CTphieuxuat(data[0],data[1],data[2],data[3],Integer.parseInt(data[4]),Long.parseLong(data[5]),Long.parseLong(data[6]),date,data[8],data[9],Integer.parseInt(data[10]));
    }
    public Account chuyenthanhtaikhoan(String s){
        String[] data=s.split(";");
        if (data[0].contains("ADMIN")){
            //Admin admin=new Admin(data[0],data[1],data[2]);
            return new Admin(data[0],data[1],data[2]);
        } else{
            //Accountnhanvien accountnhanvien=new Accountnhanvien(data[0],data[1],data[2]);
            return new Accountnhanvien(data[0],data[1],data[2]);
        }

    }
    
    public void GhifileProducts(Product product){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\Products.txt",true);
            bw =new BufferedWriter(fw);
            bw.write(product.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }

    public void GhifileProducts(List<Product> product){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\Products.txt");
            bw =new BufferedWriter(fw);
            for(Product a:product){
                if (a instanceof Digital) {
                    Digital digital=(Digital)a;
                    bw.write(digital.toString());
                    bw.newLine();
                } 
                if (a instanceof Physical) {
                    Physical physical=(Physical)a;
                    bw.write(physical.toString());
                    bw.newLine();
                }
                if (a instanceof Food) {
                    Food food=(Food)a;
                    bw.write(food.toString());
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }
    
    public List<Product> DocfileProducts(){
        List<Product> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader("D:\\DoAn\\file\\Products.txt");
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                if(line==null) break;
                list.add(chuyenthanhsanpham(line));
            }
        } catch (IOException e){
            System.out.println();
        }
        return list;
    }

    public void GhifileStaffs(Staff Staff){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\Staffs.txt",true);
            bw =new BufferedWriter(fw);
            bw.write(Staff.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }
    
    public void GhifileStaffs(List<Staff> Staff){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\Staffs.txt");
            bw =new BufferedWriter(fw);
            for(Staff a:Staff){
                bw.write(a.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }
    
    public List<Staff> DocfileStaffs(){
        List<Staff> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader("D:\\DoAn\\file\\Staffs.txt");
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                if(line==null) break;
                list.add(chuyenthanhNhanvien(line));
            }
        } catch (IOException e){
            System.out.println();
        }
        return list;
    }
    
    public void GhifileCustomers(Customer Customer){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\Customers.txt",true);
            bw =new BufferedWriter(fw);
            bw.write(Customer.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }

    public void GhifileCustomers(List<Customer> Customer){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\Customers.txt");
            bw =new BufferedWriter(fw);
            for(Customer a:Customer){
                bw.write(a.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }
    
    public List<Customer> DocfileCustomers(){
        List<Customer> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader("D:\\DoAn\\file\\Customers.txt");
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                if(line==null) break;
                list.add(chuyenthanhKhachhang(line));
            }
        } catch (IOException e){
            System.out.println();
        }
        return list;
    }

    public void GhifileSuppliers(Supplier Supplier){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\Suppliers.txt",true);
            bw =new BufferedWriter(fw);
            bw.write(Supplier.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }

    public void GhifileSuppliers(List<Supplier> Supplier){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\Suppliers.txt");
            bw =new BufferedWriter(fw);
            for(Supplier a:Supplier){
                bw.write(a.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }
    
    public List<Supplier> DocfileSuppliers(){
        List<Supplier> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader("D:\\DoAn\\file\\Suppliers.txt");
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                if(line==null) break;
                list.add(chuyenthanhNhacungcap(line));
            }
        } catch (IOException e){
            System.out.println();
        }
        return list;
    }

    public void GhifilePhieuNhaps(PhieuNhap PhieuNhap){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\PhieuNhaps.txt",true);
            bw =new BufferedWriter(fw);
            bw.write(PhieuNhap.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }

    public void GhifilePhieuNhaps(List<PhieuNhap> PhieuNhap){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\PhieuNhaps.txt",true);
            bw =new BufferedWriter(fw);
            for(PhieuNhap a:PhieuNhap){
                bw.write(a.toString());
                bw.newLine();
        }
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }
    
    public List<PhieuNhap> DocfilePhieuNhaps(){
        List<PhieuNhap> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader("D:\\DoAn\\file\\PhieuNhaps.txt");
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                if(line==null) break;
                list.add(chuyenthanhPhieuNhap(line));
            }
        } catch (IOException e){
            System.out.println();
        }
        return list;
    }

    public void GhifilePhieuXuats(PhieuXuat PhieuXuat){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\PhieuXuats.txt",true);
            bw =new BufferedWriter(fw);
            bw.write(PhieuXuat.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }

    public void GhifilePhieuXuats(List<PhieuXuat> PhieuXuat){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\PhieuXuats.txt",true);
            bw =new BufferedWriter(fw);
            for(PhieuXuat a:PhieuXuat){
                bw.write(a.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }
    
    public List<PhieuXuat> DocfilePhieuXuats(){
        List<PhieuXuat> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader("D:\\DoAn\\file\\PhieuXuats.txt");
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                if(line==null) break;
                list.add(chuyenthanhPhieuXuat(line));
            }
        } catch (IOException e){
            System.out.println();
        }
        return list;
    }

    public void GhifileCTphieunhaps(CTphieunhap CTphieunhap){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\CTphieunhaps.txt",true);
            bw =new BufferedWriter(fw);
            bw.write(CTphieunhap.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }

    public void GhifileCTphieunhaps(List<CTphieunhap> CTphieunhap){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\CTphieunhaps.txt",true);
            bw =new BufferedWriter(fw);
            for(CTphieunhap a:CTphieunhap){
                bw.write(a.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }
    
    public List<CTphieunhap> DocfileCTphieunhaps(){
        List<CTphieunhap> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader("D:\\DoAn\\file\\CTphieunhaps.txt");
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                if(line==null) break;
                list.add(chuyenthanhctpn(line));
            }
        } catch (IOException e){
            System.out.println();
        }
        return list;
    }

    public void GhifileCTphieuxuats(CTphieuxuat CTphieuxuat){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\CTphieuxuats.txt",true);
            bw =new BufferedWriter(fw);
            bw.write(CTphieuxuat.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }

    public void GhifileCTphieuxuats(List<CTphieuxuat> CTphieuxuat){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\CTphieuxuats.txt",true);
            bw =new BufferedWriter(fw);
            for(CTphieuxuat a:CTphieuxuat){
                bw.write(a.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }
    
    public List<CTphieuxuat> DocfileCTphieuxuats(){
        List<CTphieuxuat> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader("D:\\DoAn\\file\\CTphieuxuats.txt");
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                if(line==null) break;
                list.add(chuyenthanhctpx(line));
            }
        } catch (IOException e){
            System.out.println();
        }
        return list;
    }

    public void GhifileAccounts(Account Account){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\Accounts.txt",true);
            bw =new BufferedWriter(fw);
            bw.write(Account.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }

    public void GhifileAccounts(List<Account> Account){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            fw=new FileWriter("D:\\DoAn\\file\\Accounts.txt");
            bw =new BufferedWriter(fw);
            for(Account a:Account){
                bw.write(a.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        System.out.println("Ghi File khong thanh cong");
        }
    }
    
    public List<Account> DocfileAccounts(){
        List<Account> list=new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader("D:\\DoAn\\file\\Accounts.txt");
            br=new BufferedReader(fr);
            String line="";
            while (true) {
                line=br.readLine();
                if(line==null) break;
                list.add(chuyenthanhtaikhoan(line));
            }
        } catch (IOException e){
            System.out.println();
        }
        return list;
    }

    // Kiem tra file co rong khong
    public void checkFile(String tenFile) {
        File file = new File(tenFile);
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    System.out.println("File khong trong.");
                    return;
                }
            }
            System.out.println("Tep trong.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    

    public static void main(String[] args){
        FILE a=new FILE();
        a.checkFile(null);
    }
}
