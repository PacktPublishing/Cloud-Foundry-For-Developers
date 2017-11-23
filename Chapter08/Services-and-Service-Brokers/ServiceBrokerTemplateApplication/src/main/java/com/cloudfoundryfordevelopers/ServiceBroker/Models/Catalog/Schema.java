package com.cloudfoundryfordevelopers.ServiceBroker.Models.Catalog;

public class Schema
{
    public interface SchemaObject
    {
        // Needs to be user defined. 
        // Classes should inherit this and create their own private fields.
    }
    public class ServiceInstance
    {
        private SchemaObject create;
        private SchemaObject update;

        public ServiceInstance(SchemaObject create, SchemaObject update)
        {
            this.create = create;
            this.update = update;
        }
    }
    public class ServiceBinding
    {
        private SchemaObject create;
        public ServiceBinding(SchemaObject create)
        {
            this.create = create;
        }
    }

    private ServiceBinding  service_binding;
    private ServiceInstance service_instance;
    public Schema(SchemaObject si_create, SchemaObject si_update, SchemaObject sb_create)
    {
        service_instance = new ServiceInstance(si_create, si_update);
        service_binding = new ServiceBinding(sb_create);
    }
}