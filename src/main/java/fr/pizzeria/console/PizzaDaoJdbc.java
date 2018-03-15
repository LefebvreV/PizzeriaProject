package fr.pizzeria.console;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.utils.ConnectionJdbc;

public class PizzaDaoJdbc implements IPizzaDao {

	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> pizzaList = new ArrayList<Pizza>();
		try {
			ConnectionJdbc.ouvrirConnection();
			ResultSet resultats = ConnectionJdbc.getStatement().executeQuery("SELECT * FROM PIZZA");
			while (resultats.next()) {
				String code = resultats.getString("PIZ_CODE");
				String libelle = resultats.getString("PIZ_LIBELLE");
				String categorie = resultats.getString("PIZ_TYPE");
				double prix = resultats.getDouble("PIZ_PRIX");
				CategoriePizza categoriePiz = CategoriePizza.valueOf(categorie);

				pizzaList.add(new Pizza(code, libelle, categoriePiz, prix));

			}
			resultats.close();
			ConnectionJdbc.fermerJDBC();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pizzaList;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		try {
			ConnectionJdbc.ouvrirConnection();
			PreparedStatement newPizza = ConnectionJdbc.getConnection()
					.prepareStatement("INSERT INTO PIZZA(PIZ_CODE, PIZ_LIBELLE, PIZ_TYPE, PIZ_PRIX) VALUES(?,?,?,?)");
			newPizza.setString(1, pizza.getCode());
			newPizza.setString(2, pizza.getLibelle());
			newPizza.setString(3, pizza.getType().name().toUpperCase());
			newPizza.setDouble(4, pizza.getPrix());
			newPizza.executeUpdate();
			ConnectionJdbc.fermerJDBC();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		try {
			ConnectionJdbc.ouvrirConnection();
			PreparedStatement newPizza = ConnectionJdbc.getConnection()
					.prepareStatement("UPDATE PIZZA SET PIZ_CODE = ?, PIZ_LIBELLE = ?, PIZ_TYPE = ?, PIZ_PRIX = ? WHERE PIZ_CODE = ?");
			newPizza.setString(1, pizza.getCode());
			newPizza.setString(2, pizza.getLibelle());
			newPizza.setString(3, pizza.getType().name().toUpperCase());
			newPizza.setDouble(4, pizza.getPrix());
			newPizza.setString(5, codePizza);
			newPizza.executeUpdate();
			ConnectionJdbc.fermerJDBC();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deletePizza(String codePizza) {
		try {
			ConnectionJdbc.ouvrirConnection();
			PreparedStatement newPizza = ConnectionJdbc.getConnection()
					.prepareStatement("DELETE FROM PIZZA WHERE PIZ_CODE = ?");
			newPizza.setString(1, codePizza);
			newPizza.executeUpdate();
			ConnectionJdbc.fermerJDBC();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Méthode inutile avec la base de données.
	 */
	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza pizza = null;
		try {
			ConnectionJdbc.ouvrirConnection();
			PreparedStatement pizzaFind = ConnectionJdbc.getConnection()
					.prepareStatement("SELECT * FROM pizza WHERE code=?");
			pizzaFind.setString(1, codePizza);
			ResultSet resultats = pizzaFind.executeQuery();
			if (resultats.next()) {
				pizza.setCode(resultats.getString("PIZ_CODE"));
				pizza.setLibelle(resultats.getString("PIZ_LIBELLE"));
				pizza.setPrix(resultats.getDouble("PIZ_PRIX"));
				CategoriePizza categoriePiz = CategoriePizza.valueOf(resultats.getString("PIZ_TYPE"));
				pizza.setType(categoriePiz);
			}
			ConnectionJdbc.fermerJDBC();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pizza;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		boolean exist = false;

		try {
			PreparedStatement pizzaExist = ConnectionJdbc.getConnection()
					.prepareStatement("SELECT * FROM pizza WHERE code=?");
			pizzaExist.setString(1, codePizza);
			ResultSet resultats = pizzaExist.executeQuery();
			if (resultats.next())
				exist = true;
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return exist;
	}
}
