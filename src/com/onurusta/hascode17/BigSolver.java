package com.onurusta.hascode17;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BigSolver extends PizzaSolver {

	protected BigSolver(PizzaDefinition definition) {
		super(definition);
	}

	@Override
	public void findAllPossibleSlices() {
		this.slices = new ArrayList<PizzaSlice>();
		int x = (int) Math.sqrt(this.defs.getH());

		searchAndAddAllSlides(x, (int) Math.floor(this.defs.getH() / x));

		if (x > 1) {
			x--;
			searchAndAddAllSlides(x, (int) Math.floor(this.defs.getH() / x));

		}

		this.slices = this.slices.stream().distinct().filter(this.hasEnoughTomato).filter(this.hasEnoughMushroom)
				.sorted().collect(Collectors.toList());

	}

	private void searchAndAddAllSlides(int x, int y) {
		for (int r = 0; ((((r * x) + x)) - 1) < this.defs.getR(); r++) {
			for (int c = 0; ((((c * y) + y)) - 1) < this.defs.getC(); c++) {
				PizzaSlice ps = this.defs.getPizzaSlice(r, c, (r + x) - 1, (c + y) - 1);
				this.slices.add(ps);

			}
		}

	}
}
