/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package site.farmasis.hardwaredetected;

import java.util.HashMap;

/**
 *
 * @author SOPORTEFARMASIS
 */
public class memoryRam {
    
    private final String slot;
    private final Double tamaño;
    private final String marca;
    private final Integer tipo;
    private final Integer velocidad;
    private final Integer detalleTipo;
    
    public memoryRam(String _slot,Double _tamaño,String _marca,Integer _tipo,Integer _velocidad,Integer _detalleTipo){
    slot=_slot;
    tamaño=_tamaño;
    marca=_marca;
    tipo=_tipo;
    velocidad=_velocidad;
    detalleTipo=_detalleTipo;
    }
    
    public String getSlot(){
    return slot;}
    
    public String getTamaño(){
       Double tamañoEnGigas=((tamaño/1024)/1024/1024); 
        
     return tamañoEnGigas+" GB";            
    }
    
    public String getMarca(){
    return marca;}
    
    public String getTipo(){
    String[] tipos={
"Desconocido",
"Otro",
"DRAM",
"Synchronous DRAM",
"Cache DRAM",
"EDO",
"EDRAM",
"VRAM",
"SRAM",
"RAM",
"ROM",
"Flash",
"EEPROM",
"FEPROM",
"EPROM",
"CDRAM",
"3DRAM",
"SDRAM",
"SGRAM",
"RDRAM",
"DDR",
"DDR2",
"DDR2 FB-DIMM",
"nulo",      
"DDR3",
"FBD2"
};
 return tipos[tipo];       
    }

public String getVelocidad(){
return velocidad+" Mhz";}
    
public String getDetalleTipo(){

    HashMap<Integer,String> detalleTipos=new HashMap<Integer,String>();
    detalleTipos.put(1, "Reserved");
    detalleTipos.put(2, "Other");
    detalleTipos.put(4, "Unknown");
    detalleTipos.put(8, "Fast-paged");
    detalleTipos.put(16, "Static column");
    detalleTipos.put(32, "SPseudo-static");
    detalleTipos.put(64, "Rambus");
    detalleTipos.put(128, "Synchronous");
    detalleTipos.put(256, "CMOS");
    detalleTipos.put(512, "EDO");
    detalleTipos.put(1024,"Window DRAM");
    detalleTipos.put(2048, "Cache DRAM");
    detalleTipos.put(4096, "Non-volatile");
    
    String resultado=detalleTipos.get(detalleTipo);

return resultado;
}

}