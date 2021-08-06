package projetohospital;

import java.util.ArrayList;

public class RegistroHospital {
    protected ArrayList<Paciente> registroPacientes = new ArrayList();
    protected ArrayList<Medico> registroMedicos = new ArrayList();
    protected ArrayList<Fisioterapeuta> registroFisioterapeutas = new ArrayList();
    protected ArrayList<Enfermeiro> registroEnfermeiros = new ArrayList();
    protected ArrayList<Consulta> registroConsulta = new ArrayList();
    
    public void registrar (Consulta c) {
        registroConsulta.add(c);
    }
    public void registrar(Medico m){
        registroMedicos.add(m);
    }
    public void registrar(Fisioterapeuta f){
        registroFisioterapeutas.add(f);
    }
    public void registrar(Enfermeiro enf){
        registroEnfermeiros.add(enf);
    }
    public void registrar(Paciente p){
        registroPacientes.add(p);
    }
    public void desligar(Medico m){
        registroMedicos.remove(m);
    }
    public void desligar(Fisioterapeuta f){
        registroFisioterapeutas.remove(f);
    }
    public void desligar(Enfermeiro enf){
        registroEnfermeiros.remove(enf);
    }
    public boolean verificarRegistroMedicos(String cpf){
        for (int i=0; i<registroMedicos.size(); i++)
            if(registroMedicos.get(i).getCpf().equals(cpf))
                return true;
        return false;
    }
    public boolean verificarRegistroFisio(String cpf){
        for (int i=0; i<registroFisioterapeutas.size(); i++)
            if(registroFisioterapeutas.get(i).getCpf().equals(cpf))
                return true;
        return false;
    }
    public boolean verificarRegistroEnfermeiros(String cpf){
        for (int i=0; i<registroEnfermeiros.size(); i++)
            if(registroEnfermeiros.get(i).getCpf().equals(cpf))
                return true;
        return false;
    }
    public boolean verificarRegistroPacientes(String cpf){
        for (int i=0; i<registroPacientes.size(); i++)
            if(registroPacientes.get(i).getCpf().equals(cpf))
                return true;
        return false;
    }
    public void exibirConsultas(Consulta c) {
        for (int i = 0; i < registroConsulta.size(); i++)
            System.out.println(registroConsulta.get(i));
    }
    public void remover(String cpf) {
        for (int i = 0; i < registroConsulta.size(); i++)
            if(registroConsulta.get(i).getCpfPac().equals(cpf))
                 registroConsulta.remove(i);
            else
                System.out.println("\tConsulta não encontrada no registro.");
    }
}
