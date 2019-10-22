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
    void update(String tab, String id, String clmn, String val);
    void delete(String tab);
    void SelectCooker();
    void SelectClient();
}
