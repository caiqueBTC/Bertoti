public interface EstrategiaDeDesconto {
    double calcularPrecoComDesconto(double precoOriginal, int quantidade);
    String getNomeEstrategia();
}
