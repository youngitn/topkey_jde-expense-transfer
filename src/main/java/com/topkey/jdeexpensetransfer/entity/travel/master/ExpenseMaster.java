package com.topkey.jdeexpensetransfer.entity.travel.master;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@IdClass(ExpenseMasterId.class)
@Table(name = "F0041Z1",schema = "CRPdta")
public class ExpenseMaster {

	@Id
	private String ZFCTID;

	@Id
	private String ZFUSER;

	@Id
	private String ZFTRNM;

	@Id
	private String ZFTRNY;

	@Id
	private String ZFTRNK;

	@Id
	private String ZFPID;

	private String ZFSERK;
	private String ZFAPVC;
	private String ZFTSC;
	private String ZFCNF;
	private String ZFUPTY;
}
