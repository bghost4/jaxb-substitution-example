package com.derpderphurr;

import com.example.sub.GarageType;

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
            //ctx = JAXBContext.newInstance(com.example.sub.ObjectFactory.class);
            JAXBElement<GarageType> garage = ctx.createUnmarshaller().unmarshal(ss, GarageType.class);

            System.out.println("Garage Owner: "+
            garage.getValue().getOwnerName()
            );

            if (garage.getValue().getVehicle().size() > 0){
                garage.getValue().getVehicle().stream().forEach(v -> System.out.printf("Vechicle %s\n", v.getModel()));
            } else {
                System.out.println("No Vehicles Found");
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
