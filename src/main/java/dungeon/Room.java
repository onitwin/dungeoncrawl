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
    private HashMap<String,Room> exits;
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
        this.exits=new HashMap<String, Room>();
    }

    public String getRoomname(){
        return this.roomname;
    }

    public String getDescription(){
        return this.description;
    }

    public void addPlayer(Player player){
        this.visited = true;
        this.player=player;
    }

    public Player getPlayer(){
        return this.player;
    }

    public boolean visitedStatus(){
        return this.visited;

    }

    public void passPlayer(Room newRoom){
        newRoom.addPlayer(this.player);
        this.player = null;
    }

    public int getExitSize(){
        return this.exits.size();
    }

    public void addExits(String direction, Room room){
        this.exits.put(direction,room);
    }

    public HashMap getExits(){
        return this.exits;
    }

    public int getMonstersSize(){
        return this.monsters.size();
    }

    public void addMonster(Monster monster){
        this.monsters.add(monster);
    }

    public Monster getSpecificMonster(Monster monster){
        Monster target=this.monsters.get(this.monsters.indexOf(monster));
        return target;
    }



}
