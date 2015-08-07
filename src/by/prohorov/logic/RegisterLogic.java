package by.prohorov.logic;

public class RegisterLogic {
    public static boolean checkPassword(String password, String repeatPassword) {
        return password.equals(repeatPassword);
     }
}
