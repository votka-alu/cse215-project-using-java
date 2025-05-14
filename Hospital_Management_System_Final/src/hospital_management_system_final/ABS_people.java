package hospital_management_system_final;


import java.util.Scanner;


public abstract class ABS_people {
    private String Id;
    private String Name;
    private String Age;
    private String Contact;
    private String Birthdate;
    private String Bloodtype;
    private String Gender;
    Scanner s=new Scanner(System.in);

    public ABS_people() {
        this.Id = "Null";
        this.Name = "Null";
        this.Age = "Null";
        this.Contact = "Null";
        this.Birthdate = "Null";
        this.Bloodtype = "Null";
        this.Gender = "Null";
    }
    
    
    
    public ABS_people(String Id, String Name, String Age, String Contact, String Birthdate, String Bloodtype, String gender) {
        this.Id = Id;
        this.Name = Name;
        this.Age = Age;
        this.Contact = Contact;
        this.Birthdate = Birthdate;
        this.Bloodtype = Bloodtype;
        this.Gender = gender;
    }
//getter
    public String getId() {
        return Id;
    }
    public String getName() {
        return Name;
    }
    public String getAge() {
        return Age;
    }
    public String getContact() {
        return Contact;
    }
    public String getBirthdate() {
        return Birthdate;
    }
    public String getBloodtype() {
        return Bloodtype;
    }
    public String getGender() {
        return Gender;
    }
//setter
    public void setId(String Id) {
        this.Id = Id;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setAge(String Age) {
        this.Age = Age;
    }
    public void setContact(String Contact) {
        this.Contact = Contact;
    }
    public void setBirthdate(String Birthdate) {
        this.Birthdate = Birthdate;
    }
    public void setBloodtype(String Bloodtype) {
        this.Bloodtype = Bloodtype;
    }
    public void setGender(String gender) {
        this.Gender=gender;
    }

    @Override
    public String toString() {
        return "ABS_people{" + "Id=" + Id + ", Name=" + Name + ", Age=" + Age + ", Contact=" + Contact + ", Birthdate=" + Birthdate + ", Bloodtype=" + Bloodtype + ", Gender=" + Gender + ", s=" + s + '}';
    }
  
}
