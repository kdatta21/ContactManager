package net.codejavaspring.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejavaspring.contact.model.Contact;

class ContactDAOTest {
	private DriverManagerDataSource datasource;
	private ContactDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		datasource.setUsername("kaushik");
		datasource.setPassword("12345");
		dao = new ContactDAOImpl(datasource);
	}
	@Test
	void testSave() {
		Contact contact = new Contact("Test Kumar","test7in@gmail.com","Belghoria,IN","0727567899");
		int result = dao.save(contact);
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Contact contact = new Contact(1, "Navin Kumar","nav7in@gmail.com","Belghoria,IN","0727567890");
		int result = dao.update(contact);
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Contact contact = dao.get(id);
		if (contact != null) {
			System.out.println(contact);
		}
		assertNotNull(contact);
	}

	@Test
	void testDelete() {
		Integer id = 2;
		int result = dao.delete(id);
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Contact> listcontacts = dao.list();
		for (Contact aContact : listcontacts) {
			System.out.println(aContact);
		}
		assertTrue(!listcontacts.isEmpty());
	}

}
