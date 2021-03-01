package br.henkels.forms;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.henkels.organizaturma.OrganizaTurmas;

public class TelaCadAluno extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8078421293997677002L;
	private JTextField textFieldNomeAluno;
	private JTextField textFieldSobrenomeAluno;
	//private OrganizaTurmas gerenciador;

	/**
	 * Create the frame.
	 */
	public TelaCadAluno(OrganizaTurmas gerenciador) {
		//this.gerenciador = gerenciador;

		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel jlabelNomeAluno = new JLabel("Digite Seu Nome");
		jlabelNomeAluno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelNomeAluno.setBounds(37, 73, 153, 25);
		panel.add(jlabelNomeAluno);

		textFieldNomeAluno = new JTextField();
		textFieldNomeAluno.setBounds(222, 76, 170, 23);
		panel.add(textFieldNomeAluno);
		textFieldNomeAluno.setColumns(10);

		JLabel jlabelSobrenomeAluno = new JLabel("Digite seu Sobrenome");
		jlabelSobrenomeAluno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelSobrenomeAluno.setBounds(37, 109, 178, 25);
		panel.add(jlabelSobrenomeAluno);

		textFieldSobrenomeAluno = new JTextField();
		textFieldSobrenomeAluno.setBounds(222, 111, 170, 25);
		panel.add(textFieldSobrenomeAluno);
		textFieldSobrenomeAluno.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Cadastro Aluno");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(127, 11, 239, 32);
		panel.add(lblNewLabel_1);

		JButton JbuttonSalvarCadastroAluno = new JButton("Salvar");
		JbuttonSalvarCadastroAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciador.saveAluno(textFieldNomeAluno.getText(), textFieldSobrenomeAluno.getText());
			}
		});
		JbuttonSalvarCadastroAluno.setBounds(277, 174, 89, 23);
		panel.add(JbuttonSalvarCadastroAluno);
	}

}
