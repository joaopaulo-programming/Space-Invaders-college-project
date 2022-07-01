package Jogo_APS;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Nuvens {

	private Image imagem;
	private int x, y;// posição da nuvem.
	private int largura, altura;
	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	private boolean isVisivel;// comando para quando o inimigo chocar contra outro corpo ou o limite de tela da fase, desaparecer.
	//private static final int LARGURA = 938;
	private static int VELOCIDADE = 1;// velocidade do estrela

	public Nuvens(int x, int y) {// movimentação da estrela
		this.x = x;
		this.y = y;
		isVisivel = true;

	}

	public void load() {
		ImageIcon referencia = new ImageIcon("res\\Nuvens2.png");
		imagem = referencia.getImage();

		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
	}

	public void update() {
		if(this.x < 0 ) {
			this.x = largura;
			Random a = new Random();
			int m = a.nextInt(500);
			this.x = m + 1024;
			
			Random r = new Random();
			int n = r.nextInt(728);
			this.y = n;
			}else {
				this.x -= VELOCIDADE;
			}
			
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
