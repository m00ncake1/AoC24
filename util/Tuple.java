package util;
public class Tuple<X, Y>{
    private final X itemOne;
    private final Y itemTwo;

    public Tuple(X itemOne, Y itemTwo){
        this.itemOne = itemOne;
        this.itemTwo = itemTwo;
    }

    public X getItemOne(){
        return itemOne;
    }

    public Y getItemTwo(){
        return itemTwo;
    }

    @Override
    public String toString(){
        return "("+ itemOne + ", " + itemTwo + ")";
    }
    

}