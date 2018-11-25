package parsare;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import procesare.Avion;

public class ReadAvionXMLFile extends DefaultHandler {
	private boolean bAvion;
	private boolean bModel;
	private boolean bLoc;
	private boolean bDestinatie;

	private Avion avion;
	private List<Avion> avioane;

	public List<Avion> getAvioane() {
		return avioane;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if (qName.equalsIgnoreCase("Avion")) {
			avion = new Avion();
			if (attributes.getValue("id") != null) {
				avion.setId(Integer.parseInt(attributes.getValue("id")));
			}
			bAvion = true;
		} else if (qName.equalsIgnoreCase("model")) {
			bModel = true;
		} else if (qName.equalsIgnoreCase("destinatie")) {
			bDestinatie = true;
		} else if (qName.equalsIgnoreCase("loc")) {
			bLoc = true;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		if (bModel) {
			avion.setModel(new String(ch, start, length));
		} else if (bDestinatie) {
			avion.setIdDestinatie(Integer.parseInt(new String(ch, start, length)));
		} else if (bLoc) {
			avion.setNrLocuri(Integer.parseInt(new String(ch, start, length)));
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if (qName.equalsIgnoreCase("Avion")) {
			if (avioane == null) {
				avioane = new ArrayList<Avion>();
			}
			avioane.add(avion);
			avion = null;
			bAvion = false;
		} else if (qName.equalsIgnoreCase("model")) {
			bModel = false;
		} else if (qName.equalsIgnoreCase("loc")) {
			bLoc = false;
		} else if (qName.equalsIgnoreCase("destinatie")) {
			bDestinatie = false;
		}
	}

}