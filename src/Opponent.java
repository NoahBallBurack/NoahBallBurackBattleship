import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;

public class Opponent {

    ArrayList<Integer> numbers=new ArrayList<>();
    public int numberInArray=0;

    public Opponent(){
        for(int i=0;i<36;i++){
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);
    }

    public void guess(Board playerBoard, Board opponentBoard, Player p){
        boolean opponentGotAHit=false;
        int randomNumberInt=numbers.get(numberInArray);
        String randomNumber = Integer.toString(randomNumberInt);
        for(int j=0;j<playerBoard.spaces.length;j++){
            for(int k=0;k<playerBoard.spaces[0].length;k++){
                if(playerBoard.spaces[j][k].trueNumber.equals(randomNumber)){
                    playerBoard.spaces[j][k].hit=true;
                    if(playerBoard.spaces[j][k].isShip){
                        opponentGotAHit=true;
                        playerBoard.spaces[j][k].number="Hit";
                    }else{
                        playerBoard.spaces[j][k].number="Miss";
                    }
                }
            }
        }
        for(int m=0;m<20;m++){
            System.out.println("\b");
        }
        playerBoard.printBoard("Your Board");
        opponentBoard.printBoard("Opponent Board");
        p.printResult();
        if(opponentGotAHit){
            System.out.println("Opponent guessed space "+ randomNumber + " and hit");
        }else{
            System.out.println("Opponent guessed space "+ randomNumber + " and missed");
        }
        p.gotAHit=false;
        numberInArray++;
    }

}
