package jpa;


import domain.*;

public class JpaTest {
	public static void main(String[] args) {
		GenTestDAO dao = new GenTestDAO();
		Person p = new Person("Joshua", "Finch", "finch.joshua@email.com");
		Person p1 = new Person("Helen", "Ramirez", "ramirez.helen@email.com");
		Person p3 = new Person("John", "Snow", "snow.john@got.com");
		Person p4 = new Person("Ned", "Stark", "stark.ned@got.com");
        p1.getFriends().add(p3);
        p3.getFriends().add(p1);
        p4.getFriends().add(p);
        p.getFriends().add(p4);
		Address a = new Address("34 Avenue Rochester", "Buckingham", "8931", "London");
		Address a1 = new Address("41957 Dexter Parkway", "Louisiana", "3231", "Los Angels");
		Home h = new Home(1000, 10, a);
		Home h1 = new Home(170, 4, a1);
		p.addHomes(h);
		p4.addHomes(h1);
		ElectronicDevice d = new ElectronicDevice("Speaker", 400);
		ElectronicDevice d2 = new ElectronicDevice("SmartPhone",90);
		ElectronicDevice d3 = new ElectronicDevice("MacBook Retina",500);
		ElectronicDevice d1 = new ElectronicDevice("Play Station",500);
		p.addDevices(d, d1);
		p1.addDevices(d3, d2);
		Heater he1 = new Heater();
		Heater he2 = new Heater();
		dao.getTransaction().begin();
		try {
			dao.create(p, p1, p3, p4, h, h1, d, d1, d2, d3, he1, he2, a, a1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.getTransaction().commit();
		dao.getEntityManager().close();
		dao.getEntityManagerFactory().close();

	}


}
