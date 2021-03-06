package dungeon;

import behaviors.IUse;
import characters.Monster;
import characters.Player;
import gear.treasure.Loot;

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
        String startDescription = this.description;
        if( this.monsters.size() > 0){
           String newDescription = String.format(" There is %s %s in the room.", this.monsters.size(), this.monsters.get(0).getName());
           startDescription = startDescription + newDescription;
        }
        if( this.loot.size() > 0){
            String newDescription = String.format(" There is a %s on the floor.", ((Loot)this.loot.get(0)).getName());
            startDescription = startDescription + newDescription;

        }
        return  startDescription;
    }

    public void addPlayer(Player player){
        this.visited = true;
        this.player=player;
        System.out.println(this.getDescription());

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

    public void getExitString(){
        for (String exit:this.exits.keySet()){
            System.out.println(String.format("There is a door to the %s",exit));
        }
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

    public ArrayList getMonsters(){
        return this.monsters;
    }


    public int getLootSize(){
        return this.loot.size();
    }

    public ArrayList<IUse> getAllLoot(){
        return this.loot;
    }

    public void addLoot(IUse item){
        this.loot.add(item);
    }

    public void passLoot(IUse item){
                this.player.addEquipment(this.loot.remove(this.loot.indexOf(item)));
    }

    public IUse individualItemOfLoot(){
        return this.loot.get(0);

    }




}

