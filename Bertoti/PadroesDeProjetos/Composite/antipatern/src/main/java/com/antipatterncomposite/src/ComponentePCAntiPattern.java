package com.antipatterncomposite.src;


public class ComponentePCAntiPattern {
    private String nome;
    private double preco;

    public ComponentePCAntiPattern(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}