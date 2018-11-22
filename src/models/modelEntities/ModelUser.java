package models.modelEntities;

import java.util.LinkedList;
import java.util.List;

import entities.User;

public class ModelUser {
	static List<User> list = new LinkedList<User>();
	
	public static Boolean validateUser(User user) {
		for(User name : list) {
		   if(name.getIdentifier()
				   .equals(user.getIdentifier()) && name.getUsername()
				   .equals(user.getUsername())) {
			   System.out.println("Usuário encontrado");
			   System.out.println(user.getUser());
			   return true;
		    }
		}
		System.out.println("Usuário não encontrado");
		System.out.println(user.getUser());
		return false;
	}
	
	public static void addUser(User user) {
		System.out.println("FUNÇAO ADD USER");
		if(!validateUser(user)) {
			list.add(user);
			System.out.println("Usuário cadastrado com sucesso");
			System.out.println(user.getUser());
		}
	}
	
	public static User findUser(String identifier) {
		System.out.println("FUNÇAO FIND USER");
		list.stream()
			.filter(user -> {
				if(user.getIdentifier() == identifier) {
					return user != null;
				}
				return false;
			})
			.forEach(user -> {
				System.out.println("Usuário");
				System.out.println(user.getUser());
			});
		return null;
	}
	
	public static void getListUsers() {
		System.out.println("FUNÇAO GET ALL USERS");
		if (list.size() > 0) {
			System.out.println("Todos os usuários");
			for(User user : list) {
				System.out.println(user.getUser());
			}
		} else {
			System.out.println("Sem usuários");
		}
		
	}
	
	public static void updateUser(User change) {
		System.out.println("FUNÇAO UPDATE USER");
		for (User user : list) {
			if (validateUser(user) && user.getIdentifier()
					.equals(change.getIdentifier())) {
				System.out.println("Atualizar user");
				System.out.println(user.getUser());
				list.set(list.indexOf(user), change);
			}  else {
				System.out.println("Usuário não encontrado no sistema");
			}
		}
		System.out.println("Usuário atualizado");
		System.out.println(change.getUser());
	}
	
	public static void removeUser(String identifier) {
		System.out.println("FUNÇAO REMOVE USER");
		for (User user : list) {
			if (validateUser(user) && user.getIdentifier().equals(identifier)) {
				System.out.println("Remover user");
				System.out.println(user.getUser());
				list.remove(user);
			} 
		}		
	}
	
}
