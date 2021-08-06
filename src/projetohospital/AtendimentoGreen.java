package projetohospital;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AtendimentoGreen extends Atendimento{
    protected ArrayList<String> nivelVerde = lerArquivo("nivelVerde.txt");
    
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
        if(tipoDeProblema.equals("Procedimentos de enfermagem"))
            for(int i=0; i<bdHospital.registroEnfermeiros.size(); i++)
                System.out.println(bdHospital.registroEnfermeiros.get(i).getNome());
        if(tipoDeProblema.equals("Consulta de rotina") || tipoDeProblema.equals("Avaliação de exames") || tipoDeProblema.equals("Gripe") || tipoDeProblema.equals("Dor abdominal sem riscos vitais") || tipoDeProblema.equals("Outros"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Clínico Geral"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Dor de ouvido"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Otorrinolaringologia"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        else
                    System.out.println("Inválido");
    }
        
    @Override
    public void atender(String profissional) {
        System.out.println("Atendimento por ordem de chegada.");
        System.out.println("O %s será atendido por %s" + profissional);
    }  
    
}
