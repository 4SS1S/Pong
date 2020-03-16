//@Autor:Assis
//@Date:25/06/2012
//
//  Este jogo foi montado em java, com software livre
//Com um pequeno "tutorial", explicando certas coisas
//n�o t�o bem detalhados.
//  Em s�, pe�o para que quem for modificar qualquer 
//parte deste c�digo, coloque o seu nome nesta parte,
//assim como a data e qual foi a modifica��o que fez.

//Pacote de onde se encontra o arquivo
//Para manter arrumado os nossos c�digos
package org;

import java.awt.Image; //Importamos este m�todo para usar imagens
import java.awt.Rectangle; //Importamos este m�todo para usar retangulos

//Importamos o m�todo para criar um icone de imagem
import javax.swing.ImageIcon;

//Criamos uma classe public chamada ball, onde nela teremos todos os
//par�metros da bola que ser� usada no jogo
public class ball {

	int x, y; // Variaveis inteiros de pixel x e y

	// variaveis de valor duplo de um inteiro para
	// a sua velocidade de locomo��o
	public double dx = -5, dy = -5;

	// Imagem privada, onde n�nguem (nenhuma outra classe)
	// possa alterar ou ver a nossa imagem, vamos fazer isto
	// por um pouco de "seguran�a"
	private Image ballImage;

	// T�, estes dois eu n�o preciso explicar correto?
	private int altura;
	private int largura;

	// M�todo publico de onde criaremos a bola do jogo
	public ball() {

		// Chama o m�todo public de resetBall, para
		// Colocar a bola em seu lugar pr�-definido
		resetBall();

		// Usaremos este pequeno c�digo que segue abaixo para
		// pegar a imagem, cria-la como icone e transforma-la
		// em uma imagem de verdade
		ballImage = new ImageIcon("res/bola.gif").getImage();

		// Pegamos a altura e a largura da imagem
		altura = ballImage.getHeight(null);
		largura = ballImage.getWidth(null);
	}

	// Finalizamos o m�todo ball

	// Criamos um m�todo para que os membros de outras
	// classes possam ver a variavel x
	public int getX() {
		return x;
	}

	// Criamos um m�todo para que os membros de outras
	// classes possam ver a variavel dx
	public double getDx() {
		return dx;
	}

	// Criamos um m�todo para que os membros de outras
	// classes possam modificar a variavel x
	public void setDx(double dx) {
		this.dx = dx;
	}

	// Criamos um m�todo para que os membros de outras
	// classes possam ver a variavel dy
	public double getDy() {
		return dy;
	}

	// Criamos um m�todo para que os membros de outras
	// classes possam alterar a variavel dy
	public void setDy(double dy) {
		this.dy = dy;
	}

	// Criamos um m�todo para que os membros de outras
	// classes possam ver a variavel y
	public int getY() {
		return y;
	}

	// Criamos um m�todo para que os membros de outras
	// classes possam ver a imagem da bola
	public Image getBallImage() {
		return ballImage;
	}

	// M�todo onde a bola se mover� livremente,
	// Por�m, n�o podemos deixa-la sair da tela,
	// Por isto colocamos estes testes (if)
	public void move() {

		x += dx;
		y += dy;

		if (x <= 0) {
			dx = 5;
		}

		if (y <= 0) {
			dy = 5;
		}

		if (x >= 667) {
			dx = -5;
		}

		if (y >= 398) {
			dy = -5;
		}

	}

	// Criamos um m�todo para que os membros de outras
	// classes possam alterar a variavel x
	public void setX(int x) {
		this.x = x;
	}

	// Criamos um m�todo para que os membros de outras
	// classes possam alterar a variavel y
	public void setY(int y) {
		this.y = y;
	}

	// Pr�-padroniza a bola na tela, em uma posi��o abaixo
	// indicado
	public void resetBall() {
		this.x = 350;
		this.y = 850;
	}

	// Cria um retangulo com as variaveis x e y da bola,
	// Al�m de sua altura e sua largura
	public Rectangle getBound() {
		return new Rectangle(x, y, largura, altura);
	}
}