package com;
import org.apache.log4j.Logger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyClass {
    final static Logger logger = Logger.getLogger(MyClass.class);

    public static void main(String args[]){
        int messageCount=100;
        MyClass myClass = new MyClass();
        try{
            for (int i = 0; i <messageCount ; i++) {
                logger.error("error > "+myClass.getSaltString());
                TimeUnit.SECONDS.sleep(1);
                //logger.debug("***************************************");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
