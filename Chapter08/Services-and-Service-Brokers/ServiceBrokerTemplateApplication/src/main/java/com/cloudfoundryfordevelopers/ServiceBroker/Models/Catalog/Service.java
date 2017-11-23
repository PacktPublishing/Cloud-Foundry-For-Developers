package com.cloudfoundryfordevelopers.ServiceBroker.Models.Catalog;

public class Service 
{
    private String          id;
    private String          name;
    private String          description;
    private String[]        tags;
    private String[]        requires;
    private boolean         bindable;
    private Metadata        metadata;
    private Plan[]          plans;
    private DashboardClient dashboard_client;
    private boolean         plan_updateable;

    // Full Dataset for a service
    public Service( String id, String name, String description,
                    String[] tags, String[] requires, boolean isBindable, 
                    Metadata metadata, Plan[] plans, DashboardClient dashboardClient, boolean isPlanUpdateable
                    ) 
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.requires = requires;
        this.bindable = isBindable;
        this.metadata = metadata;
        this.plans = plans;
        this.dashboard_client = dashboardClient;
        this.plan_updateable = isPlanUpdateable;
    }

    // Minimum data required for a service
    public Service( String id, String name, String description,
                    boolean isBindable, Plan[] plans
                    ) 
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.bindable = isBindable;
        this.plans = plans;
        this.metadata = null;
        this.tags = null;
        this.requires = null;
        this.dashboard_client = null;
        this.plan_updateable = false;
    }

}



