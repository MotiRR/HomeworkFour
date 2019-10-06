package ru.sber.edu;

public class Main {

    public static void main(String[] args) throws Exception {
        ClientBankService service = new ClientBankService();
        service.hibernate();
    }

}
