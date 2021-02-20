package ibrahimcode.be.data.implementation;

import ibrahimcode.be.data.AdminDao;
import ibrahimcode.be.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminDaoImpl implements AdminDao {


    private Admin admin;

    @Override
    public void addAdmin(Admin admin) {
        this.admin = new Admin();
        this.admin = admin;
    }

    @Override
    public boolean checkAdminLogin(String userName, String password) {
        if(admin.getUsername().equals(userName) && admin.getPassword().equals(password)){
            return true;
        }else {
            return false;
        }
    }

}
