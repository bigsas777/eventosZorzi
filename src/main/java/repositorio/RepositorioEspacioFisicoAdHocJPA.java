package repositorio;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.EspacioFisico;
import utils.EntityManagerHelper;

public class RepositorioEspacioFisicoAdHocJPA extends RepositorioEspacioFisicoJPA implements RepositorioEspacioFisicoAdHoc {
	
	public List<EspacioFisico> buscarEspaciosLibres(LocalDateTime inicio, LocalDateTime fin, int capacidadMinima) throws RepositorioException {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            String queryString = "SELECT e FROM EspacioFisico e WHERE e.capacidad >= :capacidad " +
                          "AND e.id NOT IN (SELECT o.espacioFisico.id FROM Ocupacion o " +
                          "WHERE (o.fechaInicio <= :fin AND o.fechaFin >= :inicio))";
            Query query = em.createQuery(queryString);
            query.setParameter("capacidad", capacidadMinima);
            query.setParameter("inicio", inicio);
            query.setParameter("fin", fin);
            return query.getResultList();
        } catch (Exception e) {
            throw new RepositorioException("Error al buscar espacios libres", e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

}
