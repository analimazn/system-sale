package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.User;
import enums.EnumUser;
import models.modelEntities.ModelUser;

class ModelUserTest {
	User user1;
	User user2;
	User user3;
	
	@BeforeEach
	void setUp() throws Exception {
		user1 = new User("teste1", "@123", EnumUser.Admin, "00001", "Teste1", "00000000000000");
		user2 = new User("teste2", "@123", EnumUser.Client, "00002", "Teste2", "00000000000000");
		user3 = new User("teste3", "@123", EnumUser.Client, "00003", "Teste3", "00000000000000");
	}
	
	@Test
	public void addUser() {		
		ModelUser.addUser( user1 );
		assertEquals(true, ModelUser.validateUser(user1));
	}
	
	@Test
	public void removeUser() {			
		ModelUser.addUser( user2 );
		ModelUser.removeUser(user2.getId());		
		assertEquals(false, ModelUser.validateUser(user2));		
	}
	
	@Test
	public void findUser() {		
		ModelUser.addUser( user3 );
		//assertEquals(user3.getId(), ModelUser.findUser( user3.getId() ).getId()  );		
	}
		
}
