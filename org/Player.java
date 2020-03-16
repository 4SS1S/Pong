//@Autor:Assis
//@Date:26/06/2012
//
//  Este jogo foi montado em java, com software livre
//Com um pequeno "tutorial", explicando certas coisas
//não tão bem detalhados.
//  Em sí, peço para que quem for modificar qualquer 
//parte deste código, coloque o seu nome nesta parte,
//assim como a data e qual foi a modificação que fez.

//Pacote de onde se encontra o arquivo
//Para manter arrumado os nossos códigos
package org;

import java.awt.Image; //Importamos este método para usar imagens
import java.awt.Rectangle; //Importamos este método para usar retangulos
import java.awt.event.KeyEvent; //Aqui faremos os eventos de teclado

//Importamos o método para criar um icone de imagem
import javax.swing.ImageIcon;

class Player {

	private int x, y;
	private int dx, dy;

	private int altura;
	private int largura;

	private Image playerImage;

	public Player() {

		playerImage = new ImageIcon("res/bastao.gif").getImage();

		reset();

		altura = playerImage.getHeight(null);
		largura = playerImage.getWidth(null);
	}

	public Image getPlayerImage() {
		return playerImage;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void move() {
		x += dx;
		y += dy;

		if (y <= 0) {
			y = 0;
		}

		if (y >= 347) {
			y = 347;
		}

	}

	public void KeyPressed(KeyEvent key) {

		int presskey = key.getKeyCode();

		switch (presskey) {

		case KeyEvent.VK_UP:
			dy = -5;
			break;

		case KeyEvent.VK_DOWN:
			dy = 5;
			break;
			
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;

		}
	}

	public void KeyReleased(KeyEvent key) {

		int presskey = key.getKeyCode();

		switch (presskey) {

		case KeyEvent.VK_UP:
			dy = 0;
			break;

		case KeyEvent.VK_DOWN:
			dy = 0;
			break;

		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}

	public void reset() {

		this.x = 10;
		this.y = 150;

	}
}
