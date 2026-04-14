import javax.swing.JOptionPane;

public class lab226b {
    public static void main(String[] args) {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("a12:"));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("b1:"));

        double a21 = Double.parseDouble(JOptionPane.showInputDialog("a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("a22:"));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("b2:"));

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        String result;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            result = "Nghiem:\nx1 = " + x1 + "\nx2 = " + x2;
        } else {
            if (D1 == 0 && D2 == 0) {
                result = "He vo so nghiem";
            } else {
                result = "He vo nghiem";
            }
        }

        JOptionPane.showMessageDialog(null, result);
        System.exit(0);
    }
}