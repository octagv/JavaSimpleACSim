/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nucleo;

/**
 *
 * @author Octav
 */
public class Cortocircuito extends Componente {
    public Cortocircuito(String nombre){
        super();
        this.nombre = nombre;
    }
    @Override
    public String reporte() {
            return "";
    }
    public void calcularConVoltaje(FuenteVoltaje v){
        
    }
    public void calcularConCorriente(FuenteCorriente i){
        
    }
    public NumeroComplejo getImpedancia(double frecuencia){
        return new NumeroComplejo(0, 0);
    }
}
