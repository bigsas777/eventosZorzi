package repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Evento;
import utils.EntityManagerHelper;

public class RepositorioEventoJPA extends RepositorioJPA<Evento>{

	@Override
	public Class<Evento> getClase() {
		return Evento.class;
	}
	
	public List<Evento> getEventosDelMes(int mes, int año) throws RepositorioException {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            String jpql = "SELECT e FROM Evento e WHERE MONTH(e.ocupacion.fechaInicio) = :mes " +
                          "AND YEAR(e.ocupacion.fechaInicio) = :año";
            Query query = em.createQuery(jpql);
            query.setParameter("mes", mes);
            query.setParameter("año", año);
            return query.getResultList();
        } catch (Exception e) {
            throw new RepositorioException("Error al obtener eventos del mes", e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

}
