package org.sparta.hellgorithm.week02.homework.jw.customexception;

public class OverflowStackExpception extends RuntimeException{

    public OverflowStackExpception(String message) {
        super(message);
    }
}
