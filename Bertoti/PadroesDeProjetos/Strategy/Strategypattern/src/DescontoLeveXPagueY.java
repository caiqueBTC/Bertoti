public class DescontoLeveXPagueY implements EstrategiaDeDesconto {
    private int quantidadeLevar;
    private int quantidadePagar;

    public DescontoLeveXPagueY(int quantidadeLevar, int quantidadePagar) {
        if (quantidadeLevar <= 0 || quantidadePagar <= 0 || quantidadePagar >= quantidadeLevar) {
            throw new IllegalArgumentException("Quantidades para Leve X Pague Y inválidas.");
        }
        this.quantidadeLevar = quantidadeLevar;
        this.quantidadePagar = quantidadePagar;
    }

    @Override
    public double calcularPrecoComDesconto(double precoOriginalTotal, int quantidadeItens) {
        if (quantidadeItens < quantidadeLevar) {
            return precoOriginalTotal;
        }
        double precoPorItem = precoOriginalTotal / quantidadeItens;
        int numeroDePromocoesCompletas = quantidadeItens / quantidadeLevar;
        int itensForaDaPromocao = quantidadeItens % quantidadeLevar;
        double precoDosItensEmPromocao = numeroDePromocoesCompletas * (precoPorItem * quantidadePagar);
        double precoDosItensForaDaPromocao = itensForaDaPromocao * precoPorItem;
        return precoDosItensEmPromocao + precoDosItensForaDaPromocao;
    }

    @Override
    public String getNomeEstrategia() {
        return "Leve " + quantidadeLevar + " Pague " + quantidadePagar;
    }
}