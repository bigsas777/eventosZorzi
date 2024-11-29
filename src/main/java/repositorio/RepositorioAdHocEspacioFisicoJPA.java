package repositorio;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.EspacioFisico;
import utils.EntityManagerHelper;
import utils.Estado;

public class RepositorioAdHocEspacioFisicoJPA extends RepositorioEspacioFisicoJPA implements RepositorioAdHocEspacioFisico {
	
	public List<EspacioFisico> buscarEspaciosLibres(LocalDateTime inicio, LocalDateTime fin, int capacidadMinima) throws RepositorioException {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            String queryString = "SELECT e FROM EspacioFisico e WHERE e.capacidad >= :capacidad " +
            			  "AND e.estado = :estado " + 
                          "AND e.id NOT IN (SELECT o.espacioFisico.id FROM Ocupacion o " +
                          "WHERE (o.fechaInicio <= :fin AND o.fechaFin >= :inicio))";
            Query query = em.createQuery(queryString);
            query.setParameter("capacidad", capacidadMinima);
            query.setParameter("estado", Estado.ACTIVO);
            query.setParameter("inicio", inicio);
            query.setParameter("fin", fin);
            return query.getResultList();
        } catch (Exception e) {
            throw new RepositorioException("Error al buscar espacios libres", e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
	
	public boolean tieneOcupacionActiva(String idEspacio) throws RepositorioException {
    	EntityManager em = EntityManagerHelper.getEntityManager();
        try {
        	String queryString = "SELECT COUNT(o) FROM Ocupacion o " +
                    "WHERE o.espacioFisico.id = :idEspacio AND o.fechaFin > :fechaActual";
			Query query = em.createQuery(queryString);
			query.setParameter("idEspacio", idEspacio);
			query.setParameter("fechaActual", LocalDateTime.now());
			
			Long count = (Long) query.getSingleResult();
			return count > 0;
        } catch (Exception e) {
            throw new RepositorioException("Error al buscar espacios libres", e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

}
