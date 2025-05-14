package hospital_management_system_final;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Scanner;


public class Staff extends ABS_people implements Common_methods {
    private String stfSalary = null;
    private String stfSpecialty = null;
    private String stfSchedule = null;

    public Staff() {
    }

    public Staff(String stfSalary, String stfSpecialty, String stfSchedule, String Id, String Name, String Age, String Contact, String Birthdate, String Bloodtype, String gender) {
        super(Id, Name, Age, Contact, Birthdate, Bloodtype, gender);
        this.stfSalary = stfSalary;
        this.stfSpecialty = stfSpecialty;
        this.stfSchedule = stfSchedule;
    }
//getter
    public String getStfSalary() {
        return stfSalary;
    }
    public String getStfSpecialty() {
        return stfSpecialty;
    }
    public String getStfSchedule() {
        return stfSchedule;
    }
//setter
    public void setStfSalary(String stfSalary) {
        this.stfSalary = stfSalary;
    }
    public void setStfSpecialty(String stfSpecialty) {
        this.stfSpecialty = stfSpecialty;
    }
    public void setStfSchedule(String stfSchedule) {
        this.stfSchedule = stfSchedule;
    }

    
    
    @Override
    public void add() {
        File file=new File("Staff.txt");
        
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter(file,true));
            w.write(this.getId()+" "+this.getName()+" "+this.getAge()+" "+this.getContact()+" "+this.getBirthdate()+" "+this.getBloodtype()+" "+this.getGender()+" "+this.stfSalary+" "+this.stfSpecialty+" "+this.stfSchedule+" ");
            w.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    @Override
    public void view() {
        File file=new File("Staff.txt");
        String rId = null;
        String rName = null;
        String rAge = null;
        String rContact = null;
        String rBirthDate = null;
        String rBloodType = null;
        String rGender = null;
        String rSalary = null;
        String rSpecialty = null;
        String rSchedule = null;
        try{
            Scanner r=new Scanner(file);
            while(r.hasNext()){
                rId=r.next();
                rName=r.next();
                rAge=r.next();
                rContact=r.next();
                rBirthDate=r.next();
                rBloodType=r.next();
                rGender=r.next();
                rSalary=r.next();
                rSpecialty=r.next();
                rSchedule=r.next();
                System.out.println("Staff ID = "+rId+"  Staff Name = "+rName+" Staff Age = "+rAge+" Phone = "+rContact+"  Birth Date = "+rBirthDate+" Blood Type = "+rBloodType+" Gender = "+rGender+"  Salary = "+rSalary+" Position = "+rSpecialty+" Schedule = "+rSchedule);
            }
            r.close();
        }catch(Exception e){
            System.out.println("done");
        }
    }

