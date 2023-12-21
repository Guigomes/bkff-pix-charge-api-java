package com.astrapay.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum TipoCobEnum {

	COB("cob"), COV("cobv");

	private String name;
}
