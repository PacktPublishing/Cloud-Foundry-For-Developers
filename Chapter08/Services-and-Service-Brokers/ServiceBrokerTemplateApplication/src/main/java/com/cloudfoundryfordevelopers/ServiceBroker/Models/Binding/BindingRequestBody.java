package com.cloudfoundryfordevelopers.ServiceBroker.Models.Binding;

import com.google.gson.JsonObject;

public class BindingRequestBody
{
    public class BindResource
    {
        public String app_guide;
        public String route;
    }
    public JsonObject context;
    public String service_id;
    public String plan_id;
    public String app_guid;
    public BindResource bind_resource;
    public JsonObject parameters;
}