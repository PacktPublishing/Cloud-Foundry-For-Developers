package com.cloudfoundryfordevelopers.ServiceBroker.Controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cloudfoundryfordevelopers.ServiceBroker.Models.Binding.*;
import com.cloudfoundryfordevelopers.ServiceBroker.Models.Catalog.*;
import com.cloudfoundryfordevelopers.ServiceBroker.Models.Deprovisioning.*;
import com.cloudfoundryfordevelopers.ServiceBroker.Models.LastOperation.*;
import com.cloudfoundryfordevelopers.ServiceBroker.Models.Provisioning.*;
import com.cloudfoundryfordevelopers.ServiceBroker.Models.Update.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@RestController
public class ServiceBrokerController {

    Log log = LogFactory.getLog(ServiceBrokerController.class);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @RequestMapping(value="/v2/catalog", method=RequestMethod.GET)
    public ResponseEntity<String> catalog(
                @RequestHeader(value="X-Broker-API-Version") String osbVersion
            ) 
    {
        log.info("Performing Catalog:");
        log.info("OsbVersion is " + osbVersion);

        // Create a dummy service
        Services services = new Services(
            new Service[]{
                new Service(/* service id = */"acb56d7c-XXXX-XXXX-XXXX-feb140a59a66", 
                            /* name = */"My-Service", 
                            /* description = */"MyService Plan", 
                            /* tags= */new String[]{"cloudfoundryfordevelopers","dummy"},
                            /* requires = */new String[]{},
                            /* bindable = */true, 
                            /* metadata = */new Metadata("My-Service", "www.image.com", "some dummy service", "www.docs.com", "www.support.com"),
                            /* plans = */new Plan[] {
                                                        new Plan("plan1234", "servicePlan", "ServicePlan Description")
                                                    },
                            /* dashboard_client = */null,
                            /* updateable = */true
                            ),
                new Service(/* service id = */"acb56d7c-XXXX-XXXX-XXXX-feb140a59a67", 
                            /* name = */"My-Service2", 
                            /* description = */"MyService2 Plan", 
                            /* tags= */new String[]{"cloudfoundryfordevelopers","dummy"},
                            /* requires = */new String[]{},
                            /* bindable = */true, 
                            /* metadata = */new Metadata("My-Service2", "www.image.com", "some dummy service", "www.docs.com", "www.support.com"),
                            /* plans = */new Plan[] {
                                                        new Plan("plan5678", "servicePlanA", "ServicePlan Description"),
                                                        new Plan("plan1012", "servicePlanB", "ServicePlan Description")
                                                    },
                            /* dashboard_client = */null,
                            /* updateable = */true
                            ),           
            }
            );

        return new ResponseEntity<String>(gson.toJson(services), HttpStatus.OK);
    }   
    
    @RequestMapping(value="/v2/service_instances/{instance_id}/last_operation", method=RequestMethod.GET)
    public ResponseEntity<String> lastOperation(
                @RequestHeader(value="X-Broker-API-Version")        String osbVersion,
                @PathVariable("instance_id")                        String instanceId,
                @RequestParam(value="service_id", required=false)   String serviceId,
                @RequestParam(value="plan_id", required=false)      String planId,
                @RequestParam(value="operation", required=false)    String operation
            ) 
    {
        log.info("Performing Last Operation:");
        log.info("OsbVersion is " + osbVersion);
        log.info("Instance id is " + instanceId);
        log.info("Service id is " + serviceId);
        log.info("Plan id is " + planId);
        log.info("Operation is " + operation);
        
        
        // Need to add code here to determine the right response
        LastOperationStatus status = new LastOperationStatus(State.in_progress.toString(), operation + " in progress");

        return new ResponseEntity<String>(gson.toJson(status), HttpStatus.OK);
    }

