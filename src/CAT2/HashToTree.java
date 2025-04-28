package CAT2;
import java.util.*;
import java.util.stream.*;

public class HashToTree {
    static TreeMap<Integer,String> hashtoTree(HashMap<String,String> map) {
        TreeMap<Integer,String> tree = new TreeMap<>();
        for(Map.Entry<String,String> entry : map.entrySet()) {
            tree.put(Integer.parseInt(entry.getKey()),entry.getValue());
        }
        return tree;
    }


    public static void main(String[] args){
        HashMap<String,String> map = new HashMap<>();
        map.put("1","B");
        map.put("2","C");
        map.put("23","D");
        map.put("5","E");
        map.put("566","F");
        map.put("12","G");
        TreeMap<Integer,String>mp=hashtoTree(map);
        for(Map.Entry<Integer,String> entry:mp.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
