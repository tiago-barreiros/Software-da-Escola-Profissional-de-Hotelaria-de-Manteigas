package tp;

import java.io.Serializable;
import java.time.LocalDate;


public class Dia implements Serializable{

    private LocalDate Dia;
    private int HoraInicio;
    private int HoraFim;

    Dia() {

        Dia = LocalDate.of(2021, 1, 1);
        HoraInicio = 0;
        HoraFim = 0;

    }

    Dia(LocalDate Dia, int HoraInicio, int HoraFim) {

        this.Dia = Dia;
        this.HoraInicio = HoraInicio;
        this.HoraFim = HoraFim;

    }

    //getters
    public LocalDate getDia() {
        return Dia;
    }

    public int getHoraInicio() {
        return HoraInicio;
    }

    public int getHoraFim() {
        return HoraFim;
    }

    //setters
    public void setDia(LocalDate dia) {
        this.Dia = dia;
    }

    public void setHoraInicio(int horas) {
        this.HoraInicio = horas;
    }

    public void setHoraFim(int horas) {
        this.HoraFim = horas;
    }

    @Override
    public String toString() {
        return "Dia=" + Dia + ", HoraInicio=" + HoraInicio + ", HoraFim=" + HoraFim;
    }

}
