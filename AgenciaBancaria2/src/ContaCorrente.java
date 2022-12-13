
public class ContaCorrente {

    private static int quantidadeDeContas = 1;

    private int numerodaConta;
    private Cliente cliente;
    private Double saldo = 0.0;

    private String contaCorrente;

    private String contaPoupança;


    public ContaCorrente( Cliente cliente) {
        this.numerodaConta = quantidadeDeContas;
        this.cliente = cliente;
        quantidadeDeContas +=1;



    }

    public int getNumerodaConta() {

        return numerodaConta;
    }
    public void setNumerodaConta(int numerodaConta) {
        this.numerodaConta = numerodaConta;

    }
    public Cliente getCliente() {

        return cliente;
    }

    public void setCliente(Cliente cliente) {

        this.cliente = cliente;
    }
    public Double getSaldo() {

        return saldo;
    }
    public void setSaldo(Double saldo) {

        this.saldo = saldo;
    }

    public String toString(){
        return "\nNumero da conta: " + this.getNumerodaConta() +
                "\nNome: " + this.cliente.getNome() +
                "\nCPF: " + this.cliente.getCpf() +
                "\nEmail: " + this.cliente.getEmail() +
                "\nSaldo: " + Utilitarios.doubleToString(this.getSaldo()) +
                "\n";
    }
    public void depositar(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Seu depósito foi realizado com sucesso, acesse o menu na opção saldo para verificar!");
        } else {
            System.out.println("Não foi possível realizar seu depósito, verefique novamente seus dados.");
        }
    }
    public void sacar(Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso, verifique o valor no locAL indicado!");
        } else {
            System.out.println("Saldo insuficiente, verifique os valores e tente novamente!");
        }
    }
    public void transferir(ContaCorrente contaParaDeposito, Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Sua transferência realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente, verifique os valores e informações!");
        }
    }
}