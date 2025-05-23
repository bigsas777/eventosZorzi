package repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Evento;
import utils.EntityManagerHelper;

public class RepositorioAdHocEventoJPA extends RepositorioEventoJPA implements RepositorioAdHocEvento {
	
	public List<Evento> getEventosDelMes(int mes, int año) throws RepositorioException {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            String queryString = "SELECT e FROM Evento e WHERE " +
                    "EXTRACT(MONTH FROM e.ocupacion.fechaInicio) = :mes AND " +
                    "EXTRACT(YEAR FROM e.ocupacion.fechaInicio) = :año";
            Query query = em.createQuery(queryString);
            query.setParameter("mes", mes);
            query.setParameter("año", año);
            return query.getResultList();
        } catch (Exception e) {
            throw new RepositorioException("Error al obtener eventos del mes", e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
	
	public List<Evento> getByOrganizador(String organizador) throws RepositorioException {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		
		try {
			
			String queryString = "SELECT e FROM Evento e WHERE :organizador = e.organizador";
			
			Query query = em.createQuery(queryString);
			query.setParameter("organizador", organizador);
			
			return query.getResultList();			
		} catch (Exception e) {
            throw new RepositorioException("Error al obtener eventos del mes", e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
		
	}

}
