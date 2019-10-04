import java.util.LinkedList;
import java.util.Queue;

class PlayerQueue {

    private Queue<Player> players = new LinkedList<>();

    public Player remove(){
        // remove player from queue
        // pass player to Game
        return this.players.remove();
    }

    private void add(Player player){
        // add player to queue
        this.players.add(player);
    }

}
