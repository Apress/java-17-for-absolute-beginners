package com.apress.bgn.four.hierarchy;

/**
 * @author iuliana.cosmina
 * @date 11/04/2018
 * @since 1.0
 */
public interface Artist {
    public static final int LIFESPAN = 100;

    String getSchool();

    void setSchool(String school);

    default boolean isCreative(){
        explain();
        return true;
    }

    private void explain(){
        System.out.println("A true artist has a creative nature.");
    }

    public static String capitalize(final String name){
        Character c = name.charAt(0);
        if(Character.isLowerCase(c)) {
            Character upperC = Character.toUpperCase(c);
            name.replace(c, upperC);
        }
        return name;
    }
}
