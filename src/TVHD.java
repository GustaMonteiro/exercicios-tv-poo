import java.util.ArrayList;
import java.util.stream.Collectors;

public class TVHD extends Televisao {
    private String modelo;

    public String getModelo() {
        return modelo;
    }

    public TVHD(String id, ArrayList<Canal> canaisDisponiveis, String modelo) {
        super(id, canaisDisponiveis);
        this.modelo = modelo;
    }

    @Override
    public void cadastrarCanais() {
        this.canaisCadastrados = new ArrayList<>(this.canaisDisponiveis
                .stream()
                .filter(canal -> canal.isHd())
                .collect(Collectors.toList()));

        this.setCanalAtual(this.canaisCadastrados.getLast());
    }

}
