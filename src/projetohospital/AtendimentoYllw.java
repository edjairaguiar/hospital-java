package projetohospital;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AtendimentoYllw extends Atendimento{
    protected ArrayList<String> nivelAmarelo = lerArquivo("nivelAmarelo.txt");
    
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
        if(tipoDeProblema.equals("Mordedura") || tipoDeProblema.equals("Avaliação de exames") || tipoDeProblema.equals("Ferimento controlável") || tipoDeProblema.equals("Crise asmática") || tipoDeProblema.equals("Hemorragia digestiva"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Clínico Geral"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Cólica renal"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Nefrologia"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Idoso"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Geriatria"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Gestante com complicação"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Obstetrícia"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        if(tipoDeProblema.equals("Hemorragia digestiva"))
            for(int i=0; i<bdHospital.registroMedicos.size(); i++)
                if(bdHospital.registroMedicos.get(i).getEspecialidade().equals("Obstetrícia"))
                    System.out.println(bdHospital.registroMedicos.get(i).getNome());
        else
                    System.out.println("Inválido");
    }
    
    @Override
    public void atender(String profissional) {
        System.out.println("Espera para atendimento de até 1 hora.");
        System.out.println("O paciente %s será atendido pelo doutor %s" + profissional);
    }
    
}
