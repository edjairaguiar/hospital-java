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
        if(tipoDeProblema.equals("Parada cardiorespirat√≥ria"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Cardiologia"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Politraumatismo"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Cirurgi√£o Geral"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Trauma craniano"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Neurologia"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Queimadura de terceiro grau") || tipoDeProblema.equals("Ferimento extenso"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Cl√≠nico Geral"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Trauma tor√°cico"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Cirurgi√£o Geral"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());  
        if(tipoDeProblema.equals("Convuls√£o"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Neurologia"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Obstru√ß√£o de via a√©rea"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Endocrinologia"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Amputa√ß√£o"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Ortopedia"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        else
                    System.out.println("Inv√°lido");
    }
    
    @Override
    public void atender(String profissional) {
        System.out.println("URG√äNCIA!! Atendimento imediato.");
        System.out.println("O paciente %s ser√° atendido pelo(a) doutor(a) %s" + profissional);
    }
    
}
