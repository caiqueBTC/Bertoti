public class MainDemonstracaoAntiPatternObserver {
    public static void main(String[] args) {
        System.out.println("--- Iniciando Demonstração: Anti-Pattern Observer ---");
        // ... (lógica original do main do anti-pattern observer) ...
        ProdutoLojaAcoplado camiseta = new ProdutoLojaAcoplado("Camiseta Geek");
        ClienteNotificacaoAcoplado clienteJoao = new ClienteNotificacaoAcoplado("joao@example.com");
        camiseta.setClienteParaNotificacaoEmail(clienteJoao);
        camiseta.setPreco(59.90);
        camiseta.setEstoque(10);
        camiseta.setPreco(49.90);
        camiseta.setEstoque(0);
        System.out.println("--- Demonstração Anti-Pattern Observer Concluída ---");
    }
}

class ProdutoLojaAcoplado { 
    private ClienteNotificacaoAcoplado clienteEmail;
    private String nomeProduto;
    private double preco;
    private int estoque;

    public ProdutoLojaAcoplado(String nomeProduto) { this.nomeProduto = nomeProduto; }
    public void setClienteParaNotificacaoEmail(ClienteNotificacaoAcoplado cliente) { this.clienteEmail = cliente; }
    public void setPreco(double novoPreco) {
        this.preco = novoPreco;
        if (clienteEmail != null) clienteEmail.notificarAlteracaoPreco(nomeProduto, preco);
    }
    public void setEstoque(int novoEstoque) {
        this.estoque = novoEstoque;
        if (clienteEmail != null) {
            if (novoEstoque > 0) clienteEmail.notificarDisponibilidade(nomeProduto, estoque);
            else clienteEmail.notificarIndisponibilidade(nomeProduto);
        }
    }
}
class ClienteNotificacaoAcoplado { 
    private String emailCliente;
    public ClienteNotificacaoAcoplado(String email) { this.emailCliente = email; }
    public void notificarAlteracaoPreco(String nomeProduto, double novoPreco) {
        System.out.println("Email (Acoplado) para " + emailCliente + ": PREÇO! '" + nomeProduto + "' agora por R$" + String.format("%.2f", novoPreco));
    }
    public void notificarDisponibilidade(String nomeProduto, int estoque) {
        System.out.println("Email (Acoplado) para " + emailCliente + ": ESTOQUE! '" + nomeProduto + "' tem " + estoque + " unidades.");
    }
    public void notificarIndisponibilidade(String nomeProduto) {
        System.out.println("Email (Acoplado) para " + emailCliente + ": INDISPONÍVEL! '" + nomeProduto + "' fora de estoque.");
    }
}