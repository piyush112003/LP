// import java.util.HashMap;

// public class LiteralTableGenerator {
    
//     public static void main(String[] args) {
//         String[] sourceCode = {
//             "START 100",
//             "READ A",
//             "READ B",
//             "MOVER AREG, ='50'",
//             "MOVER BREG, ='60'",
//             "ADD AREG, BREG",
//             "LOOP MOVER CREG, A",
//             "ADD CREG, ='10'",
//             "COMP CREG, B",
//             "BC LT, LOOP",
//             "NEXT SUB AREG, ='10'",
//             "COMP AREG, B",
//             "BC GT, NEXT",
//             "STOP",
//             "A DS 1",
//             "B DS 1",
//             "END"
//         };
        
//         HashMap<String, Integer> literalTable = new HashMap<>();
//         int literalCounter = 0;

//         for (String line : sourceCode) {
//             String[] tokens = line.split("\\s+");
//             for (String token : tokens) {
//                 if (token.startsWith("='") && token.endsWith("'")) {
//                     String literal = token.substring(2, token.length() - 1);
//                     if (!literalTable.containsKey(literal)) {
//                         literalTable.put(literal, literalCounter);
//                         literalCounter++;
//                     }
//                 }
//             }
//         }
        
//         // Print literal table
//         System.out.println("Literal Table:");
//         System.out.println("Literal\tAddress");
//         for (String literal : literalTable.keySet()) {
//             System.out.println(literal + "\t" + literalTable.get(literal));
//         }
//     }
// }

import java.util.HashMap;

/**
 * LiteralTableGenerator
 */
public class LiteralTableGenerator {

    public static void main(String [] args){
        String [] sourceCode = {
            "START 100",
            "READ A",
            "READ B",
            "MOVER AREG, ='50'",
            "MOVER BREG, ='60'",
            "ADD AREG, BREG",
            "LOOP MOVER CREG, A",
            "ADD CREG, ='10'",
            "COMP CREG,B",
            "BC LT, LOOP",
            "NEXT SUB AREG, ='10'",
            "COMP AREG, B",
            "BX GT, NEXT",
            "STOP",
            "A DS 1",
            "B DS 1",
            "END"
        };

//         HashMap<String,Integer> literalTable = new HashMap<>();
//         int locationCounter=0;

//         for(String line : sourceCode){
//             if(line.split("\\s+")[0].equals("START")){
//                 locationCounter = Integer.parseInt(line.split("\\s+")[1])-1;
//             }
//             // also include dsvalue
//             else{
//                 String []tokens = line.split("\\s+");
//                 for(String token : tokens){
//                     if(token.startsWith("='") && token.endsWith("'")){
//                         String literal = token.substring(2, token.length()-1);
//                         if(!literalTable.containsKey(literal)){
//                             literalTable.put(literal,locationCounter);
//                         }
//                     }
//                 }
//             }
//             locationCounter++;
//         }

//         System.out.println("Literal\tAddress");
//         for(String literal : literalTable.keySet()){
//             System.out.print(literal+"\t");
//             System.out.println(literalTable.get(literal));


        HashMap<String,Integer> literalTable = new HashMap<>();
        int locationCounter = 0;

        for(String line : sourceCode){
            String[] tokens = line.split("\\s+");
            
            if(tokens[0].equals("START")){
                locationCounter = Integer.parseInt(tokens[1]);
            }
            else if(tokens[0].equals("DS")){
                locationCounter += Integer.parseInt(tokens[1]);
            }
            else{

                for(String token : tokens){
    
    
                    if(token.startsWith("='") && token.endsWith("'")){
                        String literal = token.substring(2,token.length()-1);
                        if(!literalTable.containsKey(literal)){
                            literalTable.put(literal,locationCounter);
                        }
                    }
                }
                locationCounter++;
            }
        }  
        
        
        System.err.println("Literal table : ");
        System.err.println("Literal\tAddress");
        for(String literal : literalTable.keySet()){
            System.err.print(literal+"\t");
            System.err.println(literalTable.get(literal));
        }

    }
}


