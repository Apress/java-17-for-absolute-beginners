package com.apress.bgn.four.exceptions;

import com.apress.bgn.four.classes.Gender;
import com.apress.bgn.four.hierarchy.Performer;

public class PerformerGenerator {

    public static Performer get(String name) {
        if ("John". equals(name)) return new Performer(name,40, 1.91f, Gender.MALE);
        else return null;
    }
}
