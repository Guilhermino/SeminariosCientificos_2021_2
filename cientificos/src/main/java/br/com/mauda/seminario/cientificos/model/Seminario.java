package br.com.mauda.seminario.cientificos.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Seminario {

    private Long id;
    private String titulo;
    private String descricao;
    private boolean mesaRedonda;
    private LocalDate data;
    private final Integer qtdInscricoes;
    private final List<AreaCientifica> areasCientificas = new ArrayList<>();
    private final List<Inscricao> inscricoes = new ArrayList<>();
    private final List<Professor> professores = new ArrayList<>();

    public void adicionarAreaCientifica(AreaCientifica areaCientifica) {
        areasCientificas.add(areaCientifica);
    }

    public void adicionarProfessor(Professor professor) {
        professor.adicionarSeminario(this);
        professores.add(professor);
    }

    public boolean possuiAreaCientifica(AreaCientifica areaCientifica) {
        return areasCientificas.contains(areaCientifica);
    }

    public boolean possuiInscricao(Inscricao inscricao) {
        return inscricoes.contains(inscricao);
    }

    public boolean possuiProfessor(Professor professor) {
        return professores.contains(professor);
    }

    public Seminario(AreaCientifica areaCientifica, Professor professor, Integer qtdInscricoes) {
        this.qtdInscricoes = qtdInscricoes;
        this.areasCientificas.add(areaCientifica);
        professor.adicionarSeminario(this);
        professores.add(professor);
        createIncricoes();
    }

    private void createIncricoes() {
        for (int i = 0; i < qtdInscricoes; i++) {
            adicionarInscricao(new Inscricao(null, LocalDateTime.now(), null, null));
        }
    }

    public void adicionarInscricao(Inscricao inscricao) {
        inscricao.setSeminario(this);
        inscricoes.add(inscricao);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setMesaRedonda(boolean mesaRedonda) {
        this.mesaRedonda = mesaRedonda;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getQtdInscricoes() {
        return qtdInscricoes;
    }

    public List<AreaCientifica> getAreasCientificas() {
        return areasCientificas;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.id == null ? 0 : this.id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Seminario other = (Seminario) obj;
        if (this.id == null) {
            return other.id == null;
        } else return this.id.equals(other.id);
    }
}
