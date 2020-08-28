/**
@Autor:Assis
@Date:25/06/2012

  Este jogo foi montado em java, com software livre
Com um pequeno "tutorial", explicando certas coisas
não tão bem detalhados.
  Em sí, peço para que quem for modificar qualquer 
parte deste código, coloque o seu nome nesta parte,
assim como a data e qual foi a modificação que fez.

(Sim, eu não conhecia GitHub em 2012)
*/
	
//Pacote de onde se encontra o arquivo
//Para manter arrumado os nossos códigos
package org;


//Importamos os pacotes de java.awt que iremos usar
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


//Importamos os pacotes de javax.swing que vamos utilizar
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


//Criamos a classe Mundo que extende, ou seja, recebe as informações
//de JPanel, e ainda implementa os "ouvindo de ações" ActionListener
@SuppressWarnings("serial")
public class Mundo extends JPanel implements ActionListener {

	//Criamos uma imaagem privada chamada de
	//Background
	private Image bakcground;

	//Criamos um timer para contar quanto
	//Tempo em milesegundos para repintar
	private Timer timer;


	//Criamos os pontos, inicializando
	//os pontos zerados
	private int pontoUm = 0;
	private int pontoDois = 0;

	//Chamamos os personagens "os bastões"
	//e a bola
	private Player playerOne;
	protected ball gameBall;
	private PlayerTwo playerTwo;

	//Método publico Mundo é inicializado
	public Mundo() {

		//Deixa a tela em fóco e com
		//doubleBuffered
		this.setFocusable(true);
		this.setDoubleBuffered(true);

		//Adicionamos um evento de teclado a partir
		//do KAdap, que vamos criar depois
		addKeyListener(new kAdap());

		//Criamos a imagem de fundo, a partir deste desenho
		//Tosco a qual eu fiz
		bakcground = new ImageIcon("res/background.gif").getImage();
		
		//Pedimos para ser "pintado" na tela também os dois jogadores
		//e a bola
		playerOne = new Player();
		gameBall = new ball();
		playerTwo = new PlayerTwo();

		//A cada 10 milesegundos esta tela irá ser repintada,
		//Com um evento próprio
		timer = new Timer(15, this);
		timer.start();		//Inicia o timer
    }


	//Método com valor vazio para pintar na tela que criamos
	public void paint(Graphics g) {


		//Pinta o cenário com a posição inicial no topo da tela
		g.drawImage(bakcground, 0, 0, null);
		//Desenha o primeiro jogador (o da esquerda), com o seu
		//valor inicial sendo pego pelos seus valores pré-determinados
		//Nos métodos das classe Player
		g.drawImage(playerOne.getPlayerImage(), playerOne.getX(),
				playerOne.getY(), this);
		//Se entendeu o anterior, não merece outra explicação
		g.drawImage(gameBall.getBallImage(), gameBall.getX(), gameBall.getY(),
				null);
		g.drawImage(playerTwo.getPlayerTwoImage(), playerTwo.getX(),
				playerTwo.getY(), null);

		
		//Escreveremos na tela as pontuações com a cor verde
		g.setColor(Color.GREEN);
		g.drawString("Player 1: " + pontoUm, 23, 23);
		g.drawString("Computador: " + pontoDois, 600, 23);
		// System.out.println("x: " + playerOne.getX());
		// System.out.println("y: " + playerOne.getY());

		/*
		 * if(gameBall.getX() <= 331){ playerTwo.setDy(playerTwo.dy = 3);
		 * if(gameBall.getX() >= 311){ playerTwo.setDy(playerTwo.dy = -3);
		 * if(playerTwo.getY() == 113){ playerTwo.setDy(playerTwo.dy = 0); } } }
		 */

		bateVolta();
		intelArt();

		g.dispose();
		die();
	}		//Finaliza o método paint

	
	public void bateVolta() {

		Rectangle p1 = playerOne.getBounds();
		Rectangle p2 = playerTwo.getBounds();
		Rectangle b = gameBall.getBound();

		if (b.intersects(p1)) {
			gameBall.setDx(gameBall.dx = 5);
		}

		if (b.intersects(p2)) {
			gameBall.setDx(gameBall.dx = -5);
			if (playerTwo.getY() <= 110) {
				playerTwo.setDy(playerTwo.dy = 5);
				if (playerTwo.getY() >= 110) {
					playerTwo.setDy(playerTwo.dy = 0);
				}
			} else if (playerTwo.getY() >= 113) {
				playerTwo.setDy(playerTwo.dy = -5);
				if (playerTwo.getY() <= 113) {
					playerTwo.setDy(playerTwo.dy = 0);
				}
			}
		}
	}

	public void intelArt() {
		if (gameBall.getX() >= 235) {
			if (gameBall.getY() >= 250) {
				playerTwo.setDy(playerTwo.dy = 5);
				if (gameBall.getY() <= 255) {
					playerTwo.setDy(playerTwo.dy = -5);
				}
				if (gameBall.getY() >= 55) {
					playerTwo.setDy(playerTwo.dy = 5);
				}

			}
			if (gameBall.getY() <= 250) {
				playerTwo.setDy(playerTwo.dy = -5);
				if (gameBall.getY() >= 300) {
					playerTwo.setDy(playerTwo.dy = 5);
				}
			}
		}

		if (gameBall.getX() <= 450) {
			if (playerTwo.getY() <= 113) {
				playerTwo.setDy(playerTwo.dy = 5);
				if (playerTwo.getY() >= 110) {
					playerTwo.setDy(playerTwo.dy = 0);
				}
			} else if (playerTwo.getY() >= 113) {
				playerTwo.setDy(playerTwo.dy = -5);
				if (playerTwo.getY() <= 113) {
					playerTwo.setDy(playerTwo.dy = 0);
				}
			}
		}
	}

	public void die() {

		// pontoDois = Integer.parseInt();
		if (gameBall.x <= 0) {
			pontoDois++;
			reset();
		}

		if (gameBall.x >= 667) {
			pontoUm++;
			reset();
		}
	}

	public void reset() {
		gameBall.resetBall();
		playerOne.reset();
		playerTwo.reset();
	}

	public void resetPontos() {
		pontoUm = 0;
		pontoDois = 0;
		reset();
	}

	private class kAdap extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			playerOne.KeyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			playerOne.KeyReleased(e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		playerOne.move();
		playerTwo.move();
		gameBall.move();
		repaint();
	}
}
