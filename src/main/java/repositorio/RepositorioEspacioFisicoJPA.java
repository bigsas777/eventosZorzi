package repositorio;

import modelo.EspacioFisico;

public class RepositorioEspacioFisicoJPA extends RepositorioJPA<EspacioFisico> {

    @Override
    public Class<EspacioFisico> getClase() {
        return EspacioFisico.class;
    }

}