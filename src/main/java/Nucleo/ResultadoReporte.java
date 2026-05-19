/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nucleo;

/**
 *
 * @author Octav
 */
public class ResultadoReporte {
    private NumeroComplejo voltaje;
    private NumeroComplejo corriente;
    private NumeroComplejo impedancia;
    private double PotenciaActiva;
    private double PotenciaReactiva;
    private double PotenciaTotal;
    private String nombre;
    public ResultadoReporte(String nombre, NumeroComplejo voltaje, NumeroComplejo corr, NumeroComplejo impedancia) {
        this.nombre = nombre;
        this.voltaje = voltaje;
        this.corriente = corr;
        this.impedancia = impedancia;
    }
    public String getNombre(){
        return String.format("%-16s", this.nombre);
    }
    public String getVoltaje() {
        return this.voltaje.toString();
    }
    public String getCorriente() {
        return this.corriente.toString();
    }
    public String getImpedancia() {
        return this.impedancia.toString();
    }
    public String getPotActiva(){
        return String.format("%.6f", NumeroComplejo.multiplicacion(this.voltaje, NumeroComplejo.conjugado(this.corriente)).real);
    }
    public String getPotReactiva(){
        return String.format("%.6f", NumeroComplejo.multiplicacion(this.voltaje, NumeroComplejo.conjugado(this.corriente)).imag);
    }
    public String getPotTotal(){
        return String.format("%.6f", NumeroComplejo.multiplicacion(this.voltaje, NumeroComplejo.conjugado(this.corriente)).getModulo());
    }
}
