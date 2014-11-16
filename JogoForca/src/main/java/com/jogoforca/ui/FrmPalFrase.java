package com.jogoforca.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.jogoforca.dao.PalavrasDao;
import com.jogoforca.model.Palavra;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPalFrase extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public FrmPalFrase() {
		setTitle("Cadastro de Palavras ou Frases");
		setBounds(100, 100, 338, 136);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(10, 28, 296, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblDigiteAPalavra = new JLabel("Digite a Palavra ou Frase:");
			lblDigiteAPalavra.setBounds(10, 11, 200, 14);
			contentPanel.add(lblDigiteAPalavra);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Palavra palavra = new Palavra();
						PalavrasDao dao = new PalavrasDao();
						
						palavra.setDescricao(textField.getText());
						Boolean retorno =  dao.saveOrUpdate(palavra);
						
						if(retorno){
							JOptionPane.showMessageDialog(null,"Dados salvos com sucesso");
							FrmPalFrase.this.dispose();
						} else {
							JOptionPane.showMessageDialog(null,"Houve um problema ao salvar!");
						}
						
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}