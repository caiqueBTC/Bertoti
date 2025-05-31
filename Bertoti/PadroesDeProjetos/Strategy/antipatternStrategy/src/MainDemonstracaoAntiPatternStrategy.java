public class MainDemonstracaoAntiPatternStrategy {
    public static void main(String[] args) {
        CalculadoraDeDescontoProdutoLegado calculadora = new CalculadoraDeDescontoProdutoLegado();
        
        double precoProdutoA = 100.0;
        int quantidadeA = 1;

        double precoProdutoB = 50.0;
        int quantidadeB = 3;

        System.out.println("--- Calculadora de Descontos LEGADO ---");
        
        System.out.println("Produto A (R$" + precoProdutoA + ") com 10% de desconto: R$" + 
            calculadora.calcularPrecoComDesconto("PERCENTUAL_10", precoProdutoA, quantidadeA));

        System.out.println("Produto A (R$" + precoProdutoA + ") com R$5 de desconto fixo: R$" + 
            calculadora.calcularPrecoComDesconto("FIXO_5_REAIS", precoProdutoA, quantidadeA));
        
        double precoTotalProdutoB = precoProdutoB * quantidadeB;
        System.out.println("Produto B (3 unidades, total R$" + precoTotalProdutoB + ") com Leve 3 Pague 2: R$" +
            calculadora.calcularPrecoComDesconto("QUANTIDADE_LEVE_3_PAGUE_2", precoTotalProdutoB, quantidadeB));

        System.out.println("Produto A (R$" + precoProdutoA + ") sem desconto: R$" +
            calculadora.calcularPrecoComDesconto("NENHUM", precoProdutoA, quantidadeA));

        try {
            System.out.println("Tentando desconto inválido: " +
                calculadora.calcularPrecoComDesconto("DESCONTO_MALUCO", precoProdutoA, quantidadeA));
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}