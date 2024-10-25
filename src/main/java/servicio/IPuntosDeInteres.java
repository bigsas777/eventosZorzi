package servicio;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import modelo.PuntoDeInteres;

public interface IPuntosDeInteres {
	
	List<PuntoDeInteres> getPuntosDeInteres(float longitud, float latitud) throws MalformedURLException, URISyntaxException, ParserConfigurationException, SAXException, IOException;

}
