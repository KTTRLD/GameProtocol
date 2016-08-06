package com.gameprojekt.gottfried.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import com.gameprojekt.gottfried.model.Model;

/**
 * Das ist die Hauptklasse des GameProtocolProjekt dies ist die aktuelleste
 * Version welche am 17.07.2016 stabiel lief. Es können Daten des Live Roulettes
 * erfasst werden und in eine CSV-Datei gespeichert werden. Aktuell läuft das
 * Programm noch teilweise sehr unsicher. Es gibt noch einige Buggs die zu
 * beheben sind, aber es erfüllt den Nutzen der erleichterten Dokumentation der
 * Spielverläufe. Der Code ist sehr schlecht geschrieben, Ziel ist es diesen in
 * der nächsten Zeit zu verbessern und damit ein stabileres und besser lesbares
 * Programm zu schreiben. Dies muss aber nicht sofort sein.
 * 
 * Die Application ist auf Grundlage des MVC Paradigmas geschrieben. Hält dies
 * jedoch nicht komplet kohärent aus. Dies soll im weiteren ebenfalls verbessert
 * werden.
 * 
 * Es gibt eine HauptGUI {@link #view} Das Hauptmodel {@link #model}
 * 
 * 
 * @author K.Gottfried
 *
 */

public class MainControler implements Observer {

	private static Model model;
	private static MainGUI view;

	public MainControler() {
		model = new Model(this);
		view = new MainGUI(this);
		model.addObserver(this);
		model.addObserver(view);
		initActionListenerForButtons();
	}

	public static void main(String[] args) {
		new MainControler();
	}
	static void initActionListenerForButtons() {

		JButton[] button = view.getButtons();

		// <--NewGame-Button Aktion-->
		button[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.startNewGameAction();
			}

		});

		// <--changeTable-Button Aktion-->
		button[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(null, null,
						"TableID und Kontostand", JOptionPane.OK_CANCEL_OPTION);
				model.setTableID(input);
			}

		});

		// <--Win-Button Aktion-->
		button[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initCommunication();

				model.winAction();
				view.winAction();

			}

		});

		// <--Loose-Button Aktion-->
		button[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initCommunication();
				model.looseAction();
				view.winAction();
			}
		});

	}

	private static void initCommunication() {
		String[] drehRichtung = {"rechts", "links"};
		String drehRichtungString = (String) JOptionPane.showInputDialog(view,
				"Wie ist die Kugeldrehrichtung", "Drehrichtung",
				JOptionPane.QUESTION_MESSAGE, null, drehRichtung,
				drehRichtung[0]);
		model.setDrehrichtung(drehRichtungString);

		String input = JOptionPane.showInputDialog(view, null, "Ergebnis",
				JOptionPane.OK_CANCEL_OPTION);
		model.setErgebnis(input);
	}

	public LinkedList<Integer> getList() {
		return Model.getList();
	}

	public Model getModel() {
		return model;
	}

	public void close() {
		model.close();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	public TableModel getTableModel() {
		return model.getTableModel();
	}

}
