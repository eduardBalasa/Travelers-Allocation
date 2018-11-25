package parsare;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import procesare.Repartizare;
import procesare.Situatie;

public class WriteXMLFile {
	public void createXMLFrom(List<Repartizare> repartizari, String outputFile)
			throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();

		Element root = doc.createElement("Repartizare");
		doc.appendChild(root);
		for (Repartizare rep : repartizari) {
			Element dest = doc.createElement("Destinatie");
			dest.setAttribute("descriere", rep.getDestinatie().getDenumire());
			for (Situatie situatie : rep.getSituatii()) {
				Element elem = doc.createElement("Calator");
				elem.setAttribute("id", Integer.toString(situatie.getCalator().getId()));
				elem.setAttribute("nume", situatie.getCalator().getNume());
				elem.setAttribute("prenume", situatie.getCalator().getPrenume());
				elem.setAttribute("sex", situatie.getCalator().getSex());
				elem.setAttribute("varsta", Integer.toString(situatie.getCalator().getVarsta()));
				elem.setAttribute("avion", Integer.toString(situatie.getAvion().getId()));
				dest.appendChild(elem);
			}
			root.appendChild(dest);
		}
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer t = tFactory.newTransformer();
		t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		t.setOutputProperty(OutputKeys.INDENT, "yes");
		Result result = new StreamResult(new File(outputFile));
		Source source = new DOMSource(doc);
		t.transform(source, result);
	}

}
