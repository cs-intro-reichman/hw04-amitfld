public class StringOps {

    /*allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)   */
    public static void main(String[] args) {
        //String s = "Hello World";
        //System.out.println(s);
        //System.out.println(firstInWordUpper(s));
        //String newaa = firstInWordUpper(s);
        //System.out.println(firstLower(newaa));
        //newaa = firstLower(newaa);
        //System.out.println(removeSpaces(newaa));
/*        int[] d = allIndexOf(s, 'l');
        String str = "{";
        for (int i = 0; i < d.length; i++){
            str += d[i];
            str += ", ";
        }
        str += "}";
        System.out.println(str);*/
    }

    public static String capVowelsLowRest (String string) {
        String newStr = "";
        char[] lowerVowels = {'a', 'e', 'i', 'o', 'u'};
        char c;
        int asciiRep;
        for (int i = 0; i< string.length(); i++){
            c = string.charAt(i);
            if (c > 65 && c <= 90 && c != 69 && c != 73 && c != 79 && c != 85){
                asciiRep = c;
                c = (char) (asciiRep + 32);
            } else {
                for (char currC : lowerVowels){
                    if (currC == c){
                        asciiRep = c;
                        c = (char) (asciiRep - 32);
                    }
                }
            }
            newStr += c;
        }
        return newStr;
    }

    public static String camelCase (String string) {
        String newStr = firstInWordUpper(string);
        newStr = firstLower(newStr);
        newStr = removeSpaces(newStr);
        return newStr;
    }

    public static String firstLower (String string) {
        String newStr = "";
        char c;
        int subIndex = 0;

        c = string.charAt(0);
        while (c == ' '){
            newStr += ' ';
            subIndex ++;
            c = string.charAt(subIndex);
        }
        newStr += (char) (c + 32);
        subIndex ++;
        newStr += string.substring(subIndex);


        /*for (int i = 0; i< string.length(); i++){
            c = string.charAt(i);

            if (c == ' '){
                newStr += ' ';
            }else{
                c = (char) (c + 32);
                newStr += c;
                subIndex = i + 1;
                break;
            }
        }*/
/*        if (subIndex != 0) {
            newStr += string.substring(subIndex);
        }*/
        return newStr;
    }

    public static String firstInWordUpper (String string) {
        char currC, prevC, cToAdd;
        String newStr = "";
        int index = 0;
        currC = string.charAt(0);
        while (currC == ' '){
            newStr += ' ';
            index ++;
            currC = string.charAt(index);
        }
        //"Hello World"
        for (int i = index; i< string.length(); i++){
            currC = string.charAt(i);
            cToAdd = currC;//H
            if (i == 0){
                if (currC >= 97 && currC <= 122) {
                    cToAdd = (char) (currC - 32);
                }
            }else {
                prevC = string.charAt(i - 1);
                if (currC == ' '){
                    cToAdd = ' ';
                }else {
                    if (prevC == ' ' && (currC >= 97 && currC <= 122)){
                        cToAdd = (char) (currC - 32);
                    }else {
                        if (prevC != ' ' && (currC >= 65 && currC <= 90)){
                            cToAdd = (char) (currC + 32);
                        }
                    }
                }
            }
            newStr += cToAdd;
        }
        return newStr;
    }

    public static String removeSpaces (String string) {
        String newStr = "";
        for (int i = 0; i< string.length(); i++){
            if (string.charAt(i) != ' '){
                newStr += string.charAt(i);
            }

        }
        return newStr;
    }

    public static int[] allIndexOf (String string, char chr) {
        int occur = 0;
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) == chr){
                occur ++;
            }
        }
        int[] indexes = new int[occur];
        int index = 0;
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) == chr){
                indexes[index] = i;
                index ++;

            }
        }
        return indexes;
    }
}
