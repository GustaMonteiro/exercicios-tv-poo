package poo.exercicio.tv;

import java.util.ArrayList;

public class SmartTV extends Televisao {
    private int polegadas;

    public int getPolegadas() {
        return polegadas;
    }

    public SmartTV(String id, ArrayList<Canal> canaisDisponiveis, int polegadas) {
        super(id, canaisDisponiveis);
        this.polegadas = polegadas;
    }

    @Override
    public void cadastrarCanais() {
        this.canaisCadastrados = new ArrayList<Canal>(this.canaisDisponiveis);
        this.setCanalAtual(this.canaisCadastrados.getFirst());
    }
}
