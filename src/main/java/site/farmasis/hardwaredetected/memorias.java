/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package site.farmasis.hardwaredetected;

import java.util.ArrayList;

/**
 *
 * @author SOPORTEFARMASIS
 */
public class memorias {
    
    ArrayList<memoryRam> memorias=new ArrayList<>();
    
    public void addMemori(memoryRam memory){
    memorias.add(memory);
    }
    
    public ArrayList getMemorias(){
    return memorias;}
    
}
