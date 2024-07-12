package com.topkey.jdeexpensetransfer.repo.travel;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topkey.jdeexpensetransfer.entity.travel.master.ExpenseMaster;
import com.topkey.jdeexpensetransfer.entity.travel.master.ExpenseMasterId;

public interface ExpenseMasterRepository  extends JpaRepository<ExpenseMaster, ExpenseMasterId>{

}
