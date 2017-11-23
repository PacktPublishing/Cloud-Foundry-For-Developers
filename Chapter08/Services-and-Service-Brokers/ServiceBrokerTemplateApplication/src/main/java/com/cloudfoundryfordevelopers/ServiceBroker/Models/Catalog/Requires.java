package com.cloudfoundryfordevelopers.ServiceBroker.Models.Catalog;

// Service Requires enum
public enum Requires
{
    syslog_drain("syslog_drain"),
    route_forwarding("route_forwarding"),
    volume_mount("volume_mount")
    ;
    private final String text;
    private Requires(final String text) { this.text = text; }
    @Override public String toString() { return text; }
}