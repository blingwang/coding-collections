import java.util.*;
class Solution10Q2 {}
class Server {
    HashMap<Integer, Machine> machines = new HashMap<Integer, Machine>();
    HashMap<Integer, Integer> personToMachineMap = new HashMap<Integer, Integer>();

    public Machine getMachineWithId(int machineID) {
        return machines.get(machineID);
    }

    public int getMachineIDForUser(int personID) {
        Integer machineID = personToMachineMap.get(personID);
        return machineID == null ? -1 : machineID;
    }

    public Person getPersonWithID(int personID) {
        Integer machineID = personToMachineMap.get(personID);
        if (machineID == null) return null;

        Machine machine = getMachineWithId(machineID);
        if (machine == null) return null;

        return machine.getPersonWithID(personID);
    }
}

class Person {
    private ArrayList<Integer> friendIDs;
    private int personID;

    public Person(int id) { this.personID= id; }

    public int getID() { return personID; }
    public void addFriend(int id) { friendIDs.add(id);}
}

class Machine {
    public HashMap<Integer, Person> persons = new HashMap<Integer, Person>();
    public int machineID;

    public Person getPersonWithID(int personID) {
        return persons.get(personID);
    }
}
