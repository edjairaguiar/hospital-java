package projetohospital;

//Diferente das classes que herdam de Atendimento, a classe Consulta se refere a um atendimento com horário marcado.

import java.time.LocalDate;

public class Consulta extends Agendamento{
    
    private LocalDate dataC;
    private String especialidade;
    private String nomeProf;
    private String cpfPac;
        
    public LocalDate getDataC() {
        return dataC;
    }

    public void setDataC(LocalDate dataC) {
        this.dataC = dataC;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNomeProf() {
        return nomeProf;
    }

    public void setNomeProf(String nomeProf) {
        this.nomeProf = nomeProf;
    }

    public String getCpfPac() {
        return cpfPac;
    }

    public void setCpfPac(String cpfPac) {
        this.cpfPac = cpfPac;
    }   
    
}  