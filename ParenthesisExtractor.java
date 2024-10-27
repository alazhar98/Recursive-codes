public class ParenthesisExtractor {
    public static void main(String[] args){

    }
    public static String parenBit(String str){
        // check if str is empty return nothing
        if(str.isEmpty()){
            return "";
        }
        //check if str is start by ( and leave the others before
        if(str.charAt(0)=='('){
            // check If the last character is ) then return the substring
            if(str.charAt(str.length()-1)==')'){
                return str;
            }
            // if nit call again to the end
            return parenBit(str.substring(0,str.length()-1));

            }
        // if start not equal to ( call again until it found
        return parenBit(str.substring(1));

        }
    }
}
