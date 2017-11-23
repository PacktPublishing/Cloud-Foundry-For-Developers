package com.cloudfoundryfordevelopers.ServiceBroker.Models.Catalog;

public class Plan
{
    private String id;
    private String name;
    private String description;
    private Metadata metadata;
    private boolean free;
    // private boolean bindable;    // Excluded here to allow Service to take precedence. 
                                    // However to enable, suggested route is to inherit Plan class
                                    // and add this field in.
    private Schema[] schemas;

    public Plan(String id, String name, String description, Metadata metadata,
                Boolean free, Schema[] schemas)
                {
                    this.id = id;
                    this.name = name;
                    this.description = description;
                    this.metadata = metadata;
                    this.free = free;
                    this.schemas = schemas;
                }

    public Plan(String id, String name, String description)
                {
                    this.id = id;
                    this.name = name;
                    this.description = description;
                    this.free = true;
                    this.metadata = null;
                    this.schemas = null;;
                }
}