package hospital_management_system_final;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class Medicine implements Common_methods {
    private String MedName;
    private String MedCost;
    private String MedAmount ;
    
    private String MedExpiryDate;
    private String MedCompName; 

    public Medicine() {
        
    }
    
    public Medicine(String MedName, String MedCost, String MedAmount, String MedExpiryDate, String MedCompName) {
        this.MedName = MedName;
        this.MedCost = MedCost;
        this.MedAmount = MedAmount;
        this.MedExpiryDate = MedExpiryDate;
        this.MedCompName = MedCompName;
    }
//getter
    public String getMedName() {
        return MedName;
    }
    public String getMedCost() {
        return MedCost;
    }
    public String getMedAmount() {
        return MedAmount;
    }
    public String getMedExpiryDate() {
        return MedExpiryDate;
    }
    public String getMedCompName() {
        return MedCompName;
    }
//setter
    public void setMedName(String MedName) {
        this.MedName = MedName;
    }
    public void setMedCost(String MedCost) {
        this.MedCost = MedCost;
    }
    public void setMedAmount(String MedAmount) {
        this.MedAmount = MedAmount;
    }
    public void setMedExpiryDate(String MedExpiryDate) {
        this.MedExpiryDate = MedExpiryDate;
    }
    public void setMedCompName(String MedCompName) {
        this.MedCompName = MedCompName;
    }

    
    
    @Override
    public void add() {
        File file=new File("Medicine.txt");
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter(file,true));
            w.write(this.getMedName()+" "+this.getMedCompName()+" "+this.getMedExpiryDate()+" "+this.getMedAmount()+" "+this.getMedCost()+" ");
            w.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void view() {
        File file=new File("Medicine.txt");
        String rMedName , rMedCompName , rMedExpiryDate , rMedAmount , rMedCost;
        try{
            Scanner r=new Scanner(file);
            while(r.hasNext()){
                rMedName=r.next();
                rMedCompName=r.next();
                rMedExpiryDate=r.next();
                rMedAmount=r.next();
                rMedCost=r.next();
                System.out.println("Medicine Name = "+rMedName+"  Company Name = "+rMedCompName+" Expiry Date = "+rMedExpiryDate+" Medicine Amount = "+rMedAmount+" Medicine Cost = "+rMedCost);
            }
            r.close();
        }catch(Exception e){
            System.out.println("done");
        }
    }

    public void Edit(){
        Scanner s=new Scanner(System.in);
        File rfile=new File("Medicine.txt");
        String rMedName ,rMedCompName ,rMedExpiryDate , rMedAmount , rMedCost ;
        int count=0;
        Medicine[] n=new Medicine[50];
        //read and put in obj
        try{
            Scanner r=new Scanner(rfile);
            int i=0;
            while(r.hasNext()){
                rMedName=r.next();
                rMedCompName=r.next();
                rMedExpiryDate=r.next();
                rMedAmount=r.next();
                rMedCost=r.next();
                n[i]=new Medicine(rMedName,rMedCost,rMedAmount,rMedExpiryDate,rMedCompName);
                i++;
            }
            count=i;
            r.close();
        }catch(Exception e){
            System.out.println("There is an error ");
        }
        //search
        System.out.println("Give name to edit :");
        String find=s.next();
        int i;
        boolean t=false;
        for(i=0;i<count;i++){
            if(find.equals(n[i].getMedName())){
                System.out.println("What do you want to edit?");
                System.out.println("press : ");
                System.out.println("1: Name     2:Company     3:ExpiryDate     4:Amount     5:Cost");
                String press=s.next();
                if(press.equals("1")) {
                    System.out.println("Give a Name :");
                    String nameR=s.next();
                    if(isvalidName(n, nameR, count)==true){
                        n[i].setMedName(nameR);
                    }
                    else{
                        System.out.println("Wrong name ,try agin");
                        Edit(); 
                    }
                }
                else if(press.equals("2")){
                    System.out.println("Give company name :");
                    String companyR=s.next();
                    n[i].setMedCompName(companyR);
                }    
                else if(press.equals("3")){//dob
                    System.out.println("Give  month digit   :");
                    String monR=s.next();
                    System.out.println("Give  day number    :");
                    String dayR=s.next();
                    System.out.println("Give  year          :");
                    String yearR=s.next();
                    String expR=dayR+"/"+monR+"/"+yearR;
                    if(isValidExpiryDate(dayR,monR, yearR)==true){
                        n[i].setMedExpiryDate(expR);
                    }
                    else{
                        System.out.println("Wrong input ,try agin");
                        Edit();
                    }
                }
                else if(press.equals("4")){
                    System.out.println("Give a Number :");
                    String amountR=s.next();
                    if(StringisIntChecker(amountR)==true){
                        n[i].setMedAmount(amountR);
                    }
                    else{
                        System.out.println("Wrong number ,try agin");
                        Edit();
                    }
                } 
                else if(press.equals("5")){
                    System.out.println("Give cost :");
                    String costR=s.next();
                    if(StringisIntChecker(costR)==true){
                        n[i].setMedAmount(costR);
                    }
                    else{
                        System.out.println("Wrong number ,try agin");
                        Edit();
                    }
                }
                t=true;
                break;
            }
        } 
        if(t==false){
            System.out.println("Medicine not found ");
            Edit();
        }
        //rewrite file
        File wfile=new File("Medicine.txt");
        
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter(wfile));
            int j=0;
            while(j<count){
                w.write(n[j].MedName+" "+n[j].MedCompName+" "+n[j].MedExpiryDate+" "+n[j].MedAmount+" "+n[j].MedCost+" ");
                j++;
            }
            w.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    
    private boolean StringisIntChecker(String str){
        char[] c = str.toCharArray();
        boolean b = false;
        for(int i=0;i<c.length;i++){
            if(Character.isDigit(c[i])==false){
                b=false;
                break;
            }
            else{
                b=true;
            }
        }
        return b;
    }
    public static boolean isValidExpiryDate(String day, String month, String year) {
        try {
            int dayInt = Integer.parseInt(day);
            int monthInt = Integer.parseInt(month);
            int yearInt = Integer.parseInt(year);

            if (yearInt < 2018 || yearInt >= 2028) {
                return false; // Assuming a reasonable range for birth years
            }

            if (monthInt < 1 || monthInt > 12) {
                return false;
            }

            if (dayInt < 1 || dayInt > daysInMonth(monthInt, yearInt)) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            return false; 
        }
    }
    public static int daysInMonth(int month, int year) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28;
            default:
                return 31;
        }
    }
    
    private static boolean isvalidName(Medicine[] p, String name, int count ){
        boolean b=true;
        for(int i=0;i<count+1;i++){
            if(p[i] != null && p[i].getMedName().equals(name)){
                b=false;
                break;
            }
        }
        
        return b;
    }
}

