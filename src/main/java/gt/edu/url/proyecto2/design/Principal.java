package gt.edu.url.proyecto2.design;

import javax.swing.*;
import gt.edu.url.proyecto2.btree.*;
import gt.edu.url.proyecto2.dataStructures.*;
import gt.edu.url.proyecto2.graphviz.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FilenameFilter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.filefilter.FileFileFilter;

/**
 *
 * @author Laptop
 *
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }
    
    /**
     * these are the objects that we used
     */
    Graphviz dg = new Graphviz();
    FileLoader Fl = new FileLoader();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos permitidos", "txt", "dot");
    JFileChooser filechoose = new JFileChooser();
    CreateDot newdot = new CreateDot();
    String location, storage, type;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImportDoc_buttom = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ShowDoc_AreaText = new javax.swing.JTextArea();
        GeneratGraph_Buttom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImportDoc_buttom.setText("Import txt doc");
        ImportDoc_buttom.setName("ImportTxtDoc"); // NOI18N
        ImportDoc_buttom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportDoc_buttomActionPerformed(evt);
            }
        });
        getContentPane().add(ImportDoc_buttom, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 42, 109, 31));

        ShowDoc_AreaText.setColumns(20);
        ShowDoc_AreaText.setRows(5);
        jScrollPane1.setViewportView(ShowDoc_AreaText);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 23, 245, 288));

        GeneratGraph_Buttom.setText("Generate Graph");
        GeneratGraph_Buttom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneratGraph_ButtomActionPerformed(evt);
            }
        });
        getContentPane().add(GeneratGraph_Buttom, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 84, -1, 32));

        pack();
    }// </editor-fold>//GEN-END:initComponents

/**
 * buttom used to import a new doc and show it in our text area
 * @param evt 
 */
    private void ImportDoc_buttomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportDoc_buttomActionPerformed
        filechoose.setFileFilter(filter);
        int opcion = filechoose.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            location = filechoose.getSelectedFile().getPath();
            ShowDoc_AreaText.setText(Fl.writetext(location));
        }
    }//GEN-LAST:event_ImportDoc_buttomActionPerformed
/**
 * buttom used to created all the new graphs
 * @param evt 
 */
    private void GeneratGraph_ButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneratGraph_ButtomActionPerformed

        filechoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (filechoose.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            storage = filechoose.getSelectedFile().getAbsolutePath();
        }

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(location));
            type = reader.readLine();
            while (type != null) {
                String[] data = reader.readLine().split(" ");
                int[] datos = new int[data.length];

                if (!"".equals(data[0])) {
                    for (int i = 0; i < datos.length; i++) {
                        datos[i] = Integer.parseInt(data[i]);
                    }
                } else {
                    datos[0] = -35154639;
                }

                switch (type) {
                    case "stack":
                        DynamicStack S = new DynamicStack();
                        if (!"".equals(data[0])) {
                            for (int i = 0; i < datos.length; i++) {
                                S.push(datos[i]);
                            }
                        }
                        dg.createDemoFromDot(newdot.createStack(S, storage), storage, type);
                        break;
                    case "queue":
                        DynamicQueue Q = new DynamicQueue();
                        if (!"".equals(data[0])) {
                            for (int i = 0; i < datos.length; i++) {
                                Q.enqueue(datos[i]);
                            }
                        }
                        dg.createDemoFromDot(newdot.createQueue(Q, storage), storage, type);
                        break;
                    case "linkedlist":
                        LinkedList ll = new LinkedList();
                        if (!"".equals(data[0])) {
                            for (int i = 0; i < datos.length; i++) {
                                ll.addLast(datos[i]);
                            }
                        }
                        dg.createDemoFromDot(newdot.createDotLinkedList(ll, storage), storage, type);
                        break;
                    case "circularlinkedlist":
                        CircularLinkedList Cl = new CircularLinkedList();
                        if (!"".equals(data[0])) {
                            for (int i = 0; i < datos.length; i++) {
                                Cl.addLast(datos[i]);
                            }
                        }
                        dg.createDemoFromDot(newdot.createDotCircularLinkedList(Cl, storage), storage, type);
                        break;
                    case "doublelinkedlist":
                        DoubleLinkedList dl = new DoubleLinkedList();
                        if (!"".equals(data[0])) {
                            for (int i = 0; i < datos.length; i++) {
                                dl.addLast(datos[i]);
                            }
                        }
                       dg.createDemoFromDot(newdot.createDotDoubleLinkedList(dl, storage), storage, type);
                        break;
                    case "btree":
                        DoubleLinkedList d1 = new DoubleLinkedList();
                        if (!"".equals(data[0])) {
                            for (int i = 0; i < datos.length; i++) {
                                d1.addFirst(datos[i]);
                            }
                        }
                        Iterationsbtree n1= new Iterationsbtree();
                        LinkedBinaryTree bt = new LinkedBinaryTree();
                        bt= n1.fillToTheRight(d1);
                        dg.createDemoFromDot(newdot.createBtree(bt, storage), storage, type);
                        break;
                }
                type = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_GeneratGraph_ButtomActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GeneratGraph_Buttom;
    private javax.swing.JButton ImportDoc_buttom;
    private javax.swing.JTextArea ShowDoc_AreaText;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
