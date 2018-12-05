package br.com.udesc.desafio2.dao;

import br.com.udesc.desafio2.model.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class VeiculoDao extends GenericDao {

    public List<Veiculo> buscarVeiculoTipo(String tipo) {
        EntityManager em = getEntityManager();
        Query buscar = em.createNamedQuery("veiculo.tipo");
        buscar.setParameter("tipo", tipo);
        return buscar.getResultList();
    }

    public List<Veiculo> buscarVeiculoMontadora(String montadora) {
        EntityManager em = getEntityManager();
        Query buscar = em.createNamedQuery("veiculo.montadora");
        buscar.setParameter("montadora", montadora);
        return buscar.getResultList();
    }

    public List<Veiculo> buscarVeiculoMotor(String motor) {
        EntityManager em = getEntityManager();
        Query buscar = em.createNamedQuery("veiculo.motor");
        buscar.setParameter("motor", motor);
        return buscar.getResultList();
    }

    public List<Veiculo> buscarVeiculoFiltros(String tipo, String montadora, int km) {
        EntityManager em = getEntityManager();
        Query buscar = em.createNamedQuery("veiculo.filtros");
        buscar.setParameter("tipo", tipo);
        buscar.setParameter("montadora", montadora);
        buscar.setParameter("km", km);
        return buscar.getResultList();
    }

    public Veiculo getVeiculoById(long id) {
        return (Veiculo) ler(Veiculo.class, id);
    }

    public void removeVeiculoById(int id) {
        Veiculo oVeiculo = getVeiculoById(id);
        remover(oVeiculo);
    }

    public void modifyVeiculoById(Veiculo oVeiculo) {
        Veiculo valida = getVeiculoById(oVeiculo.getId());
        if (valida != null) {
            atualizar(oVeiculo);
        }
    }

}
