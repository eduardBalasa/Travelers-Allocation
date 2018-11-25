package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import procesare.Destinatie;

public class EditareDestinatieFrame extends JFrame {
	
	private Destinatie destinatie;
	private JTextField txtDenumire;
	private JTextField txtDistanta;
	private JTextField txtTara;
	private JTextField txtContinent;
	
	public EditareDestinatieFrame(Destinatie temp) {
		super("Editare :"+temp.getDenumire());
		destinatie = new Destinatie();
		destinatie.setId(temp.getId());
		destinatie.setDenumire(temp.getDenumire());
		destinatie.setDistanta(temp.getDistanta());
		destinatie.setTara(temp.getTara());
		destinatie.setContinent(temp.getContinent());
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JLabel lbl = new JLabel("Id");
		lbl.setBounds(10, 10, 85, 20);
		panel.add(lbl);
		lbl = new JLabel("Denumire");
		lbl.setBounds(10, 40, 85, 20);
		panel.add(lbl);
		lbl = new JLabel("Distanta");
		lbl.setBounds(10, 70, 85, 20);
		panel.add(lbl);
		lbl = new JLabel("Tara");
		lbl.setBounds(10, 100, 85, 20);
		panel.add(lbl);
		lbl = new JLabel("Continent");
		lbl.setBounds(10, 130, 85, 20);
		panel.add(lbl);
		
		lbl = new JLabel(""+destinatie.getId());
		lbl.setBounds(110, 10, 150, 20);
		panel.add(lbl);
		
		txtDenumire = new JTextField(destinatie.getDenumire());
		txtDenumire.setBounds(110, 40, 150, 20);
		panel.add(txtDenumire);

		txtDistanta = new JTextField(destinatie.getDistanta());
		txtDistanta.setBounds(110, 70, 150, 20);
		panel.add(txtDistanta);

		txtTara = new JTextField(destinatie.getTara());
		txtTara.setBounds(110, 100, 150, 20);
		panel.add(txtTara);

		txtContinent = new JTextField(""+destinatie.getContinent());
		txtContinent.setBounds(110, 130, 150, 20);
		panel.add(txtContinent);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//EditareAngajatForm.this.setVisible(false);
				//parent.reloadTable();
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
				EditareDestinatieFrame.this.setVisible(false);
			}
		});
		btnCancel.setBounds(10, 170, 90, 40);
		panel.add(btnCancel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//EditareAngajatForm.this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				//parent.getModel().setValueAt(txtName.getText(), 0, 0);
				//parent.getModel().addTableModelListener();
				//parent.reloadTable();
				EditareDestinatieFrame.this.setVisible(false);
			}
		});
		btnSave.setBounds(110, 170, 90, 40);
		panel.add(btnSave);
	}

	public Destinatie getDestinatie() {
		return destinatie;
	}
}
