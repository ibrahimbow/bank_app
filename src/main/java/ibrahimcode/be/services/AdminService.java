package ibrahimcode.be.services;

import ibrahimcode.be.models.Admin;

public interface AdminService {

    void addAdmin(Admin admin);
    boolean checkAdminLogin(String username, String password);
}
