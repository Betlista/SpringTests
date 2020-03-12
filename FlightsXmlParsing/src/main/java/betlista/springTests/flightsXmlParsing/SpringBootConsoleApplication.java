package betlista.springTests.flightsXmlParsing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(SpringBootConsoleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        File file;
        try {
            file = ResourceUtils.getFile("classpath:flights.xml");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            return;
        }

        try {
            JAXBContext context = JAXBContext.newInstance(FlightList.class);
            Unmarshaller un = context.createUnmarshaller();
            FlightList flightList = (FlightList) un.unmarshal(file);
            List< Flight > list = flightList.getFlights();
            for (Flight flight: list) {
                LOG.info("{} -> {} [{}]", flight.getStartLocation(), flight.getEndLocation(), flight.getDate());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
