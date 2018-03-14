/**
 * 
 */
package fr.pizzeria.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.pizzeria.console.IPizzaDao;
import fr.pizzeria.console.PizzaMemDao;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Valentin Lefebvre
 *
 */
public class PizzaMemDaoTest {

	/**
	 * Test method for {@link fr.pizzeria.console.PizzaMemDao#findAllPizzas()}.
	 */
	@Test
	public void testFindAllPizzas() {
		IPizzaDao dao = new PizzaMemDao();
		
		List<Pizza> pizzas =dao.findAllPizzas();
		assertEquals(8,pizzas.size());
	}

	/**
	 * Test method for {@link fr.pizzeria.console.PizzaMemDao#saveNewPizza(fr.pizzeria.model.Pizza)}.
	 */
	@Test
	public void testSaveNewPizza() {
		IPizzaDao dao = new PizzaMemDao();
		
		dao.saveNewPizza(new Pizza(10,"POP","Poporoni", CategoriePizza.VIANDE,12.50));
		
		assertEquals(9, dao.findAllPizzas().size());
	}

	/**
	 * Test method for {@link fr.pizzeria.console.PizzaMemDao#updatePizza(java.lang.String, fr.pizzeria.model.Pizza)}.
	 */
	@Test
	public void testUpdatePizza() {
		IPizzaDao dao = new PizzaMemDao();
		
		dao.updatePizza("PEP", new Pizza("POP","Poporoni", CategoriePizza.VIANDE,12.50));
		
		assertNull(dao.findPizzaByCode("PEP"));
	}

	/**
	 * Test method for {@link fr.pizzeria.console.PizzaMemDao#deletePizza(java.lang.String)}.
	 */
	@Test
	public void testDeletePizza() {
		IPizzaDao dao = new PizzaMemDao();
		
		dao.deletePizza("PEP");
		
		assertEquals(7, dao.findAllPizzas().size());
	}

	/**
	 * Test method for {@link fr.pizzeria.console.PizzaMemDao#findPizzaByCode(java.lang.String)}.
	 */
	@Test
	public void testFindPizzaByCode() {
		IPizzaDao dao = new PizzaMemDao();
		
		assertNotNull(dao.findPizzaByCode("PEP"));
	}

	/**
	 * Test method for {@link fr.pizzeria.console.PizzaMemDao#pizzaExists(java.lang.String)}.
	 */
	@Test
	public void testPizzaExists() {
		IPizzaDao dao = new PizzaMemDao();
		
		assertTrue(dao.pizzaExists("PEP"));
	}

}
