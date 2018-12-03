package controller.controllerEntities;


import java.util.List;
import java.util.Scanner;

import entities.User;
import enums.EnumUser;
import models.modelEntities.ModelUser;

public class ControllerUser {
	
	static Scanner in = new Scanner(System.in);
	
	public static void menu() {
		
	int option;
	 	
	 do {
		   System.out.println("\n                                 *** Cliente ***");
		   System.out.println("\n                   ===============================================");
		   System.out.println("                       1 - Cadastrar usuario                     ");
		   System.out.println("                       2 - Atualizar usuario                     ");
		   System.out.println("                       3 - Remover usuario                    	  ");
		   System.out.println("                       4 - Listar usuarios                        ");		   
		   System.out.println("                       0 - Voltar                                ");  			
		   System.out.println("                   ===============================================\n");
		   
		   option = in.nextInt();
		   
		   switch (option) {
		   case 1: 
			   menuCadaster();
			   break;			  
		   case 2:
			   menuUpdate();
			   break;			  
		   case 3:
			   menuRemove();
			   break;
		   case 4:			  
			   menuList();			     
			   break;
		   case 0:
			   break;
		   default:
			   System.out.println("Opção Inválida!");
			   break;
		   }

	 }while (option != 0);
	  System.out.println("Finalizado.");
	  }
	
	
	public static void menuCadaster() {
		 int optionCadaster;
		 
		   System.out.println("\n                          *** Cadastrando novo Cliente ***");
		   System.out.println("\n                   ===============================================");
		   System.out.println("                       1 - Cadastrar cliente                     ");
		   System.out.println("                       2 - Cadastrar admin                       ");			 
		   System.out.println("                       0 - Voltar	                          ");  			
		   System.out.println("                   ===============================================\n");
		   
		   optionCadaster = in.nextInt();
		   
		   switch (optionCadaster) {
		   case 1: 
			   System.out.print("Informe o nome de acesso: ");
			   String username = in.next();
			   System.out.print("Informe a senha: ");
			   String password = in.next();
			   EnumUser usertype = EnumUser.Client;
			   System.out.print("Informe a id:  ");
			   String id = in.next();
			   System.out.print("Informe o nome:  ");
			   String name = in.next();
			   System.out.print("Informe o CPF/CNPJ:  ");
			   String cnpjCpf = in.next();
			   
			   User client = new User(username, password, usertype, id, name, cnpjCpf);
			   ModelUser.addUser(client);
			   break;
		   case 2: 
			   System.out.print("Informe o nome de acesso:  ");
			   String username1 = in.next();
			   System.out.print("Informe a senha:  ");
			   String password1 = in.next();
			   EnumUser usertype1 = EnumUser.Admin;
			   System.out.print("Informe a id:  ");
			   String id1 = in.next();
			   System.out.print("Informe o nome:  ");
			   String name1 = in.next();
			   System.out.print("Informe o CPF/CNPJ:  ");
			   String cnpjCpf1 = in.next();
			   
			   User admin = new User(username1, password1, usertype1, id1, name1, cnpjCpf1);
			   ModelUser.addUser(admin);
			   break;
		   case 0:
			   break;
		   default:
			   System.out.println("Opção Inválida!");
			   break;
	}
	
	}
		
	public static void menuUpdate() {

		   System.out.print("Informe o nome de acesso:  ");
		   String username = in.next();
		   System.out.print("Informe a senha:  ");
		   String password = in.next();
		   EnumUser usertype = EnumUser.Client;
		   System.out.print("Informe a id:  ");
		   String id = in.next();
		   System.out.print("Informe o nome:  ");
		   String name = in.next();
		   System.out.print("Informe o CPF/CNPJ:  ");
		   String cnpjCpf = in.next();
		   
		   User change = new User(username, password, usertype, id, name, cnpjCpf);
		   ModelUser.addUser(change);
	}
	
	public static void menuRemove() {
		 System.out.print("Informe o id:  ");
		 String idRemove = in.next();
		 ModelUser.removeUser(idRemove);
	}
	
	public static void menuList() {
		 System.out.println("\n                              *** Lista Clientes ***");
		   System.out.println("\n                   ===============================================");
		   try {
			   if(ModelUser.getListUser().size()>0 ) {
				   for (User objUser: ModelUser.getListUser() ) {
					   System.out.println("                       "+ objUser.getId() +" - "+ objUser.getName());
				   }
			   }
		   }
		   catch (java.lang.NullPointerException e) {
			   System.out.println("                       Nenhum usuário cadastrado                    ");
		   }  			
		   System.out.println("                   ===============================================\n");
		   			
	}

	
}