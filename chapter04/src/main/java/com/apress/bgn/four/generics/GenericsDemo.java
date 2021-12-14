/*
Freeware License, some rights reserved

Copyright (c) 2021 Iuliana Cosmina

Permission is hereby granted, free of charge, to anyone obtaining a copy 
of this software and associated documentation files (the "Software"), 
to work with the Software within the limits of freeware distribution and fair use. 
This includes the rights to use, copy, and modify the Software for personal use. 
Users are also allowed and encouraged to submit corrections and modifications 
to the Software for the benefit of other users.

It is not allowed to reuse,  modify, or redistribute the Software for 
commercial use in any way, or for a user's educational materials such as books 
or blog articles without prior permission from the copyright holder. 

The above copyright notice and this permission notice need to be included 
in all copies or substantial portions of the software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS OR APRESS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.apress.bgn.four.generics;

import com.apress.bgn.four.classes.Gender;
import com.apress.bgn.four.hierarchy.Performer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iuliana.cosmina on 29/03/2021
 */
public class GenericsDemo {

    public static void main(String... args) {
        Performer  john = new Performer("John", 43, 1.91f, Gender.MALE);
        Performer jane = new Performer("Jane", 34, 1.591f, Gender.FEMALE);

        var duet = Pair.of(john, jane);
        System.out.println(duet);

        Pair<Performer, Double> netWorth = Pair.of(john, 34_000_000.03);
        System.out.println(netWorth);

        Pair<String, Performer> johnsGenre = Pair.of("country-pop", john);
        System.out.println(johnsGenre);

        HashMap<Long, Map<String, ? extends Performer>> performers = new HashMap<Long, Map<String, ? extends Performer>>() ;
        var performers1 = new HashMap<Long, Map<String, ? extends Performer>>() ;
        HashMap<Long, Map<String, ? extends Performer>> performers3 = new HashMap<>() ;

        var performers4 = new HashMap<>();
        //performers.put(null, null);
        //performers.put(john, jane);
        //performers.put(1, "bbb");
        //performers.put("aaa", "bbb");

    }
}
