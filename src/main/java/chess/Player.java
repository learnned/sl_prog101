package chess;

public class Player {
    private Color color;
    private boolean turn;
    private String name;

    /**Getter for the attribute name**/
    public String getName() {
        return name;
    }
   /**Setter for the attribute name**/
    public void setName(final String name) {
        this.name = name;
    }

    public Player(final Color color, final boolean turn, final String name) {
        this.color = color;
        this.name = name;
        this.turn = turn;
    }
    /**Method that prints the winner**/
    public void win() {
        System.out.println("The winner is:" + getName());
    }
    /**Method that prints the winner**/
    public String showWin() {
        return "The winner is:" + getName();
    }
    /**Method that prints the loser**/
    public void lose() {
        System.out.println("The loser is:" + getName());
    }
    /**Method that prints the winner**/
    public String showLoser() {
        return "The loser is:" + getName();
    }
    /**Method that prints the surrender**/
    public void surrender() {
        System.out.println("The player " + getName() + " surrender");
    }
    /**Method that prints the surrender**/
    public String showSurrender() {
        return "The player " + getName() + " surrender";
    }


}

