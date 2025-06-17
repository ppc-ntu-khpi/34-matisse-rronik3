import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static List<Customer> customers = new ArrayList<>();

    public static void loadCustomersFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int customerCount = Integer.parseInt(reader.readLine().trim()); // Перша строка — кількість клієнтів

            for (int i = 0; i < customerCount; i++) {
                String customerLine;
                do {
                    customerLine = reader.readLine();
                } while (customerLine != null && customerLine.trim().isEmpty()); // Пропустити порожні рядки

                if (customerLine == null) {
                    throw new IllegalArgumentException("Unexpected end of file while reading customer data.");
                }

                String[] customerInfo = customerLine.split("\t");
                if (customerInfo.length < 3) {
                    throw new IllegalArgumentException("Invalid customer format in file.");
                }

                String firstName = customerInfo[0];
                String lastName = customerInfo[1];
                int accountCount = Integer.parseInt(customerInfo[2]);

                List<Account> accounts = new ArrayList<>();
                for (int j = 0; j < accountCount; j++) {
                    String accountLine;
                    do {
                        accountLine = reader.readLine();
                    } while (accountLine != null && accountLine.trim().isEmpty()); // Пропустити порожні рядки

                    if (accountLine == null) {
                        throw new IllegalArgumentException("Unexpected end of file while reading account data.");
                    }

                    String[] accountInfo = accountLine.split("\t");
                    if (accountInfo.length < 3) {
                        throw new IllegalArgumentException("Invalid account format in file.");
                    }

                    String type = accountInfo[0].equals("S") ? "Savings" : "Checking";
                    double balance = Double.parseDouble(accountInfo[1]);
                    double overdraftOrInterestRate = Double.parseDouble(accountInfo[2]);
                    accounts.add(new Account(type, balance, overdraftOrInterestRate));
                }

                customers.add(new Customer(firstName + " " + lastName, accounts.toArray(new Account[0])));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error in file format: " + e.getMessage());
        }
    }

    public static Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    public static String generateCustomerReport() {
        StringBuilder report = new StringBuilder();
        report.append("Customer Report\n");
        report.append("--------------------\n");

        for (Customer customer : customers) {
            report.append(customer.toString()).append("\n");
        }

        return report.toString();
    }
}
