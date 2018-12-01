package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import entities.User;
import enums.EnumUser;
import models.modelEntities.ModelUser;

class ModelUserTest {
	User user;
	ModelUser modeluser;
	
	@Test
	public void addUser() {
		user = new User("teste1", "@123", EnumUser.Admin, "00001", "Teste1", "00000000000000");
		ModelUser.addUser( user );
		assertEquals(true, modeluser.validateUser(user));
	}
	
	@Test
	public void removeUser() {	
		user = new User("teste2", "@123", EnumUser.Client, "00002", "Teste2", "00000000000000");
		ModelUser.addUser( user );
		modeluser.removeUser("00002");		
		assertEquals(false, modeluser.validateUser(user));		
	}
	
	@Test
	public void findUser() {
		user = new User("teste3", "@123", EnumUser.Client, "00003", "Teste3", "00000000000000");
		ModelUser.addUser( user );
		//assertEquals(user.getId(), ModelUser.findUser( user.getId() ).getId()  );		
	}
	
	@Test
	public void updateUser() {
		
	}
	
	
}
