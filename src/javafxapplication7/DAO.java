/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

/**
 *
 * @author test
 */
public interface DAO<T> {
    boolean create(T obj);
    boolean update(T obj1, T obj2);
    boolean search();
    boolean delete(T obj);
}
