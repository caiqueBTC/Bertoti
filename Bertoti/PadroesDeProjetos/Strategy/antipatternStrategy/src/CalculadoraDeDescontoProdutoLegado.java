public class CalculadoraDeDescontoProdutoLegado {

    public double calcularPrecoComDesconto(String tipoDesconto, double precoOriginal, int quantidade) {
        if ("PERCENTUAL_10".equals(tipoDesconto)) {
            return precoOriginal * 0.90;
        } else if ("FIXO_5_REAIS".equals(tipoDesconto)) {
            return Math.max(0, precoOriginal - 5.0);
        } else if ("QUANTIDADE_LEVE_3_PAGUE_2".equals(tipoDesconto)) {
            if (quantidade >= 3) {
                double precoUnidade = precoOriginal / quantidade;
                return precoUnidade * (quantidade - (quantidade / 3));
            }
            return precoOriginal;
        } else if ("NENHUM".equals(tipoDesconto)) {
            return precoOriginal;
        }
        throw new IllegalArgumentException("Tipo de desconto inválido: " + tipoDesconto);
    }
}