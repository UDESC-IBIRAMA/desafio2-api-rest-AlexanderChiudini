package br.com.udesc.desafio2.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "veiculo.tipo",
            query = "select v from Veiculo v where v.tipo = :tipo")
    ,@NamedQuery(name = "veiculo.montadora",
            query = "select v from Veiculo v where v.montadora = :montadora")
    ,@NamedQuery(name = "veiculo.motor",
            query = "select v from Veiculo v where v.motor = :motor")
    ,@NamedQuery(name = "veiculo.filtros",
            query = "select v from Veiculo v where v.tipo = :tipo and v.montadora = :montadora and v.km > :km")})
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String montadora;
    private String modelo;
    private String cor;
    private int km;
    private String motor;
    private String tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Id: " + getId()
                + "\nMontadora: " + getMontadora()
                + "\nModelo: " + getModelo()
                + "\nCor: " + getCor()
                + "\nKM: " + getKm()
                + "\nMotor: " + getMotor()
                + "\nTipo: " + getTipo();
    }

}
