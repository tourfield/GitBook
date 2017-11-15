package com.github.tourfield.gitbook.base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geary on 17-11-15.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
