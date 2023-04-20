package com.ibm.openpages.custom.actions;

import com.ibm.openpages.api.resource.IGRCObject;
import com.ibm.openpages.api.workflow.actions.AbstractCustomAction;
import com.ibm.openpages.api.workflow.actions.IWFCustomProperty;
import com.ibm.openpages.api.workflow.actions.IWFOperationContext;

import java.util.List;

/**
 * <p>
 * This CUSTOM ACTION is performing an data input int a ISSUE Object
 * </p>
 *
 * @author dannymunoz on 2023-04-13
 * @project CustomActions
 */
public class InsertDataDescriptionField extends AbstractCustomAction {


    /**
     * <p>
     * This constructor will get the workflow context
     * </p>
     *
     * @param context
     * @param properties
     */
    public InsertDataDescriptionField(IWFOperationContext context, List<IWFCustomProperty> properties) {
        super(context, properties);
    }

    /**
     * <p>
     * This process method will perform the custom action
     * </p>
     *
     * @throws Exception
     */
    @Override
    protected void process() throws Exception {
        try {

            // Logs
            System.out.println("Starting process ----------");

            /*
              <p>
                1. Starting getting IGRCObject from the implicit method getContext()
                   In this case it will take SOXIssue Object
              </p>
             */
            IGRCObject igrcObject = getContext().getResource();

            /*
              THIS getPropertyValue() method will get properties values
              defined in the workflow action
             */
            getPropertyValue("Test");
            // Logs
            System.out.println("Setting Data to Description field ---------- Description ");
            igrcObject.setDescription("TESTING DATA FOR CUSTOM ACTION - 13 AVRIL 2023");

        } catch (Exception e) {

            System.out.println("EXCEPTION " + e);
        }
    }
}
