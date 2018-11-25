package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import procesare.Masina;

public class EditareCalatorFrame extends JFrame {
	private Masina calator;
	private JTextField txtNume;
	private JTextField txtPrenume;
	private JTextField txtSex;
	private JTextField txtVarsta;
	private JTextField txtDestinatie;
	private JTextField txtAvion;
	private Main mf;
	
	

	public void setMf(Main mf) {
		this.mf = mf;
	}

	public EditareCalatorFrame(Masina temp) {
		
		super("Editare Calator: " + temp.getNume() + " " + temp.getPrenume());
		calator = temp;
		/*calator.setId(temp.getId());
		calator.setNume(temp.getNume());
		calator.setPrenume(temp.getPrenume());
		calator.setSex(temp.getSex());
		calator.setVarsta(temp.getVarsta());
		calator.setIdAvion(temp.getIdAvion());
		calator.setIdDestinatie(temp.getIdDestinatie());*/

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);

		JLabel lbl = new JLabel("Id");
		lbl.setBounds(10, 10, 85, 20);
		panel.add(lbl);
		lbl = new JLabel("Nume");
		lbl.setBounds(10, 40, 85, 20);
		panel.add(lbl);
		lbl = new JLabel("Prenume");
		lbl.setBounds(10, 70, 85, 20);
		panel.add(lbl);
		lbl = new JLabel("Sex");
		lbl.setBounds(10, 100, 85, 20);
		panel.add(lbl);
		lbl = new JLabel("Varsta");
		lbl.setBounds(10, 130, 85, 20);
		panel.add(lbl);
		lbl = new JLabel("Id Destinatie");
		lbl.setBounds(10, 160, 85, 20);
		panel.add(lbl);
		lbl = new JLabel("Id Avion");
		lbl.setBounds(10, 190, 85, 20);
		panel.add(lbl);

		lbl = new JLabel("" + calator.getId());
		lbl.setBounds(110, 10, 150, 20);
		panel.add(lbl);

		txtNume = new JTextField(calator.getNume());
		txtNume.setBounds(110, 40, 150, 20);
		panel.add(txtNume);

		txtPrenume = new JTextField(calator.getPrenume());
		txtPrenume.setBounds(110, 70, 150, 20);
		panel.add(txtPrenume);

		txtSex = new JTextField(calator.getSex());
		txtSex.setBounds(110, 100, 150, 20);
		panel.add(txtSex);

		txtVarsta = new JTextField("" + calator.getVarsta());
		txtVarsta.setBounds(110, 130, 150, 20);
		panel.add(txtVarsta);
		
		txtDestinatie = new JTextField("" + calator.getIdDestinatie());
		txtDestinatie.setBounds(110, 160, 150, 20);
		panel.add(txtDestinatie);
		
		txtAvion = new JTextField("" + calator.getIdAvion());
		txtAvion.setBounds(110, 190, 150, 20);
		panel.add(txtAvion);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				EditareCalatorFrame.this.setVisible(false);
			}
		});
		btnCancel.setBounds(10, 230, 90, 40);
		panel.add(btnCancel);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				calator.setNume(txtNume.getText());
				calator.setPrenume(txtPrenume.getText());
				calator.setSex(txtSex.getText());
				calator.setVarsta(Integer.parseInt(txtVarsta.getText()));
				calator.setIdAvion(Integer.parseInt(txtAvion.getText()));
				calator.setIdDestinatie(Integer.parseInt(txtDestinatie.getText()));
				
				EditareCalatorFrame.this.dispose();
				mf.getTabelCalatori().repaint();

			   
			}
		});
		btnSave.setBounds(130, 230, 90, 40);
		panel.add(btnSave);
		
		this.setTitle("Editare Calator");
		panel.setSize(250, 250);
		this.pack();
	}

	public Masina getCalator() {
		return calator;
	}
}
