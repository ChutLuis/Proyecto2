package gt.edu.url.proyecto2.graphviz;

import static guru.nidi.graphviz.model.Factory.graph;
import static guru.nidi.graphviz.model.Factory.node;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import guru.nidi.graphviz.engine.*;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;

public class Graphviz {

    public void createDemoGraph() throws IOException {
        Graph g = graph("example1").directed().with(node("a").link(node("b")));
        guru.nidi.graphviz.engine.Graphviz.fromGraph(g).width(200).render(Format.PNG).toFile(new File("example/ex1.png"));
    }

    public void createDemoFromDot() throws IOException{
        File file = new File("C:\\Users\\Laptop\\Desktop\\Lab8_GraphViz_1067817\\Grafo2.dot");
        FileInputStream fis = null;

        fis = new FileInputStream(file);

        MutableGraph g = Parser.read(fis);

        guru.nidi.graphviz.engine.Graphviz.fromGraph(g).width(700).render(Format.PNG).toFile(new File("C:\\Users\\Laptop\\Desktop\\ex4-1.png"));
    }
}
