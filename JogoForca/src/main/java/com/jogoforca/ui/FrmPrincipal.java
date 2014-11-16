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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Window.Type;

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
		
		JButton btnCancelar = new JButton("Cancelar");
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
				
			}
		});
		btnCancelar.setBounds(552, 403, 131, 31);
		contentPane.add(btnCancelar);
		
		JButton btnNewButton = new JButton("Verificar");
		btnNewButton.setBounds(500, 330, 89, 23);
		contentPane.add(btnNewButton);
		
		txtPalavra = new JTextField();
		txtPalavra.setBounds(261, 327, 229, 29);
		contentPane.add(txtPalavra);
		txtPalavra.setColumns(10);
		
		txtLetra = new JTextField();
		//txtLetra.setFont(new Font("Arial", Font.BOLD, 20));
		txtLetra.setBounds(394, 171, 46, 31);
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
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Jogador");
		mnTeste.add(mntmNewMenuItem_1);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JLabel label = new JLabel("");
		label.setBounds(132, 195, 84, 107);
		contentPane.add(label);
		
		
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
		
		JButton btnIniciar = new JButton("Iniciar Partida");
		btnIniciar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				//Seta invisivel as imagens do boneco
				imgCabeca.setVisible(false);
				imgCorpo.setVisible(false);
				imgMaoDir.setVisible(false);
				imgMaoEsq.setVisible(false);
				imgPeDir.setVisible(false);
				imgPeEsq.setVisible(false);
				imgTronco.setVisible(false);
				
			}
		});
		btnIniciar.setBounds(685, 403, 131, 31);
		contentPane.add(btnIniciar);
		
		JLabel imgFundo = new JLabel("");
		imgFundo.setBounds(0, 21, 816, 413);
		imgFundo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/fundo.png")));
		contentPane.add(imgFundo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(376, 195, 46, 14);
		contentPane.add(lblNewLabel);
	}
}
