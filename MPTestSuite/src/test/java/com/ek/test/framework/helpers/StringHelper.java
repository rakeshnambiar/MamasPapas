package com.ek.test.framework.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringHelper {
  
  public static boolean equalLists(List<String> listOne, List<String> listTwo){     
    if (listOne == null && listTwo == null){
        return true;
    }

    if((listOne == null && listTwo != null) 
      || listOne != null && listTwo == null
      || listOne.size() != listTwo.size()){
        return false;
    }
    listOne = new ArrayList<String>(listOne); 
    listTwo = new ArrayList<String>(listTwo);   

    Collections.sort(listOne);
    Collections.sort(listTwo);      
    return listOne.equals(listTwo);
}

}
