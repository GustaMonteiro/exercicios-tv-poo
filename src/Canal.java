public class Canal {
    private int numero;
    private String nome;
    private boolean hd;

    public Canal(int numero, String nome, boolean hd) {
        this.numero = numero;
        this.nome = nome;
        this.hd = hd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isHd() {
        return hd;
    }

    public void setHd(boolean ehHD) {
        this.hd = ehHD;
    }

    @Override
    public String toString() {
        String nome = this.getNome();
        int numero = this.getNumero();
        String qualidade = this.isHd() ? "HD" : "SD";

        return String.format("%d: %s (%s)", numero, nome, qualidade);
    }
}
