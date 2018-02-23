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

	public String getCode() {
		return code;
	}

	public String getLibelle() {
		return libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static int getCompteur() {
		return compteur;
	}

	public static void modifCompteur() {
		compteur--;
	}
	
	@Override 
	public String toString(){
		String pizza = this.code + " -> " + this.libelle + " (" + this.prix + " \u20ac)";
		return pizza;
	}

}
