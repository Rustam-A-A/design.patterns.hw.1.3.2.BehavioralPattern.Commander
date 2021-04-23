public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() { position = 5; }

        public boolean jump (int steps){
            position = position + steps;
            boolean[] frogPosition = new boolean[MAX_POSITION + 1];
            if (position > MAX_POSITION || position < MIN_POSITION) {
                position = position - steps;
                System.out.println("\nтак далеко лягушки не прыгают");
            } else {
                if (steps > 0) {
                    System.out.println("\nлягушка прыгнула вправо на " + steps + " позиции");
                } else {
                    System.out.println("\nлягушка прыгнула влево на " + (-steps) + " позиции");
                }
            }
            for (int i = 0; i < frogPosition.length ; i++) {
                frogPosition[i] = i == position;
                System.out.print(frogPosition[i] + " ");
            }
            System.out.println("");
            return true;
        }
}