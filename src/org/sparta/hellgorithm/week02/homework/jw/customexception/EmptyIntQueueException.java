package org.sparta.hellgorithm.week02.homework.jw.customexception;

public class EmptyIntQueueException extends RuntimeException {

    public EmptyIntQueueException(String message) {
        super(message);
    }
}
