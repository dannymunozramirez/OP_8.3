package com.ibm.openpages.triggers.handler;

import com.ibm.openpages.api.resource.IGRCObject;
import com.ibm.openpages.api.trigger.events.UpdateResourceEvent;
import com.ibm.openpages.api.trigger.ext.DefaultEventHandler;

/**
 * <p>
 * This Handler Class will perform a setDescription action
 * when an update event occur in the system
 * </p>
 *
 * @author dannymunoz on 2023-04-17
 * @project triggerConfiguration
 */
public class UpdateDescriptionHandler extends DefaultEventHandler {
    @Override
    public boolean handleEvent(UpdateResourceEvent event) {

        try {

            // TODO
            //  Add validations

            System.out.println("---- STARTING UpdateDescriptionHandler ---- ");
            // Getting IGRC Object from the event
            IGRCObject resource = (IGRCObject) event.getResource();

            // Setting Description field
            resource.setDescription("Testing Trigger From Backend");
            System.out.println("---- FINISH UpdateDescriptionHandler ---- ");
            return true;

        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }

        System.out.println("---- FINISH UpdateDescriptionHandler => NOT UPDATED ---- ");
        return true;
    }
}
