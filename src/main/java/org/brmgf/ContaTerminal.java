package org.brmgf;

import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Bem-vindo(a)! \nPor favor, digite seu nome:");
        String nome = getTextoValido(scanner);

        System.out.println("Digite a agência da conta:");
        String agencia = getTextoValido(scanner);

        System.out.println("Digite o número da conta:");
        int numero = getNumeroConta(scanner);

        System.out.println("Digite o saldo da conta:");
        double saldo = getSaldoConta(scanner);

        retornaMensagemCriacaoConta(nome, agencia, numero, saldo);
    }

    private static String getTextoValido(Scanner scanner) {
        String texto = "";
        while (true) {
            try {
                texto = scanner.nextLine();
                if (texto.isBlank()) {
                    throw new IllegalArgumentException();
                }

                return texto;
            } catch (IllegalArgumentException e) {
                System.out.println("É necessário digitar um valor para continuar. Por favor, digite novamente:");
            }
        }
    }

    private static int getNumeroConta(Scanner scanner) {
        int numeroConta;
        while (true) {
            try {
                numeroConta = Integer.valueOf(scanner.nextLine());
                if (numeroConta < 0) {
                    throw new IllegalArgumentException();
                }

                return numeroConta;
            } catch (NumberFormatException e) {
                System.out.println("O número da conta deve conter apenas dígitos. Por favor, digite novamente:");
            } catch (IllegalArgumentException e) {
                System.out.println("O número da conta não pode ser negativo. Por favor, digite novamente:");
            }
        }
    }

    private static double getSaldoConta(Scanner scanner) {
        while (true) {
            try {
                return Double.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Saldo da conta inválido. Por favor, digite novamente:");
            }
        }
    }

    private static void retornaMensagemCriacaoConta(String nome, String agencia, int conta, double saldo) {
        String mensagem = "Olá ".concat(nome)
                .concat(", obrigado por criar uma conta em nosso banco, sua agência é ")
                .concat(agencia)
                .concat(", conta ").concat(String.valueOf(conta))
                .concat(" e seu saldo ").concat(String.format("%.2f", saldo))
                .concat(" já está disponível para saque.");
        System.out.print(mensagem);
    }
}