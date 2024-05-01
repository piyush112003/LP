import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class MacroProcessor_3
 {
    
    public static void main(String[] args) {
        List<String> sourceCode = new ArrayList<>();
        sourceCode.add("LOAD J");
        sourceCode.add("STORE M");
        sourceCode.add("MACRO EST1");
        sourceCode.add("LOAD e");
        sourceCode.add("ADD d");
        sourceCode.add("MEND");
        sourceCode.add("MACRO EST ABC");
        sourceCode.add("EST1");
        sourceCode.add("STORE ABC");
        sourceCode.add("MEND");
        sourceCode.add("MACRO ADD7 P4,P5,P6");
        sourceCode.add("LOAD P5");
        sourceCode.add("EST 8");
        sourceCode.add("SUB4 2");
        sourceCode.add("STORE P4");
        sourceCode.add("STORE P6");
        sourceCode.add("MEND");
        sourceCode.add("EST");
        sourceCode.add("ADD7 C4, C5, C6");
        sourceCode.add("END");
        
        // HashMap<String, String> macroDefinitionTable = new HashMap<>();
        // HashMap<String, String> macroNameTable = new HashMap<>();
        
        // String currentMacroName = "";
        // String currentMacroParameters = "";
        // StringBuilder currentMacroDefinition = new StringBuilder();
        
        // for (String line : sourceCode) {
        //     if (line.startsWith("MACRO")) {
        //         String[] parts = line.split("\\s+");
        //         currentMacroName = parts[1];
        //         if (parts.length > 2) {
        //             currentMacroParameters = parts[2];
        //         }
        //         macroNameTable.put(currentMacroName,currentMacroParameters);
        //     } 
        //     else if (line.equals("MEND")) {
        //         macroDefinitionTable.put(currentMacroName, currentMacroDefinition.toString());
        //         macroNameTable.put(currentMacroName, currentMacroParameters.toString());
        //         currentMacroParameters = "";
        //         currentMacroName = "";
        //         currentMacroDefinition.setLength(0);
        //     } 
        //     else if (!currentMacroName.isEmpty()) {
        //         currentMacroDefinition.append(line).append("\n");
        //     }
        // } 
        

        HashMap<String,String> macroDefinitionTable = new HashMap<>();
        HashMap<String,String> macroNameTable =  new HashMap<>();


        String currMacroName = "";
        StringBuilder currMacroDefinition = new StringBuilder();
        String currParameters = "";

        for(String line : sourceCode){
            String tokens[] = line.split("\\s+");
            if(tokens[0].equals("MACRO")){
                currMacroName = tokens[1];
                if(tokens.length>2){
                    currParameters = tokens[2];
                }
            }
            if(tokens[0].equals("MEND")){
                macroDefinitionTable.put(currMacroName,currMacroDefinition.toString());
                macroNameTable.put(currMacroName,currParameters);
                currMacroDefinition.setLength(0);
                currMacroName = "";
                currParameters = "";
            }
            else if(currMacroName.length()>0){
                currMacroDefinition.append(line).append("\n");
            }
        }

        // Print MDT
        System.out.println("Macro Definition Table (MDT):");
        for (String macroName : macroDefinitionTable.keySet()) {
            String macroDefinition = macroDefinitionTable.get(macroName);
            System.out.println(macroName + ":");
            System.out.println(macroDefinition);
            System.out.println();
        }
        
        // Print MNT
        System.out.println("Macro Name Table (MNT):");
        for (String macroName : macroNameTable.keySet()) {
            String parameters = macroNameTable.get(macroName);
            System.out.println(macroName + ": " + parameters);
        }
    }
}
