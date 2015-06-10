package com.eb.warehouse.io.pcx;

import com.eb.warehouse.io.pcx.message.*;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Configures JAXB to be the marshaller for PCX message instances.
 */
final class JaxbPcxMessageMarshallerModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    JAXBContext bindJaxbClasses() throws JAXBException {
        Class<?>[] classesToBeBound = { //
                Action.class, //
                Announce.class, //
                IoChange.class, //
                Life.class, //
                Query.class, //
                Remove.class, //
                Response.class, //
                Request.class, //
                Status.class, //
        };

        return JAXBContext.newInstance(classesToBeBound);
    }

    @Provides
    Marshaller createMarshaller(JAXBContext cxt) throws JAXBException {
        //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        return cxt.createMarshaller();
    }

    @Provides
    Unmarshaller createUnmarshaller(JAXBContext cxt) throws JAXBException {
        return cxt.createUnmarshaller();
    }
}
