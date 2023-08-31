package site.farmasis.hardwaredetected;

import org.springframework.boot.SpringApplication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HardwaredetectedApplication {
    
     public static ArrayList<memoryRam> memorias=new ArrayList<>();
      public static ArrayList<disco> discos=new ArrayList<>();
      public static ArrayList<procesador> cpus=new ArrayList<>();
      
  

    public static void main(String[] args) {
        SpringApplication.run(HardwaredetectedApplication.class, args);
        
                
            try {
                
                Process process = Runtime.getRuntime().exec("cmd /c wmic MemoryChip get BankLabel, Capacity, MemoryType, TypeDetail, Speed, Manufacturer ");

                InputStream inputStream = process.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                
                String line;
                boolean headerSkipped = false;
                
                while ((line = reader.readLine()) != null) {
                    if (!headerSkipped ||line.length()==0 ){headerSkipped = true;continue;}                
                    String rpta[]= line.replaceAll("\\s+", " ").split(" ");              
                    memoryRam memoria=new memoryRam(rpta[0].concat(rpta[1]),
                                                Double.valueOf(rpta[2]),
                                                rpta[3],
                                                Integer.valueOf(rpta[4]),
                                                Integer.valueOf( rpta[5]),
                                                Integer.valueOf(rpta[6]) );
                    
                    memorias.add(memoria);                   
                              
                }
            reader.close();
               
          
            Process process1 = Runtime.getRuntime().exec("cmd /c wmic CPU get Name, Manufacturer, MaxClockSpeed, NumberOfCores");

            InputStream inputStream1 = process1.getInputStream();
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(inputStream1));
                
            String line1;
             boolean headerSkipped1 = false;
             
            while ((line1 = reader1.readLine()) != null) {
                if (!headerSkipped1 ||line1.length()==0 ){headerSkipped1 = true;continue;}
                
                String rpta1[]= line1.replaceAll("\\s+", " ").split(" ");
                
               procesador procesador1= new procesador(rpta1[0], rpta1[2]+" "+rpta1[3]+" "+rpta1[4]+" "+rpta1[5]+" "+rpta1[6]+" "+rpta1[7], Integer.valueOf(rpta1[8]));
              cpus.add(procesador1); 
                
            }

            reader.close();                    
        
        
       
            
            Process process2 = Runtime.getRuntime().exec("cmd /c wmic DiskDrive get Model, InterfaceType, Size");

            InputStream inputStream2 = process2.getInputStream();
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(inputStream2));

            String line2;
            boolean headerSkipped2 = false;
           
            while ((line2 = reader2.readLine()) != null) {
                if (!line2.isEmpty()) {
                    if (!headerSkipped2){headerSkipped2 = true;continue;}
                    String rpta2[]= line2.replaceAll("\\s+", " ").split(" ");
                    disco nuevoDisco=new disco(rpta2[0], rpta2[1]+" "+rpta2[2]+" "+rpta2[3]+" "+rpta2[4], Double.valueOf(rpta2[5]));
                    
                    discos.add(nuevoDisco);
                    }
            }

            reader.close();       
   
        } catch (IOException e) {
            e.printStackTrace();
        }        
        
	}
  @GetMapping(path = "/")
            public Map<String, Object> getdatos(){
                Map<String, Object> hashMap = new HashMap<String, Object>();
                hashMap.put("memorias", memorias);
                 hashMap.put("discos", discos);
                  hashMap.put("CPUS", cpus);
               
            return hashMap ;
           }
}