    public void Edit() {
        Scanner s=new Scanner(System.in);
        File rfile=new File("Staff.txt");
        String  rId , rName , rAge , rContact , rBirthDate , rBloodType , rGender , rSalary , rSpecialty , rSchedule ;
        
        int count=0;
        Staff[] n=new Staff[100];
        
        //read and put in obj
        try{
            Scanner r=new Scanner(rfile);
            int i=0;
            while(r.hasNext()){
                rId=r.next();
                rName=r.next();
                rAge=r.next();
                rContact=r.next();
                rBirthDate = r.next();
                rBloodType=r.next();
                rGender=r.next();
                rSalary=r.next();
                rSpecialty=r.next();
                rSchedule=r.next();
                n[i]=new Staff(rSalary, rSpecialty,rSchedule, rId, rName,rAge, rContact, rBirthDate, rBloodType, rGender);
                i++;
            }
            count=i;
            r.close();
        }catch(Exception e){
            System.out.println("There is an error ");
        }
        
        //search and change
        System.out.println("Give ID to search :");
        String find=s.next();
        int i;
        boolean t=false;
        for(i=0;i<count;i++){
            if(find.equals(n[i].getId())){
                System.out.println("What do you want to edit?");
                System.out.println("press : ");
                System.out.println("1:ID    2:Name    3:Contact    4:Birth    5:BloodType    6:Gender    7:Work Position    8:Schedule");
                String press=s.next();
                if(press.equals("1")){
                    System.out.println("Give a ID :");
                    String idR=s.next();
                    if(StringisIntChecker(idR,3)==true){
                        if(isvalidId(n, idR, count)==true){
                            n[i].setId(idR);
                        }
                        else{
                            System.out.println("Wrong number ,try agin");
                            Edit(); 
                        }
                    }
                    else{
                        System.out.println("Wrong number ,try agin");
                        Edit();
                    }
                }
                else if(press.equals("2")){//name
                    System.out.println("Give a Name :");
                    String nameR=s.next();
                    n[i].setName(nameR);
                } 
                else if(press.equals("3")){//phone
                    System.out.println("Give a contact number :");
                    String contactR=s.next();
                    if(StringisIntChecker(contactR,11)==true){
                        n[i].setContact(contactR);
                    }
                    else{
                        System.out.println("Wrong number ,try agin");
                        Edit();
                    }
                }
                else if(press.equals("4")){//dob
                    System.out.println("Give  month digit   :");
                    String monR=s.next();
                    System.out.println("Give  day number    :");
                    String dayR=s.next();
                    System.out.println("Give  year          :");
                    String yearR=s.next();
                    String dobR=dayR+"/"+monR+"/"+yearR;
                    if(isValidDateOfBirth(dayR,monR, yearR)==true){
                        n[i].setBirthdate(dobR);
                        n[i].setAge(calculateAge(dayR, monR, yearR));
                    }
                    else{
                        System.out.println("Wrong input ,try agin");
                        Edit();
                    }
                }
                else if(press.equals("5")){//bloodtype
                    System.out.println("Give blood type :");
                    System.out.println("**USE CAPS**");
                    String bloodtypeR=s.next();
                    if(bloodtypeR.equals("A+") || bloodtypeR.equals("A-") || bloodtypeR.equals("B+") || bloodtypeR.equals("B-") || bloodtypeR.equals("AB+") || bloodtypeR.equals("AB-") || bloodtypeR.equals("O+") || bloodtypeR.equals("O-")){
                        n[i].setBloodtype(bloodtypeR);
                    }
                    else{
                        System.out.println("Wrong input ,try agin");
                        Edit();
                    }
                }
                else if(press.equals("6")){//gender
                    System.out.println("Assign gender :");
                    System.out.println("Press :");
                    System.out.println("*1: Male  2:Female  3:Other");
                    String genderR=s.next();
                    if(genderR.equals("1") ){
                        n[i].setGender("Male");
                    }
                    else if(genderR.equals("2")){
                        n[i].setGender("Female");
                    }
                    else if(genderR.equals("3")){
                        n[i].setGender("Other");
                    }
                    else{
                        System.out.println("Wrong input ,try agin");
                        Edit();
                    }
                }
                else if(press.equals("7")){
                    System.out.println("Press for the category the specialty  falls into :");
                    System.out.println("| Employee position |  1:Nurse       2:Pharmacist       3:Ward boy       4:Cleaner       5:Guard ");
                    System.out.println("| Salary (in BDT) |    -20,000       -15,000            -10,000          -10,000         -15,000");
                    String specR=s.next();
                    if(specR.equals("1")){
                        n[i].setStfSpecialty("Nurse");
                        n[i].setStfSalary("20,000BDT");
                    }
                    else if(specR.equals("2")){
                        n[i].setStfSpecialty("Pharmacist");
                        n[i].setStfSalary("15,000BDT");
                    }
                    else if(specR.equals("3")){
                        n[i].setStfSpecialty("Wardboy");
                        n[i].setStfSalary("10,000BDT");
                    }
                    else if(specR.equals("4")){
                        n[i].setStfSpecialty("Cleaner");
                        n[i].setStfSalary("10,000BDT");
                    }
                    else if(specR.equals("5")){
                       n[i].setStfSpecialty("Guard");
                       n[i].setStfSalary("15,000BDT");
                    }
                    else{
                        System.out.println("Wrong input ,try agin");
                        Edit();
                    }
                }
                else if(press.equals("8")){
                    System.out.println("Assign duty time :");
                    System.out.println("Press :");
                    System.out.println("1:7am-3pm  2:3pm-11pm  3:11pm-7pm");
                    String timeR=s.next();
                    if(timeR.equals("1") ){
                        n[i].setStfSchedule("7am-3pm");
                    }
                    else if(timeR.equals("2")){
                        n[i].setStfSchedule("3pm-11pm");
                    }
                    else if(timeR.equals("3")){
                        n[i].setStfSchedule("11pm-7pm");
                    }
                    else{
                        System.out.println("Wrong input ,try agin");
                        Edit();
                    }
                }
                t=true;
                break;
            }
        } 
        if(t==false){
            System.out.println("Staff not found ");
            Edit();
        }
        
        //rewrite file
        File wfile=new File("Staff.txt");
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter(wfile));
            int j=0;
            while(j<count){
                w.write(n[j].getId()+" "+n[j].getName()+" "+n[j].getAge()+" "+n[j].getContact()+" "+n[j].getBirthdate()+" "+n[j].getBloodtype()+" "+n[j].getGender()+" "+n[j].stfSalary+" "+n[j].stfSpecialty+" "+n[j].stfSchedule+" ");
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
    private boolean StringisIntChecker(String str,int num){
        char[] c = str.toCharArray();
        boolean b = false;
        if(c.length==num){
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
        else{
            return b;
        }
    }
    
    //for date of birth
    private  boolean isValidDateOfBirth(String day, String month, String year) {
        try {
            int dayInt = Integer.parseInt(day);
            int monthInt = Integer.parseInt(month);
            int yearInt = Integer.parseInt(year);

            if (yearInt < 1900 || yearInt >= 2023) {
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
    public  int daysInMonth(int month, int year) {
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
    //for age
    public static String calculateAge(String day, String month, String year) {
    int birthDay = Integer.parseInt(day);
    int birthMonth = Integer.parseInt(month);
    int birthYear = Integer.parseInt(year);

    Calendar birthDate = Calendar.getInstance();
    birthDate.set(birthYear, birthMonth - 1, birthDay); 

    Calendar currentDate = Calendar.getInstance();

    int age = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
    if (currentDate.get(Calendar.DAY_OF_YEAR) < birthDate.get(Calendar.DAY_OF_YEAR)) {
        age--; 
    }
    
    return Integer.toString(age);
}  
    
     private static boolean isvalidId(Staff[] p, String id, int count ){
        boolean b=true;
        for(int i=0;i<count+1;i++){
            if(p[i] != null && p[i].getId().equals(id)){
                b=false;
                break;
            }
        }
        
        return b;
    }
}
