
package hospital_management_system_final;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Scanner;


public class Hospital_Management_Sysytem_Final{
    private static final int PAGE_SIZE = 27;
    public static void main(String[] args) throws Exception {
        
        Homescreen();
        
    }   
    
    public static void DateAndTime(){
        String months[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        Calendar calendar = Calendar.getInstance();
        System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " / " + calendar.get(Calendar.DATE) + " / " + calendar.get(Calendar.YEAR));
        System.out.println("\t\t\t\t\t\t\t    Time: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
    }
    
    public static void clear()  {  
        for (int i = 0; i < PAGE_SIZE; i++) {
        System.out.println();
        }
    } 
    
    private static void endProgramme() {
        System.out.println("");
            System.out.println("===============================================================================================");
            System.out.println("++---------------========================================================--------------------++");
            System.out.println("++-------------------------------------|| Good  bye ||---------------------------------------++");
            System.out.println("++---------------========================================================--------------------++");
            System.out.println("===============================================================================================");
            DateAndTime();
    }
    
    public static void Homescreen() {
        Scanner scn=new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("===========================================================================================");
        System.out.println("++---------------------------------------------------------------------------------------++");
        System.out.println("++---------------------------------------------------------------------------------------++");
        System.out.println("++---------------====================================================--------------------++");
        System.out.println("++--------------|| Welcome to HT Hospital  Management System Project||-------------------++");
        System.out.println("++---------------====================================================--------------------++");
        System.out.println("++---------------------------------------------------------------------------------------++");
        System.out.println("++---------------------------------------------------------------------------------------++");
        System.out.println("===========================================================================================");
        DateAndTime();
        System.out.println("\npress 1 to login          \t\t\t\t\t\t    press 0 to end ");
        String press=scn.nextLine();
        clear();
        if(press.equals("1")){
            login();
        }
        else if(press.equals("0")){
            System.out.println("===============================================================================================");
            System.out.println("++---------------========================================================--------------------++");
            System.out.println("++-------------------------------------|| Thank you ||---------------------------------------++");
            System.out.println("++---------------========================================================--------------------++");
            System.out.println("===============================================================================================");
            DateAndTime();
        }
        else{
            
            System.out.println("As the given input is wrong");
            endProgramme();
        }
        
    }
    
    public static void login() {
        Scanner scn=new Scanner(System.in);

        System.out.println("===========================================================================================");
        System.out.println("++---------------====================================================--------------------++");
        System.out.println("++-------------------------------------|| Login ||---------------------------------------++");
        System.out.println("++---------------====================================================--------------------++");
        System.out.println("===========================================================================================");
        DateAndTime();
        System.out.println("");
        System.out.println("               Admin login :                           Receptionist login :                ");
        System.out.println("        press 1 to login in as Admin            press 2 to login in as Receptionist        ");
        System.out.println("                          Disclaimer :Press 0 to return");
        System.out.println(" ");
        String press1=scn.nextLine();
        clear();
        if(press1.equals("1")) {
            adminlogin();
        }       
        else if(press1.equals("2")){
            Receptionistlogin();
        }
        else if(press1.equals("0")){
            Homescreen();
        }
        else{
            System.out.println("The input is wrong ");
            System.out.println("To try again press 1 and to return press 0");
            String press2=scn.nextLine();
            
            if(press2.equals("1")){
                login();
            }
            else if(press2.equals("0")){
                Homescreen();
                }
            else{
                System.out.println("The input is wrong again ");
                login();
            }
         
        }
    }
    
    public static void adminlogin() {
        Admin admin=new Admin();
        Scanner scn=new Scanner(System.in);
        System.out.println("===========================================================================================");
        DateAndTime();
        System.out.println("                                       Hello there                                       ");
        System.out.println("\n===========================================================================================");
        System.out.print("Please enter password : ");
        String password=scn.nextLine();
        System.out.println("===========================================================================================");
        clear();
        if(password.equals(Admin.getAdmin1Pw())){
            System.out.println("Hello "+Admin.getAdmin1());
            //DateAndTime();
            adminPanel();
        }
        else if(password.equals(Admin.getAdmin2Pw())){
            System.out.println("Hello "+Admin.getAdmin2());
            DateAndTime();
            adminPanel();
        }
        else{
            System.out.println("Password is false ");
            System.out.println("To try again press 1 and to return press 0");
            String press=scn.nextLine();
            clear();
            if(press.equals("1")){
                adminlogin();
            }
            else if(press.equals("0")){
                Homescreen();
            }
            else{
                System.out.println("Invalid value again , go try again");
                adminlogin();
            }
        }
    }

    public static void Receptionistlogin() {
        Receptionist rec=new Receptionist();
        Scanner scn=new Scanner(System.in);
        System.out.println("Hello there");
        System.out.print("Please enter password for receptionist : ");
        String password=scn.nextLine();
        clear();
        if(password.equals(Receptionist.getRec1Pw())){
            System.out.println("Hello "+Receptionist.getRec1());
            DateAndTime();
            receptionistPanel();
        }
        else if(password.equals(Receptionist.getRec2Pw())){
            System.out.println("Hello "+Receptionist.getRec2());
            DateAndTime();
            receptionistPanel();
        }
        else{
            System.out.println("Password is false ");
            System.out.println("To try again press 1 and to return press 0");
            String press=scn.nextLine();
            clear();
            if(press.equals("1")){
                Receptionistlogin();
            }
            else if(press.equals("0")){
                Homescreen();
            }
            else{
                System.out.println("The input is false ,so try again");
                Receptionistlogin();
            }
        }
    }
    
    
    
    //admins
    //=====================================================================================================================
    
    public static void adminPanel(){
            Scanner scn=new Scanner(System.in);
            System.out.println("");
            System.out.println("======================================================================================");
            System.out.println("++-------------======================================================---------------++");
            System.out.println("++-------------------------------|| Welcome Admin ||--------------------------------++");
            System.out.println("++-------------======================================================---------------++");
            System.out.println("======================================================================================");
            DateAndTime();
            System.out.println("\n                                      MAIN MENU");
            System.out.println("Press :");
            System.out.println("======================================================================================");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|          1.Doctors   2.Medicines  3.Laboratories  4.Facilities  5.Staffs           |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("======================================================================================");
            System.out.println("                          Disclaimer :Press 0 to return");
            String press=scn.nextLine();
            clear();
            
            if(press.equals("1")){
                DoctorPanelAdmin();
            }
            else if (press.equals("2")){
                medicineAdmin();
            }
            else if(press.equals("3")){
                labrotaryAdmin();
            }
            else if(press.equals("4")){
                facilitiesAdmin();
            }
            else if(press.equals("5")){
                staffAdmin();
            }
            else if(press.equals("0")){
                login();
            }
            else{
                System.out.println("The input is wrong, try again");
                adminPanel();
            }
            
            
    }  
    
    
    
    //Doctor part in admin
    private static void DoctorPanelAdmin() {
        Scanner scn=new Scanner(System.in);
        System.out.println("\nThis is the doctor panel for admin");
        System.out.println("");
        System.out.println("===================================================================================================");
        System.out.println("++---------------============================================================--------------------++");
        System.out.println("++-------------------------------------|| Doctor panel ||----------------------------------------++");
        System.out.println("++---------------============================================================--------------------++");
        System.out.println("===================================================================================================");
        System.out.println("\n                                             MENU");
        System.out.println("Press :");
        System.out.println("================================================================================================");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("|                         1.Add Doctors   2.View Doctors   3.Edit info                          |");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("================================================================================================");
        System.out.println("                                 Disclaimer :Press 0 to return");
        String press=scn.nextLine();
        clear();
        if(press.equals("1")){
            addDoctor();
        }
        else if (press.equals("2")){
            viewDoctor();
        }
        else if(press.equals("3")){
            editDoctor();
        }
        else if(press.equals("0")){
            adminPanel();
        }
        else{
            System.out.println("The input is wrong, try again");
            DoctorPanelAdmin();
        }    
        
    }
        
    private static void addDoctor() {
        System.out.println("Time to add doctors");
        Scanner s=new Scanner(System.in);
        System.out.println("If you want to continue press 1 to continue and  2 to go back ");
        String press1=s.next();
        if(press1.equals("1")){
            System.out.println("OK");
        }
        else if(press1.equals("2")){
            DoctorPanelAdmin();
        }
        else{
            System.out.println("The input is wrong, try again");
            addDoctor();
        }
        
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
        //take input
        
        Doctor d=new Doctor();
        System.out.println("Give a ID :");
        String id=s.next();
        if(StringisIntChecker(id,3)==true){
            if(isvalidId(n, id, count)==true){
                d.setId(id);
            }
            else{
                System.out.println("Wrong number ,try agin");
                addDoctor(); 
            }
        }
        else{
            System.out.println("Wrong number ,try agin");
            addDoctor();
        }
        
        System.out.println("Give a Name :");
        String name=s.next();
        d.setName(name);
        
        System.out.println("Give a contact number :");
        String contact=s.next();
        if(StringisIntChecker(contact,11)==true){
            d.setContact(contact);
        }
        else{
            System.out.println("Wrong number ,try agin");
            addDoctor();
        }
        
        System.out.println("Give  month digit   :");
        String mon=s.next();
        System.out.println("Give  day number    :");
        String day=s.next();
        System.out.println("Give  year          :");
        String year=s.next();
        String dob=day+"/"+mon+"/"+year;
        if(isValidDateOfBirth(day,mon, year)==true){
            d.setBirthdate(dob);
            d.setAge(calculateAge(day, mon, year));
        }
        else{
            System.out.println("Wrong input ,try agin");
            addDoctor();
        }
        
        System.out.println("Give blood type :");
        System.out.println("**USE CAPS**");
        String bloodtype=s.next();
        if(bloodtype.equals("A+") || bloodtype.equals("A-") || bloodtype.equals("B+") || bloodtype.equals("B-") || bloodtype.equals("AB+") || bloodtype.equals("AB-") || bloodtype.equals("O+") || bloodtype.equals("O-")){
            d.setBloodtype(bloodtype);
        }
        else{
            System.out.println("Wrong input ,try agin");
            addDoctor();
        }
        
        System.out.println("Assign gender :");
        System.out.println("Press :");
        System.out.println("1: Male  2:Female  3:Other");
        String gender=s.next();
        if(gender.equals("1") ){
            d.setGender("Male");
        }
        else if(gender.equals("2")){
            d.setGender("Female");
        }
        else if(gender.equals("3")){
            d.setGender("Other");
        }
        else{
            System.out.println("Wrong input ,try agin");
            addDoctor();
        }
        
        System.out.println("Press for the category of Specialization  falls into :");
        System.out.println("| Specialist |         1: Ortho       2:ENT          3:Surgery      4:Neurology      5:Cardiology     6:Dermatology ");
        System.out.println("| Salary (in BDT) |    -40,000        -45,000        -60,000        -50,000          -45,000           -40,000");
        System.out.println("| Qualification |      -MBBS,MS       -MBBS,FCPS,MS  -MBBS,FCPS     -MBBS,MD,FCPS    -MBBS,FCPS,MS     -MBBS,MS");
        String specR=s.next();
        if(specR.equals("1")){
            d.setDocSpecialty("Ortho");
            d.setSalary("40,000BDT");
            d.setDocQualification("MBBS,MS");
        }
        else if(specR.equals("2")){
            d.setDocSpecialty("ENT");
            d.setSalary("45,000BDT");
            d.setDocQualification("MBBS,FCPS,MS");
        }
        else if(specR.equals("3")){
            d.setDocSpecialty("Surgery");
            d.setSalary("60,000BDT");
            d.setDocQualification("MBBS,FCPS");
        }
        else if(specR.equals("4")){
            d.setDocSpecialty("Neurology");
            d.setSalary("50,000BDT");
            d.setDocQualification("MBBS,MD,FCPS");
        }
        else if(specR.equals("5")){
            d.setDocSpecialty("Cardiology");
            d.setSalary("45,000BDT");
            d.setDocQualification("MBBS,FCPS,MS");
        }
        else if(specR.equals("6")){
            d.setDocSpecialty("Dermatology");
            d.setSalary("40,000BDT");
            d.setDocQualification("MBBS,MS");
        }
        else{
            System.out.println("Wrong input ,try agin");
            addDoctor();
        }
        
        System.out.println("Assign duty time :");
        System.out.println("Press :");
        System.out.println("1:7am-3pm  2:3pm-11pm  3:11pm-7pm");
        String time=s.next();
        if(time.equals("1") ){
            d.setDocSchedule("7am-3pm");
        }
        else if(time.equals("2")){
            d.setDocSchedule("3pm-11pm");
        }
        else if(time.equals("3")){
            d.setDocSchedule("11pm-7pm");
        }
        else{
            System.out.println("Wrong input ,try agin");
            addDoctor();
        }
        
        
        d.add();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to admin panel");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            DoctorPanelAdmin();
        }
        else{
            adminPanel();
        }
    }

