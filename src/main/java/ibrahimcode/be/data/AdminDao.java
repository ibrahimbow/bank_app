package ibrahimcode.be.data;

import ibrahimcode.be.models.Admin;

public interface AdminDao {

    void addAdmin(Admin admin);
    boolean checkAdminLogin(String userName, String password);
}
