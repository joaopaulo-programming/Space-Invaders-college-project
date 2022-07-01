package Jogo_APS;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {

	private Image imagem;
	private Image fundo;
	private Player player;
	private Timer timer;
	private List<Enemy1> enemy1;
	private List<Enemy2> enemy2;
	private List<Enemy3> enemy3;
	private List<Enemy4> enemy4;
	private List<Stars> stars;
	private List<Nuvens> nuvens;
	private boolean emJogo;
	

	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);

		ImageIcon referencia = new ImageIcon("res\\Fundo.jpg");
		fundo = referencia.getImage();

		player = new Player();
		player.load();

		addKeyListener(new TecladoAdapter());

		timer = new Timer(5, this);
		timer.start();

		inicializaInimigos();
		inicializaStars();
		inicializaNuvens();
		emJogo = true;

	}

	public void inicializaInimigos() {
		int num = 1;
		
		for(int n = 0; n <= num; n++) {num += 1;}
		
		int cordenadas[] = new int[num]; // Numero de inimigos
		enemy1 = new ArrayList<Enemy1>();
		enemy2 = new ArrayList<Enemy2>();
		enemy3 = new ArrayList<Enemy3>();
		enemy4 = new ArrayList<Enemy4>();
	
		for (int i = 0; i < cordenadas.length; i++) {
			int x = (int) (Math.random() * 8000 + 1024); // algoritmo ira escolher um numero entre 8000 e 1024 para //spawnar um inimigo.
			int y = (int) (Math.random() * 650 + 20);
			enemy1.add(new Enemy1(x, y));
			
			int x2 = (int) (Math.random() * 8000 + 1024);
			int y2 = (int) (Math.random() * 650 + 20);
			enemy2.add(new Enemy2(x2, y2));
			
			int x3 = (int) (Math.random() * 8000 + 1024);
			int y3 = (int) (Math.random() * 650 + 20);
			enemy3.add(new Enemy3(x3, y3));
			
			int x4 = (int) (Math.random() * 8000 + 1024);
			int y4 = (int) (Math.random() * 650 + 20);
			enemy4.add(new Enemy4(x4, y4)); 
			
		}
	}

	public void inicializaStars() {
		int cordenadas[] = new int[1]; // Numero de estrelas
		stars = new ArrayList<Stars>();

		for (int i = 0; i < cordenadas.length; i++) {
			int x = (int) (Math.random() * 1050 + 1024); // algoritmo ira escolher um numero entre 8000 e 1024 para //
															// spawnar um inimigo.
			int y = (int) (Math.random() * 768 + 0);
			stars.add(new Stars(x, y));
		}

	}
	public void inicializaNuvens() {
		int cordenadas[] = new int[2]; //numero nuvens
		nuvens = new ArrayList<Nuvens>();

		for (int i = 0; i < cordenadas.length; i++) {
			int x = (int) (Math.random() * 1050 + 1024);
			int y = (int) (Math.random() * 768 + 0);
			nuvens.add(new Nuvens(x, y));
		}

	}

	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		if (emJogo == true) {
			graficos.drawImage(fundo, 0, 0, null);

			for (int p = 0; p < stars.size(); p++) {
				Stars q = stars.get(p);
				q.load();
				graficos.drawImage(q.getImagem(), q.getX(), q.getY(), this);
			}
			for (int nu = 0; nu < nuvens.size(); nu++) {
				Nuvens
				na = nuvens.get(nu);
				na.load();
				graficos.drawImage(na.getImagem(), na.getX(), na.getY(), this);
			}
			

			graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

			List<Tiro> tiros = player.getTiros();
			for (int i = 0; i < tiros.size(); i++) {
				Tiro m = tiros.get(i);
				m.load();
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
			}

			
				for (int o = 0; o < enemy1.size(); o++) {
					Enemy1 in1 = enemy1.get(o);
					
				
					in1.load();
					graficos.drawImage(in1.getImagem(), in1.getX(), in1.getY(), this);
				}
			} else {
				ImageIcon fimJogo = new ImageIcon("res\\GameOver.jpg");
				graficos.drawImage(fimJogo.getImage(), 0, 0, null);
				
				
			}
			
			for (int a = 0; a < enemy2.size(); a++) {
				Enemy2 in2 = enemy2.get(a);
				in2.load();
				graficos.drawImage(in2.getImagem(), in2.getX(), in2.getY(), this);
				
			}
		
			for (int b = 0; b < enemy3.size(); b++) {
				Enemy3 in3 = enemy3.get(b);
				in3.load();
				graficos.drawImage(in3.getImagem(), in3.getX(), in3.getY(), this);
			}
			
			for (int c = 0; c < enemy4.size(); c++) {
				Enemy4 in4 = enemy4.get(c);
				in4.load();
				graficos.drawImage(in4.getImagem(), in4.getX(), in4.getY(), this);
			}

		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		if (player.isTurbo()) {
			timer.setDelay(2);

		}
		if (player.isTurbo() == false) {
			timer.setDelay(5);

		}


		for (int p = 0; p < stars.size(); p++) {
			Stars on = stars.get(p);
			if (on.isVisivel()) {
				on.update();
			} else {
				stars.remove(p);
			}

		}

		for (int b = 0; b < nuvens.size(); b++) {
			Nuvens on = nuvens.get(b);
			if (on.isVisivel()) {
				on.update();
			} else {
				nuvens.remove(b);
			}

		}

		List<Tiro> tiros = player.getTiros();
		for (int i = 0; i < tiros.size(); i++) {
			Tiro m = tiros.get(i);
			if (m.isVisivel()) {
				m.update();
				if(player.isTurbo()) {
					tiros.get(i);
					Tiro.setVELOCIDADE(-1);
				}
				
				if(player.isTurbo() == false) {
					tiros.get(i);
					Tiro.setVELOCIDADE(2);
				}
			} else {
				tiros.remove(i);
			}
		}

		for (int o = 0; o < enemy1.size(); o++) {// lista para determinar inumeros inimigos com lista de aloca��o
													// dinamica
			Enemy1 in1 = enemy1.get(o);
			Enemy2 in2 = enemy2.get(o);
			Enemy3 in3 = enemy3.get(o);
			Enemy4 in4 = enemy4.get(o);
			
			if (in1.isVisivel() && in2.isVisivel() && in3.isVisivel() && in4.isVisivel()){
				in1.update();
				in2.update();
				in3.update();
				in4.update();
			} else {
				enemy1.remove(o);
				enemy2.remove(o);
				enemy3.remove(o);
				enemy4.remove(o);
			}

		checarColisoes();
		repaint();

	}
}

	public void checarColisoes() {
		Rectangle formaNave = player.getBounds();
		Rectangle formaEnemy1;
		Rectangle formaEnemy2;
		Rectangle formaEnemy3;
		Rectangle formaEnemy4;
		Rectangle formaTiro;

		for (int i = 0; i < enemy1.size(); i++) {
			Enemy1 tempEnemy1 = enemy1.get(i);
			formaEnemy1 = tempEnemy1.getBounds();
			if (formaNave.intersects(formaEnemy1)) {

				ImageIcon referencia = new ImageIcon("res\\GameOver.jpg");
				imagem = referencia.getImage();
				
				
				if(player.isTurbo()) {
					tempEnemy1.setVisivel(false);
				}else {
					player.setVisivel(false);
					tempEnemy1.setVisivel(false);
					emJogo = false;
					
				}
			}
		}
		for (int a = 0; a < enemy2.size(); a++) {
			Enemy2 tempEnemy2 = enemy2.get(a);
			formaEnemy2 = tempEnemy2.getBounds();
			if (formaNave.intersects(formaEnemy2)) {
				tempEnemy2.setVisivel(false);
			}
		}
						
		for (int b = 0; b < enemy3.size(); b++) {
			Enemy3 tempEnemy3 = enemy3.get(b);
				formaEnemy3 = tempEnemy3.getBounds();
				if (formaNave.intersects(formaEnemy3)) {
					tempEnemy3.setVisivel(false);
				}
		}
					
		for (int c = 0; c < enemy4.size(); c++) {
			Enemy4 tempEnemy4 = enemy4.get(c);
			formaEnemy4 = tempEnemy4.getBounds();
			if (formaNave.intersects(formaEnemy4)) {
				tempEnemy4.setVisivel(false);	
			}	
		}

		List<Tiro> tiros = player.getTiros();
		for (int j = 0; j < tiros.size(); j++) {
			Tiro tempTiro = tiros.get(j);
			formaTiro = tempTiro.getBounds();
			for (int o = 0; o < enemy1.size(); o++) {
				Enemy1 tempEnemy1 = enemy1.get(o);
				formaEnemy1 = tempEnemy1.getBounds();
				if (formaTiro.intersects(formaEnemy1)) {
					tempEnemy1.setVisivel(false);
					tempTiro.setVisivel(false);
					
				}
			}
		}
	}

	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			player.keyRelease(e);
		}

	}

	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

}
