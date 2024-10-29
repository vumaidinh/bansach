
public class Taikhoan{
    private Account account;
    public Taikhoan(Account account){
        this.account=account;
    }
    
    public Taikhoan(){
        account=null;
    }
    
    public Account dangnhap(DSaccount accounts){
        account=new Account();
        String tk,mk;
        int A;
        Account a=new Account();
        do{
            A=0;
            tk=Check.nhapChuoi("Ten dang nhap: ","Error");
            mk=Check.nhapChuoi(("Mat khau: "),"Error");
            for(int i=0;i<accounts.dsAccounts.length;i++)
                if(accounts.dsAccounts[i].getTendangnhap().equals(tk) && accounts.dsAccounts[i].getMatkhau().equals(mk)){
                    A++;
                    a=accounts.dsAccounts[i];
                    account=a;
                    System.out.println("Dang nhap thanh cong\n");
                }
        }while(A!=1);
        return a;
    }
    
    public void phieuxuat(PhieuXuat px){
        px.setMaNhanVien(account.getMa());
    }
    
    public void phieunhap(PhieuNhap pn){
        pn.setMaNhanVien(account.getMa());
    }
    public static void main(String[] args){
        Taikhoan tk=new Taikhoan();
        DSaccount account=new DSaccount();
        account.Khoitao();
        Account b=tk.dangnhap(account);
        if(b instanceof Admin){
            System.out.println("Admin");
        } else if(b instanceof Accountnhanvien){
            System.out.println("staff");
        }
    }
}

