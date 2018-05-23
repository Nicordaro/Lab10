package it.polito.tdp.porto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.porto.db.PortoDAO;

public class Model {

	private PortoDAO pdao = new PortoDAO();
	private Graph<Author, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
	private Map<Integer, Author> idMapAutore = new HashMap<>(pdao.getAutori());
	private Map<Integer, Paper> idMapPaper = new HashMap<>(pdao.getArticoli());
	private List<AutArt> autArt = new ArrayList<>(pdao.getArticoliEAutori());

	public void createGraph() {
		for (Author a : idMapAutore.values()) {
			graph.addVertex(a);
			// System.out.println("aggiunto vertice");
		}

		// aggiungo autori a pubblicazioni e pubblicazioni ad autori
		for (AutArt aa : this.autArt) {
			int idAut = aa.getAutore();
			int idArt = aa.getPubblicazione();
			idMapAutore.get(idAut).addPubblicazione(idMapPaper.get(idArt));
			idMapPaper.get(idArt).addAutore(idMapAutore.get(idAut));
		}

		for (AutArt aa : this.autArt) {
			for (AutArt aa2 : this.autArt) {
				if ((aa.getPubblicazione() == aa2.getPubblicazione()) && (aa.getAutore() != aa2.getAutore())) {
					Author a1 = idMapAutore.get(aa.getAutore());
					Author a2 = idMapAutore.get(aa2.getAutore());
					graph.addEdge(a1, a2);
				}
			}
		}
	}

	public Graph<Author, DefaultEdge> getGraph() {
		return graph;
	}

}
