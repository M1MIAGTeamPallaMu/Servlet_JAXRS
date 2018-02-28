package domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Home {

  private Address homeAddress;
  private List<Heater> heaters;
  private int homeId;
  private int size;
  private int rooms;

  public Home() {

  }

  public Home(int size, int rooms, Address homeAddress) {
    this.size = size;
    this.rooms = rooms;
    this.homeAddress = homeAddress;
    this.heaters = new ArrayList<Heater>();
  }

  @Id
  @GeneratedValue
  public int getHomeId() {
    return this.homeId;
  }

  public void setHomeId(int homeId) {
    this.homeId = homeId;
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
