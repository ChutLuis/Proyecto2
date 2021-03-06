/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.proyecto2.design;

import gt.edu.url.proyecto2.btree.*;
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
    /**
     * these are the conters of the diferent types of data structures
     */
    int contStack = 1;
    int contQueue = 1;
    int contLinkedList = 1;
    int contCircularLinkedList = 1;
    int contDoubleLinkedList = 1;
    int contBtree = 1;
    
/**
 * this method creates a new doc.dot
 * @param S, is our new data structure
 * @param storage, where we are going to save the new doc .dot
 * @return string with the location of the new doc .dot
 */
    public String createStack(DynamicStack<E> S, String storage) {
        String fileName = storage + "\\Stack #" + contStack + ".dot";
        contStack++;
        try {
            PrintWriter outputStream = new PrintWriter(fileName);
            outputStream.println("digraph G {");
            outputStream.println("node [shape= record]");
            outputStream.print("struct1 [label=\"{");
            while (S.isEmpty() != true) {
                outputStream.print(S.pop());
                if (S.isEmpty() != true) {
                    outputStream.print("|");
                }
            }
            outputStream.println("}\"];");
            outputStream.println("}");
            outputStream.close();
            return fileName;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateDot.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /**
 * this method creates a new doc.dot
 * @param Q, is our new data structure
 * @param storage, where we are going to save the new doc .dot
 * @return string with the location of the new doc .dot
 */

    public String createQueue(DynamicQueue<E> Q, String storage) {
        String fileName = storage + "\\Queue #" + contQueue + ".dot";
        contQueue++;
        try {
            PrintWriter outputStream = new PrintWriter(fileName);
            outputStream.println("digraph G {");
            outputStream.println("rankdir=LR;");
            outputStream.println("node [shape= record]");
            outputStream.print("struct1 [label=\"{");
            while (Q.isEmpty() != true) {
                outputStream.print(Q.dequeue());
                if (Q.isEmpty() != true) {
                    outputStream.print("|");
                }
            }
            outputStream.println("}\"];");
            outputStream.println("}");
            outputStream.close();
            return fileName;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateDot.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
/**
 * this method creates a new doc.dot
 * @param Ll, is our new data structure
 * @param storage, where we are going to save the new doc .dot
 * @return string with the location of the new doc .dot
 */
    public String createDotLinkedList(LinkedList<E> Ll, String storage) {
        String fileName = storage + "\\LinkedList #" + contLinkedList + ".dot";
        contLinkedList++;
        try {
            PrintWriter outputStream = new PrintWriter(fileName);
            outputStream.println("digraph foo {");
            E temp1, temp2;
            int n = Ll.size() - 1;
            temp1 = Ll.removeFirst();
            temp2 = Ll.removeFirst();
            if (n == 0) {
                outputStream.println(temp1 + ";");
            } else {
                for (int i = 0; i < n; i++) {
                    if (temp1 != null && temp2 != null) {
                        outputStream.println(temp1 + "->" + temp2 + ";");
                    }
                    temp1 = temp2;
                    temp2 = Ll.removeFirst();
                }
            }
            outputStream.println("}");
            outputStream.close();
            return fileName;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateDot.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
/**
 * this method creates a new doc.dot
 * @param cl, is our new data structure
 * @param storage, where we are going to save the new doc .dot
 * @return string with the location of the new doc .dot
 */
    public String createDotCircularLinkedList(CircularLinkedList<E> cl, String storage) {
        String fileName = storage + "\\CircularLinkedList #" + contCircularLinkedList + ".dot";
        contCircularLinkedList++;
        try {
            PrintWriter outputStream = new PrintWriter(fileName);
            outputStream.println("digraph foo {");
            outputStream.println("layout=circo");
            E first, temp1, temp2;
            int n = cl.size() - 1;
            temp1 = cl.removeFirst();
            first = temp1;
            temp2 = cl.removeFirst();

            if (n == 0) {
                outputStream.println(temp1 + ";");
            } else {
                for (int i = 0; i < n; i++) {
                    if (temp1 != null && temp2 != null) {
                        outputStream.println(temp1 + "->" + temp2 + ";");
                    }
                    temp1 = temp2;
                    temp2 = cl.removeFirst();
                }
                if (temp1 != first) {
                    outputStream.println(temp1 + "->" + first + ";");
                }
            }
            outputStream.println("}");
            outputStream.close();
            return fileName;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateDot.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
/**
 * this method creates a new doc.dot
 * @param dl, is our new data structure
 * @param storage, where we are going to save the new doc .dot
 * @return string with the location of the new doc .dot
 */
    public String createDotDoubleLinkedList(DoubleLinkedList<E> dl, String storage) {
        String fileName = storage + "\\DoubleLinkedList #" + contDoubleLinkedList + ".dot";
        contDoubleLinkedList++;
        try {
            PrintWriter outputStream = new PrintWriter(fileName);
            outputStream.println("digraph foo {");
            outputStream.println("rankdir=LR;");
            E temp1, temp2;
            int n = dl.size() - 1;
            temp1 = dl.removeFirst();
            temp2 = dl.removeFirst();

            if (n == 0) {
                outputStream.println(temp1 + ";");
            } else {
                for (int i = 0; i < n; i++) {
                    if (temp1 != null && temp2 != null) {
                        outputStream.println(temp1 + "->" + temp2 + ";");
                        outputStream.println(temp2 + "->" + temp1 + ";");
                    }
                    temp1 = temp2;
                    temp2 = dl.removeFirst();
                }
            }
            outputStream.println("}");
            outputStream.close();
            return fileName;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateDot.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    /**
 * this method creates a new doc.dot
 * @param n1, is our new data structure
 * @param storage, is where we will save de doc
 */
    public String createBtree(LinkedBinaryTree<E> n1, String storage){               
        String fileName = storage + "\\BeeTree #" + contBtree + ".dot";
        contBtree++;      
        Position<E> p1,p2,p3;
        p1=n1.root();
        p2=n1.left(p1);
        p3=n1.right(p1);
        do{           
             p2=n1.left(p1);
             p3=n1.right(p1);
             p1=p3;
            }while(n1.numChildren(p1)!=0);
        if(n1.isExternal(p1))System.out.println("Succes");
        try {
            PrintWriter outputStream = new PrintWriter(fileName);               
            outputStream.println("graph {");    
            do{                
                if(n1.numChildren(p1)==2){outputStream.println(n1.parent(p1).getElement().toString()+"--"+"{"+p1.getElement().toString()+" "+n1.sibling(p1).getElement().toString()+"}"+";");}
                else if(n1.numChildren(n1.parent(p1))!=0){outputStream.println(n1.parent(p1).getElement().toString()+"--"+n1.left(n1.parent(p1)).getElement().toString()+";");}
                else if(n1.numChildren(n1.parent(p1))==0){outputStream.println(n1.parent(p1).getElement().toString()+"--"+"null"+";");}
                p1=n1.parent(p1);
                   
            }while( p1 != n1.root());
            outputStream.println("}");
            outputStream.close();
        
} catch (FileNotFoundException ex) {
            Logger.getLogger(CreateDot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fileName;
    }
}
