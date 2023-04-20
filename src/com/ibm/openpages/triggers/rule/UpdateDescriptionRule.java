package com.ibm.openpages.triggers.rule;

import com.ibm.openpages.api.resource.IGRCObject;
import com.ibm.openpages.api.trigger.events.UpdateResourceEvent;
import com.ibm.openpages.api.trigger.ext.DefaultRule;

/**
 * <p>
 * For any Update event in the system, this Rule Class will be executed
 * if returns true it will trigger a handler class to perform a setDescription()
 * </p>
 *
 * @author dannymunoz on 2023-04-17
 * @project triggerConfiguratio
 */
public class UpdateDescriptionRule extends DefaultRule {

    @Override
    public boolean isApplicable(UpdateResourceEvent event) {

        System.out.println("STARTED ---- UpdateDescriptionRule");
        IGRCObject resource = (IGRCObject) event.getResource();
        System.out.println("FINISHED ---- UpdateDescriptionRule");
        return !resource.isFolder();

    }
}
