package com.ibm.openpages.triggers.handler;

import com.ibm.openpages.api.Context;
import com.ibm.openpages.api.metadata.ITypeDefinition;
import com.ibm.openpages.api.resource.IGRCObject;
import com.ibm.openpages.api.resource.IResource;
import com.ibm.openpages.api.resource.IResourceFactory;
import com.ibm.openpages.api.service.IMetaDataService;
import com.ibm.openpages.api.service.IResourceService;
import com.ibm.openpages.api.service.IServiceFactory;
import com.ibm.openpages.api.service.ServiceFactory;
import com.ibm.openpages.api.trigger.events.UpdateResourceEvent;
import com.ibm.openpages.api.trigger.ext.DefaultEventHandler;

/**
 * <p>
 * This Handler Class will create a Model Object, Associate and setDescription
 * when an update event occur in the Asia Object
 * </p>
 *
 * @author dannymunoz on 2023-04-18
 * @project triggerConfiguration
 */
public class CreateObjectHandler extends DefaultEventHandler {
    @Override
    public boolean handleEvent(UpdateResourceEvent event) {

        try {

            System.out.println("---- STARTING CreateObjectHandler ---- ");

            // Get current Updated Object Asia
            System.out.println("Get current Updated Object Asia Object");
            //TODO change variable name to AsiaObject and rebuild
            IResource AsiaObject = (IGRCObject) event.getResource();

            // CREATING Model Child of Asia Object
            System.out.println("CREATING Model Child of Asia Object");
            Context context = event.getContext();

            // Create Resource Service
            System.out.println("Create Resource Service");
            IServiceFactory serviceFactory = ServiceFactory.getServiceFactory(context);

            // Create Resource Service
            System.out.println("Create Resource Service");
            IResourceService iResourceService = serviceFactory.createResourceService();
            // Create MetaDate Service
            System.out.println("Create MetaDate Service");
            IMetaDataService iMetaDataService = serviceFactory.createMetaDataService();

            // Get the Resource Factory
            System.out.println("Get the Resource Factory");
            IResourceFactory iResourceFactory = iResourceService.getResourceFactory();

            // Get the type Definition of the Object that is being created - Child of Model
            // In fact this Model will be a child of SOXBusEntity Object
            System.out.println("Get the type Definition of the Object that is being created - Child of Model" +
                    "In fact this Model will be a child of SOXBusEntity Object");
            ITypeDefinition objectTypeDef = iMetaDataService.getType("Model");

            // Create AutoNamed Child Object - AUTO NAMED SETTING HAVE TO BE TRUE
            System.out.println("Create AutoNamed Child Object - AUTO NAMED SETTING HAVE TO BE TRUE");
            IGRCObject newObject = iResourceFactory.createAutoNamedGRCObject(objectTypeDef);

            //Set Description in new object
            System.out.println("Set Description in new object");
            newObject.setDescription("Model - CREATED FROM BACKEND - CHILD OF SOXBusEntity");

            //Set Parent Association
            System.out.println("Set Parent Association");
            newObject.setPrimaryParent(AsiaObject.getId());

            //Create the Object
            System.out.println("Create the Object");
            iResourceService.saveResource(newObject);

            // Setting Description field
            System.out.println("Setting Description field");
            AsiaObject.setDescription("Updated - Check new Association with MODEL Object - DM");

            System.out.println("---- FINISH CreateObjectHandler ---- ");
            return true;

        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }

        System.out.println("---- FINISH CreateObjectHandler => NOT CREATED ---- ");
        return true;
    }
}
