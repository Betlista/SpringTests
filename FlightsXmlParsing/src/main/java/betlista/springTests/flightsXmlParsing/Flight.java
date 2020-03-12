package betlista.springTests.flightsXmlParsing;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="flight")
@XmlType(propOrder = { "startLocation", "endLocation", "date" })
public class Flight {
    // Create variables

    String startLocation;
    String endLocation;
    String date;


    // Getters and setters for Flight class

    @XmlElement
    public String getStartLocation() {
        return startLocation;
    }
    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }
    @XmlElement
    public String getEndLocation() {
        return endLocation;
    }
    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }
    @XmlElement
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }


}
