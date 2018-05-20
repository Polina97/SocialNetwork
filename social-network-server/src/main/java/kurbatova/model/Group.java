package kurbatova.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "group")
public class Group implements Serializable {

	private static final long serialVersionUID = -8380079805990279414L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long groupId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "ACCESS")
	private Boolean access;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "LOGO_URL")
	private String logoUrl;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Profile owner;
	
	public Group() {
	}
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getAccess() {
		return access;
	}
	public void setAccess(Boolean access) {
		this.access = access;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public Profile getOwner() {
		return owner;
	}
	public void setOwner(Profile owner) {
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return String.format("Group[groupId=%d, name='%s', access='%s', description='%s', logoUrl='%s']", groupId, name, access, description, logoUrl);
	}
}
