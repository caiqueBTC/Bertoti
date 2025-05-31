public class DescontoPercentual implements EstrategiaDeDesconto {
    private double percentual;

    public DescontoPercentual(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcularPrecoComDesconto(double precoOriginal, int quantidade) {
        return precoOriginal * (1.0 - percentual);
    }

    @Override
    public String getNomeEstrategia() {
        return (percentual * 100) + "% de Desconto";
    }
}