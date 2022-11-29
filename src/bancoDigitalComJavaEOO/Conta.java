package bancoDigitalComJavaEOO;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private final int agencia;
    private final int numero;
    protected Cliente cliente;
    private final Banco banco;
    private double saldo;
    private double limiteEspecial = 1000;

    public Conta(Cliente cliente, Banco banco) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.banco = banco;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void imprimirContas(){
        System.out.printf("Titular: %s ", cliente.getNome());
        System.out.printf("%s%n", cliente.getSobrenome());
        System.out.printf("Agencia: %d%n", this.agencia); // String.format se tornou redundante
        System.out.printf("Número: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }

    public void imprimerInfosLimiteEspecial() {
        if (this.saldo >= 0){
            System.out.printf("(Limite Especial disponível: %.2f)%n", this.limiteEspecial);
        }
        if (this.saldo < 0 && this.saldo >= -this.limiteEspecial){
            System.out.println("Você está utilizando o Limite Especial. \n" +
                    "Seu limite disponível é de: " + (1000+saldo));
        }
        if (this.saldo < -this.limiteEspecial) {
            System.out.println("Limite Especial ultrapassado");
        }
    }

    @Override
    public String toString() {
        return  "Titular=" + cliente.getNome() + " " + cliente.getSobrenome() +
                ", banco=" + banco +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}