import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ATM {
    private JFrame welcomeFrame;
    private JFrame mainFrame;
    private JPanel mainPanel;
    private ArrayList<Account> accounts;

    public ATM() {
        accounts = new ArrayList<Account>();

        // create some test accounts
        accounts.add(new Account(1, 5000));
        accounts.add(new Account(2, 10000));
        accounts.add(new Account(3, 20000));

        createWelcomeWindow();
    }

    private void createWelcomeWindow() {
        welcomeFrame = new JFrame("ATM");
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel welcomeLabel = new JLabel("Welcome to the ATM.");
        JLabel idLabel = new JLabel("Enter your ID:");
        JTextField idField = new JTextField(10);
        JButton accessButton = new JButton("Access");

        accessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                boolean found = false;

                for (Account account : accounts) {
                    if (account.getId() == id) {
                        createMainWindow(account);
                        welcomeFrame.dispose();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(welcomeFrame, "Invalid ID.");
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(welcomeLabel);
        panel.add(new JLabel());
        panel.add(idLabel);
        panel.add(idField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(accessButton);

        welcomeFrame.add(panel, BorderLayout.CENTER);
        welcomeFrame.add(buttonPanel, BorderLayout.SOUTH);
        welcomeFrame.pack();
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setVisible(true);
    }

    private void createMainWindow(Account account) {
        mainFrame = new JFrame("ATM");
        mainPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Name: John Doe");
    }
}