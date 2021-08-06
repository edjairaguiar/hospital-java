package projetohospital;

import java.util.ArrayList;
import java.time.LocalDate;

public class Medico extends Funcionario {

    private String especialidade; 
    private int crm; //CRM é um número que o profissional adquire após realizar a inscrição no Conselho Regional de Medicina.
    private boolean plantao;

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public boolean isPlantao() {
        return plantao;
    }

    public void setPlantao(boolean plantao) {
        this.plantao = plantao;
    }
    
    

    public Medico(String especialidade, 
                  int crm, 
                  boolean plantao, 
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
                  String telefone){
        this.especialidade = especialidade;
        this.crm = crm;
        this.plantao = plantao;
        this.nome = nome;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
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
