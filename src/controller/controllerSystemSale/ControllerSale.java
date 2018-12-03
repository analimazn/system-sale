package controller.controllerSystemSale;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import controller.controllerProducts.ControllerProduct;
import entities.Financial;
import entities.User;
import enums.EnumStatus;
import models.modelEntities.ModelUser;
import models.modelSystemSale.ModelSale;
import systemSale.Sale;
import utils.Address;

public class ControllerSale {
	
	static Scanner in = new Scanner(System.in);
	
	public static void menu() {
		
		int option;
		 	
		 do {
			   System.out.println("\n                                 *** Leilão ***");
			   System.out.println("\n                   ===============================================");
			   System.out.println("                       1 - Cadastrar leilão             	           ");
			   System.out.println("                       2 - Atualizar leilão                         ");
			   System.out.println("                       3 - Remover Leilão                           ");
			   System.out.println("                       4 - Listar Leilão                            ");
			   System.out.println("                       5 - Verificar Status                  	   ");
			   System.out.println("                       6 - Produtos                  	   		   "); 
			   System.out.println("                       7 - Exportar arquivo      		           ");
			   System.out.println("                       8 - Consultar detalhes      		           ");
			   System.out.println("                       0 - Sair			          				   ");  			
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
			   case 5:			  
				   menuStatus();	     
				   break;
			   case 6:			  
				   System.out.println("Informe o id do leilão para acessar seus produtos");
				   String idSale = in.nextLine();
				   for(Sale obj : ModelSale.getListSale()) {
					   if (idSale.equals(obj.getId())) {
						   ControllerProduct.menu(obj);						   
					   }
					   else {
						   System.out.println("Leilão não encontrado");
					   }
				   }				   	     
				   break;
			   case 7:			  
				   menuExport();	     
				   break;	
			   case 8:			  
				   menuDetails();	     
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
		 
		 System.out.println("Data de fechamento");		 
		 System.out.println("Informe o dia: ");
		 int dia_fechamento = in.nextInt();
		 System.out.println("Informe o mêS: ");
		 int mes_fechamento = in.nextInt();
		 System.out.println("Informe o ano: ");
		 int ano_fechamento = in.nextInt();
		 
		 System.out.println("Data de abertura");		 
		 System.out.println("Informe o dia: ");
		 int dia_abertura = in.nextInt();
		 System.out.println("Informe o mêS: ");
		 int mes_abertura = in.nextInt();
		 System.out.println("Informe o ano: ");
		 int ano_abertura = in.nextInt();
		 
		 System.out.println("Endereço");
		 System.out.println("Informe a rua: ");
		 String rua = in.nextLine();
		 System.out.println("Informe o numero: ");
		 int numero = in.nextInt();
		 System.out.println("Informe a cidade: ");
		 String cidade = in.nextLine();
		 System.out.println("Informe o estado: ");
		 String estado = in.nextLine();
		 System.out.println("Informe o CEP: ");
		 String cep = in.nextLine();
		 
		 System.out.println("Entidade Financeira");
		 System.out.println("Informe a cidade: ");
		 String cidade_ent = in.nextLine();
		 System.out.println("Informe o CNPJ: ");
		 String cnpj = in.nextLine();
		 System.out.println("Informe a razão social: ");
		 String socialReason = in.nextLine();
		 
		 EnumStatus status;
		  
		 Address address = new Address(rua, numero, cidade, estado, cep);
		 Financial financial = new Financial(cidade_ent, cnpj, socialReason);
		 Sale sale = new Sale(id, LocalDate.of(ano_fechamento, mes_fechamento, dia_fechamento),
				 LocalDate.of(ano_abertura, mes_abertura, dia_abertura),
				 address.getAddress(), financial.getFinancial(), EnumStatus.Open);
		ModelSale.addSale(sale);
	}

	public static void menuUpdate() {
		  
		 System.out.print("Informe o id: ");
		 String id = in.nextLine();
		 
		 System.out.println("Data de fechamento");		 
		 System.out.println("Informe o dia: ");
		 int dia_fechamento = in.nextInt();
		 System.out.println("Informe o mêS: ");
		 int mes_fechamento = in.nextInt();
		 System.out.println("Informe o ano: ");
		 int ano_fechamento = in.nextInt();
		 
		 System.out.println("Data de abertura");		 
		 System.out.println("Informe o dia: ");
		 int dia_abertura = in.nextInt();
		 System.out.println("Informe o mêS: ");
		 int mes_abertura = in.nextInt();
		 System.out.println("Informe o ano: ");
		 int ano_abertura = in.nextInt();
		 
		 System.out.println("Endereço");
		 System.out.println("Informe a rua: ");
		 String rua = in.nextLine();
		 System.out.println("Informe o numero: ");
		 int numero = in.nextInt();
		 System.out.println("Informe a cidade: ");
		 String cidade = in.nextLine();
		 System.out.println("Informe o estado: ");
		 String estado = in.nextLine();
		 System.out.println("Informe o CEP: ");
		 String cep = in.nextLine();
		 
		 System.out.println("Entidade Financeira");
		 System.out.println("Informe a cidade: ");
		 String cidade_ent = in.nextLine();
		 System.out.println("Informe o CNPJ: ");
		 String cnpj = in.nextLine();
		 System.out.println("Informe a razão social: ");
		 String socialReason = in.nextLine();
		 
		 Address address = new Address(rua, numero, cidade, estado, cep);
		 Financial financial = new Financial(cidade_ent, cnpj, socialReason);
		 Sale change = new Sale(id, LocalDate.of(ano_fechamento, mes_fechamento, dia_fechamento),
				 LocalDate.of(ano_abertura, mes_abertura, dia_abertura),
				 address.getAddress(), financial.getFinancial(), EnumStatus.Open);
		ModelSale.updateSale(change);
	}
	
	public static void menuRemove() {
		 System.out.print("Informe o id:  ");
		 String idRemove = in.nextLine();
		 ModelSale.removeSale(idRemove);		
	}
	
	public static void menuList() {
		 System.out.println("\n                              *** Lista Leilões ***");
		   System.out.println("\n                   ===============================================");
		   try {
			   if(ModelSale.getListSale().size()>0 ) {
				   for (Sale obj: ModelSale.getListSale() ) {
					   System.out.println("                       "+ obj.getId() +" - "+ obj.getSale());
				   }
			   }
		   }
		   catch (java.lang.NullPointerException e) {
			   System.out.println("                       Nenhum leilão cadastrado                    ");
		   }  			
		   System.out.println("                   ===============================================\n");
		
	}
	
	public static void menuStatus() {
		System.out.println("Informe o id do leilão: ");
		String idSale = in.nextLine();
		for(Sale obj: ModelSale.getListSale()) {			
			if (obj.getId().equals(idSale)) {
				System.out.println("Status leilão "+ obj.getId() +": " + ModelSale.getStatus(obj));				
			}
			else {
				System.out.println("Leilão não encontrado");
			}
		}						
	}
	
	public static void menuExport() {		
		try {
			ModelSale.exportFile(ModelSale.getListSale());
			System.out.println("Arquivo exportado para src/files");
		}
		catch (IOException ex) {
			System.out.println("Não foi possível exportar arquivo");
		}
	}
	
	public static void menuDetails() {
		
	}
	
	
}

