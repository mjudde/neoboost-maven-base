package boost.bbe.simple;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class MaClasse {
    public boolean isEmpty(List<?> l) {
        return CollectionUtils.isEmpty(l);
    }

    public static void main(String[] args) {
        MaClasse mc = new MaClasse();
        boolean b = mc.isEmpty(List.of("A", "B", "C"));
        System.out.println("isEmpty ? " + b);
    }
}