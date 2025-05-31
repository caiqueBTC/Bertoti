public class DescontoFixo implements EstrategiaDeDesconto {
    private double valorFixoDesconto;

    public DescontoFixo(double valorFixoDesconto) {
        this.valorFixoDesconto = valorFixoDesconto;
    }

    @Override
    public double calcularPrecoComDesconto(double precoOriginal, int quantidade) {
        return Math.max(0, precoOriginal - valorFixoDesconto);
    }

    @Override
    public String getNomeEstrategia() {
        return "Desconto Fixo de R$" + String.format("%.2f", valorFixoDesconto);
    }
}