package xyz.aungpyaephyo.padc.myanmarattractions.controllers;

/**
 * Created by Nyein Nyein on 7/17/2016.
 */
public interface ControllerAccountControl {
    void onRegister(String name, String email, String password, String dateOfBirth, String country);
    void onLogin(String email, String password);
}