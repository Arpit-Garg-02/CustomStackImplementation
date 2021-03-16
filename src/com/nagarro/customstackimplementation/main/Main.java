/*
* Class name: Main
*
* Version info: jdk 1.8
*
* Copyright notice:
* 
* Author info: Arpit Garg
*
* Creation date: 12/Mar/2021
*
* Last updated By: Arpit Garg
*
* Last updated Date: 12/Mar/2021
*
* Description: Main class of Stack
*/
package com.nagarro.customstackimplementation.main;

import java.util.Scanner;

import com.nagarro.customstackimplementation.utils.InputValidationUtil;
import com.nagarro.customstackimplementation.exception.InvalidValuesException;
import com.nagarro.customstackimplementation.service.CustomStack;

public class Main {
    private static final String SIZE_OF_STACK = "Size of Stack ";
    private static final String ENTER_VALUE_TO_BE_SEARCH = "Enter value to be search";
    private static final String PEEK_VALUE = "Peek Value ";
    private static final String POPED_ELEMENT = "Poped Element: ";
    private static final String ENTER_ELEMENT_TO_BE_ADDED = "Enter Element to be added";
    private static final String _4_CONATINS = "4- conatins";
    private static final String _3_PEEK = "3- peek";
    private static final String _2_POP = "2- Pop";
    private static final String _1_PUSH = "1- Push";
    private static final String WELCOME = "Welcome!....";
    private static final String SELECT_OPERATION_TO_BE_PERFORM = "Select Operation to be perform...";
    private static final String PRESS_Y_FOR_CONTINUE = "Press 'y' for continue...";
    private static final String _5_SIZE = "5- Size";
    private static final String _6_REVERSE = "6- Reverse";
    private static final String _7_ITERATOR = "7- Iterator";
    private static final String _8_TRAVERSE = "8- Traverse";
    private static final String WRONG_CHOICE = "Wrong Choice!";
    static Scanner scan = new Scanner(System.in);

    /**
     * @param args
     */
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        char ch;
        System.out.println(WELCOME);
        do {
            System.out.println(SELECT_OPERATION_TO_BE_PERFORM);
            System.out.println(_1_PUSH);
            System.out.println(_2_POP);
            System.out.println(_3_PEEK);
            System.out.println(_4_CONATINS);
            System.out.println(_5_SIZE);
            System.out.println(_6_REVERSE);
            System.out.println(_7_ITERATOR);
            System.out.println(_8_TRAVERSE);
            String choiceForOperation = scan.next();
            int choice = new InputValidationUtil().inputValidation(choiceForOperation);
            choiceAction(choice, stack);
            System.out.println(PRESS_Y_FOR_CONTINUE);
            ch = scan.next().charAt(0);
        } while (ch == 'y');
        scan.close();
    }

    /**
     * provide different operations for user
     * 
     * @param choice
     * @param stack
     */
    private static void choiceAction(int choice, CustomStack stack) {
        switch (choice) {
        case 1:
            System.out.println(ENTER_ELEMENT_TO_BE_ADDED);
            String valueToBeAdd = scan.next();
            int value = new InputValidationUtil().inputValidation(valueToBeAdd);
            stack.push(value);
            break;

        case 2:
            System.out.println(POPED_ELEMENT + stack.pop());
            break;

        case 3:
            System.out.println(PEEK_VALUE + stack.peek());
            break;

        case 4:
            System.out.println(ENTER_VALUE_TO_BE_SEARCH);
            String valueToBeSearch = scan.next();
            int searchValue = new InputValidationUtil().inputValidation(valueToBeSearch);
            System.out.println(stack.contains(searchValue));
            break;

        case 5:
            System.out.println(SIZE_OF_STACK + stack.size());
            break;

        case 6:
            stack.stackReverse();
            break;

        case 7:
            stack.customIterator(stack);
            break;

        case 8:
            stack.traverse();
            break;

        default:
            new InvalidValuesException(WRONG_CHOICE);
        }
    }
}
