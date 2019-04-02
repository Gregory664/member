package ru.src.logic.factory;

import ru.src.logic.dto.Organizations;

public class OrganizationFactory {
    private static Organizations organizations;

    public static Organizations getOrganization() {
        if(organizations == null) {
            organizations = new Organizations();
        }
        return organizations;
    }
}
