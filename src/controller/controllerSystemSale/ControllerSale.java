package controller.controllerSystemSale;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import controller.controllerProducts.ControllerProduct;
import entities.Financial;
import entities.User;
import enums.EnumStatus;
import models.modelEntities.ModelUser;
import models.modelSystemSale.ModelSale;
import products.Product;
import systemSale.Bid;
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
			   System.out.println("                       7 - Lances 			      		           ");
			   System.out.println("                       8 - Consultar detalhes      		           ");
			   System.out.println("                       9 - Exportar arquivo	      		           ");
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
				   String idSale = in.next();
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
				   ControllerBid.menu();	     
				   break;	
			   case 8:			  
				   menuDetails();	     
				   break;
			   case 9:			  
				   menuExport();	     
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
		 String id = in.next();
		 
		 System.out.println("\nData de fechamento");		 
		 System.out.println("Informe o dia: ");
		 int dia_fechamento = in.nextInt();
		 System.out.println("Informe o mês: ");
		 int mes_fechamento = in.nextInt();
		 System.out.println("Informe o ano: ");
		 int ano_fechamento = in.nextInt();
		 
		 System.out.println("\nData de abertura");		 
		 System.out.println("Informe o dia: ");
		 int dia_abertura = in.nextInt();
		 System.out.println("Informe o mês: ");
		 int mes_abertura = in.nextInt();
		 System.out.println("Informe o ano: ");
		 int ano_abertura = in.nextInt();
		 
		 System.out.println("Endereço");
		 System.out.println("Informe a rua: ");
		 String rua = in.next();
		 System.out.println("Informe o numero: ");
		 int numero = in.nextInt();
		 System.out.println("Informe a cidade: ");
		 String cidade = in.next();
		 System.out.println("Informe o estado: ");
		 String estado = in.next();
		 System.out.println("Informe o CEP: ");
		 String cep = in.next();
		 
		 System.out.println("Entidade Financeira");
		 System.out.println("Informe a cidade: ");
		 String cidade_ent = in.next();
		 System.out.println("Informe o CNPJ: ");
		 String cnpj = in.next();
		 System.out.println("Informe a razão social: ");
		 String socialReason = in.next();
		
			  
		 Address address = new Address(rua, numero, cidade, estado, cep);
		 Financial financial = new Financial(cidade_ent, cnpj, socialReason);
		 Sale sale = new Sale(id, LocalDate.of(ano_fechamento, mes_fechamento, dia_fechamento),
				 LocalDate.of(ano_abertura, mes_abertura, dia_abertura),
				 address.getAddress(), financial.getFinancial(), EnumStatus.Open);
		sale.setStatus(ModelSale.getStatus(sale));
		ModelSale.addSale(sale);
	}

	public static void menuUpdate() {
		  
		 System.out.print("Informe o id: ");
		 String id = in.next();
		 
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
		 String rua = in.next();
		 System.out.println("Informe o numero: ");
		 int numero = in.nextInt();
		 System.out.println("Informe a cidade: ");
		 String cidade = in.next();
		 System.out.println("Informe o estado: ");
		 String estado = in.next();
		 System.out.println("Informe o CEP: ");
		 String cep = in.next();
		 
		 System.out.println("Entidade Financeira");
		 System.out.println("Informe a cidade: ");
		 String cidade_ent = in.next();
		 System.out.println("Informe o CNPJ: ");
		 String cnpj = in.next();
		 System.out.println("Informe a razão social: ");
		 String socialReason = in.next();
		 
		 Address address = new Address(rua, numero, cidade, estado, cep);
		 Financial financial = new Financial(cidade_ent, cnpj, socialReason);
		 Sale change = new Sale(id, LocalDate.of(ano_fechamento, mes_fechamento, dia_fechamento),
				 LocalDate.of(ano_abertura, mes_abertura, dia_abertura),
				 address.getAddress(), financial.getFinancial(), EnumStatus.Open); 
		         change.setStatus(ModelSale.getStatus(change));
		ModelSale.updateSale(change);
	}
	
	public static void menuRemove() {
		 System.out.print("Informe o id:  ");
		 String idRemove = in.next();
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
		String id = in.next();
		for(Sale obj: ModelSale.getListSale()) {			
			if (obj.getId().equals(id)) {
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
		System.out.print("Informe o id do leilão:  ");
		String idSale = in.next();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("\n                              *** Detalhes Leilão ***");
		System.out.println("\n                   ===============================================");
		if (ModelSale.getListSale().size() > 0) {
			for (Sale obj : ModelSale.getListSale()) {
				if (obj.getId().equals(idSale)) {
					System.out.println("                       ID - "+  obj.getId());
					System.out.println("                       Data inicial - "+  obj.getOpeningDateBid().format(formatter));
					System.out.println("                       Data final - "+  obj.getProposalDateBid().format(formatter) );
					System.out.println("                       Status - "+  obj.getStatus());
					System.out.println("                       Entidade Financeira "+  obj.getFinancial());				
					System.out.println("                       Ganhadores - "+ ModelSale.getWin(obj)) ;
					System.out.println("                       Total de produtos - "+  obj.getProducts().size());
					if( obj.getProducts().size() >0) {
						System.out.println("                       Produtos ");
						for(Product product : obj.getProducts()) {
							System.out.println("                        "+product.getProduct()) ;
							System.out.println();						
						}						
					}
					try {
						System.out.println("                       Total de lances - "+  obj.getBids().size());
						if(obj.getBids().size() >0) {
							System.out.println("                       Lances ");					
							for(Bid bid : obj.getBids()) {
								System.out.println("                        "+bid.getBid()) ;
								System.out.println();
								}						
						}
					}
					catch (NullPointerException e) {
						System.out.println("                       Nenhum lance cadastrado ");						
					}
					
					}							
				}				
			}		
		else {
			System.out.println("                      Nenhum leilão cadastrado ");			
		}
		System.out.println("                   ===============================================\n"); 
	}
	
	
}

