package com.jogoforca.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.jogoforca.dao.JogadorDao;
import com.jogoforca.dao.PalavrasDao;
import com.jogoforca.model.Jogador;
import com.jogoforca.model.Palavra;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmJogador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public FrmJogador(final Float pontos) {
		setTitle("Cadastro do jogador");
		setBounds(100, 100, 338, 136);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		System.out.println("MOSTRANDO TELA JOGADOR");
		{
			textField = new JTextField();

			textField.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char keyChar = e.getKeyChar();
					if (Character.isLowerCase(keyChar)) {
						e.setKeyChar(Character.toUpperCase(keyChar));
					}
				}
			});

			textField.setBounds(10, 28, 296, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblDigiteNome = new JLabel("Digite seu nome:");
			lblDigiteNome.setBounds(10, 11, 200, 14);
			contentPanel.add(lblDigiteNome);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Jogador jogador = new Jogador();
						jogador.setNome(textField.getText());
						jogador.setPontos(pontos);
						
						JogadorDao jogadorDao = new JogadorDao();
						
						if (!jogadorDao.saveOrUpdate(jogador)) {
							JOptionPane.showMessageDialog(null,
									"Houve um problema ao salvar!");
						}
						
						FrmRanking frmRanking = new FrmRanking();
						frmRanking.show();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
