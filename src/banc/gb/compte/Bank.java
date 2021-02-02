package banc.gb.compte;

import java.io.*;
import java.util.Map;

public class Bank {
    private Map<String, Account> clients =
                Map.ofEntries(
                Map.entry("Maria", new Account(150, 100, "Maria", "pass")),
                        Map.entry("Toto", new Account(150, 100, "Toto", "123")));

    public Bank() {

    }
    public Bank(String fileName) throws IOException {
        initilizeClients(fileName);
    }

    public void initilizeClients(String fileName) throws IOException {
        File fileObject = new File(fileName);
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileObject);
            ois = new ObjectInputStream(fis);
            clients = (Map)ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                fis.close();
            }
            if(ois!=null){
                ois.close();
            }
        }
    }

    public Account getAccount(String identifiant, String code) {
        Account account = clients.get(identifiant);
        if(account.getCode().equals((code))){
            return account;
        }
        return null;
    }

    public Account createAccount() {
        return null;
    }

    public void saveData() {
        File fileObject = new File("clientsMap");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileObject))){
            int x = 5;
            oos.writeObject(clients);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
