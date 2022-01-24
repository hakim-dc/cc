package howtodoinjava;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import howtodoinjava.controller.JerseyController;
import howtodoinjava.listener.MyApplicationEventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class App {

    private static final URI BASE_URI = URI.create("http://localhost:8080/demo/api");
    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        try {
            LOGGER.info("starting app");
            ResourceConfig resourceConfig = new ResourceConfig(JacksonJsonProvider.class);
            resourceConfig.setApplicationName("fast-pack");
            resourceConfig.packages(false, JerseyController.class.getPackage().getName());
            resourceConfig.register(MyApplicationEventListener.class);


            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, resourceConfig, false);
            Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));
            server.start();

        } catch (IOException ex) {
            LOGGER.info(ex);
        }
    }

}
