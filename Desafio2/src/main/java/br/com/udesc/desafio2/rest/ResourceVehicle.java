package br.com.udesc.desafio2.rest;

import br.com.udesc.desafio2.dao.VeiculoDao;
import br.com.udesc.desafio2.model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/veiculos")
public class ResourceVehicle {

    private VeiculoDao persistencia = new VeiculoDao();

    public ResourceVehicle() {
    }

    @GET
    @Path("/carro")
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo getJson() {
        Veiculo monta = new Veiculo();
        monta.setId(1L);
        monta.setTipo("CARRO");
        monta.setMontadora("Ford");
        monta.setModelo("KA");
        monta.setMotor("2.0");
        monta.setCor("Preto");
        monta.setKm(1000);
        return monta;
    }

    @GET
    @Path("/getId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo buscaVeiculoId(@PathParam("id") int idVehicle) {
        Veiculo oVeiculo = null;
        try {
            oVeiculo = persistencia.getVeiculoById(idVehicle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oVeiculo;
    }

    @GET
    @Path("/filtros/{tipo}/{montadora}/{km}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> getFiltrado(
            @PathParam("tipo") String tipo,
            @PathParam("montadora") String montadora,
            @PathParam("km") int km) {
        List<Veiculo> pesquisa = new ArrayList<>();
        VeiculoDao procura = new VeiculoDao();
        pesquisa = procura.buscarVeiculoFiltros(tipo, montadora, km);
        return pesquisa;
    }

    @GET
    @Path("/getTipo/{tipo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> buscaVeiculoTipo(@PathParam("tipo") String tipo) {
        List<Veiculo> veiculos = null;
        try {
            veiculos = persistencia.buscarVeiculoTipo(tipo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return veiculos;
    }

    @GET
    @Path("/getMontadora/{montadora}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> buscaVeiculoMontadora(@PathParam("montadora") String montadora) {
        List<Veiculo> veiculos = null;
        try {
            veiculos = persistencia.buscarVeiculoMontadora(montadora);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return veiculos;
    }

    @GET
    @Path("/getMotor/{motor}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> buscaVeiculoMotor(@PathParam("motor") String motor) {
        List<Veiculo> veiculos = null;
        try {
            veiculos = persistencia.buscarVeiculoMotor(motor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return veiculos;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addVehicle(Veiculo oVeiculo) {
        String ret = "";
        try {
            persistencia.salvar(oVeiculo);
            ret = "Dados inseridos com sucesso!!!\n" + oVeiculo.toString();
        } catch (Exception e) {
            e.printStackTrace();
            ret = "Erro ao inserir dados!\n" + e.getMessage();
        }
        return ret;
    }

    @PUT
    @Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateVehicle(Veiculo oVeiculo) {
        try {
            persistencia.modifyVeiculoById(oVeiculo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DELETE
    @Path("/apagar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteVehicle(@PathParam("id") int idVehicle) {
        try {
            persistencia.removeVeiculoById(idVehicle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
