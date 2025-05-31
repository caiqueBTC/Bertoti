public class SemDesconto implements EstrategiaDeDesconto {
    @Override
    public double calcularPrecoComDesconto(double precoOriginal, int quantidade) {
        return precoOriginal;
    }

    @Override
    public String getNomeEstrategia() {
        return "Sem Desconto Aplicado";
    }
}