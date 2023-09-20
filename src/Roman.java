public enum Roman {
    C(100), L(50), X(10), V(5), I(1);
    private int value;
    Roman(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
