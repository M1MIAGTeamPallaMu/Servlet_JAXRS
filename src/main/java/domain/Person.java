package domain;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Person {
    /**
     * Person's devices
     */
    private List<ElectronicDevice> devices;
    /**
     *
     */
    private List<Person> friends;
    /**
     *
     */
    private List<Home> homes;
    /**
     *
     */
    private int id;

    /**
     *
     */
    private String name;
    /**
     *
     */
    private String surname;
    /**
     *
     */
    private String mail;

    public Person(){

    }

    public Person(String name, String surname, String mail){
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.devices = new ArrayList<ElectronicDevice>();
        this.homes = new ArrayList<Home>();
        this.friends = new ArrayList<Person>();
    }

    @JsonIgnore
    @OneToMany(targetEntity = ElectronicDevice.class, fetch=FetchType.LAZY)
    public List<ElectronicDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<ElectronicDevice> devices) {
        this.devices = devices;
    }

    @JsonIgnore
    @ManyToMany(targetEntity = Person.class, fetch=FetchType.LAZY)
    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    @JsonManagedReference
    @OneToMany(targetEntity = Home.class)
    public List<Home> getHomes() {
        return homes;
    }

    public void setHomes(List<Home> homes) {
        this.homes = homes;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void addDevices(ElectronicDevice...devices){
        Collections.addAll(this.devices, devices);
    }

    @Transient
    public void addHomes(Home...homes){
        Collections.addAll(this.homes, homes);
    }

    @Transient
    public void addFriends(Person...friends){
        Collections.addAll(this.friends, friends);
    }

}
