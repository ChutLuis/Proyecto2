/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.proyecto2.design;

import gt.edu.url.proyecto2.btree.LinkedBinaryTree;
import gt.edu.url.proyecto2.btree.Position;
import gt.edu.url.proyecto2.dataStructures.DoubleLinkedList;
import gt.edu.url.proyecto2.dataStructures.DynamicStack;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class CreateDot<E> {
    
    public void createBtree(DoubleLinkedList<E> n1){
        String fileName= "N1.dot";
        try {
            PrintWriter outputStream = new PrintWriter(fileName);           
            E data= n1.first();
            E aux2;
            outputStream.println("graph {");    
            while(n1.isEmpty()!=true){
                outputStream.println(n1.removeFirst()+"--"+n1.removeFirst());
                aux2=n1.first();
                outputStream.println(data+"--"+aux2);
                aux2=n1.removeFirst();
            }
                
                
            
            outputStream.println("}");
            outputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateDot.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void createStack(DynamicStack<E> n1){
        String fileName= "N2.dot";
        try {
            PrintWriter outputStream = new PrintWriter(fileName);
            outputStream.println("digraph G {");            
            outputStream.println("node [shape= record]");
            outputStream.print("struct1 [label=\"{");
            while (n1.isEmpty()!=true) {                
                outputStream.print(n1.pop()+"|");
            }
             outputStream.println("}\"];");
            outputStream.println("}");
            outputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateDot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
