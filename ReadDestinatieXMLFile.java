package parsare;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import procesare.Destinatie;

public class ReadDestinatieXMLFile extends DefaultHandler{
	private boolean bDenumire;
	private boolean bContinent;
	private boolean bTara;
	private boolean bDistanta;
	
	private Destinatie destinatie;
	private List<Destinatie> destinatii;
	
	public List<Destinatie> getDestinatii(){
		return destinatii;
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if(qName.equalsIgnoreCase("Destinatie")) {
			destinatie = new Destinatie();
			if (attributes.getValue("id") != null) {
				destinatie.setId(Integer.parseInt(attributes.getValue("id")));
			}
		} else if (qName.equalsIgnoreCase("denumire")) {
			bDenumire = true;
		} else if (qName.equalsIgnoreCase("continent")) {
			bContinent = true;
		} else if (qName.equalsIgnoreCase("tara")) {
			bTara = true;
		} else if (qName.equalsIgnoreCase("distanta")) {
			bDistanta = true;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		if(bDenumire) {
			destinatie.setDenumire(new String(ch, start, length));
		} else if(bContinent) {
			destinatie.setContinent(new String(ch, start, length));
		} else if(bTara) {
			destinatie.setTara(new String(ch, start, length));
		} else if(bDistanta) {
			destinatie.setDistanta(Integer.parseInt(new String(ch, start, length)));
		} 
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if(qName.equalsIgnoreCase("Destinatie")) {
			if(destinatii == null) {
				destinatii = new ArrayList<Destinatie>();
			}
			destinatii.add(destinatie);
			destinatie = null;
		} else if (qName.equalsIgnoreCase("denumire")) {
			bDenumire = false;
		} else if (qName.equalsIgnoreCase("continent")) {
			bContinent = false;
		} else if (qName.equalsIgnoreCase("tara")) {
			bTara = false;
		} else if (qName.equalsIgnoreCase("distanta")) {
			bDistanta = false;
		}
	}


}
