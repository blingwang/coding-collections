import java.util.*;

public class ActorGraphNode{
    private String name;
    private Set<ActorGraphNode> linkedActors;
    private int baconNumber = -1;

    public ActorGraphNode(String name){
        this.name = name;
        linkedActors = new HashSet<ActorGraphNode>();
    }
    
    public void linkCostar(ActorGraphNode costar){
        linkedActors.add(costar);
        costar.linkedActors.add(this);
    }

    public int getBaconNumber(){
        return baconNumber;
    }

    // to be called only on the Kevin Bacon node
    public void setBaconNumbers(){
        baconNumber = 0;
        Queue<ActorGraphNode> queue = new LinkedList<ActorGraphNode>();
        queue.add(this);

        ActorGraphNode current;
        while((current = queue.poll()) != null){
            for(ActorGraphNode n : current.linkedActors){
                if( -1 == n.baconNumber) { // if node is unvisited
                    n.baconNumber = current.baconNumber + 1;
                    queue.add(n);
                }
            }
        }
    }
}
