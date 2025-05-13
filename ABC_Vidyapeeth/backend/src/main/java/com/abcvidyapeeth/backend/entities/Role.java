package com.abcvidyapeeth.backend.entities;

public enum Role {
	ADMIN("admin"), STUDENT("student"), TEACHER("teacher"), PRINCIPAL("principal");

    private String roleName;

    private Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
