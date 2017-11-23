package com.cloudfoundryfordevelopers.ServiceBroker.Models.BrokerError;

// Used for Error conditions. This class must be returned with HTTP Error Status Conditions.
public class BrokerError
{
    private String description;

    public BrokerError(String description)
    {
        this.description = description;
    }
}

