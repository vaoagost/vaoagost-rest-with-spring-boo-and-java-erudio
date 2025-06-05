package vaoagost.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vaoagost.exception.UnsopportedMathOperationException;

@RestController 
@RequestMapping("/math") //All operations for this request are initiated with 'math' //http:localhost:8080/math

public class MathController {

    //http:localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}") //Sum two numbers
    public Double sum(
        @PathVariable("numberOne") String numberOne, //Get the first number from the URL
        @PathVariable("numberTwo") String numberTwo //Get the second number from the URL
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsopportedMathOperationException("Please set a numeric value!"); //Check if the string is a number
        return convertToDouble(numberOne) + convertToDouble(numberTwo); //Convert to double and sum
    }
    //http:localhost:8080/math/sub/3/5
    @RequestMapping("/sub/{numberOne}/{numberTwo}") //Subtract two numbers
    public Double sub(
        @PathVariable("numberOne") String numberOne, //Get the first number from the URL
        @PathVariable("numberTwo") String numberTwo //Get the second number from the URL
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsopportedMathOperationException("Please set a numeric value!"); //Check if the string is a number
        return convertToDouble(numberOne) - convertToDouble(numberTwo); //Convert to double and dub
    }
    //http:localhost:8080/math/div/3/5
    @RequestMapping("/div/{numberOne}/{numberTwo}") //Divide two numbers
    public Double div(
        @PathVariable("numberOne") String numberOne, //Get the first number from the URL
        @PathVariable("numberTwo") String numberTwo //Get the second number from the URL
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsopportedMathOperationException("Please set a numeric value!"); //Check if the string is a number
        if (convertToDouble(numberTwo) == 0) throw new UnsopportedMathOperationException("Division by zero is not allowed.");
        return convertToDouble(numberOne) / convertToDouble(numberTwo); //Convert to double and divide
    }

    //http:localhost:8080/math/med/{numberOne}/{numberTwo}
    @RequestMapping("/med/{numberOne}/{numberTwo}") //Calculate the average of two numbers
    public Double med(
    @PathVariable("numberOne") String numberOne, //Get the first number from the URL
    @PathVariable("numberTwo") String numberTwo //Get the second number from the URL
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsopportedMathOperationException("Please set a numeric value!"); //Check if the string is a number
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2; //Convert to double, sum and divide by 2
    }

    //http:localhost:8080/math/root/{numberOne}
    @RequestMapping("/root/{numberOne}") //Calculate the square root of a number
    public Double root(
        @PathVariable("numberOne") String numberOne //Get the number from the URL
    ) throws Exception{
        if(!isNumeric(numberOne)) throw new UnsopportedMathOperationException("Please set a numeric value!"); //Check if the string is a number
        Double number = convertToDouble(numberOne); //Convert to double
        if (number < 0) throw new UnsopportedMathOperationException("Square root of negative numbers is not allowed.");
        return Math.sqrt(number); //Calculate the square root
    }
    private Double convertToDouble(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsopportedMathOperationException("Please set a numeric value!"); //Check if the string is null or empty
        String number = strNumber.replace(",", "."); //R$ 5,00 - USD 5.00 //Replace comma with dot
        return Double.parseDouble(number); //Convert to double
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsopportedMathOperationException("Please set a numeric value!"); //Check if the string is null or empty
        String number = strNumber.replace(",", "."); //R$ 5,00 - USD 5.00 //Replace comma with dot
        return number.matches("[-+]?[0-9]*\\.?[0-9]+"); //Regex to check if the string is a number 
    }

}