    private static void viewDoctor() {
        System.out.println("Time to view doctors");
        Scanner s=new Scanner(System.in);
        Doctor D=new Doctor();
        D.view();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to admin panel");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
             DoctorPanelAdmin();
        }
        else{
            adminPanel();
        }
    }

    private static void editDoctor() {
        System.out.println("Time to edit doctor information ");
        System.out.println("**WARNING YOU CAN'T GO BACK WITHOUT EDITING A SUBJECTS INFO** ");
        System.out.println("**BE CAUTIOUS**");
        Scanner s=new Scanner(System.in);
        System.out.println("If you want , press 1 to continue and  2 to go back ");
        String press1=s.next();
        if(press1.equals("1")){
            System.out.println("OK");
        }
        else if(press1.equals("2")){
            DoctorPanelAdmin();
        }
        else{
            System.out.println("The input is wrong, try again");
            editDoctor();
        }
        
        Doctor D=new Doctor();
        D.view();
        D.Edit();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to admin panel");
        String press2=s.next();
        if(press2.equals("1")){
            endProgramme();
        }
        else if(press2.equals("2")){
            DoctorPanelAdmin();
        }
        else{
            System.out.println("Taking you back to admin panel");
            adminPanel();
        }
    }
    //done
    
    
    //medicine part in admin
    private static void medicineAdmin() {
        Scanner scn=new Scanner(System.in);
        System.out.println("");
        System.out.println("This is the medicine panel for admin ");
        System.out.println("");
        System.out.println("===================================================================================================");
        System.out.println("++---------------============================================================--------------------++");
        System.out.println("++-------------------------------------||   Medicine  ||-----------------------------------------++");
        System.out.println("++---------------============================================================--------------------++");
        System.out.println("===================================================================================================");
        System.out.println("Press :");
        System.out.println("===================================================================================================");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("|                     1.Add Medicine       2.View Stock      3.Edit info                          |");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("===================================================================================================");
        System.out.println("                                 Disclaimer :Press 0 to return");
        String press=scn.nextLine();
        //clear
        if(press.equals("1")){
            addMedicine();
        }
        else if (press.equals("2")){
            viewStockAdmin();
        }
        else if(press.equals("3")){
            editMedicineInfo();
        }
        else if(press.equals("0")){
            adminPanel();
        }
        else{
            System.out.println("The input is wrong, try again");
            medicineAdmin();
        }
    }
    
    private static void addMedicine(){
        Scanner s=new Scanner(System.in);
        System.out.println("If you want to continue press 1 to continue and  2 to go back ");
        String press1=s.next();
        if(press1.equals("1")){
            System.out.println("OK");
        }
        else if(press1.equals("2")){
            medicineAdmin();
        }
        else{
            System.out.println("The input is wrong, try again");
            addMedicine();
        }
        
        //Scan
        File rfile=new File("Medicine.txt");
        String rMedName,rMedCompName,rMedExpiryDate,rMedAmount,rMedCost ;
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
        //
        System.out.println("Add a new medicine ");//obj
        Medicine m=new Medicine();
        
        System.out.println("Give Medicine Name :");
        String name=s.next();
        m.setMedName(name);
        if(isvalidName(n, name, count)==true){
            m.setMedName(name);
        }
        else{
        System.out.println("Wrong name ,try agin");
            addMedicine(); 
        }
        
        System.out.println("Give company name :");
        String company=s.next();
        m.setMedCompName(company);
        
        System.out.println("Give  month digit   :");
        String monR=s.next();
        System.out.println("Give  day number    :");
        String dayR=s.next();
        System.out.println("Give  year          :");
        String yearR=s.next();
        String expR=dayR+"/"+monR+"/"+yearR;
        if(isValidExpiryDate(dayR,monR, yearR)==true){
            m.setMedExpiryDate(expR);
        }
        else{
            System.out.println("Wrong input ,try agin");
            addMedicine();
        }
        
        System.out.println("Give a Amount :");
        String amount=s.next();
        if(StringisIntChecker(amount)==true){
            m.setMedAmount(amount);
        }
        else{
            System.out.println("Wrong number ,try agin");
            addMedicine();
        }
        
        System.out.println("Give cost :");
        String costR=s.next();
        if(StringisIntChecker(costR)==true){
            m.setMedCost(costR);
        }
        else{
        System.out.println("Wrong number ,try agin");
            addMedicine();
        }
        
        m.add();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to Admin panel");
        String press2=s.next();
        if(press2.equals("1")){
            endProgramme();
        }
        else if(press2.equals("2")){
            medicineAdmin();
        }
        else{
            System.out.println("Taking you back to Admin panel");
            adminPanel();
        }
    }

    private static void viewStockAdmin() {
        System.out.println("View the medicines and info of them here");
        Scanner s=new Scanner(System.in);
        Medicine m=new Medicine();
        m.view();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to Admin panel");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            medicineAdmin();
        }
        else{
            System.out.println("Taking you back to Admin panel");
            adminPanel();
        }
    }

    private static void editMedicineInfo() {
        System.out.println("Edit info of medicine here");
        System.out.println("Time to edit medicine information ");
        System.out.println("**WARNING YOU CAN'T GO BACK WITHOUT EDITING A SUBJECTS INFO** ");
        System.out.println("**BE CAUTIOUS**");
        Scanner s=new Scanner(System.in);
        System.out.println("If you want , press 1 to continue and  2 to go back ");
        String press1=s.next();
        if(press1.equals("1")){
            System.out.println("OK");
        }
        else if(press1.equals("2")){
            medicineAdmin();
        }
        else{
            System.out.println("The input is wrong, try again");
            editMedicineInfo();
        }
        
        Medicine m=new Medicine();
        m.view();
        m.Edit();
        m.view();
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to Admin panel");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            medicineAdmin();
        }
        else{
            System.out.println("Taking you back to Admin panel");
            adminPanel();
        }
    }
    //done
    
    
    //lab part in admin
    private static void labrotaryAdmin() {
        Scanner scn=new Scanner(System.in);
        System.out.println("\nThis is the labrotory panel  for admin ");
        System.out.println("");
        System.out.println("===================================================================================================");
        System.out.println("++---------------============================================================--------------------++");
        System.out.println("++-------------------------------------||  Lab & Test  ||----------------------------------------++");
        System.out.println("++---------------============================================================--------------------++");
        System.out.println("===================================================================================================");
        System.out.println("Press :");
        System.out.println("===================================================================================================");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("|             1.Add lab                 2.View lab details               3.Edit lab info          |");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("===================================================================================================");
        System.out.println("                                 Disclaimer :Press 0 to return");
        String press=scn.nextLine();
        
        if(press.equals("1")){
            addLab();
        }
        else if (press.equals("2")){
            viewLabDetailsAdmin();
        }
        else if(press.equals("3")){
            editLabInfo();
        }
        else if(press.equals("0")){
            adminPanel();
        }
        else{
            System.out.println("The input is wrong, try again");
            labrotaryAdmin();
        }
    }
    
    private static void addLab() {
        System.out.println("Add a new LAB here");
        Scanner s=new Scanner(System.in);
        System.out.println("If you want to continue press 1 to continue and  2 to go back ");
        String press1=s.next();
        if(press1.equals("1")){
            System.out.println("OK");
        }
        else if(press1.equals("2")){
            labrotaryAdmin();
        }
        else{
            System.out.println("The input is wrong, try again");
            addLab() ;
        }
        //Scan
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
        //
        Lab L=new Lab();
        
        System.out.println("Give LAB Name :");
        String name=s.next();
        L.setLabName(name);
        if(isvalidName(n, name, count)==true){
            L.setLabName(name);
        }
        else{
            System.out.println("Wrong name ,try agin");
            addLab();
        }
        
        
        System.out.println("Give  Amount :");
        String amount=s.next();
        if(StringisIntChecker(amount)==true){
            L.setLabAmount(amount);
        }
        else{
            System.out.println("Wrong number ,try agin");
            addLab();
        }
        
        System.out.println("Give cost :");
        String cost=s.next();
        if(StringisIntChecker(cost)==true){
            L.setLabTestCost(cost);
        }
        else{
            System.out.println("Wrong number ,try agin");
            addLab();
        }
        
        L.add();
        
        System.out.println("LAB ADDED");
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to Admin panel");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            labrotaryAdmin();
        }
        else{
            System.out.println("Taking you back to Admin panel");
            adminPanel();
        }
    }

    private static void viewLabDetailsAdmin() {
        Scanner s=new Scanner(System.in);
        System.out.println("view lab details here");
        Lab L=new Lab();
        L.view();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to Admin panel");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            labrotaryAdmin();
        }
        else{
            System.out.println("Taking you back to Admin panel");
            adminPanel();
        }
    }

    private static void editLabInfo() {
        System.out.println("Edit info of LAB here");
        System.out.println("**WARNING YOU CAN'T GO BACK WITHOUT EDITING A SUBJECTS INFO** ");
        System.out.println("**BE CAUTIOUS**");
        Scanner s=new Scanner(System.in);
        System.out.println("If you want , press 1 to continue and  2 to go back ");
        String press1=s.next();
        if(press1.equals("1")){
            System.out.println("OK");
        }
        else if(press1.equals("2")){
            labrotaryAdmin();
        }
        else{
            System.out.println("The input is wrong, try again");
            editLabInfo();
        }
        
        Lab L=new Lab();
        L.view();
        L.Edit();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to Admin panel");
        String press2=s.next();
        if(press2.equals("1")){
            endProgramme();
        }
        else if(press2.equals("2")){
            labrotaryAdmin();
        }
        else{
            System.out.println("Taking you back to Admin panel");
            adminPanel();
        }
    }
    //done
    
    
    //facilities part in admin
    private static void facilitiesAdmin() {
        Scanner scn=new Scanner(System.in);
        System.out.println("\n This is the Facility panel");
        System.out.println("");
        System.out.println("===================================================================================================");
        System.out.println("++---------------============================================================--------------------++");
        System.out.println("++---------------------------------|| Hospital facilities ||-------------------------------------++");
        System.out.println("++---------------============================================================--------------------++");
        System.out.println("===================================================================================================");
        System.out.println("Press :");
        System.out.println("===================================================================================================");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("|          1.Add Facility              2.View Facilities              3.Edit Facility Info        |");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("===================================================================================================");
        System.out.println("                                 Disclaimer :Press 0 to return");
        String press=scn.nextLine();
        //clear
        if(press.equals("1")){
            addFacility();
        }
        else if (press.equals("2")){
            viewFacilitiesAdmin();
        }
        else if(press.equals("3")){
            editFacilityInfo();
        }
        else if(press.equals("0")){
            adminPanel();
        }
        else{
            System.out.println("The input is wrong, try again");
            facilitiesAdmin();
        }
    }
    
    private static void addFacility() {
        Scanner s=new Scanner(System.in);
        System.out.println("If you want to continue press 1 to continue and  2 to go back ");
        String press1=s.next();
        if(press1.equals("1")){
            System.out.println("OK");
        }
        else if(press1.equals("2")){
            facilitiesAdmin();
        }
        else{
            System.out.println("The input is wrong, try again");
            addFacility();
        }
        
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
        
        System.out.println("Add facility");
        Facility f=new Facility();
        
        System.out.println("Give a Name :");
        String name=s.next();
        if(isvalidName(n, name, count)==true){
            f.setFacName(name);
        }
        else{
        System.out.println("Wrong name ,try agin");
            addFacility(); 
        }
        
        System.out.println("Give a Number :");
        String amount=s.next();
        if(StringisIntChecker(amount)==true){
            f.setAmount(amount);
        }
        else{
        System.out.println("Wrong number ,try agin");
            addFacility();
        }
        System.out.println("Give yes or no for availability:");
        System.out.println("Write yes or no in lower case : ");
        System.out.println("1: Yes    2:No ");
        String availabilty=s.next();
        if(availabilty.equals("yes")){
            f.setFacAvailabilty(availabilty);
        }
        else if(availabilty.equals("no")){
            f.setFacAvailabilty(availabilty);
        }
        else{
            addFacility();
        }
        
        f.add();
        f.view();
        System.out.println("FACILITY      ADDED");
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to Admin panel");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            facilitiesAdmin();
        }
        else{
            System.out.println("Taking you back to Admin panel");
            adminPanel();
        }
        
    }

    private static void viewFacilitiesAdmin() {
        Scanner s=new Scanner(System.in);
        System.out.println("View all faciliites");
        Facility f=new Facility();
        f.view();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("Press anything else to go back to Admin panel");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            facilitiesAdmin();
        }
        else{
            System.out.println("Taking you back to Admin panel");
            adminPanel();
        }
    }

    private static void editFacilityInfo() {
        System.out.println("Edit info of Facility here");
        System.out.println("**WARNING YOU CAN'T GO BACK WITHOUT EDITING A SUBJECTS INFO** ");
        System.out.println("**BE CAUTIOUS**");
        Scanner s=new Scanner(System.in);
        System.out.println("If you want , press 1 to continue and  2 to go back ");
        String press1=s.next();
        if(press1.equals("1")){
            System.out.println("OK");
        }
        else if(press1.equals("2")){
            facilitiesAdmin();
        }
        else{
            System.out.println("The input is wrong, try again");
            editFacilityInfo();
        }
        
        Facility f=new Facility();
        
        f.view();
        
        f.Edit();
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to Admin panel");
        String press2=s.next();
        if(press2.equals("1")){
            endProgramme();
        }
        else if(press2.equals("2")){
            facilitiesAdmin();
        }
        else{
            System.out.println("Taking you back to Admin panel");
            adminPanel();
        }
    }
    //done
    
    
    //staff part in admin
    private static void staffAdmin() {
        Scanner scn=new Scanner(System.in);
        System.out.println("\nThis is the staff panel");
        System.out.println("");
        System.out.println("===================================================================================================");
        System.out.println("++------------------===========================================================------------------++");
        System.out.println("++---------------------------------------|| Staff panel ||---------------------------------------++");
        System.out.println("++------------------===========================================================------------------++");
        System.out.println("===================================================================================================");
        System.out.println("Press :");
        System.out.println("===================================================================================================");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("|              1.Add Staff                2.View Staff              3.Edit Staff Info             |");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("===================================================================================================");
        System.out.println("                                 Disclaimer :Press 0 to return");
        String press=scn.nextLine();
        //clear
        if(press.equals("1")){
            addStaff();
        }
        else if (press.equals("2")){
            viewStaffAdmin();
        }
        else if(press.equals("3")){
            editStaffInfo();
        }
        else if(press.equals("0")){
            adminPanel();
        }
        else{
            System.out.println("The input is wrong, try again");
            staffAdmin();
        }
    }
    
    private static void addStaff() {
        System.out.println("Add staff here");
        Scanner s=new Scanner(System.in);
        System.out.println("If you want to continue press 1 to continue and  2 to go back ");
        String press1=s.next();
        if(press1.equals("1")){
            System.out.println("OK");
        }
        else if(press1.equals("2")){
            staffAdmin();
        }
        else{
            System.out.println("The input is wrong, try again");
            addStaff();
        }
        
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
        
        Staff stf=new Staff();
        //taking inputs
        System.out.println("Give a ID :");
        String idR=s.next();
        if(StringisIntChecker(idR,3)==true){
            if(isvalidId(n, idR, count)==true){
                stf.setId(idR);
            }
            else{
                System.out.println("Wrong number ,try agin");
                addStaff(); 
            }
        }
        else{
            System.out.println("Wrong number ,try agin");
            addStaff(); 
        }
        
        System.out.println("Give a Name :");
        String nameR=s.next();
        stf.setName(nameR);
        
        System.out.println("Give a contact number :");
        String contactR=s.next();
        if(StringisIntChecker(contactR,11)==true){
            stf.setContact(contactR);
        }
         else{
            System.out.println("Wrong number ,try agin");
            addStaff();
        }
        
        System.out.println("Give  month digit   :");
        String monR=s.next();
        System.out.println("Give  day number    :");
        String dayR=s.next();
        System.out.println("Give  year          :");
        String yearR=s.next();
        String dobR=dayR+"/"+monR+"/"+yearR;
        if(isValidDateOfBirth(dayR,monR, yearR)==true){
            stf.setBirthdate(dobR);
            stf.setAge(calculateAge(dayR, monR, yearR));
        }
        else{
            System.out.println("Wrong input ,try agin");
            addStaff();
        }
        
        System.out.println("Give blood type :");
        System.out.println("**USE CAPS**");
        String bloodtypeR=s.next();
        if(bloodtypeR.equals("A+") || bloodtypeR.equals("A-") || bloodtypeR.equals("B+") || bloodtypeR.equals("B-") || bloodtypeR.equals("AB+") || bloodtypeR.equals("AB-") || bloodtypeR.equals("O+") || bloodtypeR.equals("O-")){
            stf.setBloodtype(bloodtypeR);
        }
        else{
            System.out.println("Wrong input ,try agin");
            addStaff();
        }
        
        System.out.println("Assign gender :");
        System.out.println("Press :");
        System.out.println("*1: Male  2:Female  3:Other");
        String genderR=s.next();
        if(genderR.equals("1") ){
            stf.setGender("Male");
        }
        else if(genderR.equals("2")){
            stf.setGender("Female");
        }
        else if(genderR.equals("3")){
            stf.setGender("Other");
        }
        else{
            System.out.println("Wrong input ,try agin");
            addStaff();
        }
        
        System.out.println("Press for the category the specialty  falls into :");
        System.out.println("| Employee position |  1:Nurse       2:Pharmacist       3:Ward boy       4:Cleaner       5:Guard ");
        System.out.println("| Salary (in BDT) |    -20,000       -15,000            -10,000          -10,000         -15,000");
        String specR=s.next();
        if(specR.equals("1")){
            stf.setStfSpecialty("Nurse");
            stf.setStfSalary("20,000BDT");
        }
        else if(specR.equals("2")){
            stf.setStfSpecialty("Pharmacist");
            stf.setStfSalary("15,000BDT");
        }
        else if(specR.equals("3")){
            stf.setStfSpecialty("Wardboy");
            stf.setStfSalary("10,000BDT");
        }
        else if(specR.equals("4")){
            stf.setStfSpecialty("Cleaner");
            stf.setStfSalary("10,000BDT");
        }
        else if(specR.equals("5")){
            stf.setStfSpecialty("Guard");
            stf.setStfSalary("15,000BDT");
        }
        else{
            System.out.println("Wrong input ,try agin");
            addStaff();
        }
        System.out.println("Assign duty time :");
        System.out.println("Press :");
        System.out.println("1:7am-3pm  2:3pm-11pm  3:11pm-7pm");
        String timeR=s.next();
        if(timeR.equals("1") ){
            stf.setStfSchedule("7am-3pm");
        }
        else if(timeR.equals("2")){
            stf.setStfSchedule("3pm-11pm");
        }
        else if(timeR.equals("3")){
            stf.setStfSchedule("11pm-7pm");
        }
        else{
        System.out.println("Wrong input ,try agin");
            addStaff();
        }
        
        stf.add();
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to admin panel");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            staffAdmin();
        }
        else{
            adminPanel();
        }
        
    }

    private static void viewStaffAdmin() {
        Scanner s=new Scanner(System.in);
        System.out.println("View  all staffs");
        
        
        Staff stf=new Staff();
        stf.view();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to admin panel");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            staffAdmin();
        }
        else{
            adminPanel();
        }
    }

    private static void editStaffInfo() {
        System.out.println("Edit information of a staff ");
        System.out.println("**WARNING YOU CAN'T GO BACK WITHOUT EDITING A SUBJECTS INFO** ");
        System.out.println("**BE CAUTIOUS**");
        Scanner s=new Scanner(System.in);
        System.out.println("If you want , press 1 to continue and  2 to go back ");
        String press1=s.next();
        if(press1.equals("1")){
            System.out.println("OK");
        }
        else if(press1.equals("2")){
            staffAdmin();
        }
        else{
            System.out.println("The input is wrong, try again");
            editStaffInfo();
        }
        
        Staff stf=new Staff();
        stf.view();
        stf.Edit();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to admin panel");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            staffAdmin();
        }
        else{
            adminPanel();
        }
    }
    //done
    
    
    
    //receptionists
    //==================================================================================================================================================
     
    public static void receptionistPanel(){
            Scanner scn=new Scanner(System.in);
            System.out.println("");
            System.out.println("=========================================================================================");
            System.out.println("++-------------==============================================================----------++");
            System.out.println("++-----------------------------|| Welcome Receptionist ||------------------------------++");
            System.out.println("++-------------==============================================================----------++");
            System.out.println("=========================================================================================");
            DateAndTime();
            System.out.println("\n                                   RECEPTIONIST MENU");
            System.out.println("Press :");
            System.out.println("=========================================================================================");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("|             1.Patient              2.Doctor info           3.Staff info               |");
            System.out.println("|             4.Lab info             5.Facility info         6.Medicine info            |");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("=========================================================================================");
            System.out.println("                          Disclaimer :Press 0 to return");
            String press=scn.nextLine();
        
            clear();
            if(press.equals("1")){
                patientReceptionist();
            }
            else if (press.equals("2")){
                viewDoctorReceptionist();
            }                
            else if(press.equals("3")){
                viewStaffReceptionst();
            }
            else if(press.equals("4")){
                viewLabInfoReceptionist();
            }
            else if (press.equals("5")){
                viewFacilitiesReceptionist();
            }                
            else if(press.equals("6")){
                viewMedicineReceptionist();
            }
            else if(press.equals("0")){
                login();
            }
            else{
                System.out.println("The input is wrong, try again");
                receptionistPanel();
            }
            
    } 
    
    private static void viewDoctorReceptionist() {
        System.out.println("Time to view doctors");
        Scanner s=new Scanner(System.in);
        Doctor D=new Doctor();
        D.view();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to admin panel");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            receptionistPanel();
        }
        else{
            receptionistPanel();
        } 
    }
    
    
    
    private static void patientReceptionist() {
        Scanner scn=new Scanner(System.in);
        System.out.println("Patient panel for receptionist :");
        System.out.println("");
        System.out.println("===================================================================================================");
        System.out.println("++---------------============================================================--------------------++");
        System.out.println("++-------------------------------------|| Patient Panel  ||----------------------------------------++");
        System.out.println("++---------------============================================================--------------------++");
        System.out.println("===================================================================================================");
        System.out.println("\n                                             MENU");
        System.out.println("Press :");
        System.out.println("================================================================================================");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("|------|   1: View Patient   2:ADD Patient    3:Edit Patient   4:Appointment Schedule   |------|");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("================================================================================================");
        System.out.println("                                 Disclaimer :Press 0 to return");
        String press=scn.nextLine();
        clear();
        if(press.equals("1")){
            viewPatientReceptionst();
        }
        else if (press.equals("2")){
            addPatientReceptionist();
        }
        else if(press.equals("3")){
            editPatientReceptionist();
        }
        else if(press.equals("4")){
            editPatientAppointment();
        }
        else if(press.equals("0")){
            receptionistPanel();
        }
        else{
            System.out.println("The input is wrong, try again");
            patientReceptionist();
        } 
    }
    private static void viewPatientReceptionst() {
        Scanner s=new Scanner(System.in);
        System.out.println("View Patients details here");
        Patient p=new Patient();
        p.view();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to Receptionist panel");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            patientReceptionist();
        }
        else{
            receptionistPanel();
        }
    }
    private static void addPatientReceptionist() {
        Scanner s=new Scanner(System.in);
        System.out.println("If you want to continue press 1 to continue and  2 to go back ");
        String press1=s.next();
        if(press1.equals("1")){
            System.out.println("OK");
        }
        else if(press1.equals("2")){
            patientReceptionist();
        }
        else{
            System.out.println("The input is wrong, try again");
            addPatientReceptionist();
        }
        
        //scan to see for ID
        File rfile=new File("Patient.txt");
        String  rId , rName , rAge , rContact , rcoDiseases , rAssignedDoc , rAppointTime , rBirthDate , rBloodType , rGender ;
        int count=0;
        Patient[] n=new Patient[100];
        //read and put in obj
        try{
            Scanner r=new Scanner(rfile);
            int i=0;
            while(r.hasNext()){
                rId=r.next();   rName=r.next();  rAge=r.next();  rContact=r.next(); rBirthDate = r.next();  rBloodType=r.next();    rGender=r.next();   rcoDiseases=r.next();   rAssignedDoc=r.next();  rAppointTime=r.next();
                n[i]=new Patient(rcoDiseases, rAssignedDoc,rAppointTime, rId, rName,rAge, rContact, rBirthDate, rBloodType, rGender);
                i++;
            }
            count=i;
            r.close();
        }catch(Exception e){
            System.out.println("There is an error ");
        }
        //
        System.out.println("Add Patient");
        Patient p=new Patient();
        
        System.out.println("Give a ID :");
        String id=s.next();
        if(StringisIntChecker(id,3)==true){
            if(isvalidId(n, id, count)==true){
                p.setId(id);
            }
            else{
                System.out.println("Wrong number ,try agin");
                addPatientReceptionist(); 
            }
        }
        else{
        System.out.println("Wrong number ,try agin");
            addPatientReceptionist();
        }
        
        System.out.println("Give a Name :");
        String name=s.next();
        p.setName(name);
        
        System.out.println("Give a contact number :");
        String contact=s.next();
        if(StringisIntChecker(contact,11)==true){
            p.setContact(contact);
        }
        else{
        System.out.println("Wrong number ,try agin");
            addPatientReceptionist();
        }
        
        System.out.println("Give  month digit   :");
        String mon=s.next();
        System.out.println("Give  day number    :");
        String day=s.next();
        System.out.println("Give  year          :");
        String year=s.next();
        String dob=day+"/"+mon+"/"+year;
        if(isValidDateOfBirth(day,mon, year)==true){
            p.setBirthdate(dob);
            p.setAge(calculateAge(day, mon, year));
        }
        else{
            System.out.println("Wrong input ,try agin");
            addPatientReceptionist();
        }
        
        System.out.println("Give blood type :");
        System.out.println("**USE CAPS**");
        String bloodtype=s.next();
        if(bloodtype.equals("A+") || bloodtype.equals("A-") || bloodtype.equals("B+") || bloodtype.equals("B-") || bloodtype.equals("AB+") || bloodtype.equals("AB-") || bloodtype.equals("O+") || bloodtype.equals("O-")){
            p.setBloodtype(bloodtype);
        }
        else{
            System.out.println("Wrong input ,try agin");
            addPatientReceptionist();
        }
        
        System.out.println("Press :");
        System.out.println("*1: Male  2:Female  3:Other");
        String genderR=s.next();
        if(genderR.equals("1") ){
            p.setGender("Male");
        }
        else if(genderR.equals("2")){
            p.setGender("Female");
        }
        else if(genderR.equals("3")){
            p.setGender("Other");
        }
        else{
            System.out.println("Wrong input ,try agin");
            addPatientReceptionist();
        }
        
        System.out.println("Press for the category the illness falls into :");
        System.out.println("*1: Artho  2:ENT  3:Surgery  4:Neurology  5:Cardiology  6:Dermatology ");
        String codiseaseR=s.next();
        if(codiseaseR.equals("1")){
            p.setcoDiseases("Artho");
        }
        else if(codiseaseR.equals("2")){
            p.setcoDiseases("ENT");
        }
        else if(codiseaseR.equals("3")){
            p.setcoDiseases("Surgery");
        }
        else if(codiseaseR.equals("4")){
            p.setcoDiseases("Neurology");
        }
        else if(codiseaseR.equals("5")){
            p.setcoDiseases("Cardiology");
        }
        else if(codiseaseR.equals("6")){
            p.setcoDiseases("Dermatology ");
        }
        else{
            System.out.println("Wrong input ,try agin");
            addPatientReceptionist();
        }
        
        p.add();
        System.out.println("Patient added ");
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to Receptionist panel");
        String press2=s.next();
        if(press2.equals("1")){
            endProgramme();
        }
        else if(press2.equals("2")){
            patientReceptionist();
        }
        else{
            System.out.println("Taking you back to Receptionist panel");
            receptionistPanel();
        }
        
    }
    private static void editPatientReceptionist() {
        System.out.println("**WARNING YOU CAN'T GO BACK WITHOUT EDITING A SUBJECTS INFO** ");
        System.out.println("**BE CAUTIOUS**");
        Scanner s=new Scanner(System.in);
        System.out.println("If you want , press 1 to continue and  2 to go back ");
        String press1=s.next();
        if(press1.equals("1")){
            System.out.println("OK");
        }
        else if(press1.equals("2")){
            patientReceptionist();
        }
        else{
            System.out.println("The input is wrong, try again");
            editPatientReceptionist();
        }
        
        Patient p=new Patient();
        p.view();
        p.Edit();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to Receptionist panel");
        String press2=s.next();
        if(press2.equals("1")){
            endProgramme();
        }
        else if(press2.equals("2")){
            patientReceptionist();
        }
        else{
            System.out.println("Taking you back to Receptionist panel");
            receptionistPanel();
        }
    }
    private static void editPatientAppointment() {
        Scanner s=new Scanner(System.in);
        Patient p=new Patient();
        System.out.println("Give id of patient to search and set appointment ");
        String id=s.next();
        p.setAppointTime(id);
        
        System.out.println("DONE ");
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to Receptionist panel");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            patientReceptionist();
        }
        else{
            receptionistPanel();
        }
        
    }
    //done
    
    private static void viewStaffReceptionst() {
        Scanner s=new Scanner(System.in);
        System.out.println("View  all staffs");
        
        
        Staff stf=new Staff();
        stf.view();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        System.out.println("press anything else to go back to admin panel");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            receptionistPanel();
        }
        else{
            viewStaffReceptionst();
        }
    }
    private static void viewLabInfoReceptionist() {
        Scanner s=new Scanner(System.in);
        System.out.println("view lab details here");
        Lab L=new Lab();
        L.view();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            receptionistPanel();
        }
        else{
            viewLabInfoReceptionist();
        }
    }
    private static void viewMedicineReceptionist() {
        System.out.println("View the medicines and info of them here");
        Scanner s=new Scanner(System.in);
        Medicine m=new Medicine();
        m.view();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            receptionistPanel();
        }
        else{
            viewMedicineReceptionist();
        }
    }
    private static void viewFacilitiesReceptionist() {
        Scanner s=new Scanner(System.in);
        System.out.println("View all faciliites");
        Facility f=new Facility();
        f.view();
        
        System.out.println("press");
        System.out.println("1:End programme     2.Go back");
        String press=s.next();
        if(press.equals("1")){
            endProgramme();
        }
        else if(press.equals("2")){
            receptionistPanel();
        }
        else{
            viewFacilitiesReceptionist();
        }
    }
    //done
    
    //======================================================================================================================
    //extra

    private static boolean StringisIntChecker(String str){
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
    private static boolean StringisIntChecker(String str,int num){
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

    //for date of birth
    private static boolean isValidDateOfBirth(String day, String month, String year) {
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
    
    
    //valid name check
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
