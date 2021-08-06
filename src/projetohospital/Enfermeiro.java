package projetohospital;

import java.time.LocalDate;
public class Enfermeiro extends Funcionario {
    
    private boolean plantao;
    private int cre;//CONSELHO REGIONAL DE ENFERMAGEM

    public Enfermeiro(boolean plantao,
                      int cre,
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
        this.plantao = plantao;
        this.cre = cre;
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

    public boolean isPlantao() {
        return plantao;
    }

    public void setPlantao(boolean plantao) {
        this.plantao = plantao;
    }

    public int getCre() {
        return cre;
    }

    public void setCre(int cre) {
        this.cre = cre;
    }
        
    
}
