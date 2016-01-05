package javase07.t01;

import java.time.LocalDateTime;
import java.util.ArrayList;

class BillsWrapper {
    private BillsLoader loader;
    private ArrayList<Bill> bills;

    public BillsWrapper(String path) {
        loader = new BillsLoader(path);
        bills = new ArrayList<>(loader.load());
    }

    public void addBill(String from, String to, int sum) {
        Bill newBill = new Bill(from, to, sum, LocalDateTime.now());
        synchronized(this) {
            bills.add(newBill);
            loader.saveBill(newBill);
        }
    }

    public int getBalance(String account) {
        int balance = 0;
        synchronized (this) {
            loader.load();

            // если не синхронизировать - при проходе по коллекции и одновременному добавлению в коллекцию элемента другим тредом - будет исключение
            for (Bill bill: bills ) {
                if (bill != null) {
                    if (bill.getRecipient().equals(account)) {
                        balance += bill.getSum();
                    }
                    if (bill.getSender().equals(account)) {
                        balance -= bill.getSum();
                    }
                }
            }
        }
        return balance;
    }
}
