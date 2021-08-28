package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ThroneInheritance {

    String king;
    HashMap<String, Boolean> alive = new HashMap<>();
    HashMap<String, String> child = new HashMap<>(); // child -> parent
    HashMap<String, ArrayList<String>> parent = new HashMap<>(); // parent -> child

    public ThroneInheritance(String kingName) {
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        alive.put(childName, true);
        child.put(childName, parentName);

        ArrayList<String> temp = parent.getOrDefault(parentName, new ArrayList<>());
        temp.add(childName);
        parent.put(parentName, temp);
    }

    public void death(String name) {
        alive.put(name, false);
    }

    String successor(String x, List<String> curOrder) {
        boolean hasChild = parent.containsKey(x);
        boolean childAreInOrder = true;
        String oldestChild = "";
        for (String s : parent.getOrDefault(x, new ArrayList<>())) {
            if (child.get(s).equals(x) && !curOrder.contains(s)) {
                childAreInOrder = false;
                oldestChild = s;
                break;
            }
        }
        if (!hasChild || childAreInOrder) {
            if (king.equals(x)) return null;
            else return successor(child.get(x), curOrder);
        } else {
            return oldestChild;
        }
    }

    public List<String> getInheritanceOrder() {
        List<String> list = getList(king);  //all list with alive and died
        List<String> res = new ArrayList<>();
        for (String s : list)
            if (alive.getOrDefault(s, true)) res.add(s);  // remove died
        return res;
    }

    private List<String> getList(String p) {   // recursion to get children and build the inheritance list;
        List<String> res = new ArrayList<>();
        res.add(p);
        List<String> cs = parent.getOrDefault(p, new ArrayList<>());
        for (String c : cs) {
            List<String> tmp = getList(c);
            for (String cc : tmp) res.add(cc);
        }
        return res;
    }
}

