package bancoDigitalComJavaEOO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Banco bancoDIO = new Banco();
        bancoDIO.setNome("DIO Bank");


        Cliente enzo = new Cliente("Enzo", "Artropodis", 19);
        Cliente ana = new Cliente("Ana", "Artropodis", 21);

        Cliente marie = new Cliente();
        marie.setNome("Marie");
        marie.setSobrenome("Curie");
        marie.setIdade(28);

        Conta cc = new ContaCorrente(ana, bancoDIO);
        Conta cc2 = new ContaCorrente(enzo, bancoDIO);
        Conta poupanca = new ContaPoupanca(marie, bancoDIO);

        List<Conta> listaContas = new ArrayList<>(Arrays.asList(cc, cc2, poupanca));
//        System.out.println(listaContas);
        bancoDIO.setContas(listaContas);

        cc.depositar(100.50);
        cc.transferir(100, poupanca);
        cc.transferir(2000, poupanca);
        cc2.transferir(570, cc);

        cc.imprimirExtrato();
        cc2.imprimirExtrato();
        poupanca.imprimirExtrato();

        bancoDIO.imprimirListaClientes();



    }
}
