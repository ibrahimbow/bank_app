package ibrahimcode.be.services.implementation;

import ibrahimcode.be.data.AdminDao;
import ibrahimcode.be.models.Admin;
import ibrahimcode.be.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceImpl implements AdminService {


    private AdminDao adminDaoImpl;

    @Autowired
    public void setAdminDaoImpl(AdminDao adminDaoImpl) {
        this.adminDaoImpl = adminDaoImpl;
    }


    @Override
    public void addAdmin(Admin admin) {
        this.adminDaoImpl.addAdmin(admin);
    }

    @Override
    public boolean checkAdminLogin(String username, String password) {
        return this.adminDaoImpl.checkAdminLogin(username,password);
    }
}
