package com.chainsys.mms.model;

/**
 * Symptoms class has symptom id and name
 * 
 * @author pavi2107
 */
public class Symptoms {
	private int sym_id;
	private String sym_name;
	private int dep_id;

	public int getSym_id() {
		return sym_id;
	}

	public void setSym_id(int sym_id) {
		this.sym_id = sym_id;
	}

	public String getSym_name() {
		return sym_name;
	}

	public void setSym_name(String sym_name) {
		this.sym_name = sym_name;
	}

	@Override
	public String toString() {
		return "Symptoms [sym_id=" + sym_id + ", sym_name=" + sym_name + ", dep_id=" + dep_id + "]";
	}

	public int getDep_id() {
		return dep_id;
	}

	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
}