/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longeststring;

/**
 *
 * @author ROG
 */
public class LongestString {
    
    static String [] Array = new String[]{"25","33","38","42","50","2","5","8","14","16","14","20","29","47","49","14","20","27","34","38","1","4","21","24","46","6","9","13","24","41","9","13","21","29","35","2","3","13","17","21","2","10","16","42","50","16","21","27","30","32","7","32","39","40","45","16","28","32","44","48","12","34","37","38","42","18","23","37","41","42","2","10","18","34","35","4","10","27","38","40","25","27","31","35","43","8","16","42","44","47","5","7","25","37","40","1","5","27","36","42","18","20","35","38","48","12","19","37","44","45","5","10","24","31","37","7","23","30","32","36","5","9","25","29","30","4","12","25","46","48","9","18","30","39","45","6","12","22","29","33","2","19","24","26","49","4","5","39","46","48","1","16","21","32","33","4","6","9","11","44","23","25","32","35","47",};
    static String [][] occurences = new String[100][2];
    static String mot;
    static boolean écriture = true;
    static boolean écriture2 = true;
    static int motpluslong = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        for (int y = 0; y < occurences.length; y++){
            occurences [y][0] = String.valueOf("0");
        }
        
        for (int i = 0; i < Array.length; i++) {
            
            mot = Array [i];   
            écriture = false;
            écriture2 = false;
            
            for (int j = 0; j < occurences.length; j++){
                
                if(écriture == false){
                    if((occurences [j][1]) == (mot)){

                        occurences [j][0] = String.valueOf(Integer.parseInt(occurences [j][0]) + 1);
                        écriture = true;
                    }          
                }
            }
            if(écriture == false){
                for (int k = 0; k < occurences.length; k++){
                    if(écriture2 == false){
//                        System.out.println(occurences [k][0]);
                        if (occurences [k][0] == "0"){

                            occurences[k][1] = mot;
                            occurences [k][0] = String.valueOf(Integer.parseInt(occurences [k][0]) + 1);
                            écriture2 = true;
                       }
                    }    
                }  
            }        
        }
        for (int p = 0; p < occurences.length; p++){
            if(occurences [p][1] != null){
                if(motpluslong < Integer.parseInt(occurences [p][0])){
                    motpluslong = Integer.parseInt(occurences [p][0]);
                }            
            }     
        }
        for (int p = 0; p < occurences.length; p++){
            if(occurences [p][1] != null){              
                System.out.println(occurences [p][1]+ " apparaît " +occurences [p][0]+" fois dans l'Array");
            }
        }    
    }
}  

