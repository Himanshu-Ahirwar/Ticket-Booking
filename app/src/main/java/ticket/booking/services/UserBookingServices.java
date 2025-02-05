package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
}
