package ibrahimcode.be.services;

import ibrahimcode.be.models.Admin;

public interface AdminService {

    public void addAdmin(Admin admin);
    public boolean checkAdminLogin(String username, String password);
}
