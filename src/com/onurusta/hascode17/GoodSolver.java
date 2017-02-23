package com.onurusta.hascode17;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GoodSolver extends PizzaSolver {

	protected GoodSolver(PizzaDefinition definition) {
		super(definition);
	}

	@Override
	public void findAllPossibleSlices() {
		this.slices = new ArrayList<PizzaSlice>();
		for (int r1 = 0; r1 < this.defs.getR(); r1++) {
			for (int c1 = 0; c1 < this.defs.getC(); c1++) {
				for (int rDiff = 0; ((r1 + rDiff) < this.defs.getR()); rDiff++) {
					for (int cDiff = 0; ((c1 + cDiff) < this.defs.getC()); cDiff++) {
						if (((cDiff + 1) * (rDiff + 1)) <= this.defs.getH()) {
							this.slices.add(this.defs.getPizzaSlice(r1, c1, r1 + rDiff, c1 + cDiff));
						}
					}
				}
			}
		}

		this.slices = this.slices.stream().filter(this.hasEnoughTomato).filter(this.hasEnoughMushroom).sorted()
				.collect(Collectors.toList());
	}
}
