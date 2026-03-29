package com.example.task_planning.service;

import com.example.task_planning.entity.User;
import com.example.task_planning.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    // ✅ Get all users
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    // ✅ Create new user
    public User createUser(User user) {
        return repository.save(user);
    }

    // ✅ Update existing user
    public User updateUser(Long id, User updatedUser) {
        User existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User with id " + id + " not found"));

        // Update fields
        existing.setUsername(updatedUser.getUsername());
        existing.setEmail(updatedUser.getEmail());

        // Optional: update password if provided
        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            existing.setPassword(updatedUser.getPassword()); // If using AuthService, encode before saving
        }

        return repository.save(existing);
    }

    // ✅ Delete user
    public void deleteUser(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("User with id " + id + " not found");
        }
        repository.deleteById(id);
    }

    // ✅ Get user by id
    public User getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User with id " + id + " not found"));
    }
}