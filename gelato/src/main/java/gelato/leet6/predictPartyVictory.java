package gelato.leet6;

import java.util.*;

//649

//想清楚greedy的条件在哪里
//This is obliviously a greedy algorithm problem.
//Each senate R must ban its next closest senate D who is from another party, or else D will ban its next senate from R's party.
public class predictPartyVictory {
    public String predictPartyVictory(String senate) {
        LinkedList<Character> linkedList = new LinkedList<>();
        for (char c : senate.toCharArray()) {
            linkedList.add(c);
        }
        Iterator<Character> ite = linkedList.iterator();
        Character win = null;
        int ncnt = 0;
        while (ncnt < linkedList.size()) {
            char next;
            if (ite.hasNext()) {
                next = ite.next();
            } else {
                ite = linkedList.listIterator();
                next = ite.next();
            }
            if(win == null){
                win = next;
                ncnt++;
            }else if (next != win) {
                ite.remove();
                ncnt--;
                if(ncnt == 0){
                    win = null;
                }
            } else {
                ncnt++;
            }
        }
        return win == 'D' ? "Dire" : "Radiant";
    }
}
