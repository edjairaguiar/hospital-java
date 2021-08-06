package projetohospital;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AtendimentoRed extends Atendimento {
    protected ArrayList<String> nivelVermelho = lerArquivo("nivelVermelho.txt");
    
    @Override
    public ArrayList lerArquivo(String fileName){
       ArrayList<String> ret = new ArrayList();
        // This will reference one line at a time
        String line;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                ret.add(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return ret;
   }
    
    public void ProfissionalParaAtender(){
        RegistroHospital bdHospital = new RegistroHospital();
        if(tipoDeProblema.equals("Abuso sexual"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Ginecologia"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Parada cardiorespiratória"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Cardiologia"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Politraumatismo"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Cirurgião Geral"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Trauma craniano"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Neurologia"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Queimadura de terceiro grau") || tipoDeProblema.equals("Ferimento extenso"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Clínico Geral"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Trauma torácico"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Cirurgião Geral"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());  
        if(tipoDeProblema.equals("Convulsão"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Neurologia"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Obstrução de via aérea"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Endocrinologia"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Amputação"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Ortopedia"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        else
                    System.out.println("Inválido");
    }
    
    @Override
    public void atender(String profissional) {
        System.out.println("URGÊNCIA!! Atendimento imediato.");
        System.out.println("O paciente %s será atendido pelo(a) doutor(a) %s" + profissional);
    }
    
}
