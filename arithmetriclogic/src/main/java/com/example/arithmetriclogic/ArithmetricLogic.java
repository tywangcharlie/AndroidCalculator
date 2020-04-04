package com.example.arithmetriclogic;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class ArithmetricLogic {

    public static String Calculate (String process) {

        process = process.replaceAll("×", "*");
        process = process.replaceAll("%", "/100");
        process = process.replaceAll("sin", "Math.sin");
        process = process.replaceAll("cos", "Math.cos");
        process = process.replaceAll("tan", "Math.tan");
        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);
        String finalResult = "";

        try{
            Scriptable scriptable = rhino.initSafeStandardObjects();
            finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
        }catch (Exception e){
            finalResult = "Error";
        }

        return finalResult;


    }






}
