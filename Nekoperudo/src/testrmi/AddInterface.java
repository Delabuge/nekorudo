/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Pascal
 */
public interface AddInterface extends Remote {
    public Integer add(Integer nb1, Integer nb2) throws RemoteException;
}
