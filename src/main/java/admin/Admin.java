package admin;

import owner.*;
import tenant.*;

import java.util.ArrayList;
import java.util.List;



public class Admin {

    private String username;
    private String password;
    private List<Owner> owners = new ArrayList<>();
    private final List<Tenant> tenantsRequest = new ArrayList<>();


    public void setPassword(String password) {this.password = password;}
    public void setUsername(String username) {this.username = username;}
    public void setOwners(List<Owner> owners) {this.owners = owners;}
    public void setOwner(Owner o){owners.add(o);}
    public void setTenantRequest(Tenant t) {tenantsRequest.add(t);}

    public String getPassword() {return password;}
    public String getUsername() {return username;}
    public List<Owner> getOwners() {return owners;}
    public List<Tenant> getTenantsRequest() {return tenantsRequest;}
}
