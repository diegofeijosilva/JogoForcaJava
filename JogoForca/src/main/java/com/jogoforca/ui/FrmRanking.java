package com.jogoforca.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;

public class FrmRanking extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public FrmRanking() {
		setTitle("Ranking");
		setBounds(100, 100, 624, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblJogador = new JLabel("Jogador");
		lblJogador.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblJogador.setBounds(45, 14, 81, 26);
		contentPanel.add(lblJogador);
		
		JLabel lblPontuao = new JLabel("Pontua\u00E7\u00E3o");
		lblPontuao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPontuao.setBounds(456, 17, 113, 20);
		contentPanel.add(lblPontuao);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
