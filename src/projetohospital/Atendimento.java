package projetohospital;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Pronto atendimento de um hospital. Ou seja, atendimento sem horário marcado.
public abstract class Atendimento implements IAtendimento {
    protected ArrayList<String> problemaMedico = lerArquivo("problemaMedico.txt");
    protected String tipoDeProblema;
    
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
    
    public void mostrarProblemasMedicos(){
        for(int i=0; i<problemaMedico.size(); i++)
            System.out.println(problemaMedico.get(i));
    }
    public void selecionarProblema(String problema){
        setTipoDeProblema(problema);
    }   
    public String verificarNivelAtendimento(){
        AtendimentoGreen verde = new AtendimentoGreen();
        AtendimentoYllw amarelo = new AtendimentoYllw();
        AtendimentoRed vermelho = new AtendimentoRed();
        for(int i=0; i<verde.nivelVerde.size(); i++)
            if(verde.nivelVerde.get(i).equals(tipoDeProblema))
                return ("verde");
        for(int i=0; i<amarelo.nivelAmarelo.size(); i++)
            if(amarelo.nivelAmarelo.get(i).equals(tipoDeProblema))
                return ("amarelo");
        for(int i=0; i<vermelho.nivelVermelho.size(); i++)
            if(vermelho.nivelVermelho.get(i).equals(tipoDeProblema))
                return ("vermelho");
        return ("Direcionar para outro hospital.");
    }
    
    @Override
     public abstract void atender(String profissional);

    public String getTipoDeProblema() {
        return tipoDeProblema;
    }

    public void setTipoDeProblema(String tipoDeProblema) {
        this.tipoDeProblema = tipoDeProblema;
    }
     
     
}
