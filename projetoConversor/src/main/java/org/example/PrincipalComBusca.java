package org.example;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.Principal;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner escolha = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Seja bem-vindo(a) ao CONVERSOR DE MOEDA!");
            System.out.println("1. Dólar -> Peso argentino");
            System.out.println("2. Peso argentino -> Dólar");
            System.out.println("3. Dólar -> Real brasileiro");
            System.out.println("4. Real brasileiro -> Dólar");
            System.out.println("5. Dólar -> Peso colombiano");
            System.out.println("6. Peso colombiano -> Dólar");
            System.out.println("7. Sair -> Sair");
            System.out.print("Escolha uma opção válida: ");
            opcao = escolha.nextInt();

            if (opcao == 7) {
                System.out.println("Saindo...");
                break;
            }

            System.out.println("Digite o valor que você deseja converter: ");
            double valor = escolha.nextDouble();

            String moedaOrigem = "";
            String moedaDestino = "";

            switch (opcao) {
                case 1:
                    moedaOrigem = "USD";
                    moedaDestino = "ARS";
                    break;
                case 2:
                    moedaOrigem = "ARS";
                    moedaDestino = "USD";
                    break;
                case 3:
                    moedaOrigem = "USD";
                    moedaDestino = "BRL";
                    break;
                case 4:
                    moedaOrigem = "BRL";
                    moedaDestino = "USD";
                    break;
                case 5:
                    moedaOrigem = "USD";
                    moedaDestino = "COP";
                    break;
                case 6:
                    moedaOrigem = "COP";
                    moedaDestino = "USD";
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    continue;
            }

            Scanner scanner = new Scanner(System.in);
            String busca = "";
            while (true) {
                System.out.println("Digite o código do País (ex: BRL, USD, ARS, BOB, CLP, COP)");
                busca = scanner.nextLine().toUpperCase();;

                System.out.println("Usuário, para sair, digite sair.");
                if (busca.equalsIgnoreCase("sair")) {
                    break;
                }

                if (busca.equals("BRL") || busca.equals("USD") || busca.equals("ARS") || busca.equals("BOB") || busca.equals("CLP") || busca.equals("COP")) {
                    try {
                        String endereco = "https://v6.exchangerate-api.com/v6/ff8a255c73ec6eea6cedc2e5/latest/" + URLEncoder.encode(busca, "UTF-8");
                        System.out.println(endereco);
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(endereco))
                                .build();
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                        String json = response.body();
                        System.out.println(json);

                        Gson gson = new Gson();
                        RespostaCambio resposta = gson.fromJson(json, RespostaCambio.class);

                        if (resposta.getError_type() == null) {
                            double taxaDeCambio = resposta.getConversion_rates().get(moedaDestino);
                            double valorConvertido = valor * taxaDeCambio;
                            System.out.printf("Valor convertido: %.2f %s\n", valorConvertido, moedaDestino);
                        } else {
                            System.out.println("Erro ao obter a taxa de câmbio: " + resposta.getError_type());
                        }
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro ao fazer a requisição: " + e.getMessage());
                    }
                } else {
                    System.out.println("Pais inválido! Tente outro por favor!");
                }
            }
        } while (true);
    }
}