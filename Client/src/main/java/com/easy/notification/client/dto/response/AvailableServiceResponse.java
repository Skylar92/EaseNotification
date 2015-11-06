package com.easy.notification.client.dto.response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by skylar on 06.11.15.
 */
public class AvailableServiceResponse extends Response {

    private Set<Service> services = new HashSet<>();

    protected AvailableServiceResponse(Status status, String message) {
        super(status, message);
    }

    public static AvailableServiceResponse createServiceResponse() {
        return new AvailableServiceResponse(Status.OK, null);
    }

    public AvailableServiceResponse addService(AvailableServiceResponse.Service service) {
        this.services.add(service);
        return this;
    }

    public AvailableServiceResponse addAllService(List<AvailableServiceResponse.Service> services) {
        this.services.addAll(services);
        return this;
    }

    public Set<Service> getServices() {
        return services;
    }

    @Override
    public String toString() {
        return "AvailableServiceResponse{" +
                "services=" + services +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AvailableServiceResponse that = (AvailableServiceResponse) o;

        return !(services != null ? !services.equals(that.services) : that.services != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (services != null ? services.hashCode() : 0);
        return result;
    }

    public static class Service {

        private String name;
        private String site;
        private String description;

        public Service(String name, String site, String description) {
            this.name = name;
            this.site = site;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "Service{" +
                    "name='" + name + '\'' +
                    ", site='" + site + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Service service = (Service) o;

            if (name != null ? !name.equals(service.name) : service.name != null) return false;
            if (site != null ? !site.equals(service.site) : service.site != null) return false;
            return !(description != null ? !description.equals(service.description) : service.description != null);

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (site != null ? site.hashCode() : 0);
            result = 31 * result + (description != null ? description.hashCode() : 0);
            return result;
        }
    }


}
