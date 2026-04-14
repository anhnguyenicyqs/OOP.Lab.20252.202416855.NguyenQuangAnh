import javax.swing.JOptionPane;

public class lab226a {
    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Input a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Input b:"));

        String result;

        if (a == 0) {
            if (b == 0) {
                result = "Vosonghiem";
            } else {
                result = "Vonghiem";
            }
        } else {
            double x = -b / a;
            result = "Nghiem x = " + x;
        }

        JOptionPane.showMessageDialog(null, result);
        System.exit(0);
    }
}