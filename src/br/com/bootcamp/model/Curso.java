package br.com.bootcamp.model;

import java.util.Objects;

/**
 *
 * @author joana
 */
public class Curso extends Conteudo {
    private String codigo;
    private int cargaHoraria;
    
    public Curso(){
        super();
    }

    public Curso(String codigo, String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao);
        this.codigo = codigo;        
        this.cargaHoraria = cargaHoraria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.codigo);
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
        final Curso other = (Curso) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código: ").append(codigo).append("\n");
        sb.append(super.toString());
        sb.append("Carga horária: ").append(cargaHoraria).append("h");        
        return sb.toString();
    }  
    
    @Override
    public double calcularXP() {
        return XP_PADRAO * cargaHoraria;
    }
}