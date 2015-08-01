package com.skizware.money.tracker.repository.relational;

import com.skizware.user.User;

/**
 * Created with IntelliJ IDEA.
 * User: david.anderson
 * Date: 2015/07/14
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository {

    public Integer save(final User user);

    public User findById(final Integer id);
}
