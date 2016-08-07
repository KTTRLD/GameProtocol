package com.gameprojekt.gottfried.controler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import com.gameprojekt.gottfried.model.Name;

public class MainGUI extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainControler controler;
	static JLabel[] label = new JLabel[6];
	static JButton[] button = new JButton[4];
	private int k, b;
	public MainGUI(final MainControler controler) {
		// TODO Auto-generated constructor stub
		this.controler = controler;
		JPanel panel = new JPanel();
		
		initSecondFrame();

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent windowEvent) {
				controler.close();
			}
		});

		initComponents(panel);
		initButtons(panel);
		initGameArray(panel);
		createMenu();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(250, 300));
		// window.setLayout(new GridLayout(2, 0));
		this.setLocation(400, 400);
		this.add(panel);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.pack();
	}

	// The bet watch table is initiated here. Only called once when initializing
	// the application.
	private void initSecondFrame() {
		
		new JPanel();
		JFrame tableFrame = new JFrame();
		javax.swing.JScrollPane scrMarket = new JScrollPane();
		javax.swing.JTable  tblMarket = new JTable();
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tblMarket.setModel(controler.getTableModel());

        for (int columnIndex = 0; columnIndex < tblMarket.getColumnCount(); columnIndex++)
        {
            tblMarket.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
		
//		tblMarket.getColumnModel().getColumn(0).
//		tblMarket.getColumnModel().getColumn(0).setPreferredWidth(30); 
//		tblMarket.getColumnModel().getColumn(1).setPreferredWidth(100); 
//		tblMarket.getColumnModel().getColumn(2).setPreferredWidth(100); 
//		tblMarket.getColumnModel().getColumn(3).setPreferredWidth(30);
//		tblMarket.getColumnModel().getColumn(4).setPreferredWidth(30);
		tblMarket.getColumnModel().getColumn(5).setPreferredWidth(160);
//		tblMarket.getColumnModel().getColumn(6).setPreferredWidth(30);
//		tblMarket.getColumnModel().getColumn(7).setPreferredWidth(50);
		
		tblMarket.setBackground(Color.orange);
		tblMarket.setForeground(Color.black);
		tblMarket.setRowHeight(24);
		
		tblMarket.setCellSelectionEnabled(false); 
		scrMarket.add(tblMarket);
		scrMarket.setViewportView(tblMarket);

		
		tableFrame.add(scrMarket);
		tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		tableFrame.setPreferredSize(new Dimension(screenSize.width,100));
		tableFrame.setLocationRelativeTo(this);
		tableFrame.setAlwaysOnTop(true);
		tableFrame.setLocation(0, 100);
		tableFrame.setVisible(true);
		tableFrame.pack();
	}

	private void initComponents(JPanel panel) {
		panel.setLayout(new GridLayout(9, 0));

		// button[Name.BUTTON_NEWGAME] = new JButton(Name.NEWGAME);

		panel.add(new JLabel("Das Ergebnis"));
		panel.add(new JLabel("Ihr Einsatz"));
		panel.add(new JLabel("Runde"));
		panel.add(new JLabel("Table ID"));
		panel.add(new JLabel("Kontostand"));
		panel.add(new JButton(Name.NEWGAME));
		panel.add(new JButton("Tisch wechseln"));
		panel.add(new JButton(Name.WIN));
		panel.add(new JButton(Name.LOOSE));
	}

	private void initButtons(JPanel panel) {
		k = 0;
		b = 0;
		for (int i = 0; i < panel.getComponentCount(); i++) {
			if (panel.getComponent(i) instanceof JLabel) {
				int j = label.length;
				if (k < j) {
					label[k] = (JLabel) panel.getComponent(i);
					label[k].setHorizontalAlignment(JLabel.CENTER);
					k++;
				}
			}

			if (panel.getComponent(i) instanceof JButton) {
				int j = button.length;
				if (b < j) {
					button[b] = (JButton) panel.getComponent(i);
					if (button[b].getText().equalsIgnoreCase(Name.WIN)) {
						button[b].setBackground(Color.GREEN);
						button[b].repaint();
						System.out.println("winn button set color");
					}
					if (button[b].getText().equalsIgnoreCase(Name.LOOSE)) {
						button[b].setBackground(Color.RED);
						button[b].repaint();
					}
					b++;
				}
			}
		}
	}

	private static void initGameArray(JPanel panel) {
		// TODO Auto-generated method stub

	}

	private void createMenu() {

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu fileMenu = new JMenu("Play");
		JMenu mnEdit = new JMenu("Bearbeiten");
		JMenu mnRun = new JMenu("Eyetracker");

		menuBar.add(fileMenu);
		menuBar.add(mnEdit);
		menuBar.add(mnRun);

		addFirstMenuItems(fileMenu);
		// addSecondMenuItems(mnEdit);
		// addThirdMenuItems(mnRun);

	}

	private void addFirstMenuItems(JMenu fileMenu) {
		JMenuItem mntmExample = new JMenuItem("Start old game");
		JMenuItem mntmExample_1 = new JMenuItem("Kontostand angeben");
		// JMenuItem mntmLoadImage = new JMenuItem("Neues Bild laden");
		JSeparator separator = new JSeparator();
		JMenuItem mntmClose = new JMenuItem("Schließen");

		mntmExample.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controler.getModel().startFromOldGameAction();
				winAction();
			}
		});
		mntmClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controler.close();
				System.exit(0);
			}
		});
		
		mntmExample_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(null, null, "Kontostand", JOptionPane.OK_CANCEL_OPTION);
				controler.getModel().setKontostand(input);
			}
		});
		fileMenu.add(mntmExample);
		 fileMenu.add(mntmExample_1);
		// fileMenu.add(mntmLoadImage);
		fileMenu.add(separator);
		fileMenu.add(mntmClose);
	}

	public JButton[] getButtons() {
		return button;
	}

	public void winAction() {
		label[0].setText(controler.getModel().getPreThrowArray().getArrayString());
		label[1].setText("neuer Einsatz: " + controler.getModel().getPreThrowArray().getEinsatzString());
		label[2].setText("Runde:" + controler.getModel().getPreThrowArray().getGameIDString());
		label[3].setText("Table: " + controler.getModel().getPreThrowArray().getTableIDString());
		label[4].setText("Kontostand: " + controler.getModel().getPreThrowArray().getKontostandString());

	}

	@Override
	public void update(Observable o, Object arg) {
		this.winAction();

	}

}
