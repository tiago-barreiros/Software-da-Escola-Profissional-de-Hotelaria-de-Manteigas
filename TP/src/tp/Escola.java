package tp;


public class Escola {
    
    private String Nome_escola;
    private String Morada;
    
    public Escola(String Nome_escola, String Morada) {
        this.Morada = Morada;
        this.Nome_escola = Nome_escola;
    }
    
    public String getNomeE(){
        return Nome_escola;
    }
    
    public String getMorada(){
        return Morada;
    }
    
    public void setNomeE(String Nome_escola){
        this.Nome_escola = Nome_escola;
    }
    
    public void getMorada(String Morada){
        this.Morada = Morada;
    }
    
    public String toString(){
        return ("Nome da Ecola: " + Nome_escola + "\nMorada: " + Morada);
    }
}