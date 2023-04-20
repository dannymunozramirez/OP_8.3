package com.ibm.openpages.triggers.rule;

import com.ibm.openpages.api.resource.IGRCObject;
import com.ibm.openpages.api.trigger.events.UpdateResourceEvent;
import com.ibm.openpages.api.trigger.ext.DefaultRule;

/**
 * <p>
 * For any Updating IKI_dm_COTask object, this Rule Class will be executed
 * if returns true it will trigger a Handler Class to perform a setDescription()
 * and create an Object
 * </p>
 *
 * @author dannymunoz on 2023-04-18
 * @project triggerConfiguration
 */
public class CreateObjectRule extends DefaultRule {

    @Override
    public boolean isApplicable(UpdateResourceEvent event) {

        System.out.println("STARTED ---- CreateObjectRule");
        IGRCObject resource = (IGRCObject) event.getResource();

        System.out.println(resource.getName() + " -----Checking the name to compare");

        // Log
        System.out.println(" Does this object match the name with IKI_dm_COTask?" + resource.getName().equals("Asia"));


        System.out.println("FINISHED ---- UpdateDescriptionRule");
        return !resource.isFolder() && resource.getName().equals("Asia");
    }

}
