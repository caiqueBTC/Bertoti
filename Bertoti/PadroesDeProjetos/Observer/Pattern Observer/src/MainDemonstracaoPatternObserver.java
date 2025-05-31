public class MainDemonstracaoPatternObserver {
    public static void main(String[] args) {
        ProdutoLoja canecaStarWars = new ProdutoLoja("Caneca Star Wars Ed. Limitada", 79.90, 5);

        ClienteInteressado ana = new ClienteInteressado("Ana", canecaStarWars);
        ClienteInteressado carlos = new ClienteInteressado("Carlos", canecaStarWars);

        System.out.println("--- Mudança de Preço ---");
        canecaStarWars.setPreco(69.90);

        System.out.println("\n--- Mudança de Estoque ---");
        canecaStarWars.setEstoque(15);

        ClienteInteressado bruno = new ClienteInteressado("Bruno", canecaStarWars);

        System.out.println("\n--- Carlos não quer mais notificações ---");
        carlos.pararDeReceberNotificacoes();

        System.out.println("\n--- Produto Esgotado ---");
        canecaStarWars.setEstoque(0);
        
        System.out.println("\n--- Produto de volta ao estoque ---");
        canecaStarWars.setEstoque(3);
    }
}