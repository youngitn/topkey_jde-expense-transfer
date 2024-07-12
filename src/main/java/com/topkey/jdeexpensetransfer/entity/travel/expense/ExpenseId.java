package com.topkey.jdeexpensetransfer.entity.travel.expense;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseId implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5637945216524293815L;
	private String vnedus;
    private String vnedtn;
    private int vnedln;
    private String vnedbt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseId expenseId = (ExpenseId) o;
        return Objects.equals(vnedus, expenseId.vnedus) &&
                Objects.equals(vnedtn, expenseId.vnedtn) &&
                Objects.equals(vnedln, expenseId.vnedln) &&
                Objects.equals(vnedbt, expenseId.vnedbt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vnedus, vnedtn, vnedln, vnedbt);
    }
}