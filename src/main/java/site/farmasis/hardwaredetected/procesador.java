/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package site.farmasis.hardwaredetected;

/**
 *
 * @author SOPORTEFARMASIS
 */
public class procesador {
    
    private final String marca;
    private final String modelo;
    private final Integer numeroCores;
    
    
    public procesador(String _marca,String _modelo,Integer _numeroCores){
        marca=_marca;
        modelo=_modelo;
        numeroCores=_numeroCores;     
                    }
    
    public String getMarca(){
    return marca;}
    
    public String getModelo(){
    return modelo;}
    
    public Integer getCores(){
    return numeroCores;}
    
       
}
