package com.bkticketing.bkTicketing_backend.ServiceImplementation;
import com.bkticketing.bkTicketing_backend.Repository.*;
import com.bkticketing.bkTicketing_backend.Service.RecordCountService;
import org.springframework.stereotype.Service;

@Service
public class RecordCountServiceImplementation implements RecordCountService {
    private final GeneralEventRepository generalEventRepository;
    private final TheaterRepository theaterRepository;
    private final SportRepository sportRepository;
    private final ActivityRepository activityRepository;
    private final EmailRepository emailRepository;
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    public RecordCountServiceImplementation(
            GeneralEventRepository generalEventRepository,
            TheaterRepository theaterRepository,
            SportRepository sportRepository,
            ActivityRepository activityRepository,
            EmailRepository emailRepository,
            ReservationRepository reservationRepository,
            UserRepository userRepository) {

        this.generalEventRepository = generalEventRepository;
        this.theaterRepository = theaterRepository;
        this.sportRepository = sportRepository;
        this.activityRepository = activityRepository;
        this.emailRepository = emailRepository;
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public long getGeneralEventCount() {
        return generalEventRepository.count();
    }

    @Override
    public long getTheaterCount() {
        return theaterRepository.count();
    }

    @Override
    public long getSportCount() {
        return sportRepository.count();
    }

    @Override
    public long getReservationCount() {
        return reservationRepository.count();
    }

    @Override
    public long getNotificationCount() {
        return emailRepository.count();
    }

    @Override
    public long getUserCounts() {
        return userRepository.count();
    }

    @Override
    public long getActivityCount() {
        return activityRepository.count();
    }
}
