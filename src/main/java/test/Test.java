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
		
		
		// 1. Dar de alta un espacio fisico
		String idEspacio = servicioEspacios.alta(nombre, propietario, capacidad, direccion, latitud, longitud, descripcion);
		System.out.println(repositorioEspacios.getById(idEspacio));
		
		// 2. Buscar puntos de interés dadas unas coordenadas
		List<PuntoDeInteres> puntosDeInteres = servicioPuntos.getPuntosDeInteres(latitud, longitud);
		puntosDeInteres.forEach(System.out::println);
		
		// 3. Asociar puntos de interes a un espacio
		servicioEspacios.addPuntosDeInteres(idEspacio, puntosDeInteres);
		
		// 4. Modificar los detalles de un espacio
		nombre += " Cordenons";
		capacidad = 700;
		descripcion += " Cordenons es mi ciudad en Italia.";
		servicioEspacios.modifica(idEspacio, nombre, capacidad, descripcion);
		System.out.println(repositorioEspacios.getById(idEspacio));
		
		// 5. Dar de baja un espacio
		servicioEspacios.darDeBaja(idEspacio);
		System.out.println(repositorioEspacios.getById(idEspacio));
		
		// 6. Reactivar un espacio
		servicioEspacios.activar(idEspacio);
		System.out.println(repositorioEspacios.getById(idEspacio));

		// 7. Consultar los espacios libres
		List<EspacioFisico> espaciosLibres = servicioEspacios.busqueda(fechaInicio, fechaFin, 40);
		System.out.println(espaciosLibres);

		// 8. Crear nuevos eventos
		nombre = "Presentacion del nuevo libro de Stephen King.";
		descripcion = "Se presentará el nuevo libro thriller de Stephen King.";
		String organizador = "Luca Zorzi";
		String idEvento = servicioEventos.alta(nombre, descripcion, organizador, Categoria.CULTURAL, fechaInicio, fechaFin, capacidad, idEspacio);
		System.out.println(repositorioEventos.getById(idEvento));
		
		// 9. Modificar los datos de un evento
		descripcion += " Buffet final incluido.";
		fechaInicio = LocalDateTime.of(2024, Month.DECEMBER, 17, 12, 0);
		fechaFin = LocalDateTime.of(2024, Month.DECEMBER, 17, 19, 0);
		servicioEventos.modifica(idEvento, descripcion, fechaInicio, fechaFin, capacidad-153, idEspacio);
		System.out.println(repositorioEventos.getById(idEvento));
		
		// 10. Cancelar un evento
		servicioEventos.cancelar(idEvento);
		repositorioEventos.getAll().forEach(System.out::println);
		
		// 11. Resumen de eventos por mes
		nombre = "Evento de test.";
		descripcion = "Esto evento es un test.";
		organizador = "Luca Zorzi";
		fechaInicio = LocalDateTime.of(2024, Month.DECEMBER, 3, 9, 0);
		fechaFin = LocalDateTime.of(2024, Month.DECEMBER, 4, 19, 0);
		idEvento = servicioEventos.alta(nombre, descripcion, organizador, Categoria.ENTRETENIMIENTO, fechaInicio, fechaFin, capacidad, idEspacio);
		// System.out.println(repositorioEventos.getById(idEvento));
		servicioEventos.eventosDelMes(12, 2024).forEach(System.out::println);
	}

}
