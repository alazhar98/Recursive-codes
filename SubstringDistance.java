public class SubstringDistance {
    public static void main(String[] args){
        System.out.println(strDist("catcowcat", "cat"));
        System.out.println(strDist("catcowcat", "cow"));
        System.out.println(strDist("cccatcowcatxx", "cat"));
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
        // if str is start with sum but not end
        if (str.startsWith(sub)){
            return strDist(str.substring(0,str.length()-1),sub);
        }
        // if str is end with sub but not start
        if (str.endsWith(sub)){
            return strDist(str.substring(1), sub);
        }
        // if not start and not end with sub
        return strDist(str.substring(1, str.length() - 1), sub);
    }
}
