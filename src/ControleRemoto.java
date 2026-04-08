import java.util.ArrayList;

public class ControleRemoto {
    private ArrayList<Televisao> televisoes;

    public ControleRemoto() {
        this.televisoes = new ArrayList<>();
    }

    public boolean adicionarTV(Televisao televisao) {
        boolean tvJaExiste = this.televisoes.stream().anyMatch(tv -> tv.equals(televisao));

        if (!tvJaExiste)
            this.televisoes.add(televisao);

        return tvJaExiste;
    }

    public void mudarCanais(String direcao) {
        this.televisoes.forEach(tv -> tv.alterarCanal(direcao));
        this.mostrarInformacoesTVs(false);
    }

    public void mudarVolumes(String direcao) {
        this.televisoes.forEach(tv -> tv.alterarVolume(direcao));
        this.mostrarInformacoesTVs(false);
    }

    public void mostrarInformacoesTVs(boolean informacoesCompletas) {

        this.televisoes.forEach(tv -> {
            System.out.println("> Televisão " + tv.getId());
            System.out.println("\tVolume atual: " + tv.getVolume());
            System.out.println("\tCanal atual: " + tv.getCanalAtual());

            if (informacoesCompletas)
                tv.mostrarGrade();
            else {
                System.out.printf("\tCanais: ");

                tv.canaisCadastrados.forEach(canal -> {
                    if (canal.equals(tv.getCanalAtual()))
                        System.out.printf("*");

                    System.out.printf("%s ", canal);
                });
            }

            System.out.println("");
        });
    }
}
