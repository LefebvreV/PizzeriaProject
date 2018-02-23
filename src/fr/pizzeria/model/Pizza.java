package fr.pizzeria.model;

public class Pizza {
	
	public int id;
	public String code;
	public String libelle;
	public double prix;
	private static int compteur=0;

	public Pizza(String code, String libelle, double prix) {
		this.id = compteur++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public Pizza(int id, String code, String libelle, double prix) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		compteur++;
	}

	
	public String afficherPizza(){
		String pizza = this.code + " -> " + this.libelle + " (" + this.prix + " \u20ac)";
		return pizza;
	}

}
