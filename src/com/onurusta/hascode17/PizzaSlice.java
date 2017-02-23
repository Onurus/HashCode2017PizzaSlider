package com.onurusta.hascode17;

import java.util.List;

public class PizzaSlice implements Comparable<PizzaSlice> {

	private int r1;
	private int c1;
	private int r2;
	private int c2;

	private int tomatoCount;
	private int mushroomCount;
	private int area;
	private List<PizzaNode> nodes;

	public PizzaSlice(int r1, int c1, int r2, int c2, int tomatoCount, int mushroomCount, List<PizzaNode> nodes) {
		super();
		this.r1 = r1;
		this.c1 = c1;
		this.r2 = r2;
		this.c2 = c2;
		this.tomatoCount = tomatoCount;
		this.mushroomCount = mushroomCount;
		this.area = (((r2 - r1) + 1) * ((c2 - c1) + 1));
		this.nodes = nodes;

	}

	public List<PizzaNode> getNodes() {
		return this.nodes;
	}

	@Override
	public int compareTo(PizzaSlice o) {
		return Integer.compare(this.area, o.getAreaRatio());
	}

	private int getAreaRatio() {
		return this.area;
	}

	public int getR1() {
		return this.r1;
	}

	public int getC1() {
		return this.c1;
	}

	public int getR2() {
		return this.r2;
	}

	public int getC2() {
		return this.c2;
	}

	public int getTomatoCount() {
		return this.tomatoCount;
	}

	public int getMushroomCount() {
		return this.mushroomCount;
	}

	public boolean notContainSameNode(PizzaSlice ps) {
		for (PizzaNode pizzaNode : this.nodes) {
			if (ps.getNodes().contains(pizzaNode)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PizzaSlice) {
			PizzaSlice ps = (PizzaSlice) obj;
			return (ps.getC1() == this.c1) && (ps.getC2() == this.c2) && (ps.getR1() == this.r1)
					&& (ps.getR2() == this.r2);
		} else {
			return false;
		}

	}

}
