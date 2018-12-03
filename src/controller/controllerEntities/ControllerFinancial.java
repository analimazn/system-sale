package controller.controllerEntities;

import java.util.Scanner;

import entities.Financial;
import models.modelEntities.ModelFinancial;

public class ControllerFinancial {
	

	static Scanner in = new Scanner(System.in);
	
	public static void menu() {
		
	int option;
	 	
	 do {
		   System.out.println("\n                               *** Entidade Financeira ***");
		   System.out.println("\n                   ===============================================");
		   System.out.println("                       1 - Cadastrar entidade financeira            ");
		   System.out.println("                       2 - Atualizar entidade financeira            ");
		   System.out.println("                       3 - Remover entidade financeira              ");
		   System.out.println("                       4 - Listar entidades financeiras             ");		   
		   System.out.println("                       0 - Voltar                                   ");  			
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
		       System.out.print("Informe o id: ");
			   String id = in.nextLine();
			   System.out.println();
			   System.out.print("Informe o CNPJ: ");
			   String cnpj = in.nextLine();			   
			   System.out.print("Informe a razão social:  ");
			   String socialReason = in.nextLine();			  
			   
			   Financial financial = new Financial(id, cnpj, socialReason);					  
			   ModelFinancial.addFinancial(financial);			   
	}
	
	public static void menuUpdate() {
		  System.out.print("Informe o id: ");
		   String id = in.nextLine();
		   System.out.println();
		   System.out.print("Informe o CNPJ: ");
		   String cnpj = in.nextLine();			   
		   System.out.print("Informe a razão social:  ");
		   String socialReason = in.nextLine();			  
		   
		   Financial change = new Financial(id, cnpj, socialReason);		
		   ModelFinancial.addFinancial(change);
	}

	public static void menuRemove() {
		 System.out.print("Informe o id:  ");
		 String idRemove = in.nextLine();
		 ModelFinancial.removeFinancial(idRemove);
	}
	
	public static void menuList() {
		 System.out.println("\n                            *** Lista Entidades Financeiras ***");
		   System.out.println("\n                   ===============================================");
		   try {
			   if(ModelFinancial.getListFinancial().size()>0 ) {
				   for (Financial objUser: ModelFinancial.getListFinancial() ) {
					   System.out.println("                       "+ objUser.getId() +" - "+ objUser.getSocialReason());
				   }
			   }
			   else {
				   System.out.println("                       Nenhuma entidade cadastrada                    ");
			   }
		   }
		   catch (java.lang.NullPointerException e) {
			   System.out.println("                       Nenhuma entidade cadastrada                    ");
		   }  			
		   System.out.println("                   ===============================================\n");
		   			
	}

	
}
