package com.cloudfoundryfordevelopers.ServiceBroker.Models.Catalog;

public class DashboardClient
{
    private String id;
    private String secret;
    private String redirect_uri;

    public DashboardClient(String id, String secret, String redirect_uri)
    {
        this.id = id;
        this.secret = secret;
        this.redirect_uri = redirect_uri;
    }
}