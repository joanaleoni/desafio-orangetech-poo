package br.com.bootcamp.main;

import br.com.bootcamp.model.Bootcamp;
import br.com.bootcamp.model.Conteudo;
import br.com.bootcamp.model.Curso;
import br.com.bootcamp.model.Dev;
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
        
        Conteudo c2 = new Curso("JS-001", "JavaScript II", "Curso de JavaScript - Nível intermediário", 50);
        Conteudo m1 = new Mentoria(1, "Mentoria LinkedIn", "Aprenda a tornar seu LinkedIn mais atrativo", LocalDate.of(2023, Month.FEBRUARY, 26));

        Bootcamp orangeTech = new Bootcamp(1, "Orange Tech +", "O que falta para você se tornar um desenvolvedor Java e começar 2023 com uma formação completa? Inscreva-se já no Orange Tech+ Back-End e tenha mais de 80 horas para transformar sua carreira e conquistar as melhores vagas do mercado tech em 2023! Tenha acesso a módulos sobre a linguagem Java que vão desde o básico e introdução ao ambiente até códigos mais avançados e frameworks mais usados.");
        orangeTech.getConteudos().add(c1);
        orangeTech.getConteudos().add(m1);        
        
        Dev joana = new Dev(1, "Joana Leoni");
        Dev liza = new Dev(2, "Liza Lermann");
        Dev caio = new Dev(3, "Caio Rodrigues");
        
        joana.inscreverBootcamp(orangeTech);
        liza.inscreverBootcamp(orangeTech);
        caio.inscreverBootcamp(orangeTech);
        
        joana.progredir();
        caio.progredir();        
        
        System.out.println("---- XPs ----");
        System.out.println("XP de " + joana.getNome() + ": " + joana.calcularTotalXP());
        System.out.println("XP de " + liza.getNome() + ": " + liza.calcularTotalXP());
        System.out.println("XP de " + caio.getNome() + ": " + caio.calcularTotalXP());
        
        joana.progredir();
        liza.progredir();
        
        System.out.println("XP de " + joana.getNome() + ": " + joana.calcularTotalXP());
        System.out.println("XP de " + liza.getNome() + ": " + liza.calcularTotalXP());
        System.out.println("XP de " + caio.getNome() + ": " + caio.calcularTotalXP());
        
        System.out.println("\n---- DEVS ----");
        System.out.println(joana);
        System.out.println("----------------");
        System.out.println(liza);
        System.out.println("----------------");
        System.out.println(caio);
        
        joana.concluirBootcamp(orangeTech);
        
        System.out.println("\n---- BOOTCAMP ----");
        System.out.println(orangeTech);
    }
}