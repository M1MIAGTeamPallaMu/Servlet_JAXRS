package domain;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Home {
    /**
     *
     */
    private Address homeAddress;

    /**
     * heaters in the house
     */
    private List<Heater> heaters;
    /**
     * home id
     */
    private int homeID;
    /**
     *
     */
    private int size;

    /**
     *
     */
    private int rooms;

    public Home(){

    }

    public Home(int size, int rooms, Address homeAddress){
        this.size = size;
        this.rooms = rooms;
        this.homeAddress = homeAddress;
        this.heaters = new ArrayList<Heater>();
    }

    @Id
    @GeneratedValue
    public int getHomeID() {
        return this.homeID;
    }

    public void setHomeID(int homeID) {
        this.homeID = homeID;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRooms() {
        return this.rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    @JsonIgnore
    @OneToMany(targetEntity = Heater.class)
    public List<Heater> getHeaters() {
        return this.heaters;
    }

    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }

    @OneToOne(targetEntity = Address.class)
    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
}
