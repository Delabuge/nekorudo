/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.IfJoueur;

import java.rmi.Naming;

/**
 *
 * @author Rémi
 */
public class MainJoueur {

    public static void main(String[] argv) throws Exception {

        Nekoperudo proxy = (Nekoperudo) Naming.lookup("MJ");
        //proxy.letest("je suis un test");

        JoueurNotificationImpl jni = new JoueurNotificationImpl("Bob");
        proxy.enregistrerNotification("Bob", jni);
        jni.test("Bob");

        jni = null;
        //  proxy.enleverNotification("Bob");

        /*
        

        bni = null;*/
    }

}
