package com.cloudfoundryfordevelopers.ServiceBroker.Models.Update;

import com.google.gson.JsonObject;

public class UpdateRequestBody
{
    public class PreviousValues
    {
       public String service_id;
       public String plan_id;
       public String organization_id;
    }

    public JsonObject context;
    public String service_id;
    public String plan_id;
    public JsonObject parameters;
    public PreviousValues previous_values;
}