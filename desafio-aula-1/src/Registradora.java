
public class Registradora {

    public static final int COZINHA_FECHADA = -1;

    public static void main(String[] args) {
//        primeiroBug();
//
//        segundoBug();
//
//        terceiroBug();
//
//        quartoBug();
//
//        quintoBug();

        sextoBug();
    }

    private static double registrarItem(String item, int quantidade) {
        double precoItem = 0.0;
        if (QuantidadeMinimaItem.precisaReposicao(item)) {
            if ("pao".equals(item) || "sanduiche".equals(item) || "torta".equals(item)) {
                if (!DataProjeto.cozinhaEmFuncionamento()) {
                    System.out.println("Cozinha fechada!");
                    precoItem = COZINHA_FECHADA; // Passando flag para informar que a venda não foi ralizada.
                }else {
                    ReposicaoCozinha.reporItem(item);
                    precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
                    ItensPorQuantidade.saida(item, quantidade);
                }

            }

            if ("leite".equals(item) || "cafe".equals(item)) {
                ReposicaoFornecedor.reporItem(item);
            }
        }else {
            precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
            ItensPorQuantidade.saida(item, quantidade);
        }

        return precoItem;
    }

    private static void primeiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "sanduiche";
        int quantidade = 4;

        double precoTotal = registrarItem(item, quantidade);

        exibirResultadoVenda(precoTotal);
    }

    private static void segundoBug() {
        DataProjeto.criarDataComCozinhaEncerradaMasComDiaUtil();
        String item = "torta";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        exibirResultadoVenda(precoTotal);
    }

    private static void terceiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "cafe";
        int quantidade = 40;

        double precoTotal = registrarItem(item, quantidade);

        exibirResultadoVenda(precoTotal);
    }

    private static void quartoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        exibirResultadoVenda(precoTotal);

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        exibirResultadoVenda(precoTotal2);
    }

    private static void quintoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "pao";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        exibirResultadoVenda(precoTotal);
    }

    private static void sextoBug() {
        DataProjeto.criarDataComCozinhaEncerradaSemDiaUtil();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        exibirResultadoVenda(precoTotal);

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        exibirResultadoVenda(precoTotal2);
    }

    private static void exibirResultadoVenda(double precoTotal2) {
        if (precoTotal2 != COZINHA_FECHADA){
            System.out.println(String.format("Valor total: %.2f", precoTotal2));
        }else {
            System.out.printf("Estoque indisponível, sem reposição nesse horário");
        }


    }

}
