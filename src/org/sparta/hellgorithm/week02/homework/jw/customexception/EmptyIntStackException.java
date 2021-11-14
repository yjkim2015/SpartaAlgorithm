package org.sparta.hellgorithm.week02.homework.jw.customexception;

public class EmptyIntStackException extends RuntimeException{

    public EmptyIntStackException(String message) {
        super(message);
    }
}
