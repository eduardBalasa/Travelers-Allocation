package gui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import procesare.Avion;
import procesare.Destinatie;
import procesare.Situatie;

public class RepartizareDataModel extends DefaultTableModel {

	private List<Avion> avioane = null;

	public RepartizareDataModel(List<Avion> avioane) {
		super();
		this.avioane = avioane;
	}

	@Override
	public int getRowCount() {
		if(avioane == null) return 0;
		
		return avioane.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Id";
		case 1:
			return "Model";
		case 2:
			return "Locuri";
		case 3:
			return "Id Destinatie";
		
		}

		return "";
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 2:
		case 3:
			return Integer.class;
		}
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Avion s = avioane.get(rowIndex);
				switch (columnIndex) {
				case 0:
					return s.getId();
				case 1:
					return s.getModel();
				case 2:
					return s.getNrLocuri();
				case 3:
					return s.getIdDestinatie();

				}
				return null;
	}
}
