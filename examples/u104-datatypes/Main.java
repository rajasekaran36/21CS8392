import java.lang.reflect.Type;

class Main {
    public static void main(String[] args) {
        
        //-------PRIMITIVE----
        //Numeric
        byte aByte = 2; 
        short aShort = 12458;
        int anInt = 29727928;
        long aLong = 87683663890L;        
        
        //Precition 
        float aFloat = 5.6566f;
        double aDouble = 22.3646545481221212;
        
        //Boolean
        boolean aTrueBoolean = true;
        boolean aFalseBoolean = false;
        
        //For Charecter
        char aChar = 'x';
        
        //---------CLASS-------//
        String aString = "Hello";

        System.out.println(""
        
        +"\naByte="+aByte
        +"\naShort="+aShort
        +"\nanInt="+anInt
        +"\naLong="+aLong
        +"\naFloat="+aFloat
        +"\naDouble="+aDouble
        +"\naTrueBoolean="+aTrueBoolean
        +"\naFalseBoolean="+aFalseBoolean
        +"\naChar="+aChar
        +"\naString="+aString
        +"");
        
    }    
}
