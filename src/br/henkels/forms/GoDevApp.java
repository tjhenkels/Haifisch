package br.henkels.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.henkels.organizaturma.OrganizaTurmas;

public class GoDevApp {

	public JFrame mainForm;

	private JButton ButtonTelaCadastroSaladeAula;
	private OrganizaTurmas gerenciador; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoDevApp window = new GoDevApp();
					window.mainForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GoDevApp() {
		initialize();
		gerenciador = new OrganizaTurmas();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainForm = new JFrame();
		mainForm.setBounds(100, 100, 450, 300);
		mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		mainForm.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro e Consulta");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(153, 30, 160, 14);
		panel.add(lblNewLabel);

		JButton ButtonTelaCadastroAluno = new JButton("Aluno");
		ButtonTelaCadastroAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadAluno tela = new TelaCadAluno(gerenciador);
				tela.setModal(true);
				tela.setVisible(true);

			}
		});
		ButtonTelaCadastroAluno.setBounds(170, 75, 112, 23);
		panel.add(ButtonTelaCadastroAluno);

		ButtonTelaCadastroSaladeAula = new JButton("Sala de Aula");
		ButtonTelaCadastroSaladeAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadSalaAula tela = new TelaCadSalaAula(gerenciador);
				tela.setModal(true);
				tela.setVisible(true);

			}
		});
		ButtonTelaCadastroSaladeAula.setBounds(170, 109, 112, 23);
		panel.add(ButtonTelaCadastroSaladeAula);

		JButton btnNewButton = new JButton("Sala de Caf\u00E9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadSalaCafe tela = new TelaCadSalaCafe(gerenciador);
				tela.setModal(true);
				tela.setVisible(true);
			}
		});
		btnNewButton.setBounds(170, 147, 112, 23);
		panel.add(btnNewButton);
	}

}
