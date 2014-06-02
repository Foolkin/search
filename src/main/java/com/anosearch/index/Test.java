package com.anosearch.index;

import org.configureme.annotations.ConfigureMe;
import org.configureme.annotations.SetIf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by admin on 6/2/14.
 */
@ConfigureMe (name="param")
public class Test {

    List<String> list = new ArrayList<String>();

    @SetIf(value = "value", condition = SetIf.SetIfCondition.startsWith)
    public void add(String value, String name){
        list.add(value);
        System.out.println("add");
    }

    public List<String> getList(){
        return list;
    }
    public static void main(String[] args) {
        String[] m = new String[0];
        List l  = new ArrayList(Arrays.asList(m));
        l.add(1);
        l.add(2);
        System.out.println(m);
        System.out.println(l);
        System.out.println(l);

        String[] s = {"1", "2", "3", "3"};

        HashSet<String> set = new HashSet<String>();
        set.addAll(Arrays.asList(s));

        System.out.println(set);

        String[] s2 = set.toArray(new String[set.size()]);
        for(String string : s2)
            System.out.print(string + " ");
    }
}
