/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrmi;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Pascal
 */
public class Server {
    public static void main(String[] argv) {
        try {
        	// 10000 est le port sur lequel sera publié le service. Nous devons le préciser à la fois sur le registry et à la fois à la création du stub.
            AddInterface skeleton = (AddInterface) UnicastRemoteObject.exportObject(new AddImpl(), 10000); // Génère un stub vers notre service.
            Registry registry = LocateRegistry.createRegistry(10000);
            registry.rebind("Add", skeleton); // publie notre instance sous le nom "Add"
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}