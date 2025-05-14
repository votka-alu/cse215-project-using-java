package hospital_management_system_final;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class Facility implements Common_methods{
    private String FacName="Null";
    private String FacAvailabilty="Null";
    private String amount="Null" ;

    public Facility() {
        
    }

    public Facility(String FacName, String amount,String FacAvailabilty) {
        this.FacName = FacName;
        this.FacAvailabilty = FacAvailabilty;
        this.amount = amount;
    }
//getter
    public String getFacName() {
        return FacName;
    }
    public String getFacAvailabilty() {
        return FacAvailabilty;
    }
    public String getAmount() {
        return amount;
    }
//setter
    public void setFacName(String FacName) {
        this.FacName = FacName;
    }
    public void setFacAvailabilty(String FacAvailabilty) {
        this.FacAvailabilty = FacAvailabilty;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    
    public void add() {
        File file=new File("Facility.txt");
        
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter(file,true));
            w.write(this.FacName+" "+this.amount+" "+this.FacAvailabilty+" ");
            w.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    public void view() {
        //my view code
        File file=new File("Facility.txt");
        String rFacName,ramount,rFacAvailabilty ;
        try{
            Scanner r=new Scanner(file);
            while(r.hasNext()){
                rFacName=r.next();
                ramount=r.next();
                rFacAvailabilty=r.next();
                System.out.println("Facility = "+rFacName+"  exist = "+ramount+" available = "+rFacAvailabilty+" ");
            }
            r.close();
        }catch(Exception e){
            System.out.println("done");
        }
    }

    public void Edit() {
        Scanner s=new Scanner(System.in);
        File rfile=new File("Facility.txt");
        String rFacName ,ramount , rFacAvailabilty ;
        int count=0;
        Facility[] n=new Facility[50];
        
        //read and put in obj
        try{
            Scanner r=new Scanner(rfile);
            int i=0;
            while(r.hasNext()){
                rFacName=r.next();
                ramount=r.next();
                rFacAvailabilty=r.next();
                n[i]=new Facility(rFacName,ramount,rFacAvailabilty);
                i++;
            }
            count=i;
            r.close();
        }catch(Exception e){
            System.out.println("There is an error ");
        }
        
        //search and change
        System.out.println("Give name to edit :");
        String find=s.next();
        int i;
        boolean t=false;
        for(i=0;i<count;i++){
            if(find.equals(n[i].getFacName())){
                System.out.println("What do you want to edit?");
                System.out.println("press : ");
                System.out.println("1: Name     2:Number     3:Availability");
                String press=s.next();
                if(press.equals("1")) {
                    System.out.println("Give a Name :");
                    String nameR=s.next();
                    if(isvalidName(n, nameR, count)==true){
                        n[i].setFacName(nameR);
                    }
                    else{
                        System.out.println("Wrong name ,try agin");
                        Edit(); 
                    }
                }
                else if(press.equals("2")){
                    System.out.println("Give a Number :");
                    String amountR=s.next();
                    if(StringisIntChecker(amountR)==true){
                        n[i].setAmount(amountR);
                    }
                    else{
                        System.out.println("Wrong number ,try agin");
                        Edit();
                    }
                } 
                else if(press.equals("3")){
                    System.out.println("Give yes or no :");
                    System.out.println("Write : ");
                    System.out.println("Yes    No ");
                    String availabiltyR=s.next();
                    if(availabiltyR.equals("Yes")){
                        n[i].setFacAvailabilty(availabiltyR);
                    }
                    else if(availabiltyR.equals("No")){
                        n[i].setFacAvailabilty(availabiltyR);
                    }
                    else{
                        Edit();
                    }
                }
                t=true;
                break;
            }
        } 
        if(t==false){
            System.out.println("Facility not found ");
            Edit();
        }
        
        //rewrite file
        File wfile=new File("Facility.txt");
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter(wfile));
            int j=0;
            while(j<count){
                w.write(n[j].FacName+" "+n[j].amount+" "+n[j].FacAvailabilty+" ");
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

    private static boolean isvalidName(Facility[] p, String name, int count ){
        boolean b=true;
        for(int i=0;i<count+1;i++){
            if(p[i] != null && p[i].getFacName().equals(name)){
                b=false;
                break;
            }
        }
        
        return b;
    }
    
}
