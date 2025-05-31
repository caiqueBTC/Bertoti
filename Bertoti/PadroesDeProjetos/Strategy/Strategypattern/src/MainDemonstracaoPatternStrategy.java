public class MainDemonstracaoPatternStrategy {
    public static void main(String[] args) {
        System.out.println("--- Calculadora de Descontos ESTRATÉGICA ---");

        ItemParaVenda livro = new ItemParaVenda("O Senhor dos Anéis", 75.00, 1);
        livro.exibirDetalhesComDesconto();

        System.out.println("\n--- Aplicando 15% de desconto no Livro ---");
        livro.setEstrategiaDeDesconto(new DescontoPercentual(0.15));
        livro.exibirDetalhesComDesconto();

        ItemParaVenda camiseta = new ItemParaVenda("Camiseta Star Wars", 120.00, 1);
        System.out.println("\n--- Aplicando R$20 de desconto fixo na Camiseta ---");
        camiseta.setEstrategiaDeDesconto(new DescontoFixo(20.00));
        camiseta.exibirDetalhesComDesconto();

        ItemParaVenda canecas = new ItemParaVenda("Caneca Geek", 30.00, 5);
        System.out.println("\n--- Aplicando Leve 3 Pague 2 nas Canecas ---");
        canecas.setEstrategiaDeDesconto(new DescontoLeveXPagueY(3, 2));
        canecas.exibirDetalhesComDesconto();

        System.out.println("\n--- Aplicando Leve 5 Pague 3 nas Canecas ---");
        canecas.setEstrategiaDeDesconto(new DescontoLeveXPagueY(5, 3));
        canecas.exibirDetalhesComDesconto();
    }
}