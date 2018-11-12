import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TypeUtil {
    private final String keyWords[] = { "abstract", "boolean", "break", "byte",
            "case", "catch", "char", "class", "continue", "default", "do",
            "double", "else", "extends", "final", "finally", "float", "for",
            "if", "implements", "import", "instanceof", "int", "interface",
            "long", "native", "new", "package", "private", "protected",
            "public", "return", "short", "static", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "try",
            "void", "volatile", "while","strictfp","enum","goto","const","assert" }; // 关键字数组
    private final char operators[] = { '+', '-', '*', '/', '=', '>', '<', '&', '|', '!' }; // 运算符数组


    private final char separators[] = { ',', ';', '{', '}', '(', ')', '[', ']', '_',
            ':', '.', '"','\\'}; // 界符数组

    /** 类型2 运算符*/
//    public static final int NEQ = 81;
//    public static final int LTE = 82;
//    public static final int GTE = 83;
//    public static final int EQE =  84;
//    public static final int INC = 85;
//    public static final int ASC = 86;
//    public static final int ADDEQ = 87;
//    public static final int MINEQ = 88;
//    public static final int MULEQ = 89;
//    public static final int DIVEQ = 90;

    private final String operatorsType2[] ={"!=","<=",">=","==","++","--","+=","-=","*=","/="};

    private Set<String> keyWordsSet =new HashSet<String>(Arrays.asList(keyWords));

    private Set<String>  operatorsType2Set = new HashSet<String>(Arrays.asList(operatorsType2));

    public boolean isOperatorsType2(String s){
        return operatorsType2Set.contains(s);
    }

    public   boolean isLetter(char ch){
        return Character.isLetter(ch);
    }

    public boolean isDigit(char ch){
        return Character.isDigit(ch);
    }

    /**
     * 判断是否为关键字
     * @param s 需判断的字符串
     * @return boolean
     */
    public boolean isKeyWord(String s) {
        return keyWordsSet.contains(s);
    }

    /**
     * 判断是否为运算符
     * @param ch 需判断的字符
     * @return boolean
     */
    public boolean isOperator(char ch) {
        for(char c:operators) {
            if (c == ch)
                return true;
        }
        return false;
    }

    /**
     * 判断是否为分隔符
     * @param ch 需判断的字符
     * @return boolean
     */
    public boolean isSeparators(char ch) {
        for(char c:separators){
            if(c==ch)
                return true;
        }
        return false;
    }


    public int getType(String str){
        int type = -1;
        Field[] fields = keyTypes.class.getDeclaredFields();
        for(Field field: fields){
            if(field.getName().equals(str.toUpperCase())){
                try {
                    type = (Integer) field.get(new keyTypes());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return type;
    }

}
