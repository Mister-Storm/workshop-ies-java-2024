package br.com.ies.v1;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Pessoa> pessoas;

    public Agenda() {
        this.pessoas = new ArrayList<>();
    }
    public Pessoa encontraPessoaPorNome(String nome) {
        Pessoa p = new Pessoa(nome);
        for(Pessoa pessoa : pessoas) {
            if(pessoa.equals(p)) {
                return pessoa;
            }
        }
        return null;
    }
    public String encontraTelefonePorNome(String nome){
        Pessoa pessoa = this.encontraPessoaPorNome(nome);
        if(pessoa == null) {
            return null;
        }
        return pessoa.getTelefone();
    }
    public void adicionaPessoa(Pessoa pessoa) {
        if(pessoas.contains(pessoa)){
            return;
        }
        pessoas.add(pessoa);
    }
    public boolean removePessoa(Pessoa pessoa) {
        return pessoas.remove(pessoa);
    }
    public int quantidadeDePessoasNaAgenda() {
        return pessoas.size();
    }
}
