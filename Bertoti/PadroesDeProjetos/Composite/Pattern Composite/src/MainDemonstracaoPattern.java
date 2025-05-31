public class MainDemonstracaoPattern {
    public static void main(String[] args) {
        ItemDeVenda cpu = new ComponentePCUnitario("Processador Ryzen 7", 1800.0);
        ItemDeVenda ram = new ComponentePCUnitario("Memória RAM 32GB DDR5", 700.0);
        ItemDeVenda ssd = new ComponentePCUnitario("SSD NVMe 1TB", 600.0);
        ItemDeVenda gpu = new ComponentePCUnitario("Placa de Vídeo RX 6800XT", 4500.0);
        ItemDeVenda placaMae = new ComponentePCUnitario("Placa Mãe AM5 B650", 1100.0);
        ItemDeVenda fonte = new ComponentePCUnitario("Fonte 750W Gold", 550.0);
        ItemDeVenda gabinete = new ComponentePCUnitario("Gabinete Gamer Mid-Tower", 300.0);

        KitPC kitGamer = new KitPC("PC Gamer High-End");
        kitGamer.adicionarItem(cpu);
        kitGamer.adicionarItem(placaMae);
        kitGamer.adicionarItem(ram);
        kitGamer.adicionarItem(ssd);
        kitGamer.adicionarItem(gpu);
        kitGamer.adicionarItem(fonte);
        kitGamer.adicionarItem(gabinete);

        kitGamer.listarItens();
        System.out.println("\nPreço final do " + kitGamer.getNome() + ": R$" + String.format("%.2f", kitGamer.getPreco()));

        KitPC kitUpgradeMemoriaArmazenamento = new KitPC("Kit Upgrade Essencial");
        kitUpgradeMemoriaArmazenamento.adicionarItem(new ComponentePCUnitario("Memória RAM 16GB DDR4", 300.0));
        kitUpgradeMemoriaArmazenamento.adicionarItem(new ComponentePCUnitario("SSD SATA 1TB", 450.0));

        kitUpgradeMemoriaArmazenamento.listarItens();
        System.out.println("\nPreço final do " + kitUpgradeMemoriaArmazenamento.getNome() + ": R$" + String.format("%.2f", kitUpgradeMemoriaArmazenamento.getPreco()));

        KitPC pcCompletoComUpgrade = new KitPC("PC Completo com Opção de Upgrade");
        pcCompletoComUpgrade.adicionarItem(cpu);
        pcCompletoComUpgrade.adicionarItem(kitUpgradeMemoriaArmazenamento);

        pcCompletoComUpgrade.listarItens();
        System.out.println("\nPreço final do " + pcCompletoComUpgrade.getNome() + ": R$" + String.format("%.2f", pcCompletoComUpgrade.getPreco()));
    }
}