package br.henkels.forms;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.henkels.organizaturma.OrganizaTurmas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadSalaCafe extends JDialog {

	private JPanel contentPane;
	private JTextField nomeSalaCafe;
	private JTextField lotacaoSalaCafe;

	/**
	 * Create the frame.
	 */
	public TelaCadSalaCafe(OrganizaTurmas gerenciador) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro Sala de Caf\u00E9");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(113, 11, 212, 40);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome da Sala de Caf\u00E9:");
		lblNewLabel_1.setBounds(38, 87, 127, 14);
		contentPane.add(lblNewLabel_1);

		nomeSalaCafe = new JTextField();
		nomeSalaCafe.setBounds(251, 84, 86, 20);
		contentPane.add(nomeSalaCafe);
		nomeSalaCafe.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Capacidade de lota\u00E7\u00E3o da Sala de Caf\u00E9:");
		lblNewLabel_2.setBounds(38, 131, 212, 14);
		contentPane.add(lblNewLabel_2);

		lotacaoSalaCafe = new JTextField();
		lotacaoSalaCafe.setBounds(251, 128, 86, 20);
		contentPane.add(lotacaoSalaCafe);
		lotacaoSalaCafe.setColumns(10);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lotacao = Integer.parseInt(lotacaoSalaCafe.getText());
				gerenciador.saveSalaCafe(nomeSalaCafe.getText(),lotacao);
			}
		});
		btnNewButton.setBounds(289, 197, 89, 23);
		contentPane.add(btnNewButton);
	}
}
