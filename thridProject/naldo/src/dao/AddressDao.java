package dao;

import domain.Address;

/**
 * @auther:houkexin
 * @date: 2018/8/1
 * @description:
 * @version: 1.0
 */
public interface AddressDao {
    public boolean add(Address address);
    public boolean update(Address address);
    public Address queryById(int id);
}
