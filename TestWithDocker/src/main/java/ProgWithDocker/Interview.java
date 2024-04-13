package ProgWithDocker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interview {
    public static void main(String[] args) {
//        System.out.println("Hello Java");
        //15, "Steeve","US","30"
        //+7.70, +7.40, +6.0, -15.70

        ArrayList<String> li = new ArrayList<>();
        li.add("Steeve");
        li.add("US");
        li.add("30");

//        for(String name : li){
//            System.out.print(name);
//        }

//        HashMap<Integer,ArrayList<String>> map  = new HashMap<>();
//        map.put(15,li);
//
//        for(Map.Entry<Integer, ArrayList<String>> entry: map.entrySet()){
////            entry.getValue();
////            entry.getKey();
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }

        String str = "tomorrow";
        char ch = '$';
        char[] a = str.toCharArray();
        StringBuilder builder = new StringBuilder(str);
        builder.setCharAt(3,ch);
        System.out.println(builder);


    }
    }

