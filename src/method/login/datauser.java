/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method.login;

/**
 *
 * @author Alvin Y
 */
public class datauser {

    String username, password, hak_akses;

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String gethak_akses() {
        return hak_akses;
    }

    public void sethak_akses(String hak_akses) {
        this.hak_akses = hak_akses;
    }

    int id_user;

    public int getid_user() {
        return id_user;
    }

    public void setid_user(int id_user) {
        this.id_user = id_user;
    }
}
