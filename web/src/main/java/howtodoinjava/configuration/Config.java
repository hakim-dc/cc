package howtodoinjava.configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import howtodoinjava.controller.JerseyController;
import howtodoinjava.listener.MyApplicationEventListener;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;


@ApplicationPath("/api")
public class Config extends ResourceConfig {

    public Config() {
        setApplicationName("fast-pack");
        packages(JerseyController.class.getPackage().getName());
        register(MyApplicationEventListener.class);
        register(JacksonJsonProvider.class);
    }

}