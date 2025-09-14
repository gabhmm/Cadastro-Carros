import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroVeiculos {
    static Scanner scan = new Scanner(System.in);
    static List<Veiculo> veiculos = new ArrayList<>();


    public static void main(String[] args) {

        System.out.println("=== BEM VINDO AO CONTROLE DE FROTAS ===");

        String menu = """
                Escolha uma das opções abaixo:

                1 - Cadastro de Veículo
                2 - Listar Veículos
                3 - Excluir Veículo
                4 - Pesquisar
                0 - Sair
                """;
        int opcao;

        do {
            System.out.print("\033[H\033[2J");
            System.out.println(menu);
            opcao = Input.scanInt("Escolha uma opção: ", scan);
            switch (opcao) {

                case 1:
                    cadastraVeiculo();
                    System.out.println("Pressione ENTER para continuar");
                    scan.nextLine();
                    break;

                case 2:
                    listaVeiculos();
                    System.out.println("Pressione ENTER para continuar");
                    scan.nextLine();
                    break;

                case 3:
                    removeVeiculo();
                    System.out.println("Pressione ENTER para continuar");
                    scan.nextLine();
                    break;
                case 4:
                    pesquisaVeiculo();
                    System.out.println("Pressione ENTER para continuar");
                    scan.nextLine();
                case 0:
                    System.out.println("Volte sempre!!!");
                    break;
                default:
                    System.out.println("Opção inválida!!!");
                    break;
            }
        } while (opcao != 0);
    }

    static void cadastraVeiculo() {
        System.out.println("==== CADASTRANDO NOVO VEICULO ====");

        String modelo = Input.scanString("Digite o modelo: ", scan);

        String marca = Input.scanString("Digite a marca: ", scan);

        String placa =  Input.scanString("Digite a placa: ", scan);

        if (identificaPlaca(placa)) {
            System.out.println("Já existe um veículo com essa placa");
            return;
        }
        int ano = Input.scanInt("Ano: ", scan);

        Veiculo v = new Veiculo(modelo, marca, placa, ano);
        veiculos.add(v);

    }
    static void listaVeiculos() {
        System.out.println("==== LISTA DE VEICULOS ====");
        for (Veiculo v : veiculos)
            System.out.println(v);
    }

    static void removeVeiculo() {
        System.out.println("==== EXCLUIR VEICULO ====");
        String placa = Input.scanString("Digite a placa do veículo que deseja excluir: ", scan);

        for (Veiculo v : veiculos) {
            if (identificaPlaca(placa)) {
                System.out.println("Veículo removido com sucesso!");
                veiculos.remove(v);
                return;
            }
        }
        System.out.println("Placa não encontrada!");
    }


static void pesquisaVeiculo() {
    System.out.println("==== PESQUISAR VEICULO ====");
    String pesquisa = Input.scanString("Você deseja fazer a pesquisa por placa ou por modelo?\n(P) - placa | (M) - modelo\n", scan).toUpperCase();
        if (pesquisa.equals("P")) {
            String placa = Input.scanString("Digite a placa: ", scan);

            for (Veiculo v : veiculos){

                if (identificaPlaca(placa)) {
                    System.out.println(v);
                    return;
                }
            }
            System.out.println("Placa inválida!");
            return;
        }
        if (pesquisa.equals("M")) {
            String  modelo = Input.scanString("Digite o modelo: ", scan).toLowerCase();

            for (Veiculo v : veiculos){

                if (v.getModelo().toLowerCase().contains(modelo)) {
                    System.out.println(v);
                }
            }
        }
        System.out.println("Opção inválida!");
}
static Boolean identificaPlaca(String v) {
    for (Veiculo v2 : veiculos){
        if (v2.getPlaca().equals(v)) {
            return true;
        }
    }
    return false;
    }
}