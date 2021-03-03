package dungeon;

import behaviors.IUse;
import characters.Monster;
import characters.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {

    private String roomname;
    private String description;
    private ArrayList<Monster> monsters;
    private HashMap<String,Room> rooms;
    private boolean visited;
    private Player player;
    private ArrayList<IUse>loot;

    public Room (String roomname,String description){
        this.roomname=roomname;
        this.description=description;
        this.player=null;
        this.monsters=new ArrayList<Monster>();
        this.loot=new ArrayList<IUse>();
        this.visited=false;
        this.rooms=new HashMap<String, Room>();
    }

    public String getRoomname(){
        return this.roomname;
    }

    public String getDescription(){
        return this.description;
    }

    public void addPlayer(Player player){
        this.player=player;
    }

    public Player getPlayer(){
        return this.player;
    }


}
