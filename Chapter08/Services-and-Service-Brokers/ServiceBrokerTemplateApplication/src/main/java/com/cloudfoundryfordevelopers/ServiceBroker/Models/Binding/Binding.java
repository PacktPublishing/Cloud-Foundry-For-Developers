package com.cloudfoundryfordevelopers.ServiceBroker.Models.Binding;

import com.google.gson.JsonObject;

public class Binding
{
    public class VolumeDevice
    {
        private String volume_id;
        private JsonObject mount_config;

        public VolumeDevice(String volumeId, JsonObject mountConfig)
        {
            this.volume_id = volumeId;
            this.mount_config = mountConfig;
        }
    }

    public class VolumeMount
    {
        private String driver;
        private String container_dir;
        private String mode;
        private String device_type;
        private VolumeDevice device;

        public VolumeMount(String driver, String containerDir, String mode, String deviceType ,VolumeDevice device)
        {
            this.driver = driver;
            this.container_dir = containerDir;
            this.mode = mode;
            this.device_type = deviceType;
            this.device = device;
        }
    }

    private JsonObject credentials;
    private String syslog_drain_url;
    private String route_service_url;
    private VolumeMount[] volume_mounts;

    // Please refer to the OSB Api Specification.  Be aware that it is possible and necessary to set some of 
    // these parameters to null, if they are not in use! 
    public Binding(JsonObject credentials, String syslogDrainUrl, String routeServiceUrl, VolumeMount[] volumeMounts)
    {
        this.credentials = credentials;
        this.syslog_drain_url = syslogDrainUrl;
        this.route_service_url = routeServiceUrl;
        this.volume_mounts = volumeMounts;
    }
}