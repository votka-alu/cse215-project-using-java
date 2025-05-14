
package hospital_management_system_final;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Scanner;




public class Doctor extends ABS_people implements Common_methods{
    private String Salary="Null";
    private String DocQualification="Null";
    private String DocSpecialty="Null";
    private String DocSchedule="Null";

    public Doctor() {
    }
    
    public Doctor(String Salary, String DocQualification, String DocSpecialty, String DocSchedule, String Id, String Name, String Age, String Contact, String Birthdate, String Bloodtype, String gender) {
        super(Id, Name, Age, Contact, Birthdate, Bloodtype, gender);
        this.Salary = Salary;
        this.DocQualification = DocQualification;
        this.DocSpecialty = DocSpecialty;
        this.DocSchedule = DocSchedule;
    }
//getter
    public String getSalary() {
        return Salary.trim();
    }
    public String getDocQualification() {
        return DocQualification;
    }
    public String getDocSpecialty() {
        return DocSpecialty;
    }
    public String getDocSchedule() {
        return DocSchedule;
    }
    
//setter
    public void setSalary(String Salary) {
        this.Salary = Salary;
    }
    public void setDocQualification(String DocQualification) {
        this.DocQualification = DocQualification;
    }
    public void setDocSpecialty(String DocSpecialty) {
        this.DocSpecialty = DocSpecialty;
    }
    public void setDocSchedule(String DocSchedule) {
        this.DocSchedule = DocSchedule;
    }
    

    
    
    @Override
    public void add() {
        File file=new File("Doctor.txt");
        
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter(file,true));
            w.write(this.getId()+" "+this.getName()+" "+this.getAge()+" "+this.getContact()+" "+this.getBirthdate()+" "+this.getBloodtype()+" "+this.getGender()+" "+this.getSalary()+" "+this.getDocQualification()+" "+this.getDocSpecialty()+" "+this.getDocSchedule()+" ");
            w.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    @Override
    public void view() {
        File file=new File("Doctor.txt");
        String rId ,rName ,rAge ,rContact ,rBirthDate , rBloodType , rGender ,rSalary ;
        String rDocQualification="null" , rDocSpecialty="null" ,rDocSchedule="null";
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
                rDocQualification=r.next();
                rDocSpecialty=r.next();
                rDocSchedule=r.next();
                System.out.println("Doctor ID = "+rId+" Doctor Name = "+rName+" Doctor Age = "+rAge+" Phone = "+rContact+"  Birth Date = "+rBirthDate+" Blood Type = "+rBloodType+" Gender = "+rGender+"  Salary = "+rSalary+" Doctors Qualfication = "+rDocQualification+"  Doctors Specialty = "+rDocSpecialty+" Doctors Schedule = "+rDocSchedule);
            }
            r.close();
        }catch(Exception e){
            System.out.println("done");
        }
    }

    public void Edit() {
        Scanner s=new Scanner(System.in);
        File rfile=new File("Doctor.txt");
        String  rId , rName , rAge , rContact , rBirthDate , rBloodType , rGender , rSalary , rDocQualification , rDocSpecialty ,rDocSchedule;
        
        int count=0;
        Doctor[] n=new Doctor[100];
        
        //read and put in obj
        try{
            Scanner r=new Scanner(rfile);
            int i=0;
            while(r.hasNext()){
                rId=r.next();
                rName=r.next();
                rAge=r.next();
                rContact=r.next();
                rBirthDate=r.next();
                rBloodType=r.next();
                rGender=r.next();
                rSalary=r.next();
                rDocQualification=r.next();
                rDocSpecialty=r.next();
                rDocSchedule=r.next();
                n[i]=new Doctor(rSalary , rDocQualification , rDocSpecialty , rDocSchedule , rId , rName , rAge , rContact , rBirthDate ,rBloodType , rGender);
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
                System.out.println("1:ID    2:Name    3:Phone    4:Birth of Date    5:Blood Type    6:Gender    7:Doctor Specialty ,Salary and Qualification   8:Doctor Schedule    ");
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
                    System.out.println("1: Male  2:Female  3:Other");
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
                else if(press.equals("7")){//SPECIALty
                    System.out.println("Press for the category of Specialization  falls into :");
                    System.out.println("| Specialist |         1: Ortho       2:ENT          3:Surgery      4:Neurology      5:Cardiology     6:Dermatology ");
                    System.out.println("| Salary (in BDT) |    -40,000        -45,000        -60,000        -50,000          -45,000           -40,000");
                    System.out.println("| Qualification |      -MBBS,MS       -MBBS,FCPS,MS  -MBBS,FCPS     -MBBS,MD,FCPS    -MBBS,FCPS,MS     -MBBS,MS");
                    String specR=s.next();
                    if(specR.equals("1")){
                        n[i].setDocSpecialty("Ortho");
                        n[i].setSalary("40,000BDT");
                        n[i].setDocQualification("MBBS,MS");
                    }
                    else if(specR.equals("2")){
                        n[i].setDocSpecialty("ENT");
                        n[i].setSalary("45,000BDT");
                        n[i].setDocQualification("MBBS,FCPS,MS");
                    }
                    else if(specR.equals("3")){
                        n[i].setDocSpecialty("Surgery");
                        n[i].setSalary("60,000BDT");
                        n[i].setDocQualification("MBBS,FCPS");
                    }
                    else if(specR.equals("4")){
                        n[i].setDocSpecialty("Neurology");
                        n[i].setSalary("50,000BDT");
                        n[i].setDocQualification("MBBS,MD,FCPS");
                    }
                    else if(specR.equals("5")){
                       n[i].setDocSpecialty("Cardiology");
                       n[i].setSalary("45,000BDT");
                       n[i].setDocQualification("MBBS,FCPS,MS");
                    }
                    else if(specR.equals("6")){
                       n[i].setDocSpecialty("Dermatology");
                       n[i].setSalary("40,000BDT");
                       n[i].setDocQualification("MBBS,MS");
                    }
                    else{
                        System.out.println("Wrong input ,try agin");
                        Edit();
                    }
                }
                else if(press.equals("8")){//Schedule
                    System.out.println("Assign duty time :");
                    System.out.println("Press :");
                    System.out.println("1:7am-3pm  2:3pm-11pm  3:11pm-7pm");
                    String timeR=s.next();
                    if(timeR.equals("1") ){
                        n[i].setDocSchedule("7am-3pm");
                    }
                    else if(timeR.equals("2")){
                        n[i].setDocSchedule("3pm-11pm");
                    }
                    else if(timeR.equals("3")){
                        n[i].setDocSchedule("11pm-7pm");
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
            System.out.println("Doctor not found ");
            Edit();
        }
        
        //rewrite file
        File wfile=new File("Doctor.txt");
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter(wfile));
            int j=0;
            while(j<count){
                w.write(n[j].getId()+" "+n[j].getName()+" "+n[j].getAge()+" "+n[j].getContact()+" "+n[j].getBirthdate()+" "+n[j].getBloodtype()+" "+n[j].getGender()+" "+n[j].getSalary()+" "+n[j].getDocQualification()+" "+n[j].getDocSpecialty()+" "+n[j].getDocSchedule()+" ");
                j++;
            }
            w.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
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
    
    private static boolean isvalidId(Doctor[] p, String id, int count ){
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
