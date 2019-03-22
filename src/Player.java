import java.util.Scanner;

public class Player {

    public boolean gotAHit=false;

    public void guess(Board playerBoard, Board opponentBoard){
        String spaceGuessed=scanSpace();
        for(int i=0;i<opponentBoard.spaces.length;i++){
            for(int j=0;j<opponentBoard.spaces[0].length;j++){
                if(opponentBoard.spaces[i][j].number.equals(spaceGuessed)){
                    opponentBoard.spaces[i][j].hit=true;
                    if(opponentBoard.spaces[i][j].isShip){
                        gotAHit=true;
                        opponentBoard.spaces[i][j].number="Hit";
                    }else{
                        opponentBoard.spaces[i][j].number="Miss";
                    }
                }
            }
        }
        for(int k=0;k<20;k++){
            System.out.println("\b");
        }
        playerBoard.printBoard("Your Board");
        opponentBoard.printBoard("Opponent Board");
        String hitOrDidNot;
        if(gotAHit){
            hitOrDidNot="got a hit";
        }else{
            hitOrDidNot="missed";
        }
        System.out.println("You "+hitOrDidNot);
    }

    public void printResult(){
        String hitOrDidNot;
        if(gotAHit){
            hitOrDidNot="got a hit";
        }else{
            hitOrDidNot="missed";
        }
        System.out.println("You "+hitOrDidNot);
    }


    public String scanSpace(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Type the number of the space you would like to shoot on your opponent's board");
        return sc.next();
    }

    public String scanShips(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Type up to four different numbers, separated by commas and without any spaces, of the locations in which you would like to place your ships");
        return sc.next();
    }

    public void placeShips(Board playerBoard, Board opponentBoard){
        String singleString = scanShips();
        String[] multipleStrings = singleString.split(",");
        int[] spaces = new int[4];
        for(int i=0;i<multipleStrings.length;i++){
            spaces[i]=Integer.parseInt(multipleStrings[i]);
        }
        for(int j=0;j<spaces.length;j++){
            for(int k=0;k<playerBoard.spaces.length;k++){
                for(int l=0;l<playerBoard.spaces[0].length;l++){
                    int spaceNumber = Integer.parseInt(playerBoard.spaces[k][l].number);
                    if(spaceNumber==spaces[j]){
                        playerBoard.spaces[k][l].isShip=true;
                    }
                }
            }
        }
        for(int y=0;y<playerBoard.spaces.length;y++){
            for(int z=0;z<playerBoard.spaces[0].length;z++){
                if(playerBoard.spaces[y][z].isShip){
                    playerBoard.spaces[y][z].number="\uD83D\uDEA2";
                }
            }
        }
        for(int m=0;m<20;m++){
            System.out.println("\b");
        }
        playerBoard.printBoard("Your Board");
        opponentBoard.printBoard("Opponent Board");
    }

}
