package com.bkticketing.bkTicketing_backend.Service;
import com.bkticketing.bkTicketing_backend.Model.Activity;
import java.util.List;
import java.util.Optional;

public interface ActivityService {
    Activity addActivity(Activity activity);
    List<Activity> getAllActivities();
    Optional<Activity> getActivityById(String activityId);
    Activity updateActivity(String activityId, Activity activityDetails);
    void deleteActivity(String activityId);
}
