package com.bkticketing.bkTicketing_backend.ServiceImplementation;
import com.bkticketing.bkTicketing_backend.Model.Activity;
import com.bkticketing.bkTicketing_backend.Repository.ActivityRepository;
import com.bkticketing.bkTicketing_backend.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImplementation implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;
    @Override
    public Activity addActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public Optional<Activity> getActivityById(String activityId) {
        return activityRepository.findById(activityId);
    }

    @Override
    public Activity updateActivity(String activityId, Activity activityDetails) {
        return activityRepository.findById(activityId).map(activity -> {
            activity.setEventName(activityDetails.getEventName());
            activity.setActivityDate(activityDetails.getActivityDate());
            activity.setStartTime(activityDetails.getStartTime());
            activity.setEndTime(activityDetails.getEndTime());
            activity.setVenue(activityDetails.getVenue());
            activity.setChargePerPerson(activityDetails.getChargePerPerson());
            activity.setMaxPerson(activityDetails.getMaxPerson());
            activity.setDuration(activityDetails.getDuration());
            activity.setAvailableFor(activityDetails.getAvailableFor());
            return activityRepository.save(activity);
        }).orElseThrow(() -> new RuntimeException("Activity not found with id " + activityId));
    }

    @Override
    public void deleteActivity(String activityId) {
        activityRepository.deleteById(activityId);
    }
}
