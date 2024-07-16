package com.topkey.jdeexpensetransfer.entity.travel.expense;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "F0911Z1",schema = "${jde-table.F0911Z1.schema}")
@IdClass(ExpenseId.class)
public class Expense {

	
	@Id
	@Column(nullable = false)
	private String vnedus = "TKIRIS"; // 素端ERP ID

	@Id
	@Column(nullable = false)
	private String vnedtn; // OA單號

	@Id
	@Column(nullable = false, columnDefinition = "NUMBER(10,0)")
	private int vnedln; // 流水號

	@Id
	@Column(nullable = false)
	private String vnedbt; // OA單號

	@Column
	private String vneddt; // 傳輸日期JDE DATE

	@Column(nullable = false)
	private String vneder = "B"; // Default value

	@Column(nullable = false)
	private String vnedtc = "A"; // Default value

	@Column(nullable = false)
	private String vnedtr = "J"; // Default value

	@Column(nullable = false)
	private String vnkco = "00010"; // Default value

	@Column(nullable = false)
	private String vndct = "JE"; // 傳票類型固定, default value

	@Column
	private String vndgj; // 同vneddt傳輸日期JDE DATE

	@Column(nullable = false)
	private String vnco = "00010"; // Default value

	@Column
	private String vnani; // OA欄位-科目號碼

	@Column(nullable = false)
	private String vnam = "2"; // Default value

	@Column
	private String vnsbl; // OA欄位-明細帳

	@Column(nullable = false)
	private String vnsblt = "C"; // Default value

	@Column(nullable = false)
	private String vnlt = "AA"; // Default value

	@Column(nullable = false)
	private String vnctry = "20"; // Default value

	@Column(nullable = false)
	private String vncrcd = "NTD"; // Default value

	@Column
	private String vnexa; // OA欄位-說明

	@Column(nullable = false)
	private String vnuser = "TKIRIS"; // Default value

	@Column(nullable = false)
	private String vnjobn = "JDEAPP1"; // Default value

	@Column
	private String vnupmj; // 當天

	@Column(nullable = false)
	private String vncrrm = "D"; // Default value

	@Column
	private String vnabr1; // OA欄位-成本會計科目1

	@Column
	private String vnabr2; // OA欄位-成本會計科目2

	@Column
	private String vnabr3; // OA欄位-成本會計科目3
	
	@Column
	private String vnabr4; // OA欄位-成本會計科目3

	@Column
	private String vnabt1; // OA欄位-成本類型1

	@Column
	private String vnabt2; // OA欄位-成本類型2

	@Column
	private String vnabt3; // OA欄位-成本類型3
	
	@Column
	private String vnabt4; // OA欄位-成本類型3

	@Column
	private String vnag; // OA欄位-金額
	
	@Column
	private String vnedsp = "0";
	
	@Column
	private String vnexr;
	
	@Column
	private String vnpost=" ";

}
