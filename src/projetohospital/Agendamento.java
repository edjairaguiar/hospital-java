package projetohospital;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Agendamento {
   private String especialista; //Pode ser medico ou fisioterapeuta.
   private ArrayList<String> especialidadeMedico = lerArquivo("EspecialidadesMedico.txt");
   private ArrayList<String> especialidadeFisio = lerArquivo("EspecialidadesFisio.txt");
   
   public ArrayList lerArquivo(String fileName){
       ArrayList<String> ret = new ArrayList<String>();
        // This will reference one line at a time
        String line = null;

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
   
   public void selecionarEspecialista(String especialista){
       setEspecialista(especialista);    
   }

   public void mostrarEspecialidade(){
      if(especialista.equals("Médico"))
          for(int i=0; i<especialidadeMedico.size(); i++){
              System.out.println("%d - ");
              System.out.print(especialidadeMedico.get(i));  
          }
      else if(especialista.equals("Fisioterapeuta"))
          for(int i=0; i<especialidadeFisio.size(); i++){
              System.out.println("%d - " + i);
              System.out.print(especialidadeFisio.get(i));  
          } 
      else
           System.out.println("Especialista inválido.");
   }
   public void mostrarFuncionarios(String especialidade){
       RegistroHospital bdHospital = new RegistroHospital(); 
       if(especialista.equals("Médico"))
           for(int i=0; i<bdHospital.registroMedicos.size(); i++)
               if(bdHospital.registroMedicos.get(i).getEspecialidade().equals(especialidade))
                   System.out.println(bdHospital.registroMedicos.get(i).getNome());
       if(especialista.equals("Fisioterapeuta"))
           for(int i=0; i<bdHospital.registroFisioterapeutas.size(); i++)
               if(bdHospital.registroFisioterapeutas.get(i).getEspecialidade().equals(especialidade))
                   System.out.println(bdHospital.registroFisioterapeutas.get(i).getNome());
   }
   public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }
}