package org.startsteps.controller.user;

import org.startsteps.model.user.User;
import org.startsteps.model.user.UserRole;

import java.io.*;
import java.util.Map;

public class UserDataManager {
    private static final String FILE_PATH = "src/main/java/org/startsteps/user_data.txt";

    public void saveUserData(User user) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bufferedWriter.write(user.getUsername() + "," + user.getPassword() + "," + user.getRole().toString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }
    }

    public void loadUserData(Map<String, User> userDatabase) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/user_data.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 3) {
                    String username = userData[0];
                    String password = userData[1];
                    UserRole role = UserRole.valueOf(userData[2]);
                    User user = new User(username, password, role);
                    userDatabase.put(username, user);
                } else {
                    System.err.println("Invalid user data");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error finding file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error loading user data: " + e.getMessage());
        }
    }
}
