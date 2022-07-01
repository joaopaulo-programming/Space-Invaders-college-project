package Jogo_APS;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Tiro {

	private Image imagem;
	private int x, y;// posi��o do tiro. Shot Position
	private int largura, altura;
	private boolean isVisivel;// comando para quando o tiro chocar contra outro corpo ou o limite de tela da fase, desaparecer.

	private static final int LARGURA = 1024;
	private static int VELOCIDADE = 10;// velocidade do tiro

	public Tiro(int x, int y) {// movimenta��o do tiro
		this.x = x;
		this.y = y;
		isVisivel = true;

	}

	public void load() {
		ImageIcon referencia = new ImageIcon("res\\Tiro1.png");
		imagem = referencia.getImage();

		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
	}

	public void update() {
		this.x += VELOCIDADE;
		if (this.x > LARGURA) {
			isVisivel = false;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle (x, y, largura, altura);
	}

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public static int getVELOCIDADE() {
		return VELOCIDADE;
	}

	public static void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
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

}

