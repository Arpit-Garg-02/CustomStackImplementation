/*
* Class name: StackIterator
*
* Version info: jdk 1.8
*
* Copyright notice:
* 
* Author info: Arpit Garg
*
* Creation date: 16/Mar/2021
*
* Last updated By: Arpit Garg
*
* Last updated Date: 16/Mar/2021
*
* Description: Iterator class for Stack
*/
package com.nagarro.customstackimplementation.service;

import java.util.Iterator;

import com.nagarro.customstackimplementation.exception.InvalidValuesException;
import com.nagarro.customstackimplementation.model.Node;

public class StackIterator implements Iterator {
    private static final String NO_SUCH_ELEMENT = "No such Element";
    private Node currentNode = null;
    private Node top = null;

    public StackIterator(Node top) {
        this.top = top;
    }

    /**
     * check stack has next element or not
     */
    @Override
    public boolean hasNext() {
        if (currentNode == null && top != null) {
            return true;
        } else if (currentNode != null) {
            return currentNode.getNext() != null;
        }
        return false;
    }

    @Override
    public Object next() {
        if (currentNode == null) {
            currentNode = top;
            return top.getValue();
        } else if (currentNode != null) {
            currentNode = currentNode.getNext();
            return currentNode.getValue();
        }
        throw new InvalidValuesException(NO_SUCH_ELEMENT);
    }

}
