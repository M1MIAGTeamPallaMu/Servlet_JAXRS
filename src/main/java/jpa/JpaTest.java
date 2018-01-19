package jpa;
import domain.ElectronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;

import javax.persistence.*;

public class JpaTest {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		GenTestDAO dao = new GenTestDAO(manager);
		Person p = new Person("Joshua", "Finch", "finch.joshua@email.com");
		Person p1 = new Person("Helen", "Ramirez", "ramirez.helen@email.com");
		Person p3 = new Person("John", "Snow", "snow.john@got.com");
		Person p4 = new Person("Ned", "Stark", "stark.ned@got.com");
		p.getFriends().add(p1);
		p1.getFriends().add(p4);
		p3.getFriends().add(p);
		p4.getFriends().add(p3);
		Home h = new Home(1000, 10, p);
		Home h1 = new Home(70, 4, p1);
		ElectronicDevice d = new ElectronicDevice(400, p1);
		ElectronicDevice d2 = new ElectronicDevice(90, p1);
		ElectronicDevice d3 = new ElectronicDevice(500, p1);
		ElectronicDevice d1 = new ElectronicDevice(500, p);
		Heater he1 = new Heater(h);
		Heater he2 = new Heater(h1);
		tx.begin();
		try {
			dao.create(p, p1, p3, p4, h, h1, d, d1, d2, d3, he1, he2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		manager.close();
		factory.close();
	}

}
