public class ItensPorQuantidade {

    static int pao = 3600;
    static int fatiaTorta = 64;
    static int sanduiche = 20;
    static int leite = 20;
    static int cafe = 20;

    public static void saida(String item, int quantidade){
      if ("sanduiche".equals(item)){
          setSanduiche(getSanduiche()- quantidade);
      }else if ("pao".equals(item)) {
          setPao(getPao() - quantidade);
      } else if ("fatiaTorta".equals(item)) {
          setFatiaTorta(getFatiaTorta() - quantidade);
      } else if ("leite".equals(item)) {
          setLeite(getLeite() - quantidade);
      } else if ("cafe".equals(item)) {
          setCafe(getCafe() - quantidade);
      }
    }
    public static int getPao() {
        return pao;
    }

    public static void setPao(int pao) {
        ItensPorQuantidade.pao = pao;
    }

    public static int getFatiaTorta() {
        return fatiaTorta;
    }

    public static void setFatiaTorta(int fatiaTorta) {
        ItensPorQuantidade.fatiaTorta = fatiaTorta;
    }

    public static int getSanduiche() {
        return sanduiche;
    }

    public static void setSanduiche(int sanduiche) {
        ItensPorQuantidade.sanduiche = sanduiche;
    }

    public static int getLeite() {
        return leite;
    }

    public static void setLeite(int leite) {
        ItensPorQuantidade.leite = leite;
    }

    public static int getCafe() {
        return cafe;
    }

    public static void setCafe(int cafe) {
        ItensPorQuantidade.cafe = cafe;
    }
}
