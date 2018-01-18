package jpa;

import javax.persistence.*;
import java.util.ArrayList;
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
    private long id;

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

    @OneToMany(mappedBy = "p")
    public List<ElectronicDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<ElectronicDevice> devices) {
        this.devices = devices;
    }

    @ManyToMany
    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "owner")
    public List<Home> getHomes() {
        return homes;
    }

    public void setHomes(List<Home> homes) {
        this.homes = homes;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
