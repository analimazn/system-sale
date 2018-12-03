package models.modelEntities;

import java.util.LinkedList;
import java.util.List;
import entities.User;

public class ModelUser {
	static List<User> list = new LinkedList<User>();
	
	public static Boolean validateUser(User objUser) {
		for(User user : list) {
		   if(user.getId().equals(objUser.getId())) {
			   System.out.println("Usuário encontrado");
			   return true;
		    }
		}
		System.out.println("Usuário não encontrado");
		return false;
	}
	
	public static void addUser(User objUser) {
		if(!validateUser(objUser)) {
			list.add(objUser);
			System.out.println("Usuário cadastrado com sucesso");
		} else {
			System.out.println("Usuário não cadastrado");
		}
	}
	
	public static User findUser(String id) {
		list.stream()
			.filter(objUser -> {
				if(objUser.getId() == id) {
					return objUser != null;
				}
				return false;
			})
			.forEach(objUser -> {
				System.out.println("Usuário");
				System.out.println(objUser.getUser());
			});
		return null;
	}
	
	public static List<User> getListUser() {
		if (list.size() > 0) {
			return list;
		}
		System.out.println("Sem usuários");
		return list;
	}
	
	public static void updateUser(User change) {
		for (User objUser : list) {
			if (validateUser(objUser) && objUser.getId()
					.equals(change.getId())) {
				System.out.println("Atualizar Usuário");
				System.out.println(objUser.getUser());
				list.set(list.indexOf(objUser), change);
			}  else {
				System.out.println("Usuário não encontrado no sistema");
			}
		}
		System.out.println("Usuário atualizado");
		System.out.println(change.getUser());
	}
	
	public static void removeUser(String id) {
		for (User objUser : list) {
			if (validateUser(objUser) && objUser.getId().equals(id)) {
				System.out.println("Remover objUser");
				System.out.println(objUser.getUser());
				list.remove(objUser);
			} 
		}		
	}
	
}
