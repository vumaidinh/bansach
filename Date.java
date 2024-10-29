import java.io.Serializable;
import java.util.Calendar;

public class Date implements Serializable{
    private int day;
    private int month;
    private int year;
    public Date(int day,int month,int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }
    public Date(){
        day=0;
        month=0;
        year=0;
    }
    
    public void setday(int day){
        if(day>0 && day<=31)
            this.day=day;
    }
    public int getday(){
        return day;
    }
    
    public void setmonth(int month){
        if(month>0 && month<=12)
            this.month=month;
    }
    public int getmonth(){
        return month;
    }
    
    public void setyear(int year){
        if(year>1900 && year<=2050)
            this.year=year;
    }
    public int getyear(){
        return year;
    }
    
    public boolean checkDate() {
        // Kiểm tra tính hợp lệ của ngày, tháng và năm
        if (day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1900 && year <=2050) {
            // Kiểm tra tháng 2 và ngày 30 hoặc 31 không hợp lệ
            if (month == 2) {
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    // Năm nhuận
                    return day <= 29;
                } else {
                    // Năm không nhuận
                    return day <= 28;
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                // Tháng 4, 6, 9, 11 có tối đa 30 ngày
                return day <= 30;
            } else {
                return true;
            }
        }
        return false;
    }
    
    public String toString(){
        return day+"/"+month+"/"+year;
    }
    
    public void nhapDate(){
        Check.nhapNgayThang(null, null);
        checkDate();
    }
    
    public String format() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }
    
    public long getTime() {
        Calendar ca1 = Calendar.getInstance();
        ca1.set(this.year,this.month,this.day, 0, 0, 0);
        return ca1.getTimeInMillis();
    }
    
    public void xuatDate(){
        System.out.print(day+"/"+month+"/"+year);
    }
    public static void main(String[] args){
        Date a=new Date();
        a.nhapDate();
        a.xuatDate();
    }
}
