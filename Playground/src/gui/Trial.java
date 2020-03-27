package gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Trial extends JFrame {
	
	public Trial() {
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		setSize(450, 450);
		
		JButton button = new JButton("Press");
		panel.add(button);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Line2D lin = new Line2D.Float(100,100,250,250);
		g2.setStroke(new BasicStroke(10));
		g2.draw(lin);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trial t = new Trial();
		t.setVisible(true);
	}

}
