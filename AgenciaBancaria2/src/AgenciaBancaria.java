import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner input = new Scanner(System.in);
    static ArrayList<ContaCorrente> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<ContaCorrente>();
        operacoes();
    }
    public static void criarContacorrente() {
        System.out.println("\nNome: ");
        String nome = input.next();
        input.nextLine();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Cliente cliente = new Cliente(nome, cpf, email);
        ContaCorrente contacorrente = new ContaCorrente(cliente);

        contasBancarias.add(contacorrente);
        System.out.println("Sua conta foi criada com sucesso!! \n" +
                "O número de conta é: " + contacorrente);

        operacoes();
    }

    private static ContaCorrente encontrarConta(
            int numerodaConta) {
                ContaCorrente contacorrente = null;
             if (contasBancarias.size() > 0) {

            for (ContaCorrente numero : contasBancarias) {
                if (numero.getNumerodaConta() == numerodaConta) {
                   contacorrente = numero;
                }
            }
        }
        return contacorrente;
    }
    public static void depositar() {
        System.out.println("Informe o número da conta: ");
        int numeroDaConta = input.nextInt();
        ContaCorrente contacorrente = encontrarConta(numeroDaConta);

        if (contacorrente != null) {
            System.out.println("Informe o valor para depósito: ");
            Double valorDeposito = input.nextDouble();
            contacorrente.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso, confira seu saldo!");

        } else {
            System.out.println("Conta não encontrada");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Informe o número da conta: ");
        int numeroDaConta = input.nextInt();
        ContaCorrente contacorrente = encontrarConta(numeroDaConta);

        if (contacorrente != null) {
            System.out.println("Informe o valor do saque: ");
            Double valorSaque = input.nextDouble();
            contacorrente.sacar(valorSaque);
            System.out.println("Valor retirado com sucesso, retire o dinheiro no local indicado e confira seu saldo!");

        } else {
            System.out.println("Conta não encontrada, revise as informaçõe e tente novamente");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Informe a conta que fará a transferência: ");
        int numeroContaEnvia = input.nextInt();
        ContaCorrente contaEnvia = encontrarConta(numeroContaEnvia);

        if (contaEnvia != null) {
            System.out.println("Informe a conta que receberá a transferência: ");

            int numeroContaRecebe = input.nextInt();
                ContaCorrente contarecebe = encontrarConta(numeroContaRecebe);

                if (contarecebe != null) {
                   System.out.println("Valor da transferência: ");
                       Double valor = input.nextDouble();
                       contaEnvia.transferir(contarecebe, valor);

            } else {
                System.out.println("Conta para deposito não foi encontrada");
            }
        }
        operacoes();
    }
    public static void Listarconta() {
        if (contasBancarias.size() > 0) {
            for (ContaCorrente contacorrente : contasBancarias) {
                System.out.println(contacorrente);
            }
        } else {
            System.out.println("Não existem contas cadastradas");
        }
        operacoes();
    }
        public static void operacoes() {
        System.out.println("----------------------------------------");
        System.out.println("-                BANCO APK             -");
        System.out.println("-                ---------             -");
        System.out.println("-                                      -");
        System.out.println("-                                      -");
        System.out.println("-  O QUE PODEMOS FAZER POR VOCÊ HOJE?  -");
        System.out.println("-                                      -");
        System.out.println("- 1- Abra sua conta corrente;          -");
        System.out.println("- 2- Efetuar um depósito;              -");
        System.out.println("- 3- Realizar saque;                   -");
        System.out.println("- 4- Efetuar uma transferência;        -");
        System.out.println("- 5- Consultar conta corrente;         -");
        System.out.println("- 6- Sair                              -");
        System.out.println("----------------------------------------");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                criarContacorrente();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                Listarconta();
                break;
            case 6:
                System.out.println("Obrigado por usar nossa agência, volte sempre!!");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }
}
