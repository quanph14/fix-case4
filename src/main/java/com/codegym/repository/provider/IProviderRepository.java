package com.codegym.repository.provider;

import com.codegym.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface IProviderRepository extends JpaRepository<Provider, Long> {
    @Query(nativeQuery = true, value = "select * from provider where name like :name;")
    Iterable<Provider>findAllByFullName(@Param("name") String name);
    @Query(nativeQuery = true,value = "select * from provider where gender = 'nu' order by has_been_hired DESC limit 8;")
    Iterable<Provider> getProviderByHasBeenHired8female();
    @Query(nativeQuery = true,value = "select * from provider where gender = 'nam' order by has_been_hired DESC limit 4;")
    Iterable<Provider> getProviderByHasBeenHired4male();
    @Query(nativeQuery = true,value = "select * from provider order by view DESC limit 6;")
    Iterable<Provider> get6ProviderByView();

//    @Query(value = "CALL `case4`.get_all_employee();", nativeQuery = true)
//    Iterable<Provider> list12ProviderSuitableForGender(@Param("gender") String gender);

    Iterable<Provider>findAllByGender(@Param("gender") String gender);

    @Query(value = "select * from provider where `city` like :city limit 12;", nativeQuery = true)
    Iterable<Provider> list12ProviderSuitableForCity(@Param("city") String city);
    @Query(value = "select services_id from (select services_id from provider_services where provider_id = :id) as dich_vu_theo_user limit 3;",nativeQuery = true)
    Iterable<BigInteger> get3Service(@Param("id") Long id);
}
