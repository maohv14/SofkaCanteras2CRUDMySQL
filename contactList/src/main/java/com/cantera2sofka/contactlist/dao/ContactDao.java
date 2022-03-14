package com.cantera2sofka.contactlist.dao;

import com.cantera2sofka.contactlist.domain.ContactList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Interfaz del DAO
 */


public interface ContactDao extends CrudRepository<ContactList, Long> {
    @Modifying
    @Query("update ContactList cont set cont.name = :name where cont.id = :id")
    public void updateName(@Param(value = "id") Long id,
                           @Param(value = "name") String name);

    @Modifying
    @Query("update ContactList cont set cont.phoneNumber = :phoneNumber where cont.id = :id")
    public void updatePhoneNumber(@Param(value = "id") Long id,
                           @Param(value = "phoneNumber") String phoneNumber);

    @Modifying
    @Query("update ContactList cont set cont.email = :email where cont.id = :id")
    public void updateEmail(@Param(value = "id") Long id,
                               @Param(value = "email") String email);

    @Modifying
    @Query("update ContactList cont set cont.bornAt = :bornAt where cont.id = :id")
    public void updateBornAt(@Param(value = "id") Long id,
                             @Param(value = "bornAt") String bornAt);

    @Modifying
    @Query("update ContactList cont set cont.deleteAt = :deleteAt  where cont.id = :id")
    public void updateDeleteAt(@Param(value = "id") Long id,
                             @Param(value = "deleteAt") String deleteAt);

}
