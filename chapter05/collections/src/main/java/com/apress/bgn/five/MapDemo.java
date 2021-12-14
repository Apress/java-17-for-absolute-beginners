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
package com.apress.bgn.five;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iuliana.cosmina on 20/04/2021
 */
public class MapDemo {
    public static void main(String... args) {
        Map<Ball, Integer> ballMap = new HashMap<>();
        Ball redBall = new Ball(2, "RED", "rubber");

        ballMap.put( redBall, 5);
        ballMap.put(new Ball(4, "BLUE", "cotton"), 7);

        //ballMap.put( redBall, 3); // this overrides entry <redBall, 5>

        // pre-java 8
        if(! ballMap.containsKey(redBall)) {
            ballMap.put(redBall, 3);
        }

        // after Java 8
        ballMap.putIfAbsent(redBall, 3);

        for (Map.Entry<Ball, Integer> entry : ballMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
