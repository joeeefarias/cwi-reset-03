public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;


        /*
        Pães são vendidos por unidade e tortas são vendidas por fatias, ou seja inteiros.
         */
        if ("pao".equals(item)) {
            precoTotal = 12.75 * (Double.valueOf(qtd) * 60 / 1000);
        }

        if ("torta".equals(item)) {
            precoTotal = 96.00 * (Double.valueOf(qtd)  / 16);
        }

        if ("leite".equals(item)) {
            precoTotal = 4.48 * qtd;
        }

        if ("cafe".equals(item)) {
            precoTotal = 9.56 * qtd;
        }

        if ("sanduiche".equals(item)) {
            precoTotal = 4.5 * qtd;
        }

        return precoTotal;
    }
}
