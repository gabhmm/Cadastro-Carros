public class Veiculo {

    private  String modelo;
    private String marca;
    private String placa;
    private int ano;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Veiculo() {

    }

    public Veiculo(String modelo, String marca, String placa, int ano) {
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Modelo: " + this.modelo + " | Marca: " + this.marca + " | Placa: " + this.placa + " | ano: " + this.ano;
    }
}
