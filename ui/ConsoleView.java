package HW7.ui;


import java.util.List;
import java.util.Map;
import java.util.Scanner;

import HW7.data.ContactMain;

public class ConsoleView implements View{

    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in).useDelimiter("\n");
    }

    @Override
    public String getName() {
        System.out.println("Имя: ");
        return in.next();
    }

    @Override
    public String setName() {
        System.out.println("Имя: ");
        String temp = "";
        temp += in.next();
        return temp;
    }

    @Override
    public Map<String, String> getCommunicationMethods() {
        System.out.println("способ связи: ");
        return null;
    }


    @Override
    public String getAddress() {
        System.out.println("дрес: ");
        return in.nextLine();
    }

    @Override
    public String setAddress() {
        System.out.println("Адрес: ");
        String temp = "";
        temp += in.next();
        return temp;
    }

    @Override
    public String getCompanyName() {
        System.out.println("Название компании: ");
        return in.nextLine();
    }

    @Override
    public String setCompanyName() {
        System.out.println("Название компании: ");
        return in.next();
    }

    @Override
    public String getOccupation() {
        System.out.println("Род деятельности: ");
        return in.nextLine();
    }

    @Override
    public String setOccupation() {
        System.out.println("Род деятельности: ");
        return in.next();
    }

    public void printView(List<ContactMain> lst) {
        for(ContactMain item: lst) {
            System.out.println(item);
        }
    }

    public Integer getIndex() {
        System.out.println("Выберите контакт: ");
        return in.nextInt() - 1;
    }


    @Override
    public String setKey() {
        System.out.println("Введите метод: ");
        return in.next();
    }

    @Override
    public String setValue() {
        System.out.println("Введите номер: ");
        return in.next();
    }
}
