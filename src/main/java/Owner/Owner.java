package Owner;
import java.util.ArrayList;

public class Owner {
private ArrayList<String> photosLink;
private String userName;
private String password;
private String information;
    public Owner(){

    }
    public void addPhoto(String photo){
        photosLink.add(photo);
    }
    public void setInformation(String info){
        information = info;
    }
    public void setUserName(String username){this.userName = username;}
    public void setPassword(String password){this.password = password;}
    public void setPhotosLink(ArrayList<String> photos){this.photosLink=photos;}
    public String getUserName(){return userName;}
    public String getPassword(){return password;}
    public String getInformation(){return information;}



}
