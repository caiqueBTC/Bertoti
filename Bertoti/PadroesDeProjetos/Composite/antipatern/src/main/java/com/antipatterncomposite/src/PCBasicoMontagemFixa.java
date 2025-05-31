package com.antipatterncomposite.src;

public class PCBasicoMontagemFixa {
    private ComponentePCAntiPattern processador; 
    private ComponentePCAntiPattern memoriaRAM;  
    private ComponentePCAntiPattern armazenamentoSSD;

    public PCBasicoMontagemFixa(ComponentePCAntiPattern cpu, ComponentePCAntiPattern ram, ComponentePCAntiPattern ssd) { 
        this.processador = cpu;
        this.memoriaRAM = ram;
        this.armazenamentoSSD = ssd;
    }

    
    public void adicionarPlacaDeVideo(ComponentePCAntiPattern gpu) { 
        
        System.out.println("Placa de vídeo não pode ser adicionada dinamicamente neste PC de montagem fixa.");
    }

    public double getPreco() {
        
        return (processador.getPreco() + memoriaRAM.getPreco() + armazenamentoSSD.getPreco()) * 0.95; 
            }
}