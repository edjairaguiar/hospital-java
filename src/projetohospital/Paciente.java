package projetohospital;

import java.time.LocalDate;

public class Paciente extends Pessoa {
    private String atividade;
    private String convenio; //Serao definidos posteriormente os convenios;
    

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public Paciente(String atividade,
                    String convenio,
                    String nome, 
                    String bairro, 
                    String cidade,    
                    String cpf,   
                    LocalDate dataNascimento,  
                    String email,     
                    String estado, 
                    String estadoCivil,   
                    String nomeDaMae,     
                    int numero,   
                    String rg,    
                    String rua,
                    String sexo,
                    String telefone) {
        this.atividade = atividade;
        this.convenio = convenio;
        this.nome = nome;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.estado = estado;
        this.estadoCivil = estadoCivil;
        this.nomeDaMae = nomeDaMae;
        this.numero = numero;
        this.rg = rg;
        this.rua = rua;
        this.sexo = sexo;
        this.telefone = telefone;
        
    }

}
