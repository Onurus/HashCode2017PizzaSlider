package com.onurusta.hascode17;

public class SolverFactory {

	private static final int limit = 100 * 100;

	public static PizzaSolver getSolver(PizzaDefinition pizzaDefinition) {
		int totalNode = pizzaDefinition.getR() * pizzaDefinition.getC();

		if (totalNode < limit) {
			return new GoodSolver(pizzaDefinition);
		}
		return new BigSolver(pizzaDefinition);
	}

}
