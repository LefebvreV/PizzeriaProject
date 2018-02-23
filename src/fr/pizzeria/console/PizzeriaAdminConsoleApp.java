package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	
	private static Pizza tableauPizza[]; 
	
	public static void main(String[] args) {
		tableauPizza = new Pizza[8];
		tableauPizza[0]= new Pizza(0,"PEP","Pépéroni",12.50);
		tableauPizza[1]= new Pizza(1,"MAR","Margherita",14.00);
		tableauPizza[2]= new Pizza(2,"REIN","La reine",11.50);
		tableauPizza[3]= new Pizza(3,"FRO","La 4 formages",12.00);
		tableauPizza[4]= new Pizza(4,"CAN","La cannibale",12.50);
		tableauPizza[5]= new Pizza(5,"SAV","La savoyarde",13.00);
		tableauPizza[6]= new Pizza(6,"ORI","L'orientale",13.50);
		tableauPizza[7]= new Pizza(7,"IND","L'indienne",14.00);
		
		Scanner choixUtilisateur = new Scanner(System.in); 
		System.out.println(afficherMenu());
		String choixTemp = choixUtilisateur.nextLine();
		int choix = Integer.parseInt(choixTemp);
		
		do{
			switch(choix){
				case 1: 
					System.out.println("Liste des pizzas");
					for(int i=0; i <tableauPizza.length;i++){
						System.out.println(tableauPizza[i].toString());
					}
				
				break;
				
				case 2: 
					System.out.println("Ajout d'une nouvelle pizza");
					System.out.println("Veuillez saisir le code :");
					String code = choixUtilisateur.nextLine();
					
					System.out.println("Veuillez saisir le nom (sans espace) :");
					String nom = choixUtilisateur.nextLine();
					
					System.out.println("Veuillez saisir le prix :");
					String prixTemp = choixUtilisateur.nextLine();
					double prix = Double.parseDouble(prixTemp);
					
					Pizza pizzaTemp= new Pizza(code,nom,prix);
					nouveauTab(tableauPizza, pizzaTemp);
				break;
				
				case 3: 
					System.out.println("Mise à jour d'une pizza");
					System.out.println("Liste des pizzas");
					for(int i=0; i <tableauPizza.length;i++){
						System.out.println(tableauPizza[i].toString());
					}
					System.out.println("Veuillez choisir le code de la pizza à modifier :");
					String codeModif = choixUtilisateur.nextLine();
					
					System.out.println("Veuillez saisir le nouveau code :");
					String newCode = choixUtilisateur.nextLine();
					
					System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
					String newNom = choixUtilisateur.nextLine();
					
					System.out.println("Veuillez saisir le nouveau prix :");
					String newPrixTemp = choixUtilisateur.nextLine();
					double newPrix = Double.parseDouble(newPrixTemp);
					
					for(int i=0; i <tableauPizza.length;i++){
						if(tableauPizza[i].getCode().equals(codeModif)){
							tableauPizza[i].setCode(newCode);
							tableauPizza[i].setLibelle(newNom);
							tableauPizza[i].setPrix(newPrix);
							break;
						}
					}
				break;
				
				case 4: 
					System.out.println("Suppresion d'une pizza");
					System.out.println("Liste des pizzas");
					for(int i=0; i <tableauPizza.length;i++){
						System.out.println(tableauPizza[i].toString());
					}
					System.out.println("Veuillez choisir le code de la pizza à supprimer :");
					String codeSupprimer = choixUtilisateur.nextLine();
					
					for(int i=0; i <tableauPizza.length;i++){
						if(tableauPizza[i].getCode().equals(codeSupprimer)){
							for(int j=i;j<tableauPizza.length-1;j++){
								tableauPizza[j]=tableauPizza[j+1];
								tableauPizza[j].setId(tableauPizza[j].getId()-1);
							}
							Pizza.modifCompteur();
							refaireTableau(tableauPizza);
						}
					}
				break;
				
				case 99: System.out.println("Aurevoir ☹");
				break;
			}
			
			if(choix!=99){
				System.out.println(afficherMenu());
				choixTemp = choixUtilisateur.nextLine();
				choix = Integer.parseInt(choixTemp);	
			}
						
		}while(choix!=99);
		
		choixUtilisateur.close();
	}

	/**
	 * Méthode servant à créer un tableau plus grand 
	 * avant l'inserttion d'une nouvelle pizza
	 * @param tab
	 * @param pizza
	 */
	private static void nouveauTab(Pizza[] tab, Pizza pizza){
		tableauPizza= new Pizza[tab.length+1];
		for(int i=0;i<tab.length;i++){
			tableauPizza[i]=tab[i];
		}
		tableauPizza[tableauPizza.length-1]= pizza;
	}
	
	/**
	 * 
	 * Méthode servant à fair un tableau plus petit après une suppression
	 * @param tab
	 */
	private static void refaireTableau(Pizza[] tab){
		tableauPizza = new Pizza[tab.length-1];
		for(int i=0;i<tab.length-1;i++){
			tableauPizza[i]=tab[i];
		}
		
	}
	
	/**
	 * Méthode pour afficher le menu
	 * @return menu
	 */
	private static String afficherMenu(){
		String menu;
		menu = "\n***** Pizzeria Administration *****\n";
		menu += "1. Lister les pizzas\n";
		menu += "2. Ajouter une nouvelle pizza\n";
		menu += "3. Mettre à jour une pizza\n";
		menu += "4. Supprimer une pizza\n";
		menu += "99. Sortir\n";
		return menu;
	}
	
}
