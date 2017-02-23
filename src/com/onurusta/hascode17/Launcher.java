package com.onurusta.hascode17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Launcher {

	public static void main(String[] args) {
		String[] fileNames = { "example", "small", "medium", "big" };
		String filePath = "/home/onurus/Documents/pizza17/";

		System.out.println("*********************************");
		for (String fileName : fileNames) {
			String inputFileName = filePath + fileName + ".in";
			String outputFileName = filePath + fileName + ".out";
			System.out.println("***\tSolution For : " + fileName);
			long l1 = System.currentTimeMillis();
			PizzaDefinition pizzaDefinition = null;
			try (Stream<String> stream = Files.lines(Paths.get(inputFileName))) {
				pizzaDefinition = new PizzaDefinition(stream);
			} catch (IOException e) {
				e.printStackTrace();
			}

			PizzaSolver solver = SolverFactory.getSolver(pizzaDefinition);

			long l2 = System.currentTimeMillis();
			System.out.println("***\t\tConstruction Time : " + (l2 - l1));

			l1 = System.currentTimeMillis();
			solver.findAllPossibleSlices();
			l2 = System.currentTimeMillis();
			System.out.println("***\t\tfindAllPossibleSlices Time : " + (l2 - l1));

			l1 = System.currentTimeMillis();
			solver.sliceSelectionForMaxTotalNode();
			l2 = System.currentTimeMillis();
			System.out.println("***\t\tsliceSelectionForMaxTotalNode Time : " + (l2 - l1) + memory());

			l1 = System.currentTimeMillis();
			new EarnedValueAnalysis(solver.getSlices(), pizzaDefinition.getR(), pizzaDefinition.getC())
			.calculateAndPrint();
			l2 = System.currentTimeMillis();
			System.out.println("***\t\tEarnedValueAnalysis Time : " + (l2 - l1));

			l1 = System.currentTimeMillis();
			new SolutionWritter().writeSolutionToFile(outputFileName, solver.getSlices());
			l2 = System.currentTimeMillis();
			System.out.println("***\t\t writeSolutionToFile Time : " + (l2 - l1));
			System.out.println("*********************************");
		}

	}

	private static String memory() {
		return "\t memory:" + ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024)
				+ "MB";
	}
}
