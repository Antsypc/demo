package xyz.antsgroup.demo.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Manager manager = new Manager("young", 11, "shenzhen", 0L);
        System.out.println(new ObjectMapper().writeValueAsString(manager));

        ObjectMapper mapper = new ObjectMapper();
        Manager manager1 = mapper.readValue(new FileInputStream(Main.class.getResource("/").getPath() + "manager.json"), Manager.class);
        System.out.println(manager1);
    }
}
