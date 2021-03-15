/*
* Class name: CustomStack
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
* Description: Stack class for creating and do operations
*/
package com.nagarro.customstackimplementation.service;

import com.nagarro.customstackimplementation.exception.InvalidValuesException;
import com.nagarro.customstackimplementation.model.Node;

public class CustomStack {
    private static final String STACK_IS_EMPTY = "Stack is Empty!";
    int length = 0;
    Node top = null;

    /**
     * For insert/Push value in stack
     * 
     * @param value
     */
    public void push(int value) {
        Node node = new Node();
        node.setValue(value);
        node.setNext(top);
        top = node;
        length++;
    }

    /**
     * check stack is empty or not
     * 
     * @return
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * pop/delete the top element from stack
     * 
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            new InvalidValuesException(STACK_IS_EMPTY);
        }
        Node node = top;
        top = top.getNext();
        length--;
        return node.getValue();
    }

    /**
     * return the top element from stack
     * 
     * @return
     */
    public int peek() {
        if (isEmpty()) {
            new InvalidValuesException(STACK_IS_EMPTY);
        }
        return top.getValue();
    }

    /**
     * search the value in the stack
     * 
     * @param searchValue
     * @return
     */
    public boolean contains(int searchValue) {
        if (isEmpty()) {
            new InvalidValuesException(STACK_IS_EMPTY);
        }
        Node node = top;
        while (node != null) {
            if (node.getValue() == searchValue) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    /**
     * return the size of the stack
     * 
     * @return
     */
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return length;
    }

    /**
     * return the node value
     * 
     * @param index
     * @return
     */
    private Node getNode(int index) {
        int s = length - 1;
        Node temp = top;
        while (s != index) {
            temp = temp.getNext();
            s--;
        }
        return temp;
    }

    /**
     * Reverse the stack
     */
    public void stackReverse() {
        int left = 0;
        int right = length - 1;
        System.out.println(right);
        while (left < right) {
            Node leftNode = getNode(left);
            Node rightNode = getNode(right);
            int temp = leftNode.getValue();
            leftNode.setValue(rightNode.getValue());
            rightNode.setValue(temp);
            left++;
            right--;
        }
    }

    /**
     * Iterator method used to print stack
     * 
     * @return
     */
    public String toString() {
        String output = "";
        Node node = top;
        while (node != null) {
            output += ", " + node.getValue();
            node = node.getNext();
        }
        return "[" + output.substring(1) + " ]";
    }

    /**
     * stack traverser method
     */
    public void traverse() {
        if (isEmpty()) {
            new InvalidValuesException(STACK_IS_EMPTY);
        }
        Node node = top;
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
        System.out.println();
    }

}
