package com.antipatterncomposite.src;

public class MainDemonstracaoAntiPattern {
    public static void main(String[] args) {
        ComponentePCAntiPattern cpu = new ComponentePCAntiPattern("Processador Intel i5", 1200.0);
        ComponentePCAntiPattern ram = new ComponentePCAntiPattern("Memória RAM 16GB", 350.0);
        ComponentePCAntiPattern ssd = new ComponentePCAntiPattern("SSD 512GB", 400.0);

        // Anti-Pattern: PCBasicoMontagemFixa só funciona com 3 componentes fixos
        PCBasicoMontagemFixa pcGamerBasico = new PCBasicoMontagemFixa(cpu, ram, ssd);
        System.out.println("Preço do PC Básico (Montagem Fixa): R$" + pcGamerBasico.getPreco());

        // Problema 3: Não aceita novos componentes sem modificação na classe PCBasicoMontagemFixa
        ComponentePCAntiPattern gpu = new ComponentePCAntiPattern("Placa de Vídeo RTX 3060", 2500.0);
        System.out.println("Tentando adicionar placa de vídeo:");
        pcGamerBasico.adicionarPlacaDeVideo(gpu);
    }
}