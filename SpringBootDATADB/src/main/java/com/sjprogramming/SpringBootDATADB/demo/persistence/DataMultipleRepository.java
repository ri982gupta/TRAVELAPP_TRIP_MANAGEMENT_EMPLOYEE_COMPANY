package com.sjprogramming.SpringBootDATADB.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataMultipleRepository extends JpaRepository<DataMultiple, Long> {
}
