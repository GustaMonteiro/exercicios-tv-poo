import java.util.ArrayList;

public abstract class Televisao {
    private String id;
    private int volume;
    private Canal canalAtual;
    protected ArrayList<Canal> canaisCadastrados;
    protected ArrayList<Canal> canaisDisponiveis;

    public Televisao(String id, ArrayList<Canal> canaisDisponiveis) {
        this.id = id;
        this.canaisDisponiveis = canaisDisponiveis;
        this.volume = 5;
    }

    // --- Getters e Setters ---

    public String getId() {
        return id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Canal getCanalAtual() {
        return canalAtual;
    }

    public void setCanalAtual(Canal canalAtual) {
        this.canalAtual = canalAtual;
    }

    // --- Incrementos ---

    public void alterarVolume(String direcao) {
        if (direcao.equals("aumentar") && this.volume < 10) {
            this.volume++;
        } else if (direcao.equals("diminuir") && this.volume > 0) {
            this.volume--;
        }
    }

    public abstract void cadastrarCanais();

    public boolean verificarCanalExistente(Canal canal) {
        // Método simples para identificar.
        // No mundo ideal, deveriamos sobrescrever os métodos equals e hashCode
        // return this.canaisCadastrados.stream().anyMatch(
        // c -> c.getNumero() == canal.getNumero());

        return this.canaisCadastrados.contains(canal);
    }

    public void sintonizar(int numeroDoCanal) {
        this.canaisCadastrados.forEach(canal -> {
            if (canal.getNumero() == numeroDoCanal) {
                this.canalAtual = canal;
                return;
            }
        });
    }

    public void alterarCanal(String direcao) {
        int indexCanalAtual = this.canaisCadastrados.indexOf(this.canalAtual);

        if (indexCanalAtual == -1) {
            return;
        }

        int quantidadeCanais = this.canaisCadastrados.size();
        int indexNovoCanal = -1;

        if (direcao.equals("proximo")) {
            indexNovoCanal = (indexCanalAtual + 1) % quantidadeCanais;
        } else if (direcao.equals("anterior")) {
            indexNovoCanal = (indexCanalAtual + quantidadeCanais - 1) % quantidadeCanais;
        }

        this.canalAtual = this.canaisCadastrados.get(indexNovoCanal);
    }

    public void mostrarGrade() {
        System.out.println("\tCanais disponíveis:");
        this.canaisDisponiveis.forEach(canal -> System.out.println("\t - " + canal));

        System.out.println("\tCanais cadastrados:");
        this.canaisCadastrados.forEach(canal -> System.out.println("\t - " + canal));
    }
}
