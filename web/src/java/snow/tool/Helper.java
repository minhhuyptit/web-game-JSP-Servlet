/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snow.tool;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author huyla
 */
public class Helper {
    public static String formatNumber(long number){
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ITALY);
        return numberFormat.format(number);
    }
    public static String cutString(String str, int size){
        if(str.length() > size){
            str = str.substring(0, size);
            str += "..";
        }
        return str;
    }
    public static String randomKey(int length){
        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(rand.nextInt(str.length())));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(randomKey(10));
    }
}
