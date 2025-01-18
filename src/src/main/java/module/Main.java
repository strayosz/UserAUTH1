package module;

import java.util.Scanner;

import static module.Role.ADMIN;
import static module.Role.USER;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("kamilyakupov25@mail.ru", "gbq5txa.x33c", ADMIN);
        User user2 = new User("kamilyakupov01@mail.ru", "gbq5txa.x33c", USER);

        User[] users = {user1, user2};
        boolean flag = true;
        Scanner sc;
        while (flag) {
            try {
                sc = new Scanner(System.in);
                System.out.println("Введите Логин");
                String login = sc.nextLine();
                if (login.equals("exit")) {
                    break;
                }
                System.out.println("Введите Пароль");
                String password = sc.nextLine();

                if (checkUser(login, password, users) == ADMIN) {
                    System.out.println("Меню Админа");
                    flag = false;
                }
                if (checkUser(login, password, users) == USER) {
                    System.out.println("Меню Пользователя");
                    flag = false;
                }
            } catch (WrongLogin s) {
                System.out.println(s.getMessage());;
            } catch (WrongPassword s) {
                System.out.println(s.getMessage());
            } catch (WrongUser s) {
                System.out.println(s.getMessage());
            }
        }
    }
    public static Role checkUser(String login, String password, User[] users) throws WrongUser, WrongPassword, WrongLogin {
        if (!(login.length() >= 20 && login.matches("[a-zA-Z0-9@._-]+"))) {
            throw new WrongLogin("Неправильный формат логина");
        }

        if (!(password.length() >= 8 && password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[{}\\[\\](),.;&?!_\\-+]).{8,}$"))) {
            throw new WrongPassword("Неправильный формат пароля");
        }

        if (login.equals(users[0].getLogin()) && (password.equals(users[0].getPassword()))) {
            return ADMIN;
        } else if (login.equals(users[1].getLogin()) && (password.equals(users[1].getPassword()))) {
            return USER;
        } else {
            throw new WrongUser("Неправильный логин или пароль, попробуйте еще раз!");
        }
    }
}