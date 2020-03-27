package gui;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main extends JFrame{
	
	public Main() {
		setTitle("Window 1");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Menu
		JMenuBar menu = new JMenuBar();
		JMenu datei = new JMenu("Menu 1");
		JMenuItem abo = new JMenuItem("abo");
		abo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Desktop desktop = Desktop.getDesktop();
				URL url = null;
				try {
					url = new URL("youtube.com/?hl=tr&gl=TR");
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					desktop.browse(url.toURI());
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		datei.add(abo);
		menu.add(datei);
		setJMenuBar(menu);
		
		Container pane = getContentPane();
		GroupLayout g1 = new GroupLayout(pane);
		pane.setLayout(g1);
		
		JButton button = new JButton("Button 1");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(0);
			}
			
		});
		
		g1.setVerticalGroup(g1.createSequentialGroup().addComponent(button));
		g1.setHorizontalGroup(g1.createSequentialGroup().addComponent(button));
		
		g1.setAutoCreateContainerGaps(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Main m = new Main();
				m.setVisible(true);
			}
			
		});
	}

}
