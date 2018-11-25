package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import parsare.ReadAvionXMLFile;
import parsare.ReadCalatorXMLFile;
import parsare.ReadDestinatieXMLFile;
import parsare.WriteXMLFile;
import procesare.Avion;
import procesare.Masina;
import procesare.Destinatie;
import procesare.Repartizare;
import procesare.Situatie;

public class Main extends JFrame {
	private List<Masina> calatori;
	private List<Destinatie> destinatii;
	private List<Avion> avioane;
	private List<Repartizare> repartizari;
	private JTable tabelCalatori;
	private JTable tabelDestinatii;
	private JTable tabelRepartizari;
	
	public JTable getTabelCalatori() {
		return tabelCalatori;
	}

	public Main() {
		super("Repartizare Calatori");

		JPanel panel = new JPanel();
		panel.setLayout(null);

		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int i = fc.showOpenDialog(Main.this);
				if (i == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					String filepath = f.getPath();
					if (!filepath.endsWith("Calator.xml")) {
						JOptionPane.showMessageDialog(Main.this, "Nu s-a ales fisierul calatorilor");
					} else {
						calatori = Main.this.parseXMLC(0, filepath);
						System.out.println("nr calatori: " + calatori.size());
						EditareDataModel model = new EditareDataModel();
						model.setCalatori(calatori);
						tabelCalatori.setModel(model);
					}
				}

			}
		});
		button.setText("Alege Calator.xml");
		button.setBounds(10, 10, 150, 20);
		panel.add(button);
		add(panel);

		button = new JButton();
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int i = fc.showOpenDialog(Main.this);
				if (i == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					String filepath = f.getPath();
					if (!filepath.endsWith("Destinatie.xml")) {
						JOptionPane.showMessageDialog(Main.this, "Nu s-a ales fisierul Destinatiilor");
					} else {
						destinatii = Main.this.parseXMLD(1, filepath);
						System.out.println("nr destinatii: " + destinatii.size());
						EditareDataModel model = new EditareDataModel();
						model.setDestinatii(destinatii);
						tabelDestinatii.setModel(model);
					}
				}

			}
		});
		button.setText("Alege Destinatie.xml");
		button.setBounds(10, 200, 150, 20);
		panel.add(button);
		add(panel);

		button = new JButton();
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int i = fc.showOpenDialog(Main.this);
				if (i == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					String filepath = f.getPath();
					if (!filepath.endsWith("Avion.xml")) {
						JOptionPane.showMessageDialog(Main.this, "Nu s-a ales fisierul avioanelor");
					} else {
						Main.this.parseXMLA(2, filepath);
						if (Main.this.avioane != null && destinatii != null && calatori != null) {
							RepartizareDataModel model = new RepartizareDataModel(avioane);
							tabelRepartizari.setModel(model);
							repartizari = new ArrayList<Repartizare>();
							for (Destinatie destinatie : destinatii) {
								Repartizare repartizare = new Repartizare();
								repartizare.setDestinatie(destinatie);
								for (Avion avion : avioane) {
									if (avion.getIdDestinatie() == destinatie.getId()) {
										for (Masina calator : calatori) {
											if (calator.getIdDestinatie() == destinatie.getId()
													&& calator.getIdAvion() == avion.getId()) {
												Situatie situatie = new Situatie();
												situatie.setDestinatie(destinatie);
												situatie.setAvion(avion);
												situatie.setCalator(calator);
												repartizare.addSituatie(situatie);
											}
										}
									}
								}
								repartizari.add(repartizare);
							}

						}
					}
				}

			}
		});
		button.setText("Alege Avion.xml");
		button.setBounds(10, 400, 150, 20);
		panel.add(button);
		add(panel);

		tabelCalatori = new JTable();

		JScrollPane sp = new JScrollPane(tabelCalatori);
		sp.setBounds(200, 10, 400, 170);
		panel.add(sp);

		tabelDestinatii = new JTable();

		sp = new JScrollPane(tabelDestinatii);
		sp.setBounds(200, 200, 400, 170);
		panel.add(sp);

		tabelRepartizari = new JTable();

		sp = new JScrollPane(tabelRepartizari);
		sp.setBounds(200, 400, 400, 200);
		panel.add(sp);

		JButton btnSave = new JButton();
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WriteXMLFile domWriter = new WriteXMLFile();
				try {
					domWriter.createXMLFrom(repartizari, "oRepartizare.xml");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnEdit = new JButton("Edit");
		
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				EditareCalatorFrame ecf = new EditareCalatorFrame(calatori.get(tabelCalatori.getSelectedRow()));
				ecf.setMf(Main.this);
				ecf.setVisible(true);
				ecf.setSize(400,500);
			}
			
		});
		
		btnEdit.setBounds(10, 60, 150, 20);
		panel.add(btnEdit);
		
		
		btnSave.setText("Save to XML");
		btnSave.setBounds(200, 720, 150, 20);
		panel.add(btnSave);

		setSize(650, 800);
		setLocationRelativeTo(null);

		setVisible(true);
	}


	public void parseXMLA(int tip, String file) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = factory.newSAXParser();

			ReadAvionXMLFile saxReader = new ReadAvionXMLFile();
			parser.parse(file, saxReader);

			avioane = saxReader.getAvioane();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public List<Masina> parseXMLC(int tip, String file) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = factory.newSAXParser();

			ReadCalatorXMLFile saxReader = new ReadCalatorXMLFile();
			parser.parse(file, saxReader);
			return saxReader.getCalatori();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return null;
	}

	public List<Destinatie> parseXMLD(int tip, String file) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = factory.newSAXParser();

			ReadDestinatieXMLFile saxReader = new ReadDestinatieXMLFile();
			parser.parse(file, saxReader);
			return saxReader.getDestinatii();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return null;
	}

}
