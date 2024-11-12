package com.bkticketing.bkTicketing_backend.Controller;
import com.bkticketing.bkTicketing_backend.Model.Activity;
import com.bkticketing.bkTicketing_backend.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/getAllActivity")
    public List<Activity> getAllActivity() {
        return activityService.getAllActivities();
    }

    @GetMapping("/getActivityById/{id}")
    public Optional<Activity> getActivityById(@PathVariable("id") String activityId) {
        return activityService.getActivityById(activityId);
    }

    @PostMapping("/addActivity")
    public Activity addActivity(@RequestBody Activity activity) {
        return activityService.addActivity(activity);
    }

    @PutMapping("/updateActivity/{id}")
    public Activity updateActivity(@PathVariable("id") String activityId, @RequestBody Activity activity) {
        return activityService.updateActivity(activityId, activity);
    }

    @DeleteMapping("/deleteActivity/{id}")
    public String deleteActivity(@PathVariable("id") String activityId) {
        activityService.deleteActivity(activityId);
        return "Activity deleted with id " + activityId;
    }
}
