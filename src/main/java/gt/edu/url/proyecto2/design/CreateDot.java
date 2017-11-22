/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.proyecto2.design;

import gt.edu.url.proyecto2.btree.LinkedBinaryTree;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class CreateDot<E> {
    
    public void createBtree(LinkedBinaryTree<E> n1){
        String fileName= "N1.dot";
        try {
            PrintWriter outputStream = new PrintWriter(fileName);
            outputStream.println("graph {");            
            outputStream.println(n1.root().getElement().toString()+"--"+ n1.left(n1.root()).getElement().toString()+";");
            outputStream.println("}");
            outputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateDot.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
