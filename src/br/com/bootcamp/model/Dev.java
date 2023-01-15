package br.com.bootcamp.model;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author joana
 */
public class Dev {
    private int id;
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev() {}

    public Dev(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Dev other = (Dev) obj;
        return this.id == other.id;
    }

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }
    
    public void concluirBootcamp(Bootcamp bootcamp){
        if(this.conteudosConcluidos.containsAll(bootcamp.getConteudos())){
            bootcamp.getDevsInscritos().remove(this);
        } 
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());            
        } else {
            System.err.println("Você não está matriculado/a em nenhum conteúdo");
        }
    }

    public double calcularTotalXP() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXP)
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("XP: ").append(this.calcularTotalXP()).append("\n");

        sb.append("\n-- Conteúdos inscritos --").append("\n");
        if (this.conteudosInscritos.size() == 0) {
            sb.append(this.nome + " não está inscrito/a em nenhum conteúdo no momento.").append("\n");
        } else {
            for (Conteudo ci : this.conteudosInscritos) {
                sb.append(ci.getTitulo()).append("\n");
            }
        }

        sb.append("\n-- Conteúdos concluídos --").append("\n");
        if (this.conteudosConcluidos.size() == 0) {
            sb.append(this.nome + " ainda não concluiu nenhum conteúdo.").append("\n");
        } else {
            for (Conteudo cc : this.conteudosConcluidos) {
                sb.append(cc.getTitulo()).append("\n");
            }
        }
        
        return sb.toString();
    }
}