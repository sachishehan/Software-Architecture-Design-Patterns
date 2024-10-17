// OldCal class (existing code)
class OldCal {
    private int number1;
    private int number2;

    public OldCal(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public int getNum1() {
        return number1;
    }

    public int getNum2() {
        return number2;
    }

    public int sum() {
        return number1 + number2;
    }
}

// NewCal interface (defines the multi() method)
interface NewCal {
    int multi();
}

// AdaptorCal class (implements NewCal using OldCal)
class AdaptorCal implements NewCal {
    private OldCal oldCal;

    public AdaptorCal(OldCal oldCal) {
        this.oldCal = oldCal;
    }

    public int multi() {
        int num1 = oldCal.getNum1();
        int num2 = oldCal.getNum2();
        return num1 * num2;
    }
}

// Usage example
public class MyApp {
    public static void main(String[] args) {
        OldCal oldType = new OldCal(10, 20);
        NewCal newType = new AdaptorCal(oldType);

        System.out.println("Sum: " + oldType.sum()); // Output: Sum: 30
        System.out.println("Multiplication: " + newType.multi()); // Output: Multiplication: 200
    }
}