package com.derpderphurr;

import com.example.sub.Garage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;

public class Example {
    public static void main(String[] args) {
        InputStream is = Example.class.getClassLoader().getResourceAsStream("MyGarage.xml");
        StreamSource ss = new StreamSource(is);
        JAXBContext ctx = null;
        if(is == null || ss == null) {
            System.exit(1);
        }
        System.out.println("Found XML File");
        try {
            ctx = JAXBContext.newInstance("com.example.sub");
            JAXBElement<Garage> garage = ctx.createUnmarshaller().unmarshal(ss, Garage.class);

            System.out.println("Garage Owner: "+
            garage.getValue().getOwnerName()
            );

            if (garage.getValue().getvehicle().size() > 0){
                System.out.println("Found "+garage.getValue().getvehicle().size()+" Vehicles");
                garage.getValue().getvehicle().stream().forEach(v -> System.out.printf("Vechicle %s\n", v.getModel()));
            } else {
                System.out.println("No Vehicles Found");
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
