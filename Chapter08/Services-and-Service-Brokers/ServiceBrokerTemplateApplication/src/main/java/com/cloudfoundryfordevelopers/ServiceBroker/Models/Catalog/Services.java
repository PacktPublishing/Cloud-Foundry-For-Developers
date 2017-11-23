package com.cloudfoundryfordevelopers.ServiceBroker.Models.Catalog;

// Describes an array of services
public class Services 
{
    private Service[] services;
    public Services(Service[] services)
    {
        this.services = services;
    }
}