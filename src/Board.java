import java.util.Random;

public class Board {

    Space[][] spaces = new Space[3][12];

    public Board(){
        populateBoard();
    }

    public void populateBoard(){
        int integer = 1;
        for(int i=0;i<spaces.length;i++){
            for(int j=0;j<spaces[0].length;j++){
                spaces[i][j] = new Space(Integer.toString(integer));
                integer++;
            }
        }
    }

    public void printBoard(String competitorBoard){
        System.out.println(competitorBoard);
        for(int i=0;i<spaces.length;i++){
            for(int j=0;j<spaces[0].length;j++){
                System.out.print(spaces[i][j].number+ "  ");
            }
            System.out.println("\n");
        }
    }

    public void placeShips(){
        int shipsCreated=0;
        int numberOfSpaces=(spaces.length)*(spaces[0].length);
        Random rand=new Random();
        while(shipsCreated<4){
            int randomNumber=rand.nextInt(numberOfSpaces)+1;
            String randomNumberString = Integer.toString(randomNumber);
            for(int j=0;j<spaces.length;j++){
                for(int k=0;k<spaces[0].length;k++){
                    if(spaces[j][k].number.equals(randomNumberString)){
                        spaces[j][k].isShip=true;
                        shipsCreated++;
                    }
                }
            }
        }
    }

    public boolean gameDone(){
        for(int j=0;j<spaces.length;j++){
            for(int k=0;k<spaces[0].length;k++){
                Space space=spaces[j][k];
                if(space.isShip&&(!space.hit)){
                    return false;
                }
            }
        }
        return true;
    }
}