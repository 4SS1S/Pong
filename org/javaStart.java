//@Autor:Assis
//@Date:25/06/2012
//
//  Este jogo foi montado em java, com software livre
//Com um pequeno "tutorial", explicando certas coisas
//n�o t�o bem detalhados.
//  Em s�, pe�o para que quem for modificar qualquer 
//parte deste c�digo, coloque o seu nome nesta parte,
//assim como a data e qual foi a modifica��o que fez.
//
//  Tendo em m�os um compilador java, voc� pode estudar
//como criar um jogo basico, mas com um pouco de I.A.
//(Intelig�ncia Artificial), a qual vai ser o nosso ini-
//migo.

//Pacote de onde se encontra o arquivo
//Para manter arrumado os nossos c�digos
package org;

//Importamos o JFrame, que � onde ir� ser criada a nossa
//janela do jogo
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Importa os pacotes que iremos usar de javax.swing
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

//O nome da class "class" dever� sempre ser o nome do arquivo
//por�m, com a exten��o java (javaStart.java).
//Depois extenderemos o JFrame, para ser uma "superclasse" de
//da nossa "sub-class".
class javaStart extends JFrame {

	private static final long serialVersionUID = 1L;

	
	//Cria um modo para acessarmos o mundo para
	//ser pintado na nossa janela
	private Mundo mundo;

	// M�todo onde ser� inst�nciada a nossa janela
	// com seus devidos par�metros.
	public javaStart() {

		// Adiciona um novo elemento, a qual ser� o Mundo.java
		// Depois de compilado (transformado em byte-codes java)
		mundo = new Mundo();
		add(mundo);


		//Criaremos aqui a barra onde colocaremos os menus e sub-
		//menus no m�todo privado meuJogo
		setJMenuBar(menuJogo());

		setSize(700, 500); // Tamanho da janela em pixels
		setVisible(true); // Sim, a nossa janela que ser visivel
		setTitle("Pong"); // T�tulo da janela, "a parte superior"
		setLocationRelativeTo(null);// Janela no meio da tela
		setResizable(false); // Ela n�o poder� ser alterado o seu tamanho
								// Obs.: J� viram uma janela de um jogo de pode
								// ser
								// Alterado? Raramente n�, pois �, para n�o
								// acontecer
								// "bus", vamos evitar que a pessoa n�o veja
								// al�m do que pode

		// O que acontece quando fechar a janela?
		// Ela vai ser fechada!
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	// Finaliza o m�todo javaStart


	//Criamos o m�todo menuJogo, para ser implementado
	//numa barra de menus
	private JMenuBar menuJogo() {
		// TODO Auto-generated method stub


		//Criamos uma barra de menus com o nome de barra
		JMenuBar barra = new JMenuBar();


		//Criamos um menu com o nome de jogo
		JMenu menuArquivo = new JMenu("Jogo");
		//Dizemos ao compilador java que quando uma pessoa
		//apertar os bot�es Alt+A vai acessar este menu
		menuArquivo.setMnemonic('A');

		//Criamos um item de menu com o nome de reinicializar
		JMenuItem reiniciar = new JMenuItem("Reiniciar");
		//Dizemos ao compilador java que quando uma pessoa
		//apertar os bot�es Alt+R vai acessar este item de menu
		reiniciar.setMnemonic('R');
		//Quando este item for acionado ele gerar� um evento privado
		reiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Event) {
				//Dizemos para que quando for acionado este evento
				//Que ele resete os pontos de Player Um e do Computador
				mundo.resetPontos();
			}
		});		//Finalizamos este evento privado

		//Criamos um outro item de menu com o nome de sair,
		//Adicionamos um Mnemonic e um evento privado, a qual
		//S� ele sabe o que �
		JMenuItem sair = new JMenuItem("Sair");
		sair.setMnemonic('S');
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Event) {
				//Quando for acionado este evento, a janela
				//Ir� ser fechada
				System.exit(0);
			}
		});


		//Adicionamos estes dois itens de menu no menuArquivo
		//e entre eles, colocaremos um separador, para dividir
		//Depois adicionamos o menuArquivo para a barra de menus
		menuArquivo.add(reiniciar);
		menuArquivo.addSeparator();
		menuArquivo.add(sair);
		barra.add(menuArquivo);

		
		//Criamos um segundo menu com o nome de ajuda
		JMenu ajuda = new JMenu("Ajuda");
		ajuda.setMnemonic('J');


		//Criamos um item de menu com o nome de sobre
		JMenuItem sobre = new JMenuItem("Sobre...");
		sobre.setMnemonic('S');
		sobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//Neste evento, importaremos o JOptionPane para
				//Mostrar uma caixa de mensagem com uma pequena
				//Explica��o de como funciona o jogo
				JOptionPane.showMessageDialog(null,
						"Use as setas para Cima e para Baixo\n"
								+ "para mover o seu jogador, sua fun��o\n"
								+ "� n�o deixar a bola tocar o seu lado",
						"Ajudou pelo o menos?", JOptionPane.NO_OPTION);
			}
		});


		//Criamos um outro item de menu com o nome de informa��es,
		//O qual, vai fazer a mesma coisa que o item sobre, por�m
		//Com uma mensagem diferente
		JMenuItem informacao = new JMenuItem("Informa��es Adicionais?");
		informacao.setMnemonic('I');
		informacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Achou Erros?\n"
						+ "As melhoras ir�o a vir na proxima\n"
						+ "vers�es.\nEsta vers�o � a 0.0.1",
						"Por favor, ajude a melhorar o pong",
						JOptionPane.YES_NO_OPTION);
			}
		});


		//Adicionamos os dois itens de menu para o menu ajuda
		//Depois adicionamos o menu ajuda na barra de menus
		setFocusable(false);
		ajuda.add(sobre);
		ajuda.add(informacao);
		barra.add(ajuda);

		
		//Retorna o valor da barra, a qual agora cont�m todos
		//os menus e itens de menus que acamos de 
		return barra;
	}

	/**
	 * @param args
	 */
	// M�todo principal, onde quando o programa for executado
	// Ele vai procurar primeiramente este m�todo.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Chama o nosso m�todo de onde criamos a janela
		new javaStart();
	}
	// Finaliza o m�todo main

}
