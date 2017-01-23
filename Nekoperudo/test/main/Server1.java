/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import micrormi.Registry;
import service.impl.AddImpl;
/**
 *
 * @author Pascal
 */
public class Server1 {
    public static void main(String[] argv) {
        new Registry()
                .register("Add", new AddImpl())
                .publish(10000);
    }
}