//@Autor:Assis
//@Date:27/06/2012
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

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class PlayerTwo {

	public int x, y;
	
	public double dy;

	private int altura;
	private int largura;
	
	private Image PlayerTwoImage;

	public PlayerTwo() {

		PlayerTwoImage = new ImageIcon("res/bastao.gif").getImage();

		altura = PlayerTwoImage.getHeight(null);
		largura = PlayerTwoImage.getWidth(null);

		reset();

	}

	public Image getPlayerTwoImage() {
		return PlayerTwoImage;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void move() {
		y += dy;
		
		
		if(y <= 0){
			y = 0;
		}
		
		if(y >= 347){
			y = 347;
		}
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}
	
	public void reset(){
		
		this.x = 662;
		this.y = 150;
	}
}
