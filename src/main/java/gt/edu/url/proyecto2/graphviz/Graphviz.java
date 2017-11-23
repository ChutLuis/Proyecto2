package gt.edu.url.proyecto2.graphviz;

import static guru.nidi.graphviz.model.Factory.graph;
import static guru.nidi.graphviz.model.Factory.node;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import guru.nidi.graphviz.engine.*;
//import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;

public class Graphviz {

    int cont = 1;

    /**
     * this method creates a new grahp from a .dot doc
     * @param Location, the location of the doc.dot
     * @param Storage, where we are going to save de graph
     * @param Type, the type of the data stricture
     * @throws IOException 
     */
public void createDemoFromDot(String Location, String Storage, String Type) throws IOException {
        File file = new File(Location);
        FileInputStream fis = null;
        fis = new FileInputStream(file);

        MutableGraph g = Parser.read(fis);
        guru.nidi.graphviz.engine.Graphviz.fromGraph(g).width(700).render(Format.PNG).toFile(new File
        (Storage + "\\example #" + cont + ' ' + Type +".png"));
        cont++;
}
}
