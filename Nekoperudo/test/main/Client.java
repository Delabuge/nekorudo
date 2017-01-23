/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import micrormi.Registry;
import service.AddInterface;

/**
 *
 * @author Pascal
 */
public class Client {
    public static void main(String[] argv) {
        Registry r = new Registry().connect("localhost", 10000);
        Registry r1 = new Registry().connect("STRI-PC", 12345);
        AddInterface cs = r.get("Add", AddInterface.class);
        AddInterface cs1 = r.get("Add", AddInterface.class);
        System.out.println(cs.add(2, 3));
        System.out.println(cs1.add(2, 3));
        
    }
}
