package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="expertdetail")
public class Expertdetail {
  private String expertinfo_id;
  private String expertdetail_id;
  private String ename;
  private String eemail;
public String getExpertinfo_id() {
	return expertinfo_id;
}
public void setExpertinfo_id(String expertinfo_id) {
	this.expertinfo_id = expertinfo_id;
}
@Id
@Column(name="expertdetail_id",nullable=false,unique=true)
public String getExpertdetail_id() {
	return expertdetail_id;
}
public void setExpertdetail_id(String expertdetail_id) {
	this.expertdetail_id = expertdetail_id;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getEemail() {
	return eemail;
}
public void setEemail(String eemail) {
	this.eemail = eemail;
}
}
