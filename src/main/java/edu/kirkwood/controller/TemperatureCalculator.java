package edu.kirkwood.controller;

import edu.kirkwood.model.Temperature;

/**
 * TemperatureCalculator is a class that provides methods to parse
 * and validate user input, and perform temperature calculations such as conversion, addition,
 * and substraction based on Temperature model.
 */

public class TemperatureCalculator {
    /**
     * Parses a user input string and creates a Temperature object.
     * The expected input format is: "value scale" (20 F).
     *
     * @param input the user input string with number and scale
     * @return a Temperature object
     * @throws IllegalArgumentException if the input is invalid or improperly formatted.
     */

    public Temperature parseTemperatureInput(String input){
        if (input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        String[] parts = input.trim().split("\\s+");
        if (parts.length != 2){
            throw new IllegalArgumentException("Invalid format. Use 'value scale', e.g. '25 C'.");
        }

        double degree;
        try {
            degree = Double.parseDouble(parts[0]);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid degree value: " + parts[0]);
        }

        String scale = parts[1];
        return new Temperature(degree, scale);
    }

    /**
     * Converts a given Temperature to the specified target scale.
     * @param temp the Temperature object to convert
     * @param targetScale The Target scale ("C", "F", or "K")
     * @return the converted temperature as a formatted string
     * @throws IllegalArgumentException if the scale is invalid
     */

    public String convertTemperature(Temperature temp, String targetScale){
        if (temp == null){
            throw new IllegalArgumentException("Temperature cannot be null");
        }
        return temp.convertTo(targetScale);
    }

    /**
     * Adds two temperatures objects together
     * The result is returned in the scale of the first temperature
     * @param t1 the first temperature
     * @param t2 the second temperature
     * @return the resulting temperature after addition
     * @throws IllegalArgumentException if any parameter is null.
     */

    public Temperature add(Temperature t1, Temperature t2){
        if (t1 == null || t2 == null){
            throw new IllegalArgumentException("T1 and T2 cannot be null");
        }
        return t1.add(t2);
    }

    /**
     * Substracts the second temperature from the first
     * @param t1 the first temperature
     * @param t2 the second temperature
     * @return the resulting temperature after substraction
     * @throws IllegalArgumentException if any parameter is null.
     */

    public Temperature subtract(Temperature t1, Temperature t2){
        if (t1 == null || t2 == null){
            throw new IllegalArgumentException("T1 and T2 cannot be null");
        }
        return t1.subtract(t2);
    }
}
