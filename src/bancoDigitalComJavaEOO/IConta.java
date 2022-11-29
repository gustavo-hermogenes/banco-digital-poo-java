package bancoDigitalComJavaEOO;

public interface IConta {
    /* -- Interface IConta que contém os métodos que devem ser implementados. --*/
    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, IConta contaDestino);

    void imprimirExtrato();

}
