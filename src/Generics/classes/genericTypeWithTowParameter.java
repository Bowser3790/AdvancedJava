package Generics.classes;

// if we use more than 1 data type in the parameter.
public class genericTypeWithTowParameter <U,S>{

    private U u;
    private S s;

    public genericTypeWithTowParameter(U u, S s) {
        this.u = u;
        this.s = s;
    }

    public U getU() {
        return u;
    }

    public void setU(U u) {
        this.u = u;
    }

    public S getS() {
        return s;
    }

    public void setS(S s) {
        this.s = s;
    }

    public static void main(String[] args) {
        genericTypeWithTowParameter<String,String> obj1 = new genericTypeWithTowParameter<>("Chris", "Freddie");
        genericTypeWithTowParameter<String,Integer> obj2 = new genericTypeWithTowParameter<>("Bob", 1);
        genericTypeWithTowParameter<Integer,String> obj3 = new genericTypeWithTowParameter<>(10, "Tom");
        genericTypeWithTowParameter<Integer,Integer> obj4 = new genericTypeWithTowParameter<>(22,100);

        System.out.println(obj1.getS());
        System.out.println(obj2.getU());
        System.out.println(obj3.getClass());
        System.out.println(obj4.getU());
        System.out.println(obj4.getS());




    }
}
