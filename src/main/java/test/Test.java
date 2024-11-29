package test;

import repositorio.EntidadNoEncontrada;
import repositorio.FactoriaRepositorios;
import repositorio.Repositorio;
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

import modelo.EspacioFisico;
import modelo.Evento;
import modelo.PuntoDeInteres;

public class Test {

	public static void main(String[] args) throws RepositorioException, MalformedURLException, URISyntaxException, ParserConfigurationException, SAXException, IOException, EntidadNoEncontrada {
		
		System.out.println(IServicioEspacios.class.getName());
		
		IServicioEspacios servicioEspacios = FactoriaServicios.getServicio(IServicioEspacios.class);
		IServicioEventos servicioEventos = FactoriaServicios.getServicio(IServicioEventos.class);
		IPuntosDeInteres servicioPuntos = FactoriaServicios.getServicio(IPuntosDeInteres.class);
		
		Repositorio<Evento, String> repositorioEventos = FactoriaRepositorios.getRepositorio(Evento.class);
		Repositorio<EspacioFisico, String> repositorioEspacios = FactoriaRepositorios.getRepositorio(EspacioFisico.class);
		
		
		String nombre = "Centro Culturale Aldo Moro";
		String propietario = "Comune di Cordenons";
		int capacidad = 500;
		String direccion = "Via Traversagna, 4";
		float latitud = 45.98492573273563f;
		float longitud = 12.701376041687318f;
		String descripcion = "El Centro Culturale Aldo Moro es un teatro en Cordenons.";
		LocalDateTime fechaInicio = LocalDateTime.of(2024, Month.DECEMBER, 10, 12, 0);
		LocalDateTime fechaFin = LocalDateTime.of(2024, Month.DECEMBER, 10, 19, 0);
		
		
		String nombre1 = "Palasport Forum";
		String propietario1 = "Comune di Pordenone";
		int capacidad1 = 2500;
		String direccion1 = "Viale Treviso, 1";
		float latitud1 = 45.963852f;
		float longitud1 = 12.660152f;
		String descripcion1 = "El Palasport Forum es una estructura polivalente para eventos deportivos y culturales.";
		LocalDateTime fechaInicio1 = LocalDateTime.of(2024, Month.DECEMBER, 15, 9, 0);
		LocalDateTime fechaFin1 = LocalDateTime.of(2024, Month.DECEMBER, 15, 18, 0);

		String nombre2 = "Auditorium Concordia";
		String propietario2 = "Comune di San Vito al Tagliamento";
		int capacidad2 = 800;
		String direccion2 = "Piazza della Repubblica, 8";
		float latitud2 = 45.903582f;
		float longitud2 = 12.841092f;
		String descripcion2 = "Auditorium Concordia es una sede para conciertos y presentaciones teatrales.";
		LocalDateTime fechaInicio2 = LocalDateTime.of(2024, Month.DECEMBER, 20, 16, 0);
		LocalDateTime fechaFin2 = LocalDateTime.of(2024, Month.DECEMBER, 20, 23, 0);

		String nombre3 = "Sala Polifunzionale Enrico Mattei";
		String propietario3 = "Comune di Pasiano di Pordenone";
		int capacidad3 = 400;
		String direccion3 = "Via Roma, 12";
		float latitud3 = 45.863125f;
		float longitud3 = 12.628741f;
		String descripcion3 = "La Sala Polifunzionale Enrico Mattei es ideal para reuniones y conferencias.";
		LocalDateTime fechaInicio3 = LocalDateTime.of(2024, Month.DECEMBER, 12, 10, 0);
		LocalDateTime fechaFin3 = LocalDateTime.of(2024, Month.DECEMBER, 12, 17, 0);

		String nombre4 = "Teatro Verdi";
		String propietario4 = "Comune di Gorizia";
		int capacidad4 = 1200;
		String direccion4 = "Corso Italia, 35";
		float latitud4 = 45.942015f;
		float longitud4 = 13.621995f;
		String descripcion4 = "El Teatro Verdi es un lugar histórico para eventos teatrales y operísticos.";
		LocalDateTime fechaInicio4 = LocalDateTime.of(2024, Month.DECEMBER, 25, 20, 0);
		LocalDateTime fechaFin4 = LocalDateTime.of(2024, Month.DECEMBER, 25, 23, 30);

		String nombre5 = "Centro Congressi Fiera di Pordenone";
		String propietario5 = "Fiera di Pordenone S.p.A.";
		int capacidad5 = 3500;
		String direccion5 = "Viale Treviso, 3";
		float latitud5 = 45.959627f;
		float longitud5 = 12.652154f;
		String descripcion5 = "El Centro Congressi es un moderno espacio para ferias y eventos corporativos.";
		LocalDateTime fechaInicio5 = LocalDateTime.of(2024, Month.DECEMBER, 18, 8, 0);
		LocalDateTime fechaFin5 = LocalDateTime.of(2024, Month.DECEMBER, 18, 20, 0);
		
		String idEspacio1 = servicioEspacios.alta(nombre1, propietario1, capacidad1, direccion1, latitud1, longitud1, descripcion1);
		String idEspacio2 = servicioEspacios.alta(nombre2, propietario2, capacidad2, direccion2, latitud2, longitud2, descripcion2);
		String idEspacio3 = servicioEspacios.alta(nombre3, propietario3, capacidad3, direccion3, latitud3, longitud3, descripcion3);
		String idEspacio4 = servicioEspacios.alta(nombre4, propietario4, capacidad4, direccion4, latitud4, longitud4, descripcion4);
		String idEspacio5 = servicioEspacios.alta(nombre5, propietario5, capacidad5, direccion5, latitud5, longitud5, descripcion5);

		
		
		// 1. Dar de alta un espacio fisico
		String idEspacio = servicioEspacios.alta(nombre, propietario, capacidad, direccion, latitud, longitud, descripcion);
		System.out.println("1. Dar de alta un espacio fisico");
		System.out.println(repositorioEspacios.getById(idEspacio));
		
		// 2. Buscar puntos de interés dadas unas coordenadas
		List<PuntoDeInteres> puntosDeInteres = servicioPuntos.getPuntosDeInteres(latitud, longitud);
		System.out.println("2. Buscar puntos de interés dadas unas coordenadas");
		puntosDeInteres.forEach(System.out::println);
		
		// 3. Asociar puntos de interes a un espacio
		servicioEspacios.addPuntosDeInteres(idEspacio, puntosDeInteres);
		System.out.println("3. Asociar puntos de interes a un espacio");
		System.out.println(repositorioEspacios.getById(idEspacio));
		
		// 4. Modificar los detalles de un espacio
		nombre += " Cordenons";
		capacidad = 700;
		descripcion += " Cordenons es mi ciudad en Italia.";
		servicioEspacios.modifica(idEspacio, nombre, capacidad, descripcion);
		System.out.println("4. Modificar los detalles de un espacio");
		System.out.println(repositorioEspacios.getById(idEspacio));
		
		// 5. Dar de baja un espacio
		servicioEspacios.darDeBaja(idEspacio);
		System.out.println("5. Dar de baja un espacio");
		System.out.println(repositorioEspacios.getById(idEspacio));
		
		// 6. Reactivar un espacio
		servicioEspacios.activar(idEspacio);
		System.out.println("6. Reactivar un espacio");
		System.out.println(repositorioEspacios.getById(idEspacio));

		// 7. Consultar los espacios libres
		List<EspacioFisico> espaciosLibres = servicioEspacios.busqueda(fechaInicio, fechaFin, 40);
		System.out.println("7. Consultar los espacios libres");
		System.out.println(espaciosLibres);

		// 8. Crear nuevos eventos
		nombre = "Presentacion del nuevo libro de Stephen King.";
		descripcion = "Se presentará el nuevo libro thriller de Stephen King.";
		String organizador = "Luca Zorzi";
		String idEvento = servicioEventos.alta(nombre, descripcion, organizador, Categoria.CULTURAL, fechaInicio, fechaFin, capacidad, idEspacio);
		System.out.println("8. Crear nuevos eventos");
		System.out.println(repositorioEventos.getById(idEvento));
		
		// 9. Modificar los datos de un evento
		descripcion += " Buffet final incluido.";
		fechaInicio = LocalDateTime.of(2024, Month.DECEMBER, 17, 12, 0);
		fechaFin = LocalDateTime.of(2024, Month.DECEMBER, 17, 19, 0);
		servicioEventos.modifica(idEvento, descripcion, fechaInicio, fechaFin, capacidad-153, idEspacio);
		System.out.println("9. Modificar los datos de un evento");
		System.out.println(repositorioEventos.getById(idEvento));
		
		// 10. Cancelar un evento
		servicioEventos.cancelar(idEvento);
		System.out.println("10. Cancelar un evento");
		repositorioEventos.getAll().forEach(System.out::println);
		
		// 11. Resumen de eventos por mes
		nombre = "Evento de test.";
		descripcion = "Esto evento es un test.";
		organizador = "Luca Zorzi";
		fechaInicio = LocalDateTime.of(2024, Month.DECEMBER, 3, 9, 0);
		fechaFin = LocalDateTime.of(2024, Month.DECEMBER, 4, 19, 0);
		idEvento = servicioEventos.alta(nombre, descripcion, organizador, Categoria.ENTRETENIMIENTO, fechaInicio, fechaFin, capacidad, idEspacio);
		System.out.println("11. Resumen de eventos por mes");
		System.out.println(repositorioEventos.getById(idEvento));
		servicioEventos.eventosDelMes(12, 2024).forEach(System.out::println);
	}

}
