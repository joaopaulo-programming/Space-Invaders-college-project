package Jogo_APS;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Player implements ActionListener {

	private int x, y;
	private int dx, dy;
	private Image imagem;
	private int altura, largura;
	private List<Tiro> tiros;// Lista para alocar a quantidade indeterminada que o player irá disparar.
	private boolean isVisivel, isTurbo;
	private Timer timer;

	

	public Player() {
		this.x = 100;
		this.y = 100;
		isVisivel = true;
		isTurbo = false;

		tiros = new ArrayList<Tiro>();

		timer = new Timer(5000, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (isTurbo == true) {
			turbo();
			isTurbo = false;
		}

		if (isTurbo == false) {
			load();
		}

	}

	public void load() {
		ImageIcon referencia = new ImageIcon("res\\Nave1.png");
		imagem = referencia.getImage();

		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);

	}
	
	

	public void update() {
		x += dx;
		y += dy;
	}

	public void tiroSimples() {
		this.tiros.add(new Tiro(x + largura, y + (altura / 2)));
	}

	public void turbo() {
		isTurbo = true;
		ImageIcon referencia = new ImageIcon("res\\Turbo.png");
		imagem = referencia.getImage();
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}

	public void keyPressed(KeyEvent tecla) {// Movimentação do "icone" nave Key event
		int codigo = tecla.getKeyCode();

		if (codigo == KeyEvent.VK_S) {
			turbo();

		}
		if (codigo == KeyEvent.VK_A) {
			tiroSimples();
		}

		if (codigo == KeyEvent.VK_UP) {
			dy = -3;
		}

		if (codigo == KeyEvent.VK_DOWN) {
			dy = 3;
		}

		if (codigo == KeyEvent.VK_LEFT) {
			dx = -3;
		}

		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 3;
		}

	}

	public void keyRelease(KeyEvent tecla) {// Movimentação do "icone" nave
		int codigo = tecla.getKeyCode();

		if (codigo == KeyEvent.VK_UP) {
			dy = 0;
		}

		if (codigo == KeyEvent.VK_DOWN) {
			dy = 0;
		}

		if (codigo == KeyEvent.VK_LEFT) {
			dx = 0;
		}

		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 0;
		}

	}

	public boolean isTurbo() {
		return isTurbo;
	}
	
	public void setTurbo(boolean isTurbo) {
		this.isTurbo = isTurbo;
	}
	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}

	public List<Tiro> getTiros() {
		return tiros;
	}

}

