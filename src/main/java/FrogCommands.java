public class FrogCommands implements FrogCommand{

    private final int steps;
    Frog frog;

    public FrogCommands(Frog frog, int steps){
        this.frog = frog;
        this.steps = steps;
    }

    public static void jumpCommand(Frog frog, int steps) {
       frog.jump(steps);
    }

    @Override
    public boolean redo() {
        frog.jump(steps);
        return true;
    }

    @Override
    public boolean undo() {
        frog.jump((-steps));
        return true;
    }

}