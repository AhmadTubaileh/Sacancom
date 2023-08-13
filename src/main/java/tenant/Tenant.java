package tenant;

import house.*;
import owner.*;

public class Tenant {
    private String username;
    private String password;
    private String information;
    private String name;
    private String major;
    private String age;
    private String usedFurniture;
    private Owner owner;
    private House house;
    private boolean isStudent;
    private boolean isBooked;
    private boolean hasFurniture;



    public String getPassword() {return password;}
    public String getUsername() {return username;}
    public String getInformation() {return information;}
    public boolean isStudent() {return isStudent;}
    public String getMajor() {return major;}
    public String getAge() {return age;}
    public boolean isBooked() {return isBooked;}
    public Owner getOwner() {return owner;}
    public House getHouse() {return house;}
    public String getName() {return name;}
    public String getUsedFurniture() {return usedFurniture;}
    public boolean isHasFurniture() {return hasFurniture;}



    public void setPassword(String password) {this.password = password;}
    public void setUsername(String username) {this.username = username;}
    public void setInformation(String information) {this.information = information;}
    public void setStudent(boolean student) {isStudent = student;}
    public void setAge(String age) {this.age = age;}
    public void setMajor(String major) {this.major = major;}
    public void setBooked(boolean booked) {isBooked = booked;}
    public void setOwner(Owner owner) {this.owner = owner;}
    public void setHouse(House house) {this.house = house;}
    public void setName(String name) {this.name = name;}
    public void setUsedFurniture(String usedFurniture) {this.usedFurniture = usedFurniture;}
    public void setHasFurniture(boolean hasFurniture) {this.hasFurniture = hasFurniture;}


    public Tenant(){
        isStudent=false;
        isBooked=false;
        hasFurniture=false;
        owner=new Owner();
        house = new House();
        usedFurniture="\n";
    }

}
