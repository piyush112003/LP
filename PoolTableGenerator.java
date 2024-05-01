import java.util.*;

// public class PoolTableGenerator {
    
//     public static void main(String[] args) {
//         String[] sourceCode = {
//             "START 100",
//             "READ A",
//             "MOVER AREG, ='1'",
//             "MOVEM AREG, B",
//             "MOVER BREG, ='6'",
//             "ADD AREG, BREG",
//             "COMP AREG, A",
//             "BC GT, LAST",
//             "LTORG",
//             "NEXT SUB AREG, ='1'",
//             "MOVER CREG, B",
//             "ADD CREG, ='8'",
//             "MOVEM CREG, B",
//             "PRINT B",
//             "LAST STOP",
//             "A DS 1",
//             "B DS 1",
//             "END"
//         };
        
//         HashMap<String, Integer> poolTable = new HashMap<>();
//         int literalCounter = 0;

//         for (String line : sourceCode) {
//             String[] tokens = line.split("\\s+");
//             for (String token : tokens) {
//                 if (token.startsWith("='") && token.endsWith("'")) {
//                     String literal = token.substring(2, token.length() - 1);
//                     if (!poolTable.containsKey(literal)) {
//                         poolTable.put(literal, literalCounter);
//                         literalCounter++;
//                     }
//                 }
//             }
//         }
        
//         // Print pool table
//         System.out.println("Pool Table:");
//         System.out.println("Literal\tAddress");
//         for (String literal : poolTable.keySet()) {
//             System.out.println(literal + "\t" + poolTable.get(literal));
//         }
//     }
// }


class PoolTableGenerator{
    public static void main(String [] args){
        String[] sourceCode = {
            "START 100",
            "READ A",
            "LTORG",
            "MOVER AREG, ='1'",
            "MOVER AREG, ='2'",
            "MOVEM AREG, B",
            "MOVER BREG, ='6'",
            "ADD AREG, BREG",
            "COMP AREG, A",
            "BC GT, LAST",
            "LTORG",
            "NEXT SUB AREG, ='1'",
            "MOVER CREG, B",
            "LTORG",
            "ADD CREG, ='8'",
            "MOVEM CREG, B",
            "PRINT B",
            "LAST STOP",
            "A DS 1",
            "B DS 1",
            "END"
        };


        // ArrayList<Integer> poolTable= new ArrayList<>();
        // int count=0;
        // boolean flag=false;

        // for(String line : sourceCode){
        //     String[] tokens = line.split("\\s+");


        //     for(String token : tokens){
        //         if(token.startsWith("='") && token.endsWith("'")){
        //             if(count==0 && poolTable.isEmpty()){
        //                 poolTable.add(1);
        //             } 
                    
        //             if(flag ==true){
        //                 poolTable.add(count+1);
        //                 flag=false;
        //             }
        //             count++;
        //         }

        //         else if(token.equals("LTORG") && !poolTable.isEmpty()){
        //             System.out.println("Flag set true");
        //             flag=true;
        //         }

        //     }
        // }

        ArrayList<Integer> poolTable = new ArrayList<>();
        int count=0;
        boolean flag = false;

        for(String line : sourceCode){
            String[] tokens = line.split("\\s+");

            for(String token : tokens){
                if(token.startsWith("='") && token.endsWith("'")){ 
                    if(poolTable.isEmpty() && count==0)
                        poolTable.add(1);
                        count++;
                        if(flag && !poolTable.isEmpty()){
                            poolTable.add(count);
                            flag = false;
                        }
                }
                
                else if(token.equals("LTORG") && !poolTable.isEmpty()){
                    flag=true;
                }
            }

            

        }

        System.out.println("\nLiteral Table : ");
        // System.out.println("literal\tcount");
        for(Integer literal : poolTable){
            System.out.print(literal+"\n");
        }

    }
}