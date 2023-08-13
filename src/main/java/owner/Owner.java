package owner;
import house.*;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    private String userName;
    private String password;
    private String information;
    private String name;
    private final List<House> houseRequests = new ArrayList<>();
    private final List<House> houses = new ArrayList<>();


//............................. functions
    public void setInformation(String info) {information = info;}
    public void setUserName(String username) {this.userName = username;}
    public void setPassword(String password) {this.password = password;}
    public void setHouses(House house) {houses.add(house);}
    public void setName(String name) {this.name = name;}
    public void setHouseRequest(House house){houseRequests.add(house);}
    public void removeHouseRequest(int index){houseRequests.remove(index);}

    public String getUserName() {return userName;}
    public String getPassword() {return password;}
    public String getInformation() {return information;}
    public List<House> getHouses(){return houses;}
    public House getHouse(int index){return houses.get(index);}
    public String getName() {return name;}
    public List<House> getHouseRequests() {return houseRequests;}
    public House getHouseRequest(int index){return houseRequests.get(index);}
}


