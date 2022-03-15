package com.example.calculadoraidadev2;
import java.util.Calendar;

public class Calendario {
    private Calendar datanasc;
    private long ano;
    private long dia;
    private long mes;
    private long hora;
    private long minuto;
    public void calcula(){
        Calendar data=Calendar.getInstance();
        long milis=data.getTimeInMillis()- getDatanasc().getTimeInMillis();
        setMinuto(milis/1000/60);
        setHora(getMinuto() /60);
        setDia(getHora() /24);
        setMes(getDia() /30);
        setAno(getMes() /12);
    }

    public Calendar getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Calendar datanasc) {
        this.datanasc = datanasc;
    }

    public long getAno() {
        return ano;
    }

    public void setAno(long ano) {
        this.ano = ano;
    }

    public long getDia() {
        return dia;
    }

    public void setDia(long dia) {
        this.dia = dia;
    }

    public long getMes() {
        return mes;
    }

    public void setMes(long mes) {
        this.mes = mes;
    }

    public long getHora() {
        return hora;
    }

    public void setHora(long hora) {
        this.hora = hora;
    }

    public long getMinuto() {
        return minuto;
    }

    public void setMinuto(long minuto) {
        this.minuto = minuto;
    }
}
