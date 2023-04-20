package com.ibm.openpages.triggers.handler;

import com.ibm.openpages.api.resource.IGRCObject;
import com.ibm.openpages.api.trigger.events.UpdateResourceEvent;
import com.ibm.openpages.api.trigger.ext.DefaultEventHandler;

/**
 * @author dannymunoz on 2023-04-14
 * @project CustomActions
 */
public class IssueUpdateTriggerHandler extends DefaultEventHandler {

    @Override
    public boolean handleEvent(UpdateResourceEvent event) {

        // Getting the object
        IGRCObject resource = (IGRCObject) event.getResource();

        if (resource.getDescription().contains("DM")) {
            resource.setDescription("Testing Trigger --- ");
        } else {
            resource.setDescription("Rien à faire");
        }

        return true;
    }
}
