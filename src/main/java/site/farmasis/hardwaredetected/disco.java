/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package site.farmasis.hardwaredetected;
import java.text.DecimalFormat;
/**
 *
 * @author SOPORTEFARMASIS
 */
public class disco {
    private final String modelo;
    private final Double tamaño;
    private final String interfaceTipe;
    private static final DecimalFormat decfor = new DecimalFormat("0.00");
    
    public disco(String _interfacetipe,String _modelo,Double _tamaño){
        modelo=_modelo;
        tamaño=_tamaño;
        interfaceTipe=_interfacetipe;
    }
    
    public String getModelo(){
    return modelo;}
    
    public String getTamaño(){
    Double total=((tamaño/1024)/1024)/1024;
    
    return decfor.format(total)+" GB";
    }
    
    public String getInterfaceTipe(){
    return interfaceTipe;
    }
    
    
    
}
