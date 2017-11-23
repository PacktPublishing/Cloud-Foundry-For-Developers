package com.cloudfoundryfordevelopers.ServiceBroker.Models.Catalog;

public class Metadata 
{
    private String displayName;
    private String imageUrl;
    private String longDescription;
    private String documentationUrl;
    private String supportUrl;

    public Metadata(String displayName, String imageUrl, String longDescription, 
                    String documentationUrl, String supportUrl)
    {
        this.displayName = displayName;
        this.imageUrl = imageUrl;
        this.longDescription = longDescription;
        this.documentationUrl = documentationUrl;
        this.supportUrl = supportUrl;
    }

}