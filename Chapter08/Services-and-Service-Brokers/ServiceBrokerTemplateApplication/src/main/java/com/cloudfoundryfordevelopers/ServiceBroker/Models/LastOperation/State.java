package com.cloudfoundryfordevelopers.ServiceBroker.Models.LastOperation;

public enum State
{
    in_progress("in progress"),
    succeeded("succeeded"),
    failed("failed")
    ;
    private final String text;
    private State(final String text) { this.text = text; }
    @Override public String toString() { return text; }
}