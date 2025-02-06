package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.User;
import ticket.booking.util.userServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.databind.ObjectMapper.*;

public class UserBookingServices {
    private User user;

    private List<User> userList;

    private ObjectMapper objectmapper = new ObjectMapper();

    private static final String USER_PATH = "app/src/main/java/ticket/booking/localdb/users.json";

    public UserBookingServices(User user1) throws IOException
    {
        this.user = user1;
        File users = new File(USER_PATH);
        userList = objectmapper.readValue(users, new TypeReference<List<User>>() {});
    }

    public Boolean loginUser() {
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && userServiceUtil.checkPassword(user.getPassword(),user1.getHashedPassword())
        }).findFirst();
        return foundUser.isPresent();
    }

    public Boolean signup(User user1) {
        try {
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch (IOException ex) {
            return Boolean.FALSE;
        }
    }
    public void saveUserListToFile() throws IOException {
        File userFile = new File(USER_PATH);
        objectmapper.writeValue(userFile,userList);
    }
    public void fetchBooing(){
        user.printlTicket();
    }

    public void cancelBooking(String ticketId) {

    }

}
