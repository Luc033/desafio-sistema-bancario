import jdk.jshell.Snippet;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        // DECLARAÇÃO DE VARIÁVEIS E MÉTODOS
        Scanner ler = new Scanner(System.in);
        String nome = "Lucas Melo";
        String conta = "Corrente";
        double saldo = 3350.85;
        int valorMenu;
        String msgEntrada = String.format("""
                =================================
                Dados iniciais do cliente:
                
                Nome:               %s
                Tipo de conta:      %s
                Saldo inicial:      %.2f
                =================================
                """, nome, conta, saldo);
        String msgMenu = String.format("""
                    M-E-N-U
                Digite a opção desejada:

                1 - Consultar saldo
                2 - Receber valor 
                3 - Tranferir valor 
                4 - Sair
                
                """);

        // INÍCIO DO PROGRAMA
        System.out.println(msgEntrada);
        while (valorMenu >= 0 && valorMenu <= 3){
            System.out.println(msgMenu);
            valorMenu = ler.nextInt();

            switch (valorMenu){
                case 1:
                    System.out.println("O saldo atual é R$" + saldo);
                    break;
                case 2:
                    System.out.println("Digite o valor a receber:");
                    saldo += ler.nextInt();
                    System.out.println("O saldo atual é R$" + saldo);
                    break;
                case 3:
                    double valorTranferido;
                    while (true) {
                        System.out.println("Digite o valor a transferir:");
                        valorTranferido = ler.nextDouble();
                        if (saldo >= valorTranferido) {
                            saldo -= valorTranferido;
                            System.out.println("Saldo atual R$" + saldo);
                            break;
                        }else{
                            System.out.println("Saldo insuficiente. Tente novamente. \n");
                        }
                    }
                case 4:
                    valorTranferido = 5;
                    break;
                default:
                    System.out.println("Opção inválida;");
                    break;
            }
        }
        System.out.println("Sistema encerrado. Até a próxima!");
    }
}