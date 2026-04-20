public class ContaBancaria {
    private String numero;
    private double saldo;
    private int saquesHoje;

    public ContaBancaria(String numero) {
        this.numero = numero;
        this.saldo = 50.0; // bônus inicial
        this.saquesHoje = 0;
        System.out.println("Conta criada com sucesso! Saldo inicial de R$ 50.");
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor inválido.");
        }
    }

    public void sacar(double valor) {
        if (saquesHoje >= 3) {
            System.out.println("Limite diário de 3 saques atingido!");
            return;
        }

        if (valor > 1000) {
            System.out.println("Limite máximo por saque é R$ 1000.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else if (valor <= 0) {
            System.out.println("Valor inválido.");
        } else {
            saldo -= valor;
            saquesHoje++;
            System.out.println("Saque realizado com sucesso!");
        }
    }
}
