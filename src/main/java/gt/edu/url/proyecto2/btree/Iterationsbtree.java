/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.proyecto2.btree;

import gt.edu.url.proyecto2.btree.LinkedBinaryTree.Node;
import gt.edu.url.proyecto2.dataStructures.DoubleLinkedList;

/**
 *
 * @author Luis
 */
public class Iterationsbtree<E> {

    /**
     * converts a doubleLinkedList in a tree and fills it in the right
     *
     * @param tryn, the double linked list
     * @return the tree filled
     */
    public LinkedBinaryTree<E> fillToTheRight(DoubleLinkedList<E> tryn) {
        LinkedBinaryTree<E> n1 = new LinkedBinaryTree<>();
        Position<E> p0, p1 = null, p2;
        if (tryn.isEmpty()) {
            return n1;
        }
        n1.addRoot(tryn.removeLast());
        p0 = n1.root();
        while (tryn.isEmpty() != true) {
            System.out.println(p0.getElement());
            p1 = n1.addLeft(p0, tryn.removeLast());
            System.out.println(p1.getElement());
            p2 = n1.addRight(p0, tryn.removeLast());

            p0 = p2;

        }
        return n1;
    }

}
