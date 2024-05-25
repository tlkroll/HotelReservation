package edu.wgu.d387_sample_code;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class WelcomeMessage {

    static ExecutorService messageExecutor=newFixedThreadPool(5);
    public ArrayList<String> getWelcomeMessage() {

            ArrayList<String> welcomeMessages = new ArrayList<>();

            Properties properties=new Properties();
            messageExecutor.execute(()-> {
                try {
                    InputStream stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
                    properties.load(stream);
                    welcomeMessages.add(properties.getProperty("welcome"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            messageExecutor.execute(()-> {
                try {
                    InputStream stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
                    properties.load(stream);
                    welcomeMessages.add(properties.getProperty("welcome"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            return welcomeMessages;

        }
    }