package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ElectronicDevice extends SmartDrivers {

  private int id;
  private String device;

  private int watts;

  public ElectronicDevice() {
  }

  public ElectronicDevice(String device, int watts) {
    this.device = device;
    this.watts = watts;
  }

  @Id
  @GeneratedValue
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getWatts() {
    return watts;
  }

  public void setWatts(int watts) {
    this.watts = watts;
  }

  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }
}
