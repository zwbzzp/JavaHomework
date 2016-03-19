package ch4.ch4_2;

import javafx.scene.control.Tab;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

/**
 * Created by zwb on 16/3/18.
 */
public class DisplayQueryResults extends JFrame {
    static final String DATABASE_URL = "jdbc:mysql://localhost/books";
    static final String USERNAME = "zwb";
    static final String PASSWORD = "syily";

    static final String DEFAULT_QUERY = "SELECT * FROM Authors";

    private ResultSetTableModel tableModel;
    private JTextArea queryArea;

    public DisplayQueryResults()
    {
        super("Displaying Query Results.");

        try{
            //create TableModel for results of query SELECT * FROM Authors
            tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
            queryArea = new JTextArea(DEFAULT_QUERY,3,100);
            queryArea.setWrapStyleWord(true);
            queryArea.setLineWrap(true);

            JScrollPane scrollPane = new JScrollPane(queryArea,
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            JButton submitButton = new JButton("Submit Query");

            //create Box to manage placement of query and submitButton
            Box boxNorth = Box.createHorizontalBox();
            boxNorth.add(scrollPane);
            boxNorth.add(submitButton);

            JTable resultTable = new JTable(tableModel);

            JLabel filterLable = new JLabel("Filter:");
            final JTextField filterText = new JTextField();
            JButton filterButton = new JButton("Apply Filter");
            Box boxSouth = Box.createHorizontalBox();
            boxSouth.add(filterLable);
            boxSouth.add(filterText);
            boxSouth.add(filterButton);

            add(boxNorth, BorderLayout.NORTH);
            add(new JScrollPane(resultTable), BorderLayout.CENTER);
            add(boxSouth,BorderLayout.SOUTH);

            submitButton.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                tableModel.setQuery(queryArea.getText());
                            }
                            catch (SQLException e1)
                            {
                                JOptionPane.showMessageDialog(null, e1.getMessage(),
                                        "Database error", JOptionPane.ERROR_MESSAGE);

                                try {
                                    tableModel.setQuery(DEFAULT_QUERY);
                                    queryArea.setText(DEFAULT_QUERY);
                                }
                                catch (SQLException e2)
                                {
                                    JOptionPane.showMessageDialog(null, e2.getMessage(),
                                            "Database error", JOptionPane.ERROR_MESSAGE);

                                    tableModel.disconnectFromDatabase();
                                    System.exit(1);
                                }
                            }
                        }
                    }
            );

            final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
            resultTable.setRowSorter(sorter);
            setSize(500, 250);
            setVisible(true);

            filterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = filterText.getText();
                    if(text.length()==0)
                        sorter.setRowFilter(null);
                    else{
                        try {
                            sorter.setRowFilter(RowFilter.regexFilter(text));
                        }
                        catch (PatternSyntaxException pse)
                        {
                            JOptionPane.showMessageDialog(null, "Bad regex pattern", "Bad regex pattern",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });
        }
        catch (SQLException sqle)
        {
            JOptionPane.showMessageDialog(null,sqle.getMessage(),
                    "Database error", JOptionPane.ERROR_MESSAGE);

            tableModel.disconnectFromDatabase();
            System.exit(1);
        }

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        super.windowClosed(e);
                        tableModel.disconnectFromDatabase();
                        System.exit(0);
                    }
                }
        );
    }

    public static void main(String[] args)
    {
        new DisplayQueryResults();
    }
}
