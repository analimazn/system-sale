package controller.controllerProducts;

import java.time.LocalDate;
import java.util.Scanner;

import enums.EnumProduct;
import enums.EnumStatus;
import models.modelSystemSale.ModelSale;
import products.Product;
import systemSale.Sale;

public class ControllerProduct {
	
static Scanner in = new Scanner(System.in);
	static Sale saleRef;
	
	public static void menu(Sale sale) {
		saleRef = sale;
	int option;
	 	
	 do {
		   System.out.println("\n                                 *** Produto ***");
		   System.out.println("\n                   ===============================================");
		   System.out.println("                       1 - Cadastrar produto                        ");
		   System.out.println("                       2 - Atualizar produto                        ");
		   System.out.println("                       3 - Remover produto                    	   ");
		   System.out.println("                       4 - Listar produtos                          ");
		   System.out.println("                       5 - Buscar produto por palavra chave         ");
		   System.out.println("                       6 - Listar produto por faixa de preço        ");
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
		   case 5:			  
			   menuKeyword();			     
			   break;
		   case 6:			  
			   menuPriceRange();			     
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
		 String optionCadaster;
		 
		 System.out.println("\n                              *** Cadastro Produto ***");
		   System.out.println("\n                   ===============================================");
		  
			   for (EnumProduct enumProd: EnumProduct.values()) {
					   System.out.println("                       "+ enumProd.toString());
				   }  			
		   System.out.println("                   ===============================================\n");
		   
		   optionCadaster = in.nextLine().toUpperCase();
		   
		   switch (optionCadaster) {
		   case "APARTMENT":
			   System.out.print("Informe o id: ");
			   String id = in.nextLine();
			   System.out.print("Informe o preço ");
			   double  price = in.nextDouble();
			   System.out.print("Informe a descrição: ");
			   String description = in.nextLine();
			   
			   Product product = new Product(saleRef.getId(), id, EnumProduct.Apartment, price, description);
			   saleRef.addProduct(product);
			   break;
		   case "BUILDINGSIT":
			   System.out.print("Informe o id: ");
			   String id1 = in.nextLine();
			   System.out.print("Informe o preço ");
			   double  price1 = in.nextDouble();
			   System.out.print("Informe a descrição: ");
			   String description1 = in.nextLine();
			   
			   Product product1 = new Product(saleRef.getId(), id1, EnumProduct.BuildingSit, price1, description1);
			   saleRef.addProduct(product1);
			   break;
		   case "HOUSE":
			   System.out.print("Informe o id: ");
			   String id2 = in.nextLine();
			   System.out.print("Informe o preço ");
			   double  price2 = in.nextDouble();
			   System.out.print("Informe a descrição: ");
			   String description2 = in.nextLine();
			   
			   Product product2 = new Product(saleRef.getId(), id2, EnumProduct.House, price2, description2);
			   saleRef.addProduct(product2);
			   break;
		   case "COMMERCIALBUILDING":
			   System.out.print("Informe o id: ");
			   String id3 = in.nextLine();
			   System.out.print("Informe o preço ");
			   double  price3 = in.nextDouble();
			   System.out.print("Informe a descrição: ");
			   String description3 = in.nextLine();
			   
			   Product product3 = new Product(saleRef.getId(), id3, EnumProduct.CommercialBuilding, price3, description3);
			   saleRef.addProduct(product3);
			   break;
		   case "CAR":
			   System.out.print("Informe o id: ");
			   String id4 = in.nextLine();
			   System.out.print("Informe o preço ");
			   double  price4 = in.nextDouble();
			   System.out.print("Informe a descrição: ");
			   String description4 = in.nextLine();
			   
			   Product product4 = new Product(saleRef.getId(), id4, EnumProduct.Car, price4, description4);
			   saleRef.addProduct(product4);
			   break;
		   case "MOTORCYLE":
			   System.out.print("Informe o id: ");
			   String id5 = in.nextLine();
			   System.out.print("Informe o preço ");
			   double  price5 = in.nextDouble();
			   System.out.print("Informe a descrição: ");
			   String description5 = in.nextLine();
			   
			   Product product5 = new Product(saleRef.getId(), id5, EnumProduct.Motorcycle, price5, description5);
			   saleRef.addProduct(product5);
			   break;
		   case "0":
			   break;
		   default:
			   System.out.println("Opção Inválida!");
			   break;
		   }	   
	}
		
	public static void menuUpdate() {
		
		   System.out.print("Informe o id: ");
		   String id = in.nextLine();
		   System.out.print("Informe o tipo: ");
		   EnumProduct type = EnumProduct.valueOf(in.nextLine());
		   System.out.print("Informe o preço ");
		   double  price = in.nextDouble();
		   System.out.print("Informe a descrição: ");
		   String description = in.nextLine();
		   
		   Product change = new Product(saleRef.getId(), id, type, price, description);
		   saleRef.updateProduct(change);
	}
	
	public static void menuRemove() {
		 System.out.print("Informe o id:  ");
		 String idRemove = in.nextLine();
		 saleRef.removeProduct(idRemove);
	}
	
	public static void menuList() {
		 System.out.println("\n                              *** Lista Produtos ***");
		   System.out.println("\n                   ===============================================");
		   try {
				   for (Product obj: saleRef.getProducts()) {
					   System.out.println("                       "+ obj.getId() +" - "+ obj.getType().toString());
				   }
			   }
		   catch (java.lang.NullPointerException e) {
			   System.out.println("                       Nenhum produto cadastrado                    ");
		   }  			
		   System.out.println("                   ===============================================\n");		   			
	}
	
	public static void menuKeyword() {
		System.out.println("Informe palavra chave: ");
		String keyword = in.nextLine();
		saleRef.getProductByTypeOrKeyWord(keyword);		
	}
	
	public static void menuPriceRange() {
		System.out.println("Informe o valor minimo: ");
		double minValue = in.nextDouble();
		System.out.println("Informe o valor maximo: ");
		double maxValue = in.nextDouble();
		saleRef.getProductByPriceRange(minValue, maxValue);
		
	}

}
