import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Frog frog = new Frog();

        List<FrogCommands> commands = new ArrayList<>();
        int curCommand = -1;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВведите одну из команду" +
                    "\n+N - прыгни на N шагов направо" +
                    "\n-N - прыгни на N шагов налево " +
                    "\n<< - Undo (отмени последнюю команду) " +
                    "\n>> - Redo (повтори отменённую команду) " +
                    "\n!! - повтори последнюю команду " +
                    "\n0 - выход " );
            String input = scanner.nextLine();
            if (input.equals("0")) break;

            switch (input) {
                case "<<":
                    if (curCommand < 0) {
                        System.out.println("Нечего отменять!");
                    } else {
                        commands.get(curCommand).undo();
                        curCommand--;
                    }
                    break;
                case ">>":
                    if (curCommand == commands.size() - 1) {
                        System.out.println("Нечего отменять!");
                    } else {
                        curCommand++;
                        commands.get(curCommand).redo();
                    }
                    break;
                case "!!":
                    if (curCommand < 0) {
                        System.out.println("Нет команды для повторения!");
                    } else {
                        commands.get(curCommand++).redo();
                    }
                    break;
                default:
                    int n = Integer.parseInt(input);
                    FrogCommands cmd = new FrogCommands(frog, n);
                    curCommand++;
                    commands.add(cmd);
                    cmd.redo();
                    break;
            }
        }
        scanner.close();
    }
}
