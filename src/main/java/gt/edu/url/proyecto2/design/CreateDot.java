/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.proyecto2.design;

import gt.edu.url.proyecto2.btree.LinkedBinaryTree;
import gt.edu.url.proyecto2.dataStructures.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class CreateDot<E> {
           int contDoubleLinkedList = 1;
    public String createDotDoubleLinkedList(DoubleLinkedList<E> dl, String storage) {
        String fileName = storage + "\\DoubleLinkedList #" + contDoubleLinkedList + ".dot";
        contDoubleLinkedList++;
        try {
            PrintWriter outputStream = new PrintWriter(fileName);
            outputStream.println("digraph foo {");
            E temp1, temp2;
            int n = dl.size() - 1;
            temp1 = dl.removeFirst();
            temp2 = dl.removeFirst();
            
            for (int i = 0; i < n; i++) {
                if (temp1 != null && temp2 != null) {
                    outputStream.println(temp1 + "->" + temp2 + ";");
                    outputStream.println(temp2 + "->" + temp1 + ";");
                }
                temp1 = temp2;
                temp2 = dl.removeFirst();
            }
        outputStream.println("}");
        outputStream.close();
        return fileName;
    }
    catch (FileNotFoundException ex

    
        ) {
            Logger.getLogger(CreateDot.class.getName()).log(Level.SEVERE, null, ex);
            return null;
    }
        
}

public void createBtree(LinkedBinaryTree<E> n1) {
        String fileName = "N1.dot";
        try {
            PrintWriter outputStream = new PrintWriter(fileName);
            outputStream.println("graph {");
            outputStream.println(n1.root().getElement().toString() + "--" + n1.left(n1.root()).getElement().toString() + ";");
            outputStream.println("}");
            outputStream.close();
        

} catch (FileNotFoundException ex) {
            Logger.getLogger(CreateDot.class  

.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
