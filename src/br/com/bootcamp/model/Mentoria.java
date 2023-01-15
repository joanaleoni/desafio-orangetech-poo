package br.com.bootcamp.model;

import br.com.bootcamp.utils.DateUtils;
import java.time.LocalDate;

/**
 *
 * @author joana
 */
public class Mentoria extends Conteudo {
    private int id;
    private LocalDate data;
    
    public Mentoria(){
        super();
    }

    public Mentoria(int id, String titulo, String descricao, LocalDate data) {
        super(titulo, descricao);
        this.id = id;       
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mentoria other = (Mentoria) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {        
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append(super.toString());
        sb.append("Data: ").append(data.format(DateUtils.FORMATTER)).append("\n");
        
        return sb.toString();
    }

    @Override
    public double calcularXP() {
        return XP_PADRAO + 20;
    }
}