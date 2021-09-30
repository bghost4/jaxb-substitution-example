package com.derpderphurr;

import com.example.sub.GarageType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;

public class Example {
    public static void main(String[] args) {
        InputStream is = Example.class.getClassLoader().getResourceAsStream("/MyGarage.xml");
        StreamSource ss = new StreamSource(is);
        JAXBContext ctx = null;
        try {
            ctx = JAXBContext.newInstance("com.example.sub");
            JAXBElement<GarageType> garage =  ctx.createUnmarshaller().unmarshal(ss, GarageType.class);
            garage.getValue().getvehicle().stream().forEach(v -> System.out.printf("Vechicle %s\n",v.getModel()));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
