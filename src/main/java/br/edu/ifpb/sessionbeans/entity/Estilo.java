package br.edu.ifpb.sessionbeans.entity;

public enum Estilo {
    Rock("Rock"),
    Pop("Pop"),
    Sertanejo("Sertanejo");
    
    private String nome;

    private Estilo() {
    }

    private Estilo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
