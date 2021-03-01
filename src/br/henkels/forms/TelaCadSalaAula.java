package br.henkels.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.henkels.organizaturma.OrganizaTurmas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadSalaAula extends JDialog {

	private JPanel contentPane;
	private JTextField TextFielSalaAula;
	private JTextField TextFielLotacaoAula;

	/**
	 * Create the frame.
	 */

	public TelaCadSalaAula(OrganizaTurmas gerenciador) {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel LabelCadastroSalaAula = new JLabel("Cadastro Sala de Aula");
		LabelCadastroSalaAula.setFont(new Font("Tahoma", Font.PLAIN, 22));
		LabelCadastroSalaAula.setBounds(114, 22, 228, 39);
		panel.add(LabelCadastroSalaAula);

		JLabel LabelNomeSalaAula = new JLabel("Nome da Sala de Aula:");
		LabelNomeSalaAula.setBounds(25, 95, 201, 27);
		panel.add(LabelNomeSalaAula);

		TextFielSalaAula = new JTextField();
		TextFielSalaAula.setBounds(236, 98, 174, 20);
		panel.add(TextFielSalaAula);
		TextFielSalaAula.setColumns(10);

		JLabel LabelCapSalaAula = new JLabel("Capacidade de lota\u00E7\u00E3o da Sala de Aula:");
		LabelCapSalaAula.setBounds(25, 149, 201, 27);
		panel.add(LabelCapSalaAula);

		TextFielLotacaoAula = new JTextField();
		TextFielLotacaoAula.setBounds(236, 152, 174, 20);
		panel.add(TextFielLotacaoAula);
		TextFielLotacaoAula.setColumns(10);

		JButton ButtonSalvarSalaAula = new JButton("Salvar");
		ButtonSalvarSalaAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lotacao = Integer.parseInt(TextFielLotacaoAula.getText());
				gerenciador.saveSalaAula(TextFielSalaAula.getText(), lotacao);
			}
		});
		ButtonSalvarSalaAula.setBounds(170, 205, 89, 23);
		panel.add(ButtonSalvarSalaAula);

	}

}
