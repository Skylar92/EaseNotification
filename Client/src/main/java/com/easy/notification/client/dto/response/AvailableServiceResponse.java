package com.easy.notification.client.dto.response;

import com.easy.notification.core.bean.Service;

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

    public AvailableServiceResponse addService(Service service) {
        this.services.add(service);
        return this;
    }

    public AvailableServiceResponse addAllService(List<Service> services) {
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

}
