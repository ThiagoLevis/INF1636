package JFrame;

import javax.swing.*;

import Controller.Observer.ObservadoIF;
import Controller.Observer.ObservadorIF;
import Regras.CtrlRegras;

import java.awt.*;
import java.awt.event.*;
// import java.io.Console;
import java.io.IOException;

public class Frame extends JFrame implements ObservadorIF, MouseListener {
	private final int ALTURA = 700;
	private final int LARGURA = 1200;
	private int nPlayers;
	JPanel p;
	JButton saveButton = new JButton("Salvar");
	JComboBox<String> comboBox = new JComboBox<String>();

	public Frame(String s) {
		super(s);
		CtrlRegras control = CtrlRegras.getInstance();
		nPlayers = control.getNumPlayers();
		////////// Frame/////////////
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int sl = screenSize.width;
		int sa = screenSize.height;
		int x = sl / 2 - LARGURA / 2;
		int y = sa / 2 - ALTURA / 2;
		setBounds(x, y, LARGURA, ALTURA);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//////////////////////////
		Board p = new Board(saveButton, comboBox);
		getContentPane().add(p);
		p.setLayout(null);
		setSize(LARGURA, ALTURA);

		addMouseListener(this);

		JButton diceButton = new JButton("Roll");
		diceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!control.isStealing()) {
					control.jogaDados();
				} else {
					JOptionPane.showMessageDialog(null,
							"Modo de jogo: Roubando\nMude o modo para poder jogar os dados");
				}
			}
		});

		JCheckBox dadoRoubar = new JCheckBox();
		dadoRoubar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.toggleDiceOptions();
			}
		});
		JButton dadosRoubarButton = new JButton("Dados Viciados");
		dadosRoubarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (control.isStealing()) {
					control.dadoViciado();
				} else {
					JOptionPane.showMessageDialog(null,
							"Modo de jogo: Normal\nMude o modo para poder escolher os dados");
				}

			}
		});

		JButton finishButton = new JButton("Finalizar");
		finishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.endGame();
			}
		});

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.saveGame();
			}
		});

		comboBox.setBounds(970, 100, 200, 20);
		p.add(comboBox);

		diceButton.setBounds(740, 10, 150, 30);
		p.add(diceButton);

		dadoRoubar.setBounds(715, 160, 25, 30);
		p.add(dadoRoubar);

		dadosRoubarButton.setBounds(740, 160, 150, 30);
		p.add(dadosRoubarButton);

		finishButton.setBounds(920, 620, 100, 30);
		p.add(finishButton);

		saveButton.setBounds(1070, 620, 100, 30);
		p.add(saveButton);

		control.add(this);
	}

	@Override
	public void notify(ObservadoIF o) {
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		if (x > 740 && x < 890 && y > 230 && y < 260) {
			CtrlRegras.getInstance().controlePlayers();
		}

		if (x > 740 && x < 890 && y > 330 && y < 360) {
			CtrlRegras.getInstance().comprarCasa();
		}

		if (x > 740 && x < 890 && y > 430 && y < 460) {
			CtrlRegras.getInstance().venderPropriedade();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
