package hospital_management_system_final;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class Lab implements Common_methods{
    private String LabName;
    private String LabTestCost;
    private String LabAmount;

    public Lab() {
    }
    
    public Lab(String LabName, String LabTestCost,String LabAmount) {
        this.LabName = LabName;
        this.LabTestCost = LabTestCost;
        this.LabAmount=LabAmount;
    }
//getter
    public String getLabName() {
        return LabName;
    }
    public String getLabTestCost() {
        return LabTestCost;
    }
    public String getLabAmount() {
        return LabAmount;
    }
//setter
    public void setLabName(String LabName) {
        this.LabName = LabName;
    }
    public void setLabTestCost(String LabTestCost) {
        this.LabTestCost = LabTestCost;
    }
    public void setLabAmount(String LabAmount) {
        this.LabAmount = LabAmount;
    }
    
    
    
    @Override
    public void add() {
        File file=new File("Lab.txt");
        
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter(file,true));
            w.write(this.LabName+" "+this.LabAmount+" "+this.LabTestCost+" ");
            w.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    @Override
    public void view() {
        File file=new File("Lab.txt");
        String rLabName = null;
        String rLabAmount = null;
        String rLabTestCost = null;
        try{
            Scanner r=new Scanner(file);
            while(r.hasNext()){
                rLabName=r.next();
                rLabAmount=r.next();
                rLabTestCost=r.next();
                System.out.println("Lab = "+rLabName+"  Total = "+rLabAmount+" Cost = "+rLabTestCost+" ");
            }
            r.close();
        }catch(Exception e){
            System.out.println("done");
        }
    }
    
    public void Edit() {
        Scanner s=new Scanner(System.in);
        File rfile=new File("Lab.txt");
        String rLabName , rLabAmount , rLabTestCost ;
        int count=0;
        Lab[] n=new Lab[50];
        //read and put in obj
        try{
            Scanner r=new Scanner(rfile);
            int i=0;
            while(r.hasNext()){
                rLabName=r.next();
                rLabAmount=r.next();
                rLabTestCost=r.next();
                n[i]=new Lab(rLabName,rLabTestCost,rLabAmount);
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
            if(find.equals(n[i].getLabName())){
                System.out.println("What do you want to edit?");
                System.out.println("press : ");
                System.out.println("1: Name     2:Amount     3:Cost");
                String press=s.next();
                if(press.equals("1")) {
                    System.out.println("Give a Name :");
                    String nameR=s.next();
                    if(isvalidName(n, nameR, count)==true){
                        n[i].setLabName(nameR);
                    }
                    else{
                        System.out.println("Wrong name ,try agin");
                        Edit(); 
                    }
                }
                else if(press.equals("2")){
                    System.out.println("Give  Number :");
                    String amountR=s.next();
                    if(StringisIntChecker(amountR)==true){
                        n[i].setLabAmount(amountR);
                    }
                    else{
                        System.out.println("Wrong number ,try agin");
                        Edit();
                    }
                } 
                else if(press.equals("3")){
                    System.out.println("Give cost :");
                    String costR=s.next();
                    if(StringisIntChecker(costR)==true){
                        n[i].setLabAmount(costR);
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
            System.out.println("Lab not found ");
            Edit();
        }
        //rewrite file
        File wfile=new File("Lab.txt");
        
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter(wfile));
            int j=0;
            while(j<count){
                w.write(n[j].LabName+" "+n[j].LabAmount+" "+n[j].LabTestCost+" ");
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
    
    private static boolean isvalidName(Lab[] p, String name, int count ){
        boolean b=true;
        for(int i=0;i<count+1;i++){
            if(p[i] != null && p[i].getLabName().equals(name)){
                b=false;
                break;
            }
        }
        
        return b;
    }
}

