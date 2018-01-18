package jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Home {
    /**
     * House owner
     */
    private Person owner;

    /**
     * heaters in the house
     */
    private List<Heater> heaters;
    /**
     * home id
     */
    private long homeID;

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
    public Home(int size, int rooms, Person owner){
        this.size = size;
        this.rooms = rooms;
        this.owner = owner;
        this.heaters = new ArrayList<Heater>();
    }

    @ManyToOne
    public Person getOwner() {
        return this.owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Id
    @GeneratedValue
    public long getHomeID() {
        return this.homeID;
    }

    public void setHomeID(long homeID) {
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

    @OneToMany(mappedBy = "home")
    public List<Heater> getHeaters() {
        return this.heaters;
    }

    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }
}
