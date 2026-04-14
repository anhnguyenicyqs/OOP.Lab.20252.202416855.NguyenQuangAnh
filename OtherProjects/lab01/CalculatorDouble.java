import javax.swing.JOptionPane;

public class CalculatorDouble {
    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null,
                "Please input the first number:",
                "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null,
                "Please input the second number:",
                "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        String result = "Result:\n";
        result += "Sum: " + sum + "\n";
        result += "difference: " + difference + "\n";
        result += "product: " + product + "\n";

        if (num2 != 0) {
            double quotient = num1 / num2;
            result += "Quotient: " + quotient;
        } else {
            result += "Cant divide to 0";
        }

        JOptionPane.showMessageDialog(null,
                result,
                "Result",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}