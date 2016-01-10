package com.easygo.common;

public class Common {
     public int convertObjToInt(Object object)
     {
    	    int numb = 0;
    	   	try {
				numb = Integer.parseInt(object.toString());
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("objtoint exception");
			}
			return numb;
     }
     public int convertStrToInt(String str)
     {
    	    int numb = 0;
    	    try {
				numb = Integer.parseInt(str);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("strtoint exception");
			}
			return numb;
     }
}
