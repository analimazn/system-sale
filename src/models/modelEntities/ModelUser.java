package models.modelEntities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import entities.User;

public class ModelUser {
	public ArrayList<User> list = new ArrayList<User>();
	
	public void addUser(User user) {
		if(validateUser(user)) {
			list.add(user);
			System.out.println("Usuário cadastrado com sucesso " + user.name);
		}
	}
	
	public Boolean validateUser(User user) {
		for(User name : list) {
		    if(name.getIdentifier().equals(user.identifier) && name.getUsername().equals(user.username)) {
		    	System.out.println("Usuário já cadastrado");
		    	return false;
		    }
		}
		return true;
	}
	
	public void getUsers() {
		 Iterator<User> iterator = list.iterator();
		 System.out.println("Usuários cadastrados");
		 while (iterator.hasNext()) {
			 User user = iterator.next();
		     System.out.println(user.name + " " + user.getUser());
		 }
	}
	
	public ListIterator<User> getAllUsers() {
		return list.listIterator();
	}
}
