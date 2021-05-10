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
package com.apress.bgn.four.base;

public class Human {
    public static final int LIFESPAN = 100;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human() { }

    /**
     * Constructs a Human instance initialized with the given parameters.
     * @param name - the name for the Human instance
     * @param age - the age for the Human instance
     */
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Constructs a Human instance initialized with the given parameters.
     * @param name - the name for the Human instance
     * @param age - the age for the Human instance
     * @param height - the height for the Human instance
     */
    public Human(String name, int age, float height) {
        this(name, age);
        this.height = height;
    }


    /**
     * compute and prints time to live
     */
    /*public void computeAndPrintTtl(){
        int ttl = LIFESPAN - this.age;
        System.out.println("Time to live: " + ttl);
    }*/

    /**
     * @return time to live
     */
    public int getTimeToLive(){
        int ttl = LIFESPAN - this.age;
        return ttl;
    }

    private int age;
    private float height;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

}