    @RequestMapping(value = "/v2/service_instances/{instance_id}", method = RequestMethod.PUT)
    public ResponseEntity<String> provisioning(
                @RequestHeader(value="X-Broker-API-Version")    String  osbVersion,
                @RequestHeader(value="X-Broker-API-Originating-Identity", required=false)    String originatingIdentity,
                @PathVariable("instance_id")                    String  instanceId,
                @RequestParam(value="accepts_incomplete", required=false)   Boolean acceptsIncomplete,
                @RequestBody                                    String  requestBody
            ) 
    {
        log.info("Performing Provisioning:");
        log.info("OsbVersion is " + osbVersion);
        log.info("OriginatingIdentity is " + originatingIdentity);
        log.info("Instance id is " + instanceId);
        log.info("acceptsIncomplete state is " + acceptsIncomplete);
        log.info("Request Body is " + requestBody);

        ProvisioningRequestBody provisioningRequestBody = gson.fromJson(requestBody, ProvisioningRequestBody.class);

        log.info(provisioningRequestBody);

        Provisioning provisioning = new Provisioning("", "Provisioning Description");
        return new ResponseEntity<>(gson.toJson(provisioning), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/v2/service_instances/{instance_id}", method = RequestMethod.PATCH)
    public ResponseEntity<String> update(
                @RequestHeader(value="X-Broker-API-Version")    String  osbVersion,
                @RequestHeader(value="X-Broker-API-Originating-Identity", required=false)    String originatingIdentity,
                @PathVariable("instance_id")                    String  instanceId,
                @RequestParam(value="accepts_incomplete", required=false)   Boolean acceptsIncomplete,
                @RequestBody                                    String  requestBody
            ) 
    {
        log.info("Performing Update:");
        log.info("OsbVersion is " + osbVersion);
        log.info("OriginatingIdentity is " + originatingIdentity);
        log.info("Instance id is " + instanceId);
        log.info("acceptsIncomplete state is " + acceptsIncomplete);
        log.info("Request Body is " + requestBody);

        UpdateRequestBody updateRequestBody = gson.fromJson(requestBody, UpdateRequestBody.class);

        log.info(updateRequestBody);

        Update update = new Update("special operation");
        return new ResponseEntity<>(gson.toJson(update), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/v2/service_instances/{instance_id}/service_bindings/{binding_id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> binding(  
            @RequestHeader(value="X-Broker-API-Version")    String  osbVersion,
            @RequestHeader(value="X-Broker-API-Originating-Identity", required=false)    String originatingIdentity,    
            @PathVariable("instance_id")    String instanceId,
            @PathVariable("binding_id")     String bindingId,
            @RequestBody                    String requestBody) 
                                                
    {
        log.info("Performing Binding:");
        log.info("OsbVersion is " + osbVersion);
        log.info("OriginatingIdentity is " + originatingIdentity);
        log.info("Instance id is " + instanceId);
        log.info("Binding id  is " + bindingId);
        log.info("Request Body is " + requestBody);

        BindingRequestBody bindingRequestBody = gson.fromJson(requestBody, BindingRequestBody.class);

        log.info(bindingRequestBody);

        // Let's assume we're binding only with credentials
        JsonObject credentialsTest = new JsonObject();
        credentialsTest.addProperty("UserName", "abcd1234567899");
        credentialsTest.addProperty("Password", "oerh.oiwGH3pibhVF");
        credentialsTest.addProperty("Host", "http://my.own.resource");

        Binding binding = new Binding(credentialsTest, null, null, null);
        return new ResponseEntity<>(gson.toJson(binding), HttpStatus.OK);
    }

    @RequestMapping(value = "/v2/service_instances/{instance_id}/service_bindings/{binding_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> unbinding(  
            @RequestHeader(value="X-Broker-API-Version")    String  osbVersion,
            @RequestHeader(value="X-Broker-API-Originating-Identity", required=false)    String originatingIdentity,    
            @PathVariable("instance_id")    String instanceId,
            @PathVariable("binding_id")     String bindingId,
            @RequestParam("service_id")     String serviceId,
            @RequestParam("plan_id")        String planId,
            @RequestBody(required=false)    String requestBody) 
                                                
    {
        log.info("Performing Unbinding:");
        log.info("OsbVersion is " + osbVersion);
        log.info("OriginatingIdentity is " + originatingIdentity);
        log.info("Instance id is " + instanceId);
        log.info("Binding id  is " + bindingId);
        log.info("Service id  is " + serviceId);
        log.info("Plan id  is " + planId);
        log.info("Request Body is " + requestBody);

        // As of v2.13 there are no request or response body yet. Need to return "{}" instead.
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @RequestMapping(value = "/v2/service_instances/{instance_id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deprovisioning(
                @RequestHeader(value="X-Broker-API-Version")                String  osbVersion,
                @RequestHeader(value="X-Broker-API-Originating-Identity", required=false)    String originatingIdentity,
                @PathVariable("instance_id")                                String  instanceId,
                @RequestParam(value ="accepts_incomplete", required = false)    Boolean acceptsIncomplete,
                @RequestParam("service_id")          String serviceId,
                @RequestParam("plan_id")             String planId,
                @RequestBody(required=false)         String requestBody
            ) 
    {
        log.info("Performing Deprovisioning:");
        log.info("OsbVersion is " + osbVersion);
        log.info("OriginatingIdentity is " + originatingIdentity);
        log.info("Instance id is " + instanceId);
        log.info("acceptsIncomplete state is " + acceptsIncomplete);
        log.info("Service id  is " + serviceId);
        log.info("Plan id  is " + planId);
        log.info("Request Body is " + requestBody);

        Deprovisioning deprovisioning = new Deprovisioning("Deprovisioning Operation");
        return new ResponseEntity<>(gson.toJson(deprovisioning), HttpStatus.OK);
    }
}