package banc.gb.compte;

public class Main {

    public static void main(String... args) throws ImpossibleOperationException, NegatifSumException {
        Bank bank = new Bank();
        Account compte = bank.getAccount("Maria", "pass");
        compte.debit(150);
        bank.saveData();
        Bank bank2 = new Bank();
        Account compte2 = bank.getAccount("Maria", "pass");
        compte2.checkBalance();
    }
}
