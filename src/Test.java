import javax.swing.*;

public class Test extends JFrame {

    private JList<String> list;
    private LinkedHashMapListModel listModel;

    public Test() {

        setTitle("Linked HashMap List Model");

        listModel = new LinkedHashMapListModel<>();
        list = new JList(listModel);

        listModel.put("1", "a");
        listModel.put("2", "b");
        listModel.put("3", "c");

        list.addListSelectionListener(e -> {
            JOptionPane.showConfirmDialog(null, listModel.get(listModel.keySet().toArray()[list.getSelectedIndex()]), "Amin Aliari", JOptionPane.DEFAULT_OPTION);
            if (listModel.contains("3")) {
                listModel.remove("3");
                System.out.println("3 -> removed");
            }// to check if JList get updated or not
        });

        getContentPane().add(list);

        setSize(300, 100);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
