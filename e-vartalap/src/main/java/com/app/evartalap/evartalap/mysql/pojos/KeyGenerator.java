package com.app.evartalap.evartalap.mysql.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KeyGenerator {
private Integer id;
private String name;
private int value;
public KeyGenerator() {
	super();
}
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
@Override
public String toString() {
	return "Key_Generator [id=" + id + ", name=" + name + ", value=" + value + "]";
}

}
