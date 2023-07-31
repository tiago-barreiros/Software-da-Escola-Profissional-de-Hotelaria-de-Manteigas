
package tp;

import java.io.Serializable;

public class Pessoa implements Serializable 
{
    private int CC;
    private String Nome;
    private String Morada;
    private int phone;

    public Pessoa(int CC, String Nome, String Morada, int phone) 
    {
        this.CC = CC;
        this.Nome = Nome;
        this.Morada = Morada;
        this.phone = phone;
    }
    public int getCC() 
    {
        return CC;
    }

    public void setCC(int CC) 
    {
        this.CC = CC;
    }

    public String getNome() 
    {
        return Nome;
    }

    public void setNome(String Nome) 
    {
        this.Nome = Nome;
    }

    public String getMorada() {
        return Morada;
    }

    public void setMorada(String Morada) 
    {
        this.Morada = Morada;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) 
    {
        this.phone = phone;
    }
    
    public String toString() 
    {
        return "\n   Dados Pessoais: " + "\n   CC: " + CC + "\n   Nome: " + Nome + "\n   Morada: " + Morada + "\n   phone: " + phone;
    }
    public Object clone()
    {
        Pessoa copia = new Pessoa(this.CC, this.Nome, this.Morada, this.phone);
        return copia; 
    }
     public boolean equals(Object obj)
    {
       if ((obj != null) && (this.getClass() == obj.getClass()))
            {
            Pessoa e = (Pessoa) obj;
            return ( this.CC == e.CC && this.Nome.equals(e.Nome) && this.Morada.equals(e.Morada) && this.phone == e.phone);
        }
        
        return false;
    }
}
