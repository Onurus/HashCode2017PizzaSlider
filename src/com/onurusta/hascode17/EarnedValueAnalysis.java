package com.onurusta.hascode17;

import java.util.List;

public class EarnedValueAnalysis {

	private List<PizzaSlice> slices;
	private int r;
	private int c;
	private int[][] grid;

	public EarnedValueAnalysis(List<PizzaSlice> slices, int r, int c) {
		this.slices = slices;
		this.r = r;
		this.c = c;
		this.grid = new int[this.r][this.c];
	}

	public void calculateAndPrint() {

		for (int i = 0; i < this.r; i++) {
			for (int j = 0; j < this.c; j++) {
				this.grid[i][j] = 0;
			}
		}
		for (PizzaSlice ps : this.slices) {
			for (int i = ps.getR1(); i <= ps.getR2(); i++) {
				for (int j = ps.getC1(); j <= ps.getC2(); j++) {
					this.grid[i][j]++;
				}
			}
		}

		int gainedNode = 0;
		int conflictNode = 0;
		int totalNode = this.r * this.c;
		for (int i = 0; i < this.r; i++) {
			for (int j = 0; j < this.c; j++) {
				if (this.grid[i][j] == 1) {
					gainedNode++;
				} else if (this.grid[i][j] > 1) {
					conflictNode = conflictNode + (this.grid[i][j] - 1);
				}
			}
		}
		System.out.println("***\t\t\t Earned Value Ratio : %" + (int) ((100.0 * gainedNode) / (totalNode * 1.0)));
		System.out.println("***\t\t\t ConflictRatio : %" + (int) ((100.0 * conflictNode) / (totalNode * 1.0)));
	}
}
