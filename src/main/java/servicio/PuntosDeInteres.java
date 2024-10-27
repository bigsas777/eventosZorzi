package servicio;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import modelo.PuntoDeInteres;

public class PuntosDeInteres implements IPuntosDeInteres {
	
	private static final String USERNAME = "bigsas777";

	@Override
	public List<PuntoDeInteres> getPuntosDeInteres(float latitud, float longitud) throws URISyntaxException, ParserConfigurationException, SAXException, IOException {
		
		List<PuntoDeInteres> puntosDeInteres = new ArrayList<PuntoDeInteres>();
		
		URL url = generaURL(longitud, latitud);
		Document doc = getXML(url);
            
		NodeList entryList = doc.getElementsByTagName("entry");
        
        if (entryList == null)
        {
        	System.out.println("Error: no se encontraron datos.");
        }
        else
        {	
        	for (int i = 0; i < entryList.getLength(); i++) {
        		
                Node node = entryList.item(i);
                PuntoDeInteres tmp = new PuntoDeInteres();
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    tmp.setNombre(element.getElementsByTagName("title").item(0).getTextContent());
                    tmp.setDescripcion(element.getElementsByTagName("summary").item(0).getTextContent());
                    tmp.setDistancia(Float.parseFloat(element.getElementsByTagName("distance").item(0).getTextContent()));
                    tmp.setUrlWikipedia(element.getElementsByTagName("wikipediaUrl").item(0).getTextContent());
                    puntosDeInteres.add(tmp);
                }
            }
        }
        
        return puntosDeInteres;
	}
	
	private static Document getXML(URL url) throws ParserConfigurationException, SAXException, IOException {
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(conn.getInputStream());
        doc.getDocumentElement().normalize();
        
        return doc;
	}
	
	private static URL generaURL(float longitud, float latitud) throws MalformedURLException, URISyntaxException {
		String urlString = String.format(
				Locale.US,
                "http://api.geonames.org/findNearbyWikipedia?lat=%f&lng=%f&username=%s",
                latitud, longitud, USERNAME
            );

        return new URI(urlString).toURL();
		
	}
	
}
