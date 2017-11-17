package gt.edu.url.proyecto2.diseño;
import gt.edu.url.proyecto2.dataStructures.DoubleLinkedList;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.DropMode;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(164, 37, 269, 283);
		contentPane.add(textArea);
		
		JButton btnSelectFile = new JButton("Select File");
		btnSelectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				DoubleLinkedList<Integer> bTree = new DoubleLinkedList<>();			
							
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				
				try {
					Scanner n1= new Scanner(f);
					FileReader reader = new FileReader(filename);
					BufferedReader br= new BufferedReader(reader);
					textArea.read(br, null);
					br.close();
					textArea.requestFocus();
					if (n1.findInLine("btree") != null) {						
						n1.nextLine();
						do {						 
						 int a = n1.nextInt();
						 bTree.addFirst(a);						 
						}while(n1.hasNext());
					}
					
					
					
				}catch(Exception e)
				{
					
				}
				int b=0;
				do {
					b= bTree.removeLast();
					System.out.println(b);
				}while(b!=0);
			}
		});
		btnSelectFile.setBounds(32, 38, 89, 23);
		contentPane.add(btnSelectFile);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(32, 87, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
//no se que esta pasando :'v
