package com.jogoforca.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JButton;

import com.jogoforca.dao.PalavrasDao;
import com.jogoforca.model.Palavra;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Window.Type;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTextArea;
import java.awt.Color;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtLetra;
	private JTextField txtPalavra;
	
	final JLabel imgCabeca = new JLabel("");
	final JLabel imgMaoEsq = new JLabel("");
	final JLabel imgCorpo = new JLabel("");
	final JLabel imgPeEsq = new JLabel("");
	final JLabel imgPeDir = new JLabel("");
	final JLabel imgTronco = new JLabel("");
	final JLabel imgMaoDir = new JLabel("");
	
	JLabel lblPalavra = new JLabel("");
	
	final JButton btnIniciar = new JButton("Iniciar Partida");
	final JButton btnCancelar = new JButton("Cancelar");
	final JButton btnVerificar = new JButton("Verificar");
	
	final JTextArea lstErros = new JTextArea();

	private PalavrasDao daoPalavra = new PalavrasDao();
	private Palavra palavra = new Palavra();
	
	// Serve para ir mostrando o corpo do boneco
	private Integer contadorBoneco = 0;
	private Integer pontuacao = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setTitle("Jogo Forca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPalavra.setVisible(false);
		btnIniciar.setEnabled(true);
		btnCancelar.setEnabled(false);
		btnVerificar.setEnabled(false);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ativa o boneco
				//Seta invisivel as imagens do boneco
				imgCabeca.setVisible(true);
				imgCorpo.setVisible(true);
				imgMaoDir.setVisible(true);
				imgMaoEsq.setVisible(true);
				imgPeDir.setVisible(true);
				imgPeEsq.setVisible(true);
				imgTronco.setVisible(true);
				
				btnIniciar.setEnabled(true);
				btnCancelar.setEnabled(false);
				lblPalavra.setVisible(false);
				btnVerificar.setEnabled(false);
				
				imgCabeca.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/cabeca.png"))); 
				lstErros.setText(null);
				
			}
		});
		
		JLabel lblErros = new JLabel("Erros:");
		lblErros.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblErros.setBounds(657, 148, 101, 31);
		contentPane.add(lblErros);
		lstErros.setEditable(false);
		
		
		lstErros.setBounds(657, 175, 149, 212);
		contentPane.add(lstErros);
		
		
		lblPalavra.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPalavra.setBounds(280, 80, 504, 31);
		contentPane.add(lblPalavra);
		
		JLabel lblOu = new JLabel("OU");
		lblOu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOu.setBounds(279, 168, 46, 31);
		contentPane.add(lblOu);
		
		JLabel lblDigiteAPalavra = new JLabel("Digite a Palavra ou Frase:");
		lblDigiteAPalavra.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDigiteAPalavra.setBounds(280, 198, 288, 31);
		contentPane.add(lblDigiteAPalavra);
		
		JLabel lblNewLabel = new JLabel("Digite uma letra:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(280, 136, 180, 31);
		contentPane.add(lblNewLabel);
		btnCancelar.setBounds(552, 403, 131, 31);
		contentPane.add(btnCancelar);
		
		
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Existe o caracter na palavra
				if(palavra.getDescricao().indexOf(txtLetra.getText()) != -1){
					JOptionPane.showMessageDialog(null,"Letra encontrada na Palavra ou Frase!");
					
					Integer pos = getPosicaoString(palavra.getDescricao(), txtLetra.getText());
					
					String pal="";
					for(int i=0; i < palavra.getDescricao().length(); i++){
						
						if(i == pos){
							pal = pal + txtLetra.getText();
						}
						else
							pal = pal + " _ ";
					}
					
					lblPalavra.setText(pal);
					
					txtLetra.setText(null);
					
				} else
				{
					lstErros.append(txtLetra.getText()+"\n");
					
					switch (contadorBoneco) {
					case 0: imgCabeca.setVisible(true); break;
					case 1: imgCorpo.setVisible(true); break;
					case 2: imgMaoDir.setVisible(true); break;
					case 3: imgMaoEsq.setVisible(true); break;
					case 4: imgTronco.setVisible(true); break;
					case 5: imgPeDir.setVisible(true); break;
					case 6: imgPeEsq.setVisible(true); break;
					case 7: {
						imgCabeca.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/cabecaFim.png"))); 
						JOptionPane.showMessageDialog(null,"Você foi enforcado!");
						btnVerificar.setEnabled(false);
						
						FrmRanking frmRanking = new FrmRanking();
						frmRanking.show();
						
						break;
						}
					
					default:
						break;
					}
					
					contadorBoneco++;
					
				}
				
			}

			private Integer getPosicaoString(String palavra, String car) {
				
				//aqui ele pega a quantidade de carcteres que tem uma determinada variável  
				//e armazena numa INT para usá-la de contador  
				int contador = palavra.length();  
				  
				//cria um for( para fazer uma varredura letra por letra até encontrar  
				for(int i = 0;i<contador;i++){  
				    //usamos substring pra pegar um caractere, passando como parâmetro,  
				    //o primeiro caractere a ser pega, até a ultima.  
				    //fiz um if para verificar se o caractere é igual a "_"  
				    if (palavra.substring(i,i+1).equals(car)){  
				        int posicao = i+1;  
				        //JOptionPane.showMessageDialog(null,"Está na posição " + posicao ,"TITULO",1);  
				        return posicao;
				    }  
				      
				}  
				
				return 0;
				
			}
		});
		btnVerificar.setBounds(280, 267, 89, 23);
		contentPane.add(btnVerificar);
		
		txtPalavra = new JTextField();
		txtPalavra.setBounds(280, 227, 263, 29);
		contentPane.add(txtPalavra);
		txtPalavra.setColumns(10);
		
		txtLetra = new JTextField();
		txtLetra.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtLetra.addKeyListener(new KeyAdapter() { public void keyTyped(KeyEvent e) { char keyChar = e.getKeyChar(); if (Character.isLowerCase(keyChar)) { e.setKeyChar(Character.toUpperCase(keyChar)); } } });
		
		//txtLetra.setFont(new Font("Arial", Font.BOLD, 20));
		txtLetra.setBounds(470, 140, 46, 31);
		contentPane.add(txtLetra);
		txtLetra.setColumns(10);
		
		
		imgCabeca.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/cabeca.png")));
		imgCabeca.setBounds(121, 78, 113, 124);
		contentPane.add(imgCabeca);
		
		
		imgMaoEsq.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/maoEsq.png")));
		imgMaoEsq.setBounds(75, 173, 62, 40);
		contentPane.add(imgMaoEsq);
		
		
		imgCorpo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/corpo.png")));
		imgCorpo.setBounds(132, 177, 84, 107);
		contentPane.add(imgCorpo);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(113, 55, -58, -43);
		contentPane.add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 816, 21);
		contentPane.add(menuBar);
		
		JMenu mnTeste = new JMenu("Cadastro");
		menuBar.add(mnTeste);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Palavra ou Frase");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmPalFrase frmPalFrase = new FrmPalFrase();
				frmPalFrase.setVisible(true);
			}
		});
		mnTeste.add(mntmNewMenuItem);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		
		imgMaoDir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/maoDir.png")));
		imgMaoDir.setBounds(194, 198, 72, 40);
		contentPane.add(imgMaoDir);
		
		
		imgTronco.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/tronco.png")));
		imgTronco.setBounds(133, 267, 62, 59);
		contentPane.add(imgTronco);
		
		
		imgPeDir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/peDir.png")));
		imgPeDir.setBounds(167, 319, 84, 94);
		contentPane.add(imgPeDir);
		
		
		imgPeEsq.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/peEsq.png")));
		imgPeEsq.setBounds(95, 318, 72, 91);
		contentPane.add(imgPeEsq);
		
		
		btnIniciar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(daoPalavra.getCountRegistros() > 0){
					
					pontuacao = 0;
					
					btnCancelar.setEnabled(true);
					
					//Seta invisivel as imagens do boneco
					imgCabeca.setVisible(false);
					imgCorpo.setVisible(false);
					imgMaoDir.setVisible(false);
					imgMaoEsq.setVisible(false);
					imgPeDir.setVisible(false);
					imgPeEsq.setVisible(false);
					imgTronco.setVisible(false);
					
					palavra = daoPalavra.getPalavraRandomico();
					
					System.out.println("PALAVRA: " + palavra.getDescricao());
					
					String pal="";
					for(int i=0; i < palavra.getDescricao().length(); i++){
						pal = pal + " _";
					}
					
					//lblPalavra.setText("PALAVRA COM "+palavra.getDescricao().length()+" LETRAS.");
					lblPalavra.setText(pal);
					lblPalavra.setVisible(true);
					
					btnIniciar.setEnabled(false);
					btnVerificar.setEnabled(true);
					contadorBoneco = 0;
					lstErros.setText(null);
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Nenhuma palavra/frase foi encontrado no banco. \nFavor adicionar.");
				}
				
				
				
			}
		});
		btnIniciar.setBounds(685, 403, 131, 31);
		contentPane.add(btnIniciar);
		
		JLabel imgFundo = new JLabel("");
		imgFundo.setBounds(0, 21, 816, 413);
		imgFundo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/fundo.png")));
		contentPane.add(imgFundo);
		
		JLabel lblLetra = new JLabel("Digite uma letra:");
		lblLetra.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLetra.setBounds(280, 148, 180, 31);
		contentPane.add(lblLetra);
	}
}
