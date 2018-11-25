package gui;

import java.util.List;

import javax.swing.JButton;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import procesare.Destinatie;
import procesare.Masina;

public class EditareDataModel extends DefaultTableModel {

	private List<Masina> calatori = null;
	private List<Destinatie> destinatii = null;
	private boolean isCalator = false;
	
	public void setDestinatii(List<Destinatie> calatori) {
		this.destinatii = calatori;
		isCalator = false;
	}

	public void setCalatori(List<Masina> calatori) {
		this.calatori = calatori;
		isCalator = true;
	}

	@Override
	public int getRowCount() {
		if(calatori == null && destinatii == null)
			return 0;
		return  isCalator? calatori.size(): destinatii.size();
	}

	@Override
	public int getColumnCount() {
		if (isCalator) return 8;
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex > 6) {
			return "";
		}
		if (!isCalator) {
			switch (columnIndex) {
			case 0:
				return "Id";
			case 1:
				return "Denumire";
			case 2:
				return "Distanta";
			case 3:
				return "Tara";
			case 4:
				return "Continent";
			}
		} else {
			switch (columnIndex) {
			case 0:
				return "Id";
			case 1:
				return "Nume";
			case 2:
				return "Prenume";
			case 3:
				return "Sex";
			case 4:
				return "Varsta";
			case 5: 
				return "IdDestinatie";
			case 6:
				return "IdAvion";
			}
		} 

		return "";
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (!isCalator) {
			switch (columnIndex) {
			case 0:
			case 4:
				return Integer.class;
			}
		} else {
			switch (columnIndex) {
			case 0:
			case 4:
				return Integer.class;
			}
		} if (columnIndex == 8) {
			return JButton.class;
		}
		return String.class;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return columnIndex == 8;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		if (!isCalator) {
			if(rowIndex >= destinatii.size() || columnIndex > 5) {
				return null;
			}
			Destinatie m = destinatii.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return m.getId();
			case 1:
				return m.getDenumire();
			case 2:
				return m.getDistanta();
			case 3:
				return m.getTara();
			case 4:
				return m.getContinent();
			}
		} else {
			if(rowIndex >= calatori.size() || columnIndex > 8) {
				return null;
			}
			Masina s = calatori.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return s.getId();
			case 1:
				return s.getNume();
			case 2:
				return s.getPrenume();
			case 3:
				return s.getSex();
			case 4:
				return s.getVarsta();
			case 5:
				return s.getIdDestinatie();
			case 6:
				return s.getIdAvion();
			}
		}
		return null;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}
}
