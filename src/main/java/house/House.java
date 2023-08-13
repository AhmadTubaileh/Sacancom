package house;

import tenant.*;
import java.util.ArrayList;
import java.util.List;

public class House {
    private final ArrayList<Tenant> tenantsArrayList =new ArrayList<>();
    private boolean isHouseStudent ;
    private String houseName ;
    private String street;
    private String floors;
    private final List<String> photosLink=new ArrayList<>();
    private String price;
    private String location;
    private String availableServices ;

    public void setPhotosLink(String p){photosLink.add(p);}
    public void setAvailableServices(String availableServices) {this.availableServices = availableServices;}
    public void setFloors(String floors) {this.floors = floors;}
    public void setHouseName(String houseName) {this.houseName = houseName;}
    public void setIsHouseStudent(boolean houseStudent) {isHouseStudent = houseStudent;}
    public void setLocation(String location) {this.location = location;}
    public void setPrice(String price) {this.price = price;}
    public void setStreet(String street) {this.street = street;}



    public List<String> getPhotosLink() {return photosLink;}
    public List<Tenant> getTenantsArrayList() {return tenantsArrayList;}
    public String getAvailableServices() {return availableServices;}
    public String getFloors() {return floors;}
    public String getHouseName() {return houseName;}
    public String getLocation() {return location;}
    public String getPrice() {return price;}
    public String getStreet() {return street;}
    public boolean isHouseStudent() {return isHouseStudent;}
    public Tenant getTenant(int index){return tenantsArrayList.get(index);}
}
