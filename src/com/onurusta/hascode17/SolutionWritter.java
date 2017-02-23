package com.onurusta.hascode17;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SolutionWritter {

	public void writeSolutionToFile(String outputFileName, List<PizzaSlice> slices) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {

			bw.write(slices.size() + "\n");
			for (PizzaSlice pizzaSlice : slices) {
				bw.write(pizzaSlice.getR1() + " " + pizzaSlice.getC1() + " " + pizzaSlice.getR2() + " "
						+ pizzaSlice.getC2() + "\n");
			}

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
