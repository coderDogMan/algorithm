package week.week.year2023;

import java.util.*;

public class ThroneInheritance {
    class People {
        People parent;
        String name;
        boolean isDeath;
        LinkedList<People> child;

        public People(People parent, String name, boolean isDeath, LinkedList<People> child) {
            this.parent = parent;
            this.name = name;
            this.isDeath = isDeath;
            this.child = child;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            People people = (People) o;
            return isDeath == people.isDeath && Objects.equals(name, people.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, isDeath);
        }
    }
    HashMap<String, People> map;
    List<String> ans;
    People king;
    public ThroneInheritance(String kingName) {
        map = new HashMap<>();
        king = new People(null, kingName, false, null);
        map.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        People parent = map.get(parentName);
        People child = new People(parent, childName, false, null);
        if (parent.child == null) {
            parent.child = new LinkedList<>();
            parent.child.add(child);
        } else {
            parent.child.add(child);
        }
        map.put(childName, child);
    }

    public void death(String name) {
        map.get(name).isDeath = true;
    }

    public List<String> getInheritanceOrder() {
        ans = new LinkedList<>();
        dfs(king);
        return ans;
    }

    private void dfs(People king) {
        if (king.isDeath == false) ans.add(king.name);
        if (king.child == null) return;
        for (People son : king.child) {
            dfs(son);
        }
    }
}
