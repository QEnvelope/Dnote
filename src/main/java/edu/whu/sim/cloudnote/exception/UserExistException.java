package edu.whu.sim.cloudnote.exception;

public class UserExistException extends IllegalArgumentException {

    public UserExistException(String s) {
        super(s);
    }
}
