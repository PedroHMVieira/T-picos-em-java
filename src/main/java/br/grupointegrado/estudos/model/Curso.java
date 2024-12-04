package br.grupointegrado.estudos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column
    private String nome;


    @Column
    private String codigo;

    @Column
    private Integer carga_horaria;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(Integer carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

}



