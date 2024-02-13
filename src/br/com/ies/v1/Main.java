package br.com.ies.v1;

import java.util.Scanner;

public class Main {
    private static final String TEXTO_PARA_INFORMAR_O_NOME = "Informe o nome: ";
    private static final String NOME_DIGITADO_INVALIDO = "Nome digitado inválido. Informe o nome: ";
    private static final String INFORME_O_NUMERO_DE_TELEFONE = "Informe o número de telefone: ";
    private static final String TELEFONE_DIGITADO_INVALIDO = "Telefone digitado inválido. Informe o número de telefone:";
    private static Agenda agenda;
    private static Scanner scanner;
    public static void main(String[] args) {
        agenda = new Agenda();
        scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao software Agenda IES - Workshop 2024");
        do {
            menuDeOpcoes();
        } while (true);

    }
    private static void menuDeOpcoes() {
        exibeTextoDeopcoes();
        String opcao = scanner.nextLine();
        switch (opcao.strip()) {
            case "1" -> incluirPessoa();
            case "2" -> excluirPessoa();
            case "3" -> consultarPessoa();
            case "4" -> consultarTelefone();
            case "5" -> encerrarPrograma();
            default-> opcaoInvalida();
        }
    }
    private static void exibeTextoDeopcoes() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Agenda com " + agenda.quantidadeDePessoasNaAgenda() + " pessoa(s) incluída(s)");
        System.out.println("Escolha sua opção:");
        System.out.println("1 - Incluir pessoa.");
        System.out.println("2 - Excluir pessoa.");
        System.out.println("3 - Consultar pessoa por nome.");
        System.out.println("4 - Consultar telefone por nome.");
        System.out.println("5 - sair.");
        System.out.print("Sua opção:");
    }
    private static void incluirPessoa() {
        String nome = getDadosDaPessoa(TEXTO_PARA_INFORMAR_O_NOME, NOME_DIGITADO_INVALIDO);
        String telefone = getDadosDaPessoa(INFORME_O_NUMERO_DE_TELEFONE, TELEFONE_DIGITADO_INVALIDO);
        Pessoa pessoa = new Pessoa(nome, telefone);
        agenda.adicionaPessoa(pessoa);
        System.out.println("Pessoa incluída com sucesso!");
    }

    private static void excluirPessoa() {
        String nome = getDadosDaPessoa(TEXTO_PARA_INFORMAR_O_NOME, NOME_DIGITADO_INVALIDO);
        boolean excluiu = agenda.removePessoa(new Pessoa(nome));
        if(excluiu) {
            System.out.println("Pessoa excluída com sucesso!");
        } else {
            System.err.println("Erro ao excluir pessoa. Por favor verifique os dados informados e tente novamente!");
        }
    }

    private static void consultarPessoa() {
        String nome = getDadosDaPessoa(TEXTO_PARA_INFORMAR_O_NOME, NOME_DIGITADO_INVALIDO);
        Pessoa pessoa = agenda.encontraPessoaPorNome(nome);
        if(pessoa == null) {
            System.err.println("Pessoa não encontrada!");
        } else {
            System.out.println("Dados da pessoa consultada:");
            System.out.println("Nome:" + pessoa.getNome());
            System.out.println("Telefone:" + pessoa.getTelefone());
        }
    }
    private static void consultarTelefone() {
        String nome = getDadosDaPessoa(TEXTO_PARA_INFORMAR_O_NOME, NOME_DIGITADO_INVALIDO);
        String telefone = agenda.encontraTelefonePorNome(nome);
        if(telefone == null) {
            System.err.println("Pessoa não encontrada!");
        } else {
            System.out.println("Dados da pessoa consultada:");
            System.out.println("Telefone:" + telefone);
        }
    }


    private static void opcaoInvalida() {
        System.err.println("Opção Incorreta, por favor informe uma opção válida!");
    }

    private static void encerrarPrograma() {
        System.out.println("Obrigado por utilizar o software Agenda IES - Workshop 2024");
        System.out.println("Até a próxima!!");
        scanner.close();
        System.exit(0);
    }

    private static String getDadosDaPessoa(String mensgagemDoAtributoASerIncluido, String mensagemDeErro) {
        System.out.print(mensgagemDoAtributoASerIncluido);
        String input = scanner.nextLine();
        while (input == null || input.isEmpty()) {
            System.err.print(mensagemDeErro);
            input = scanner.nextLine();
        }
        return input;
    }
}
