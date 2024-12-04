package test;

import repositorio.EntidadNoEncontrada;
import repositorio.RepositorioException;
import servicio.FactoriaServicios;
import servicio.IPuntosDeInteres;
import servicio.IServicioEspacios;
import servicio.IServicioEventos;
import utils.Categoria;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import modelo.PuntoDeInteres;

public class Test2 {

	public static void main(String[] args) throws RepositorioException, MalformedURLException, URISyntaxException, ParserConfigurationException, SAXException, IOException, EntidadNoEncontrada {
		
		System.out.println(IServicioEspacios.class.getName());
		
		IServicioEspacios servicioEspacios = FactoriaServicios.getServicio(IServicioEspacios.class);
		IServicioEventos servicioEventos = FactoriaServicios.getServicio(IServicioEventos.class);
		IPuntosDeInteres servicioPuntos = FactoriaServicios.getServicio(IPuntosDeInteres.class);
		
		
		String nombre = "Centro Culturale Aldo Moro";
		String propietario = "Comune di Cordenons";
		int capacidad = 500;
		String direccion = "Via Traversagna, 4";
		float latitud = 45.98492573273563f;
		float longitud = 12.701376041687318f;
		String descripcion = "El Centro Culturale Aldo Moro es un teatro en Cordenons.";
		LocalDateTime fechaInicio = LocalDateTime.of(2024, Month.NOVEMBER, 10, 12, 0);
		LocalDateTime fechaFin = LocalDateTime.of(2024, Month.NOVEMBER, 10, 19, 0);
		
		
		String nombre1 = "Palasport Forum";
		String propietario1 = "Uno";
		int capacidad1 = 2500;
		String direccion1 = "Viale Treviso, 1";
		float latitud1 = 45.963852f;
		float longitud1 = 12.660152f;
		String descripcion1 = "El Palasport Forum es una estructura polivalente para eventos deportivos y culturales.";

		String nombre2 = "Auditorium Concordia";
		String propietario2 = "Due";
		int capacidad2 = 800;
		String direccion2 = "Piazza della Repubblica, 8";
		float latitud2 = 45.903582f;
		float longitud2 = 12.841092f;
		String descripcion2 = "Auditorium Concordia es una sede para conciertos y presentaciones teatrales.";

		String nombre3 = "Sala Polifunzionale Enrico Mattei";
		String propietario3 = "Due";
		int capacidad3 = 400;
		String direccion3 = "Via Roma, 12";
		float latitud3 = 45.863125f;
		float longitud3 = 12.628741f;
		String descripcion3 = "La Sala Polifunzionale Enrico Mattei es ideal para reuniones y conferencias.";

		String nombre4 = "Teatro Verdi";
		String propietario4 = "Uno";
		int capacidad4 = 1200;
		String direccion4 = "Corso Italia, 35";
		float latitud4 = 45.942015f;
		float longitud4 = 13.621995f;
		String descripcion4 = "El Teatro Verdi es un lugar histórico para eventos teatrales y operísticos.";

		String nombre5 = "Centro Congressi Fiera di Pordenone";
		String propietario5 = "Uno";
		int capacidad5 = 3500;
		String direccion5 = "Viale Treviso, 3";
		float latitud5 = 45.959627f;
		float longitud5 = 12.652154f;
		String descripcion5 = "El Centro Congressi es un moderno espacio para ferias y eventos corporativos.";
		
		String idEspacio = servicioEspacios.alta(nombre, propietario, capacidad, direccion, latitud, longitud, descripcion);
		String idEspacio1 = servicioEspacios.alta(nombre1, propietario1, capacidad1, direccion1, latitud1, longitud1, descripcion1);
		String idEspacio2 = servicioEspacios.alta(nombre2, propietario2, capacidad2, direccion2, latitud2, longitud2, descripcion2);
		String idEspacio3 = servicioEspacios.alta(nombre3, propietario3, capacidad3, direccion3, latitud3, longitud3, descripcion3);
		String idEspacio4 = servicioEspacios.alta(nombre4, propietario4, capacidad4, direccion4, latitud4, longitud4, descripcion4);
		String idEspacio5 = servicioEspacios.alta(nombre5, propietario5, capacidad5, direccion5, latitud5, longitud5, descripcion5);
		
		// Dar de baja algunos espacios
		servicioEspacios.darDeBaja(idEspacio3);
		servicioEspacios.darDeBaja(idEspacio4);

		// Asociar puntos de interes a un espacio
		List<PuntoDeInteres> puntosDeInteres = servicioPuntos.getPuntosDeInteres(latitud, longitud);
		servicioEspacios.addPuntosDeInteres(idEspacio, puntosDeInteres);

		// 8. Crear nuevos eventos
		nombre = "Presentacion del nuevo libro de Stephen King.";
		descripcion = "Se presentará el nuevo libro thriller de Stephen King.";
		String organizador = "Tre";
		String idEvento = servicioEventos.alta(nombre, descripcion, organizador, Categoria.CULTURAL, fechaInicio, fechaFin, capacidad, idEspacio);
		
		/*
		// 10. Cancelar un evento
		servicioEventos.cancelar(idEvento);
		System.out.println("10. Cancelar un evento");
		repositorioEventos.getAll().forEach(System.out::println);
		*/
	}

}
