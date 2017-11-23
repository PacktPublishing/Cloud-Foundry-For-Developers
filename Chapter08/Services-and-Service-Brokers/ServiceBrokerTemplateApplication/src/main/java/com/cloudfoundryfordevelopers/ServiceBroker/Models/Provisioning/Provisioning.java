package com.cloudfoundryfordevelopers.ServiceBroker.Models.Provisioning;

public class Provisioning
{
    private String dashboard_url;
    private String operation;

    public Provisioning(String dashboardUrl, String operation)
    {
        this.dashboard_url = dashboardUrl;
        this.operation = operation;
    }
}