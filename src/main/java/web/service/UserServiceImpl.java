package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Long id) {
        if (userDao.findById(id) == null) {
            return null;
        } else {
            return userDao.findById(id);
        }
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        if (userDao.findById(user.getId()) == null) {
            userDao.add(user);
        } else {
            userDao.update(user);
        }
    }

    @Override
    public void delete(Long id) {
        if (userDao.findById(id) == null) {
            throw new RuntimeException("User not found");
        } else {
            userDao.delete(id);
        }
    }
}
