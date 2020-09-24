package com.codecool.gladiator.view;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * Basic console view implementation
 */
public class ConsoleView implements Viewable {

    @Override
    public void display(String text) {
        System.out.println(text);
    }

    @Override
    public int getNumberBetween(int min, int max) {
        Scanner input = new Scanner(System.in);
        int intInput = 0;
        while(intInput < min || intInput > max){
            try {
                intInput = parseInt(input.nextLine());
            }catch (Exception e){
                System.out.println("Invalid input");
            }
        }
        return intInput;
    }

}
