package com.onurusta.hascode17;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class PizzaSolver {
	protected PizzaDefinition defs;
	protected List<PizzaSlice> slices;

	protected PizzaSolver(PizzaDefinition definition) {
		this.defs = definition;
	}

	protected Predicate<? super PizzaSlice> hasEnoughTomato = ps -> ps.getTomatoCount() >= this.defs.getL();

	protected Predicate<? super PizzaSlice> hasEnoughMushroom = ps -> ps.getMushroomCount() >= this.defs.getL();

	public abstract void findAllPossibleSlices();

	public void sliceSelectionForMaxTotalNode() {
		System.out.println("***\t\t\tbefore sliceSelectionForMaxTotalNode size() :" + this.slices.size());
		List<PizzaSlice> tempList = this.slices;
		this.slices = new ArrayList<PizzaSlice>();

		while (tempList.size() > 0) {
			PizzaSlice ps = tempList.stream().sorted().findFirst().get();
			this.slices.add(ps);
			tempList.remove(ps);
			tempList = tempList.stream().filter(p -> p.notContainSameNode(ps)).sorted().collect(Collectors.toList());
		}
		System.out.println("***\t\t\tafter sliceSelectionForMaxTotalNode size() :" + this.slices.size());

	}

	public List<PizzaSlice> getSlices() {
		return this.slices;
	}
}
