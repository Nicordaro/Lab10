package it.polito.tdp.porto.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		model.createGraph();
		System.out.println(model.getGraph().vertexSet().size());
		System.out.println(model.getGraph().edgeSet().size());
		System.out.println(model.getGraph());
	}

}
