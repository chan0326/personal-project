package com.erichgamma.api.menber;

import com.erichgamma.api.enums.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public String addUsers() {
        return null;
    }

    @Override
    public String login(Member user) {
        return null;
    }

    @Override
    public String updatePassword(Member user) {
        return null;
    }

    @Override
    public List<?> findUsersByName(String name) {
        return null;
    }

    @Override
    public List<?> findUsersByJob(String job) {
        return null;
    }

    @Override
    public Map<String, ?> getUserMap() {
        return null;
    }

    @Override
    public String test() {
        return null;
    }

    @Override
    public Map<String, ?> findUser() {
        return null;
    }

    @Override
    public List<?> findUsers() throws SQLException {
        return null;
    }

    @Override
    public String creatTable() throws SQLException {
        return null;
    }

    @Override
    public String deleteTable() throws SQLException {
        return null;
    }

    @Override
    public Message tableadd() throws SQLException {
        return null;
    }
}
