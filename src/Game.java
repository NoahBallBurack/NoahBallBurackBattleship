public class Game {

    public static void main(String[] args){
        boolean gameDone=false;
        Board opponentBoard=new Board();
        opponentBoard.placeShips();
        Board playerBoard= new Board();
        playerBoard.printBoard("Your Board");
        opponentBoard.printBoard("Opponent Board");
        Player p=new Player();
        Opponent o=new Opponent();
        p.placeShips(playerBoard, opponentBoard);
        while(!gameDone){
            p.guess(playerBoard, opponentBoard);
            o.guess(playerBoard, opponentBoard, p);
            if(playerBoard.gameDone()&&(!opponentBoard.gameDone())){
                System.out.println("You lose");
                gameDone=true;
            }
            if(opponentBoard.gameDone()&&(!playerBoard.gameDone())){
                System.out.println("You win!");
                gameDone=true;
            }
            if(playerBoard.gameDone()&&opponentBoard.gameDone()){
                System.out.println("Tie game");
                gameDone=true;
            }
        }
    }

}
