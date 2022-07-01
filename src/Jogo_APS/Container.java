package Jogo_APS;

import javax.swing.JFrame;

public class Container extends JFrame{
	public Container() {
		add(new Fase());
		setTitle("Sustentabilidade");
		setSize(1024,728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Container();		
	}
}
