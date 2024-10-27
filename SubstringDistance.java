public class SubstringDistance {
    public static void main(String[] args){

    }
    public static int strDist(String str, String sub){
        //check if str does not contain sub
        if (!str.contains(sub)) {
            return 0;
        }
        // check if str is start and end with sub then Largest Substring will be str length
        if (str.startsWith(sub) && str.endsWith(sub)){
            return str.length();

        }
    }
}
