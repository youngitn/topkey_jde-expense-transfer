package com.topkey.jdeexpensetransfer.repo.travel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.topkey.jdeexpensetransfer.entity.travel.expense.Expense;
import com.topkey.jdeexpensetransfer.entity.travel.expense.ExpenseId;

public interface ExpenseRepository extends JpaRepository<Expense, ExpenseId> {

	@Query("SELECT MAX(e2.vnedln) FROM Expense e2 WHERE e2.vnedbt = :vnedbt")
    Optional<Integer> findMaxVnedlnByVnedbt(@Param("vnedbt") String vnedbt);
	
	
	//public int findMaxVNEDLN();
}
