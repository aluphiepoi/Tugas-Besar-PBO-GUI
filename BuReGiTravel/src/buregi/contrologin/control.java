
package buregi.contrologin;

import buregi.model.data_login;

public class control {
    boolean succes = false;
    data_login contrologin = new data_login();

    public boolean login(String user, String pass) {
        if (contrologin.masuk(user, pass)) {
            succes = true;
            System.out.println("clogin berhasil");
        }
        return succes;
    }
}
