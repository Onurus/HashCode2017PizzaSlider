package com.onurusta.hascode17;

import java.util.HashSet;
import java.util.Set;

public class PizzaNode {

	private boolean isTomato;

	private Set<PizzaSlice> pizzaSlices;

	public PizzaNode(int r, int c, char ch) {
		this.isTomato = (ch == 'T');
		this.pizzaSlices = new HashSet<PizzaSlice>();
	}

	public void addPizzaSlice(PizzaSlice slice) {
		this.pizzaSlices.add(slice);
	}

	public boolean isTomato() {
		return this.isTomato;
	}
}
