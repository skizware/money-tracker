package com.skizware.money.tracker.service.impl;

import com.skizware.money.tracker.domain.MoneyTracker;
import com.skizware.money.tracker.persistence.repository.UserRepository;
import com.skizware.user.User;
import com.skizware.money.tracker.service.MoneyTrackerService;

import java.util.List;

/**
 * Service for exposing operations for the money tracker application.
 */
public class MoneyTrackerServiceImpl implements MoneyTrackerService {

    UserRepository userRepository;

    @Override
    public User getUserByEmail(final String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User enrollUser(String emailAddress) {
        User enrolledUser = getUserByEmail(emailAddress);
        if(enrolledUser == null){
            enrolledUser = new User(emailAddress);
            userRepository.save(enrolledUser);
        }

        return enrolledUser;
    }

    @Override
    public MoneyTracker createUserMoneyTracker(User user, Double initialTrackerAmount) {
        MoneyTracker newMoneyTracker = new MoneyTracker(initialTrackerAmount);
        user.addMoneyTracker(newMoneyTracker);

        userRepository.saveOrUpdateUserMoneyTrackers(user);
        return newMoneyTracker;
    }

    @Override
    public void updateUserMoneyTrackers(User user) {
        userRepository.saveOrUpdateUserMoneyTrackers(user);
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
