package com.topkey.jdeexpensetransfer.entity.travel.master;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseMasterId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ZFCTID;
	private String ZFUSER;
	private String ZFTRNM;
	private String ZFTRNY;
	private String ZFTRNK;
	private String ZFPID;
}