import java.util.*;
import java.lang.*;
import java.io.*;

public class lexer {
    public static enum Type {
        GPR, FPR, KEYWORD, ERROR;
    }
    public static class Token {
        public final Type t;
        public final String s; 
        public Token(String s) {
            this.t = identifyType(s);
            this.s = s;
        }
        public static Type identifyType(String s) throws IndexOutOfBoundsException {
            //Regex
            //GPR:[R$]([0-9]|[12][0-9]|3[01])\b
            //FPR:[$]?F([0-9]|[12][0-9]|3[01])\b
            //KEYWORD:D(ADDI?U|MULTU?)\b
            //s = s.replace(",","");
            if(s.length()==0)
                return null;

            int i = 0;
            try{
            switch(s.charAt(i)) {
                case 'R':
                    i++;
                    switch(s.charAt(i)) {
                        case '0':
                            i++;
                            if(i==s.length())
                                return Type.GPR;
                            else
                                return Type.ERROR;
                        case '1':
                            i++;
                            if(i<s.length()) {
                                if(s.charAt(i)>='0' && s.charAt(i)<='9') {
                                    i++;
                                    if(i==s.length())
                                        return Type.GPR;
                                    else
                                        return Type.ERROR;
                                }
                                else
                                    return Type.ERROR;
                            }
                            else
                                return Type.GPR;
                        case '2':
                            i++;
                            if(i<s.length()) {
                                if(s.charAt(i)>='0' && s.charAt(i)<='9') {
                                    i++;
                                    if(i==s.length())
                                        return Type.GPR;
                                    else
                                        return Type.ERROR;
                                }
                                else
                                    return Type.ERROR;
                            }
                            else
                                return Type.GPR;
                        case '3':
                            i++;
                            if(i<s.length()) {
                                if(s.charAt(i)=='0' || s.charAt(i)=='1') {
                                    i++;
                                    if(i==s.length())
                                        return Type.GPR;
                                    else
                                        return Type.ERROR;
                                }
                                else
                                    return Type.ERROR;
                            }
                            else
                                return Type.GPR;
                        default:
                            if(s.charAt(i)>='4' && s.charAt(i)<='9') {
                                i++;
                                if(i==s.length())
                                    return Type.GPR;
                                else
                                    return Type.ERROR;
                            }
                            else
                                return Type.ERROR;
                    }
                case '$':
                    i++;
                    switch(s.charAt(i)) {
                        case 'F':
                            i++;
                            switch(s.charAt(i)) {
                                case '0':
                                    i++;
                                    if(i==s.length())
                                        return Type.FPR;
                                    else
                                        return Type.ERROR;
                                case '1':
                                    i++;
                                    if(i<s.length()) {
                                        if(s.charAt(i)>='0' && s.charAt(i)<='9') {
                                            i++;
                                            if(i==s.length())
                                                return Type.FPR;
                                            else
                                                return Type.ERROR;
                                        }
                                        else
                                            return Type.ERROR;
                                    }
                                    else
                                        return Type.FPR;
                                case '2':
                                    i++;
                                    if(i<s.length()) {
                                        if(s.charAt(i)>='0' && s.charAt(i)<='9') {
                                            i++;
                                            if(i==s.length())
                                                return Type.FPR;
                                            else
                                                return Type.ERROR;
                                        }
                                        else
                                            return Type.ERROR;
                                    }
                                    else
                                        return Type.FPR;
                                case '3':
                                    i++;
                                    if(i<s.length()) {
                                        if(s.charAt(i)=='0' || s.charAt(i)=='1') {
                                            i++;
                                            if(i==s.length())
                                                return Type.FPR;
                                            else
                                                return Type.ERROR;
                                        }
                                        else
                                            return Type.ERROR;
                                    }
                                    else
                                        return Type.FPR;
                                default:
                                    if(s.charAt(i)>='4' && s.charAt(i)<='9') {
                                        i++;
                                        if(i==s.length())
                                            return Type.FPR;
                                        else
                                            return Type.ERROR;
                                    }
                                    else
                                        return Type.ERROR;
                            }
                        case '0':
                            i++;
                            if(i==s.length())
                                return Type.GPR;
                            else
                                return Type.ERROR;
                        case '1':
                            i++;
                            if(i<s.length()) {
                                if(s.charAt(i)>='0' && s.charAt(i)<='9') {
                                    i++;
                                    if(i==s.length())
                                        return Type.GPR;
                                    else
                                        return Type.ERROR;
                                }
                                else
                                    return Type.ERROR;
                            }
                            else
                                return Type.GPR;
                        case '2':
                            i++;
                            if(i<s.length()) {
                                if(s.charAt(i)>='0' && s.charAt(i)<='9') {
                                    i++;
                                    if(i==s.length())
                                        return Type.GPR;
                                    else
                                        return Type.ERROR;
                                }
                                else
                                    return Type.ERROR;
                            }
                            else
                                return Type.GPR;
                        case '3':
                            i++;
                            if(i<s.length()) {
                                if(s.charAt(i)=='0' || s.charAt(i)=='1') {
                                    i++;
                                    if(i==s.length())
                                        return Type.GPR;
                                    else
                                        return Type.ERROR;
                                }
                                else
                                    return Type.ERROR;
                            }
                            else
                                return Type.GPR;
                        default:
                            if(s.charAt(i)>='4' && s.charAt(i)<='9') {
                                i++;
                                if(i==s.length())
                                    return Type.GPR;
                                else
                                    return Type.ERROR;
                            }
                            else
                                return Type.ERROR;
                    }
                case 'F':
                    i++;
                    switch(s.charAt(i)) {
                        case '0':
                            i++;
                            if(i==s.length())
                                return Type.FPR;
                            else
                                return Type.ERROR;
                        case '1':
                            i++;
                            if(i<s.length()) {
                                if(s.charAt(i)>='0' && s.charAt(i)<='9') {
                                    i++;
                                    if(i==s.length())
                                        return Type.FPR;
                                    else
                                        return Type.ERROR;
                                }
                                else
                                    return Type.ERROR;
                            }
                            else
                                return Type.FPR;
                        case '2':
                            i++;
                            if(i<s.length()) {
                                if(s.charAt(i)>='0' && s.charAt(i)<='9') {
                                    i++;
                                    if(i==s.length())
                                        return Type.FPR;
                                    else
                                        return Type.ERROR;
                                }
                                else
                                    return Type.ERROR;
                            }
                            else
                                return Type.FPR;
                        case '3':
                            i++;
                            if(i<s.length()) {
                                if(s.charAt(i)=='0' || s.charAt(i)=='1') {
                                    i++;
                                    if(i==s.length())
                                        return Type.FPR;
                                    else
                                        return Type.ERROR;
                                }
                                else
                                    return Type.ERROR;
                            }
                            else
                                return Type.FPR;
                        default:
                            if(s.charAt(i)>='4' && s.charAt(i)<='9') {
                                i++;
                                if(i==s.length())
                                    return Type.FPR;
                                else
                                    return Type.ERROR;
                            }
                            else
                                return Type.ERROR;
                    }
                case 'D':
                    i++;
                    switch(s.charAt(i)) {
                        case 'A':
                            i++;
                            switch(s.charAt(i)) {
                                case 'D':
                                    i++;
                                    switch(s.charAt(i)) {
                                        case 'D':
                                            i++;
                                            switch(s.charAt(i)) {
                                                case 'U':
                                                    i++;
                                                    if(i==s.length())
                                                        return Type.KEYWORD;
                                                    else
                                                        return Type.ERROR;
                                                case 'I':
                                                    i++;
                                                    switch(s.charAt(i)) {
                                                        case 'U':
                                                            i++;
                                                            if(i==s.length())
                                                                return Type.KEYWORD;
                                                            else
                                                                return Type.ERROR;
                                                        default:
                                                            return Type.ERROR;
                                                    }
                                                default:
                                                    return Type.ERROR;
                                            }
                                        default:
                                            return Type.ERROR;
                                    }
                                default:
                                    return Type.ERROR;
                            }
                        case 'M':
                            i++;
                            switch(s.charAt(i)) {
                                case 'U':
                                    i++;
                                    switch(s.charAt(i)) {
                                        case 'L':
                                            i++;
                                            switch(s.charAt(i)) {
                                                case 'T':
                                                    i++;
                                                    if(i==s.length())
                                                        return Type.KEYWORD;
                                                    else {
                                                        switch(s.charAt(i)) {
                                                            case 'U':
                                                                i++;
                                                                if(i==s.length())
                                                                    return Type.KEYWORD;
                                                                else
                                                                    return Type.ERROR;
                                                            default:
                                                                return Type.ERROR;
                                                        }
                                                    }
                                                default:
                                                    return Type.ERROR;
                                            }
                                        default:
                                            return Type.ERROR;
                                    }
                                default:
                                    return Type.ERROR;
                            }
                        default:
                            return Type.ERROR;
                    }
                default:
                    return Type.ERROR;
            }
            }
            catch (IndexOutOfBoundsException e){
                //e.printStackTrace();
                return Type.ERROR;
            }
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            FileWriter myWriter = new FileWriter("output.txt");            
        
            while((line = reader.readLine()) != null) {
                line = line.replace(","," ");
                String[] sarr = line.split(" ");


                //System.out.println(Arrays.toString(sarr)+sarr.length);
                for(int i=0; i<sarr.length; i++) {
                    Token t = new Token(sarr[i]);
                    if(t.t == null)
                        continue;
                    System.out.print(t.t);
                    myWriter.write((t.t).toString());
                    if(i<sarr.length-1) {
                        System.out.print(" ");
                        myWriter.write(" ");
                    }
                }
                System.out.println();
                myWriter.write("\n");
            }
            System.out.println("Successfully wrote to the file.");
            reader.close();
            myWriter.close();
        } catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
}