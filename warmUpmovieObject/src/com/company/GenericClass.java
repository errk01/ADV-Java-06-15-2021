package com.company;

public class GenericClass<G> {
    // String g
    // Integer g
    // char g
    G g;

    public void add(G g){
        this.g = g;
    }

    public G get(){
        return g;
    }

}
