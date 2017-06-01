package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="applicant")
public class Applicant {
  private String apply_id;
  private String p_name;
  private String a_status;
  private String applicant;
  private String p_num;
  private String p_keshi;
  private String a_keshi;
  @Id
  @Column(name="apply_id",nullable=false,unique=true)
public String getApply_id() {
	return apply_id;
}
public void setApply_id(String apply_id) {
	this.apply_id = apply_id;
}
public String getP_name() {
	return p_name;
}
public void setP_name(String p_name) {
	this.p_name = p_name;
}
public String getA_status() {
	return a_status;
}
public void setA_status(String a_status) {
	this.a_status = a_status;
}
public String getApplicant() {
	return applicant;
}
public void setApplicant(String applicant) {
	this.applicant = applicant;
}
public String getP_num() {
	return p_num;
}
public void setP_num(String p_num) {
	this.p_num = p_num;
}
public String getP_keshi() {
	return p_keshi;
}
public void setP_keshi(String p_keshi) {
	this.p_keshi = p_keshi;
}
public String getA_keshi() {
	return a_keshi;
}
public void setA_keshi(String a_keshi) {
	this.a_keshi = a_keshi;
}
}
