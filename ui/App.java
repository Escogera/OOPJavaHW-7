package HW7.ui;



import java.util.Scanner;

import HW7.service.PhoneBook;

public class App {

    public static void buttonClick() {
        PhoneBook model = new PhoneBook();
        ConsoleView cView = new ConsoleView();
        Presenter pr = new Presenter(model, cView);

        Scanner in = new Scanner(System.in);
        boolean condition = true;

        while(condition) {
            System.out.println("Выберите опцию и введите номер: ");
            System.out.println("1 - Показать все контакты ");
            System.out.println("2 - Поиск контакта, используйте имя ");
            System.out.println("3 - Добавить нвоый контакт ");
            System.out.println("4 - Удалить контакт ");
            System.out.println("5 - Добавить новый метод к контакту ");
            System.out.println("6 - Удалить метод у контакта");
            System.out.println("7 - Выход ");
            System.out.println("Выберите опцию: ");

            switch (in.next()) {
                case "1":
                    pr.checkList(model.getLst());
                    break;
                case "2":
                    pr.search();
                    break;
                case "3":
                    System.out.println("Нажмите 1 для добавления контакта или 2 для добавления компании");
                    switch (in.next()) {
                        case "1":
                            pr.addContact();
                            System.out.println("Контакт добавлен \n");
                            break;
                        case "2":
                            pr.addCompany();
                            System.out.println("Компания добавлена \n");
                            break;
                        default:
                            System.out.println("Что-то пошло не так, убедитесь что вы выбрали существующую опциюю \n");
                    }
                    break;
                case "4":
                    pr.deleteContact();
                    break;
                case "5":
                    pr.addCommunicationMethod();
                    break;
                case "6":
                    pr.deleteCommunicationMethod();
                    break;
                case "7":
                    condition = false;
                    break;
                default:
                    System.out.println("Что-то пошло не так, убедитесь что вы выбрали существующую опциюю \n");
            }
        }
        in.close();
    }
}
