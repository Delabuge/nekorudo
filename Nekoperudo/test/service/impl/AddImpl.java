/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import service.AddInterface;

/**
 *
 * @author Pascal
 */
public class AddImpl implements AddInterface {
    public Integer add(Integer nb1, Integer nb2) {
        return nb1 + nb2;
    }
}
