package org.example.helpers;

public class TypeCheck {
    static public boolean checkIsInteger(String s){
        if (s == null ) {
            return false;
        }
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException e){
            return false;
        }
       return true;
    }
}
