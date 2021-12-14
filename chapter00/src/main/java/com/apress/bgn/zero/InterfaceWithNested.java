package com.apress.bgn.zero;

/**
 * Created by iuliana.cosmina on 25/02/18
 */
public interface InterfaceWithNested {

    class NotStaticNested {
        NotStaticNested() {
            System.out.println("I am non-static nested!");
        }
    }
}
