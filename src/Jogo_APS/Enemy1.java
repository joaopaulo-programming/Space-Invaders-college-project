package Jogo_APS;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy1 {

	private Image imagem;
	private int x, y;// posi��o do inimigo. enemy Position
	private int largura, altura;
	private boolean isVisivel;// comando para quando o inimigo chocar contra outro corpo ou o limite de tela da fase, desaparecer.

	//private static final int LARGURA = 938;
	private static int VELOCIDADE = 1;// velocidade do inimigo

	public Enemy1(int x, int y) {// movimenta��o do tiro
		this.x = x;
		this.y = y;
		isVisivel = true;

	}

	public void load() {
		ImageIcon referencia = new ImageIcon("res\\Enemy1.png");
		imagem = referencia.getImage();

		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
	}

	public void update() {
		this.x -= VELOCIDADE;
		//if (this.x > LARGURA) {
			//isVisivel = false;
		//}
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

