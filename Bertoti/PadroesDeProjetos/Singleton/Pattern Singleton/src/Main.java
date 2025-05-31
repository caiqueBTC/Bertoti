public class Main {
    public static void main(String[] args) {

        ConfiguracoesSistema config = ConfiguracoesSistema.getInstancia();

        System.out.println("Modo atual: " + config.getModoAplicacao());

        ConfiguracoesSistema mesmaConfig = ConfiguracoesSistema.getInstancia();
        System.out.println("Mesmo objeto? " + (config == mesmaConfig));
    }
}
