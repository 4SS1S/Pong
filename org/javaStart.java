/**
//@Autor:Assis
//@Date:25/06/2012
//
//  Este jogo foi montado em java, com software livre
//Com um pequeno "tutorial", explicando certas coisas
//não tão bem detalhados.
//  Em sí, peço para que quem for modificar qualquer 
//parte deste código, coloque o seu nome nesta parte,
//assim como a data e qual foi a modificação que fez.
//
//  Tendo em mãos um compilador java, você pode estudar
//como criar um jogo basico, mas com um pouco de I.A.
//(Inteligência Artificial), a qual vai ser o nosso inimigo.

//Pacote de onde se encontra o arquivo
//Para manter arrumado os nossos códigos
*/
package org;

//Importamos o JFrame, que é onde irá ser criada a nossa
//janela do jogo
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Importa os pacotes que iremos usar de javax.swing
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

//O nome da class "class" deverá sempre ser o nome do arquivo
//porém, com a extenção java (javaStart.java).
//Depois extenderemos o JFrame, para ser uma "superclasse" de
//da nossa "sub-class".
class javaStart extends JFrame {

	private static final long serialVersionUID = 1L;

	
	//Cria um modo para acessarmos o mundo para
	//ser pintado na nossa janela
	private Mundo mundo;

	// Método onde será instânciada a nossa janela
	// com seus devidos parâmetros.
	public javaStart() {

		// Adiciona um novo elemento, a qual será o Mundo.java
		// Depois de compilado (transformado em byte-codes java)
		mundo = new Mundo();
		add(mundo);


		//Criaremos aqui a barra onde colocaremos os menus e sub-
		//menus no método privado meuJogo
		setJMenuBar(menuJogo());

		setSize(700, 500); // Tamanho da janela em pixels
		setVisible(true); // Sim, a nossa janela que ser visivel
		setTitle("Pong"); // Título da janela, "a parte superior"
		setLocationRelativeTo(null);// Janela no meio da tela
		setResizable(false); // Ela não poderá ser alterado o seu tamanho
								// Obs.: Já viram uma janela de um jogo de pode
								// ser
								// Alterado? Raramente né, pois é, para não
								// acontecer
								// "bus", vamos evitar que a pessoa não veja
								// além do que pode

		// O que acontece quando fechar a janela?
		// Ela vai ser fechada!
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	// Finaliza o método javaStart


	//Criamos o método menuJogo, para ser implementado
	//numa barra de menus
	private JMenuBar menuJogo() {
		// TODO Auto-generated method stub


		//Criamos uma barra de menus com o nome de barra
		JMenuBar barra = new JMenuBar();


		//Criamos um menu com o nome de jogo
		JMenu menuArquivo = new JMenu("Jogo");
		//Dizemos ao compilador java que quando uma pessoa
		//apertar os botões Alt+A vai acessar este menu
		menuArquivo.setMnemonic('A');

		//Criamos um item de menu com o nome de reinicializar
		JMenuItem reiniciar = new JMenuItem("Reiniciar");
		//Dizemos ao compilador java que quando uma pessoa
		//apertar os botões Alt+R vai acessar este item de menu
		reiniciar.setMnemonic('R');
		//Quando este item for acionado ele gerará um evento privado
		reiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Event) {
				//Dizemos para que quando for acionado este evento
				//Que ele resete os pontos de Player Um e do Computador
				mundo.resetPontos();
			}
		});		//Finalizamos este evento privado

		//Criamos um outro item de menu com o nome de sair,
		//Adicionamos um Mnemonic e um evento privado, a qual
		//Só ele sabe o que é
		JMenuItem sair = new JMenuItem("Sair");
		sair.setMnemonic('S');
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Event) {
				//Quando for acionado este evento, a janela
				//Irá ser fechada
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
				//Explicação de como funciona o jogo
				JOptionPane.showMessageDialog(null,
						"Use as setas para Cima e para Baixo\n"
								+ "para mover o seu jogador, sua função\n"
								+ "é não deixar a bola tocar o seu lado",
						"Ajudou pelo o menos?", JOptionPane.NO_OPTION);
			}
		});


		//Criamos um outro item de menu com o nome de informações,
		//O qual, vai fazer a mesma coisa que o item sobre, porém
		//Com uma mensagem diferente
		JMenuItem informacao = new JMenuItem("Informações Adicionais?");
		informacao.setMnemonic('I');
		informacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Achou Erros?\n"
						+ "As melhoras irão a vir na proxima\n"
						+ "versões.\nEsta versão é a 0.0.1",
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

		
		//Retorna o valor da barra, a qual agora contém todos
		//os menus e itens de menus que acamos de 
		return barra;
	}

	/**
	 * @param args
	 */
	// Método principal, onde quando o programa for executado
	// Ele vai procurar primeiramente este método.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Chama o nosso método de onde criamos a janela
		new javaStart();
	}
	// Finaliza o método main

}
