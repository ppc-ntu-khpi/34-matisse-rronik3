import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prototype {
    public static void createAndShowGUI() {
        JFrame frame = new JFrame("MyBank Clients");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        JTextField clientNameField = new JTextField(15);
        JButton showButton = new JButton("Show");
        topPanel.add(clientNameField);
        topPanel.add(showButton);

        JTextArea clientInfoArea = new JTextArea(10, 30);
        clientInfoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(clientInfoArea);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        JButton reportButton = new JButton("Report");
        JButton aboutButton = new JButton("About");
        bottomPanel.add(reportButton);
        bottomPanel.add(aboutButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(panel);

        // Обробник для кнопки "Show"
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String clientName = clientNameField.getText();
                Customer customer = Bank.findCustomerByName(clientName);
                if (customer != null) {
                    clientInfoArea.setText(customer.toString());
                } else {
                    clientInfoArea.setText("Customer not found.");
                }
            }
        });

        // Обробник для кнопки "Report"
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String report = Bank.generateCustomerReport();
                clientInfoArea.setText(report);
            }
        });

        // Обробник для кнопки "About"
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "MyBank Application\nDeveloped by Rroxy", "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}
