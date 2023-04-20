package com.ibm.openpages.triggers.rule;

import com.ibm.openpages.api.resource.IResource;
import com.ibm.openpages.api.trigger.events.UpdateResourceEvent;
import com.ibm.openpages.api.trigger.ext.DefaultRule;

/**
 * <p>
 * This rule will eveluate a specific field within a Issue in order to trigger
 * a Handler Class
 * </p>
 *
 * @author dannymunoz on 2023-04-14
 * @project CustomActions
 */
public class IssueUpdateTriggerRule extends DefaultRule {

    /**
     * <p>
     * This is the principal method for Rule class, is where I have to
     * Write all conditions for this trigger
     * </p>
     *
     * @param event
     * @return
     */
    @Override
    public boolean isApplicable(UpdateResourceEvent event) {

        // Method level variables
        Boolean isApplicable = false;
        IResource resource = null;

        // Method implementation
        System.out.println("Start Rule Class -- IssueUpdateTriggerRule");
        try {

            /**
             * <p>
             *     This evaluation is checking that the resourse IGRCObject
             *     is not a folder, if so it will return true
             * </p>
             */
            resource = event.getResource();
            isApplicable = !resource.isFolder();

            return isApplicable;

        } catch (Exception e) {
            System.out.println("Exception: " + e);

        }
        return super.isApplicable(event);
    }
}
