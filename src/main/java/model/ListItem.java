package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class ListItem {
	@Id
	@GeneratedValue
	private int id;
	private String company;
	private String export;

	

	public ListItem() {
		super();
	}

	public ListItem(String company, String export) {
		super();
		this.company = company;
		this.export = export;
	}

	public ListItem(int id, String company, String export) {
		super();
		this.id = id;
		this.company = company;
		this.export = export;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getExport() {
		return export;
	}

	public void setExport(String export) {
		this.export = export;
	}

	@Override
	public String toString() {
		return "ListItem [id=" + id + ", company=" + company + ", export=" + export + "]";
	}

	public String returnItemDetails() {
		return this.company + ": " + this.export;
	}
}
