import java.util.ArrayList;
import java.util.List;

public class IntermediateCodeGenerator {
    
    public static void main(String[] args) {
        String[] sourceCode = {
            "START 100",
            "READ A",
            "READ B",
            "MOVER AREG, A",
            "SUB AREG, B",
            "STOP",
            "A DS 1",
            "B DS 1",
            "END"
        };
        
        List<String> intermediateCode = new ArrayList<>();
        
        for (String line : sourceCode) {
            String[] tokens = line.split("\\s+");
            String opcode = tokens[0];
            String operand = "";
            if (tokens.length > 1) {
                operand = tokens[1];
            }
            switch (opcode) {
                case "START":
                    intermediateCode.add("AD " + opcode + ", " + operand);
                    break;
                case "READ":
                    intermediateCode.add("IS 1, " + operand);
                    break;
                case "MOVER":
                    intermediateCode.add("IS 4, " + operand + "AREG");
                    break;
                case "SUB":
                    intermediateCode.add("IS 2, " + operand + "BREG");
                    break;
                case "STOP":
                    intermediateCode.add("IS 0");
                    break;
                case "DS":
                    intermediateCode.add("DL 1, " + operand);
                    break;
                case "END":
                    intermediateCode.add("AD " + opcode);
                    break;
                default:
                    // Ignore comments and unrecognized instructions
                    break;
            }
        }
        
        // Print intermediate code
        System.out.println("Intermediate Code:");
        for (String code : intermediateCode) {
            System.out.println(code);
        }
    }
}
