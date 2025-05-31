public class ItemParaVenda {
    private String nome;
    private double precoBaseUnidade;
    private int quantidade;
    private EstrategiaDeDesconto estrategiaDeDesconto;

    public ItemParaVenda(String nome, double precoBaseUnidade, int quantidade) {
        this.nome = nome;
        this.precoBaseUnidade = precoBaseUnidade;
        this.quantidade = quantidade;
        this.estrategiaDeDesconto = new SemDesconto();
    }

    public void setEstrategiaDeDesconto(EstrategiaDeDesconto estrategiaDeDesconto) {
        this.estrategiaDeDesconto = estrategiaDeDesconto;
    }

    public double getPrecoOriginalTotal() {
        return precoBaseUnidade * quantidade;
    }
    
    public double calcularPrecoFinal() {
        double precoOriginalTotal = getPrecoOriginalTotal();
        return estrategiaDeDesconto.calcularPrecoComDesconto(precoOriginalTotal, quantidade);
    }

    public void exibirDetalhesComDesconto() {
        System.out.println("Produto: " + nome + " (Qtde: " + quantidade + ")");
        System.out.println("  Preço Original Total: R$" + String.format("%.2f", getPrecoOriginalTotal()));
        System.out.println("  Estratégia de Desconto: " + estrategiaDeDesconto.getNomeEstrategia());
        System.out.println("  Preço Final com Desconto: R$" + String.format("%.2f", calcularPrecoFinal()));
    }
}