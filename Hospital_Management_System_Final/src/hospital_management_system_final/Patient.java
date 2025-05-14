package hospital_management_system_final;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Scanner;


public class Patient extends ABS_people implements Common_methods{
    private String coDiseases;
    private String AssignedDoc;
    private String AppointTime;

    public Patient(){
        this.coDiseases = "Null";
        this.AssignedDoc = "Null";
        this.AppointTime = "Null"; 
    }

    public Patient(String coDiseases,String AssignedDoc, String AppointTime, String Id, String Name, String Age, String Contact, String Birthdate, String Bloodtype, String gender) {
        super(Id, Name, Age, Contact, Birthdate, Bloodtype, gender);
        this.coDiseases = coDiseases;
        this.AssignedDoc = AssignedDoc;
        this.AppointTime = AppointTime;
    }
//getter
    
    public String getcoDiseases() {
        return coDiseases;
    }
    public String getAssignedDoc() {
        return AssignedDoc;
    }
    public String getAppointTime() {
        return AppointTime;
    }
//setter
    
    public void setcoDiseases(String coDiseases) {
        this.coDiseases = coDiseases;
    }
    public void setAssignedDoc(String AssignedDoc) {
        this.AssignedDoc = AssignedDoc;
    }
    public void setAppointTime(String AppointTime) {
        this.AppointTime = AppointTime;
    }
    
    
    @Override
    public void add() {
        File file=new File("Patient.txt");
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter(file,true));
            w.write(this.getId()+" "+this.getName()+" "+this.getAge()+" "+this.getContact()+" "+this.getBirthdate()+" "+this.getBloodtype()+" "+this.getGender()+" "+this.coDiseases+" "+this.AssignedDoc+" "+this.AppointTime+" ");
            w.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void view() {
        File file=new File("Patient.txt");
        String rId,rName,rAge,rContact,rBirthDate,rBloodType,rGender,rDiseases,rAssignedDoc,rAppointTime ;
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
                rDiseases=r.next();
                rAssignedDoc=r.next();
                rAppointTime=r.next();
                System.out.println("Patient ID = "+rId+"  Patient Name = "+rName+" Patient Age = "+rAge+" Phone = "+rContact+"  Birth Date = "+rBirthDate+" Blood Type = "+rBloodType+" Gender = "+rGender+" Category of Disease = "+rDiseases+" Assign Doctor = "+rAssignedDoc+"  Appointment Time = "+rAppointTime );
            }
            r.close();
        }catch(Exception e){
            System.out.println("done");
        }
    }

    @Override
    public void Edit(){
        Scanner s=new Scanner(System.in);
        File rfile=new File("Patient.txt");
        String  rId , rName , rAge , rContact , rcoDiseases , rAssignedDoc , rAppointTime , rBirthDate , rBloodType , rGender ;
        
        int count=0;
        Patient[] n=new Patient[100];
        
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
                rcoDiseases=r.next();
                rAssignedDoc=r.next();
                rAppointTime=r.next();
                n[i]=new Patient(rcoDiseases, rAssignedDoc,rAppointTime, rId, rName,rAge, rContact, rBirthDate, rBloodType, rGender);
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
                System.out.println("1:ID    2:Name    3:Phone    4:Birth of Date    5:Blood Type    6:Gender    7:Diseases   ");
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
                else if(press.equals("7")){//catogory realated disease 
                    System.out.println("Press for the category the illness falls into :");
                    System.out.println("*1: Ortho  2:ENT  3:Surgery  4:Neurology  5:Cardiology  6:Dermatology ");
                    String codiseaseR=s.next();
                    if(codiseaseR.equals("1")){
                        n[i].setcoDiseases("Ortho");
                    }
                    else if(codiseaseR.equals("2")){
                        n[i].setcoDiseases("ENT");
                    }
                    else if(codiseaseR.equals("3")){
                        n[i].setcoDiseases("Surgery");
                    }
                    else if(codiseaseR.equals("4")){
                        n[i].setcoDiseases("Neurology");
                    }
                    else if(codiseaseR.equals("5")){
                       n[i].setcoDiseases("Cardiology");
                    }
                    else if(codiseaseR.equals("6")){
                        n[i].setcoDiseases("Dermatology");
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
            System.out.println("Facility not found ");
            Edit();
        }
        
        //rewrite file
        File wfile=new File("Patient.txt");
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter(wfile));
            int j=0;
            while(j<count){
                w.write(n[j].getId()+" "+n[j].getName()+" "+n[j].getAge()+" "+n[j].getContact()+" "+n[j].getBirthdate()+" "+n[j].getBloodtype()+" "+n[j].getGender()+" "+n[j].coDiseases+" "+n[j].AssignedDoc+" "+n[j].AppointTime+" ");
                j++;
            }
            w.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public void patientAppointment(String ID){
    Scanner s=new Scanner(System.in);
    //read and put in obj of patient
    
        File rfile=new File("Patient.txt");
        String  rId , rName , rAge , rContact , rcoDiseases , rAssignedDoc , rAppointTime , rBirthDate , rBloodType , rGender ;
        
        int count=0;
        Patient[] P=new Patient[100];
        
        
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
                rcoDiseases=r.next();
                rAssignedDoc=r.next();
                rAppointTime=r.next();
                P[i]=new Patient(rcoDiseases, rAssignedDoc,rAppointTime, rId, rName,rAge, rContact, rBirthDate, rBloodType, rGender);
                i++;
            }
            count=i;
            r.close();
        }catch(Exception e){
            System.out.println("There is an error ");
        }
        
    //read and put in obj of Doctor
        
        File drfile=new File("Doctor.txt");
        String  drId , drName , drAge , drContact , drBirthDate , drBloodType , drGender , drSalary , drDocQualification , drDocSpecialty ,drDocSchedule;
        
        int dcount=0;
        Doctor[] D=new Doctor[100];
        
        //read and put in obj
        try{
            Scanner r=new Scanner(drfile);
            int i=0;
            while(r.hasNext()){
                drId=r.next();
                drName=r.next();
                drAge=r.next();
                drContact=r.next();
                drBirthDate=r.next();
                drBloodType=r.next();
                drGender=r.next();
                drSalary=r.next();
                drDocQualification=r.next();
                drDocSpecialty=r.next();
                drDocSchedule=r.next();
                D[i]=new Doctor(drSalary , drDocQualification , drDocSpecialty , drDocSchedule , drId , drName , drAge , drContact , drBirthDate ,drBloodType , drGender);
                i++;
            }
            dcount=i;
            r.close();
        }catch(Exception e){
            System.out.println("There is an error ");
        }
        
        //asssign doc and appointment
        for(int i=0;i<count;i++){//assign
            if(P[i].getId().equals(ID)){
                for(int j=0;i<dcount;j++){
                    if(D[j].getDocSpecialty().equals(P[i].getcoDiseases())){
                        P[i].setAssignedDoc(D[j].getName());
                        P[i].setAppointTime(D[j].getDocSchedule());
                        break;
                    }
                }
                
            }
            else{
                System.out.println("ID not found ");
                break;
            }
        }
        
        File wfile=new File("Patient.txt");
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter(wfile));
            int j=0;
            while(j<count){
                w.write(P[j].getId()+" "+P[j].getName()+" "+P[j].getAge()+" "+P[j].getContact()+" "+P[j].getBirthdate()+" "+P[j].getBloodtype()+" "+P[j].getGender()+" "+P[j].coDiseases+" "+P[j].AssignedDoc+" "+P[j].AppointTime+" ");
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
    
    private static boolean isvalidId(Patient[] p, String id, int count ){
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
