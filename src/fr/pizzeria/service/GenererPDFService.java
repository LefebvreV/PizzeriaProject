package fr.pizzeria.service;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.console.IPizzaDao;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.utils.PDFGenerator;

/**
 * Service pour générer un pdf avec la liste des pizza
 * @author Valentin Lefebvre
 *
 */
public class GenererPDFService extends MenuService  {

	@Override
	public void executeUC(IPizzaDao pizzaDao) {
		List<Pizza> pizz= new ArrayList<Pizza>();
		pizz = pizzaDao.findAllPizzas();
		PDFGenerator.genererPDF(pizz);
	}
}
