package com.onurusta.hascode17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PizzaDefinition {
	// the number of rows
	private int r;
	// number of columns
	private int c;
	// minimum number of each ingredient cells in a slice
	private int l;
	// maximum total number of cells of a slice
	private int h;

	private PizzaNode[][] grid;

	public PizzaDefinition(Stream<String> stream) {
		// Parsing
		List<String> list = stream.collect(Collectors.toList());
		String[] sList = list.get(0).split(" ");
		this.r = Integer.parseInt(sList[0]);
		this.c = Integer.parseInt(sList[1]);
		this.l = Integer.parseInt(sList[2]);
		this.h = Integer.parseInt(sList[3]);

		this.grid = new PizzaNode[this.r][this.c];

		for (int i = 1; i < list.size(); i++) {
			String line = list.get(i);
			for (int j = 0; j < line.length(); j++) {
				this.grid[i - 1][j] = this.grid[i - 1][j];
				this.grid[i - 1][j] = new PizzaNode(i - 1, j, line.charAt(j));
			}
		}

	}

	public int getR() {
		return this.r;
	}

	public int getC() {
		return this.c;
	}

	public int getL() {
		return this.l;
	}

	public int getH() {
		return this.h;
	}

	public PizzaNode[][] getGrid() {
		return this.grid;
	}

	public PizzaSlice getPizzaSlice(int r1, int c1, int r2, int c2) {

		int tomatoCount = 0;
		int mushroomCount = 0;

		List<PizzaNode> nodes = new ArrayList<PizzaNode>();
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				PizzaNode node = this.grid[i][j];
				if (node.isTomato()) {
					tomatoCount++;
				} else {
					mushroomCount++;
				}
				nodes.add(node);
			}
		}
		PizzaSlice result = new PizzaSlice(r1, c1, r2, c2, tomatoCount, mushroomCount, nodes);

		return result;
	}

}
