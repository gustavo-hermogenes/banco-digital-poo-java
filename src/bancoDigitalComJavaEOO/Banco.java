package bancoDigitalComJavaEOO;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    protected void imprimirListaClientes(){
        System.out.println("=== Lista de Clientes: ===");
        for (Conta conta : contas) {
            System.out.printf("Titular: %s", conta.getCliente().getNome());
            System.out.printf(" %s;", conta.getCliente().getSobrenome());
            System.out.printf(" Idade: %s%n", conta.getCliente().getIdade());
        }
    }

    @Override
    public String toString() {
        return "'" + nome + '\'';
    }
}