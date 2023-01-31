package HW7.ui;

import java.util.ArrayList;
import java.util.List;

import HW7.data.Company;
import HW7.data.ContactMain;
import HW7.service.Add;
import HW7.service.Delete;
import HW7.service.PhoneBook;
import HW7.service.Search;

public class Presenter implements Search, Add, Delete {
    private PhoneBook modelPhoneBook;
    private ConsoleView view;

    public Presenter(PhoneBook modelPhoneBook, ConsoleView view) {
        this.modelPhoneBook = modelPhoneBook;
        this.view = view;
    }

    // • Посмотреть список контрагентов
    public void checkList(List<ContactMain> lst) {
        view.printView(lst);
    }

    // • Добавить контрагента
    @Override
    public void addContact() {
        System.out.println("Введите новое значение ");
        modelPhoneBook.getLst().add(new ContactMain(view.setName(), view.setAddress(), view.setKey(), view.setValue()));

    }

    @Override
    public void addCompany() {
        System.out.println("Введите новое значение для компании ");
        modelPhoneBook.getLst().add(new Company(view.setName(), view.setAddress(), view.setKey(), view.setValue(),
                view.setCompanyName(), view.setOccupation()));

    }

    // • Добавить новый способ связаться с контрагентом
    @Override
    public void addCommunicationMethod() {
        if (!modelPhoneBook.getLst().isEmpty()) {
            for (int i = 0; i < modelPhoneBook.getLst().size(); i++) {
                System.out.printf("%d. %s", (i + 1), modelPhoneBook.getLst().get(i));

            }
            System.out.println("Введите подходящий номер для изменения контакта");
            int chose = view.getIndex();
            modelPhoneBook.getLst().get(chose).getCommunicationMethods()
                    .put(view.setKey(), view.setValue());
        } else
            System.out.println("Список пуст. ");

    }

    // • Удалить контрагента
    @Override
    public void deleteContact() {
        System.out.println("Введите полное имя контакта для удаления");
        checkList(modelPhoneBook.getLst());
        String param = view.setName();
        for (ContactMain lst : modelPhoneBook.getLst()) {
            if (lst.getName().equals(param)) {
                modelPhoneBook.getLst().remove(lst);
            }
        }
    }

    // • Удалить способ связаться с контрагентом
    @Override
    public void deleteCommunicationMethod() {
        if (!modelPhoneBook.getLst().isEmpty()) {
            for (int i = 0; i < modelPhoneBook.getLst().size(); i++) {
                System.out.printf("%d. %s", (i + 1), modelPhoneBook.getLst().get(i));

            }
            System.out.println("Введите подходящий номер для изменения контакта. ");
            int chose = view.getIndex();
            modelPhoneBook.getLst().get(chose).getCommunicationMethods().remove(view.setKey());
        } else
            System.out.println("Список пуст. ");
    }

    // • Найти контрагента по названию. Посмотреть подробную информацию о нём
    @Override
    public void search() {
        System.out.println("Введите имя для поиска ");
        List<ContactMain> lstTemp = new ArrayList<>();
        String param = view.getName();
        for (ContactMain lst : modelPhoneBook.getLst()) {
            if (lst.getName().equals(param)) {
                lstTemp.add(lst);
            }
        }
        System.out.println(lstTemp);
    }
}
