package org.greeter;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;

public class Greeter {
    final static Logger logger = Logger.getLogger("Greeter");

    public String greet(String name){
        logger.info("Calling greet with " + name);

        final String resultName = returnName(name);
        final String timeOfDay = getTimeOfDay(LocalTime.now().getHour());
        final String msg = (resultName.equals("Invalid name with digit or special symbol.")) ? resultName : timeOfDay + resultName + ".";
        return msg;
    }

    public String returnName(final String name) {
        final String result;

        if(!validateName(name)){
            return ("Invalid name with digit or special symbol.");
        } else {
            result = transform(name);
        }
        return result;
    }

    public boolean validateName(final String name){
        if(name.isBlank() || name.isEmpty() || !name.matches("^[a-zA-Z\\s]+$")){
            return false;
        }
        return true;
    }

    public String transform(final String name){
        String trimmed = name.trim();
        final String result = StringUtils.capitalize(trimmed);
        return result;
    }

    public String getTimeOfDay(final int hour){

        String timeOfDay;
        switch (hour) {
            case 6: case 7: case 8: case 9: case 10: case 11:
                timeOfDay = "Good morning ";
                break;
            case 12: case 13: case 14: case 15: case 16: case 17:
                timeOfDay = "Hello ";
                break;
            case 18: case 19: case 20: case 21: case 22:
                timeOfDay = "Good evening ";
                break;
            default:
                timeOfDay = "Good night ";
                break;
        }
        return timeOfDay;
    }
}
