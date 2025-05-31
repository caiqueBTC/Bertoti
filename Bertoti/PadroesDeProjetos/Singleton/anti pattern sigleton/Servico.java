public class Servico {
    public String processar() {
        BancoDeDados bd = BancoDeDados.getInstancia();
        return "Processando: " + bd.buscarDados();
    }
}
