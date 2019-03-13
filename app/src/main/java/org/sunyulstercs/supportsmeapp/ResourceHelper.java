package org.sunyulstercs.supportsmeapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;

public class ResourceHelper {

    /**
     * A very verbose name so I know exactly what it does, hopefully.
     * @param arrayId2D A resource id of a 2d array
     * @return A 2D String array taken from the resource id
     */
    public static String[][] resourceIDTo2DStringArray(int arrayId2D, Context context)
    {
        TypedArray ta = context.getResources().obtainTypedArray(arrayId2D); //Getting multidimensional array from resource file
        String[][] newArray = new String[ta.length()][];
        for (int i = 0; i < ta.length(); ++i)
        { //Now we need to stuff the contents of that TypedArray into an Object[][]
            int id = ta.getResourceId(i, 0);

            if (id > 0)
            {
                newArray[i] = context.getResources().getStringArray(id);
            } else {
                Log.e("ResourceHelper", "Error getting 2d array from file");
            }
        }
        ta.recycle(); //Apparently TypedArray is one of the few java classes (that I've come across) that needs to be recycled to free the memory to be Garbage Collected
        return newArray;
    }

    public static String[] getFirstElementsOf2DStringArray(String[][] array)
    {
        String[] newArray = new String[array.length];
        for (int x = 0; x < array.length; x++)
        {
            newArray[x] = array[x][0];
        }
        return newArray;
    }
}
