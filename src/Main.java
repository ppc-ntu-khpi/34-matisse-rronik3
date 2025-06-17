public class Main {
    public static void main(String[] args) {
        // Завантаження даних із файлу
        Bank.loadCustomersFromFile("f://34-matisse-rronik3/data/test.dat");

        // Запуск GUI
        Prototype.createAndShowGUI();
    }
}
