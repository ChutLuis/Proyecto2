/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.proyecto2.btree;

import gt.edu.url.proyecto2.dataStructures.DoubleLinkedList;
import gt.edu.url.proyecto2.design.CreateDot;

/**
 *
 * @author Luis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Iterationsbtree<Integer> n1= new Iterationsbtree<>();
        DoubleLinkedList<Integer> n2= new DoubleLinkedList<>();
        LinkedBinaryTree<Integer> n3 = new LinkedBinaryTree<>(); 
                
        n2.addFirst(1);
        n2.addFirst(2);
        n2.addFirst(3);
        n2.addFirst(4);
        n2.addFirst(5);
        n2.addFirst(6);        
        
        n3=n1.fillToTheRight(n2);
        Position<Integer> p1,p2,p3;
        p1= n3.root();
        p2= n3.left(p1);
        p3=n3.right(p1);
        System.out.println("===============");
        System.out.println(p2.getElement());
        System.out.println(p3.getElement());        
        System.out.println(n3.left(p3).getElement());
        
        CreateDot<Integer> mo = new CreateDot<>();
        mo.createBtree(n3);  
        
    }
    
}
