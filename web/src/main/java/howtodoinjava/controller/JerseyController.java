package howtodoinjava.controller;

import com.conf.ConfigManager;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/message")
@Singleton
public class JerseyController {

    public static final ConfigManager INSTANCE = ConfigManager.getInstance();

    private static class User {
        private int id = 1;
        private String name = "hakim";
        private Date date = new Date();

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }

    private static User user = new User();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMsg() {
        user.setName(INSTANCE.getMessage());
        return Response.status(200).entity(user).build();
    }
}






