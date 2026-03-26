import javax.swing.JOptionPane;

public class lab226c {
    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Input a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Input b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Input c:"));

        String result;

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    result = "Vo so nghiem";
                } else {
                    result = "Vo nghiem";
                }
            } else {
                double x = -c / b;
                result = "PT bac nhat, nghiem x = " + x;
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta < 0) {
                result = "Phuong trinh vo nghiem";
            } else if (delta == 0) {
                double x = -b / (2 * a);
                result = "Nghiem kep x = " + x;
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = "2 nghiem:\nx1 = " + x1 + "\nx2 = " + x2;
            }
        }

        JOptionPane.showMessageDialog(null, result);
        System.exit(0);
    }
}