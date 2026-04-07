import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    public static ArrayList<Canal> sortearCanais(List<Canal> canais, int quantidade) {
        List<Canal> copia = new ArrayList<>(canais);
        Collections.shuffle(copia);
        return new ArrayList<>(copia.subList(0, quantidade));
    }

    public static List<Canal> getListaDeCanais() {
        return List.of(
                new Canal(2, "TV Cultura", false),
                new Canal(4, "SBT", false),
                new Canal(5, "RedeTV!", false),
                new Canal(8, "Record", false),
                new Canal(9, "CNT", false),
                new Canal(10, "Globo", false),
                new Canal(11, "TV Brasil", false),
                new Canal(12, "Band", true),
                new Canal(21, "Rede 21", true),
                new Canal(40, "Loading", true),
                new Canal(500, "GloboNews", true),
                new Canal(530, "CNN Brasil", true),
                new Canal(560, "ESPN", true),
                new Canal(570, "SporTV", true),
                new Canal(590, "Warner Channel", true));
    }

    public static ControleRemoto fazerSetupInicial() {
        List<Canal> canais = getListaDeCanais();

        SmartTV stv1 = new SmartTV("LG 123", sortearCanais(canais, 5), 55);
        stv1.cadastrarCanais();

        SmartTV stv2 = new SmartTV("Samsung 456", sortearCanais(canais, 8), 60);
        stv2.cadastrarCanais();

        TVHD tvhd1 = new TVHD("Philco 789", sortearCanais(canais, 12), "LED");
        tvhd1.cadastrarCanais();

        TVHD tvhd2 = new TVHD("TCL 1406", sortearCanais(canais, 10), "Plasma");
        tvhd2.cadastrarCanais();

        ControleRemoto controleRemoto = new ControleRemoto();
        controleRemoto.adicionarTV(stv1);
        controleRemoto.adicionarTV(stv2);
        controleRemoto.adicionarTV(tvhd1);
        controleRemoto.adicionarTV(tvhd2);

        return controleRemoto;
    }

    public static void main(String[] args) throws Exception {
        ControleRemoto controleRemoto = fazerSetupInicial();
        controleRemoto.mostrarInformacoesTVs(true);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n");
            System.out.println("1 - Aumentar volume");
            System.out.println("2 - Diminuir volume");
            System.out.println("3 - Proximo canal");
            System.out.println("4 - Voltar canal");
            System.out.println("5 - Mostrar informações basicas");
            System.out.println("6 - Mostrar informações completas");
            System.out.println("0 - Sair");

            int op = scanner.nextInt();

            if (op == 1) {
                controleRemoto.mudarVolumes("aumentar");
            } else if (op == 2) {
                controleRemoto.mudarVolumes("diminuir");
            } else if (op == 3) {
                controleRemoto.mudarCanais("proximo");
            } else if (op == 4) {
                controleRemoto.mudarCanais("anterior");
            } else if (op == 5) {
                controleRemoto.mostrarInformacoesTVs(false);
            } else if (op == 6) {
                controleRemoto.mostrarInformacoesTVs(true);
            } else if (op == 0) {
                System.out.println("Saindo...");
                break;
            } else {

            }
        }

        scanner.close();
    }
}
