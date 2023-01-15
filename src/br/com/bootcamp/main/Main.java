package br.com.bootcamp.main;

import br.com.bootcamp.model.Conteudo;
import br.com.bootcamp.model.Curso;
import br.com.bootcamp.model.Mentoria;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author joana
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conteudo c1 = new Curso();
        ((Curso)c1).setCodigo("POO-001");
        ((Curso)c1).setCargaHoraria(40);   
        c1.setTitulo("Programação Orientada a Objetos I");
        c1.setDescricao("Curso de Programação Orientada a Objetos - Nível básico ao intermediário");     
        
        System.out.println("-- Curso 1 --");
        System.out.println(c1);
        
        Conteudo c2 = new Curso("JS-001", "JavaScript II", "Curso de JavaScript - Nível intermediário", 50);
        System.out.println("\n-- Curso 2 --");
        System.out.println(c2);
        
        System.out.println("\n-- Mentoria 1 --");
        Conteudo m1 = new Mentoria(1, "Mentoria LinkedIn", "Aprenda a tornar seu LinkedIn mais atrativo", LocalDate.of(2023, Month.FEBRUARY, 26));
        System.out.println(m1);
        
    }
}