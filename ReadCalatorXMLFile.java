package parsare;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import procesare.Masina;

public class ReadCalatorXMLFile extends DefaultHandler{
	private boolean bDestinatie;
	private boolean bNume;
	private boolean bPrenume;
	private boolean bVarsta;
	private boolean bSex;
	private boolean bAvion;
	
	private Masina calator;
	private List<Masina> calatori;
	
	public List<Masina> getCalatori(){
		return calatori;
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if(qName.equalsIgnoreCase("Calator")) {
			calator = new Masina();
			if (attributes.getValue("id") != null) {
				calator.setId(Integer.parseInt(attributes.getValue("id")));
			}
		} else if (qName.equalsIgnoreCase("nume")) {
			bNume = true;
		} else if (qName.equalsIgnoreCase("prenume")) {
			bPrenume = true;
		} else if (qName.equalsIgnoreCase("sex")) {
			bSex = true;
		} else if (qName.equalsIgnoreCase("varsta")) {
			bVarsta = true;
		}else if (qName.equalsIgnoreCase("destinatie")) {
			bDestinatie = true;
		}else if (qName.equalsIgnoreCase("avion")) {
			bAvion = true;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		if(bNume) {
			calator.setNume(new String(ch, start, length));
		} else if(bPrenume) {
			calator.setPrenume(new String(ch, start, length));
		} else if(bSex) {
			calator.setSex(new String(ch, start, length));
		} else if(bVarsta) {
			calator.setVarsta(Integer.parseInt(new String(ch, start, length)));
		} else if(bDestinatie) {
			calator.setIdDestinatie(Integer.parseInt(new String(ch, start, length)));
		} else if(bAvion) {
			calator.setIdAvion(Integer.parseInt(new String(ch, start, length)));
		} 
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if(qName.equalsIgnoreCase("calator")) {
			if(calatori == null) {
				calatori = new ArrayList<Masina>();
			}
			calatori.add(calator);
			calator = null;
		} else if (qName.equalsIgnoreCase("nume")) {
			bNume = false;
		} else if (qName.equalsIgnoreCase("prenume")) {
			bPrenume = false;
		} else if (qName.equalsIgnoreCase("sex")) {
			bSex = false;
		} else if (qName.equalsIgnoreCase("varsta")) {
			bVarsta = false;
		}else if (qName.equalsIgnoreCase("destinatie")) {
			bDestinatie = false;
		}else if (qName.equalsIgnoreCase("avion")) {
			bAvion = false;
		}
	}

}
