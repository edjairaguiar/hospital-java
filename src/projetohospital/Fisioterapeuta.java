package projetohospital;
import java.time.LocalDate;
import java.time.LocalDate;

public class Fisioterapeuta extends Funcionario{
    private String especialidade;

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    public Fisioterapeuta(String especialidade,
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
        
        this.especialidade = especialidade;
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
