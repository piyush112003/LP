// import java.util.HashMap;

// public class TwoPassAssembler {
    
//     public static void main(String[] args) {
//         String[] sourceCode = {
//             "START 180",
//             "READ M",
//             "READ N",
//             "LOOP   MOVER AREG, M",
//             "       MOVER BREG, N",
//             "       COMP BREG, ='200'",
//             "       BC GT, LOOP",
//             "BACK   SUB AREG, M",
//             "       COMP AREG, ='500'",
//             "       BC  LT, BACK",
//             "STOP",
//             "M      DS  1",
//             "N      DS  1",
//             "       END"
//             // "START 100",
//             // "A",
//             // "DC 10",
//             // "MOVER AREG", 
//             // "B",
//             // "MOVEM BREG, = '1'",
//             // "ADD AREG, ='2'",
//             // "SUB BREG, ='1'",
//             // "B DC 20",
//             // "LTORG",
//             // "MOVER AREG, NUM",
//             // "MOVER CREG, LOOP",
//             // "ADD BREG, = '1'",
//             // "NUM DS 5",
//             // "LOOP DC 10",
//             // "END"
//         };
        
//         HashMap<String, Integer> symbolTable = new HashMap<>();
        
//         // First pass to generate symbol table
//         int locationCounter = -1; // Starting address
//         for (String line : sourceCode) {
//             String[] tokens = line.split("\\s+");           // single whitwspace
//             String label = tokens[0];
//             if (label.equals("END")) break; // End of program

//             if (label.equals("START")) {
//                 locationCounter = Integer.parseInt(tokens[1]) - 1; // Subtract 1 since we increment at the beginning of the loop
//             } 
//             else if (label.equals("DS")) {
//                 int dsValue = Integer.parseInt(tokens[1]);
//                 locationCounter += dsValue;
//             }
//             else  /*  if (!label.equals("DS") && !label.equals("START")) */ 
//             {
//                 locationCounter++;
//                 symbolTable.put(label, locationCounter);
//             }
//         }
        
//         // Print symbol table
//         System.out.println("Symbol Table:");
//         System.out.println("Label\tAddress");
//         for (String label : symbolTable.keySet()) {
//             System.out.println(label + "\t" + symbolTable.get(label));
//         }
//     }
// }





import java.util.HashMap;

public class TwoPassAssembler{

    public static void main(String[]args){
        String[] sourceCode = {
            "START 180",
            "     READ M",
            "     READ N",
            "LOOP MOVER AREG, M",
            "     MOVER BREG, N",
            "     COMP BREG, ='200'",
            "     BC GT, LOOP",
            "BACK SUB AREG, M",
            "     COMP AREG, ='500",
            "     BC LT, BACK",
            "     STOP",
            "M     DS 1",
            "N     DS 1",
            "       END"
        };

        HashMap<String,Integer> symboletbl = new HashMap<>();
        int locationCounter = 0;

        for(String line : sourceCode){
            String [] tokens = line.split("\\s+");
            String label = tokens[0];
            if(label.equals("START")){
                locationCounter = Integer.parseInt(tokens[1])-1;
            }
            else if(label.equals("END")) break;
            else if(label.equals("DS")){
                int dsValue = Integer.parseInt(tokens[1]);
                locationCounter += dsValue;
            }
            else if(!label.equals("START") && !label.equals("DS")){
                locationCounter++;
                symboletbl.put(label,locationCounter);
            }
        }

        System.out.println("Label\tAddress");
        for(String symboleName: symboletbl.keySet()){
            System.out.print(symboleName);
            System.out.print("\t");
            System.out.println(symboletbl.get(symboleName));
        }


    }
}

